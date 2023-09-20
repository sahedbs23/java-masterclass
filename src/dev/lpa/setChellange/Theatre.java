package dev.lpa.setChellange;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class Theatre {
    public class Seat implements Comparable<Seat> {
        private final String seatNum;
        private boolean reserved;

        public Seat(char row, int seatNumber) {
            this.seatNum = "%c%03d".formatted(row, seatNumber).toUpperCase();
        }

        @Override
        public int compareTo(Seat o) {
            return seatNum.compareTo(o.seatNum);
        }

        @Override
        public String toString() {
            return seatNum;
        }
    }

    private String theatreName;
    private int seatPerRow;
    private NavigableSet<Seat> seats;

    public Theatre(String theatreName, int rows, int totalSeats) {
        this.theatreName = theatreName;
        this.seatPerRow = totalSeats / rows;

        seats = new TreeSet<>();
        for (int i = 0; i < totalSeats; i++) {
            char rowChar = (char) (i / seatPerRow + (int) 'A');
            int seatInRow = i % seatPerRow + 1;
            seats.add(new Seat(rowChar, seatInRow));
        }
    }

    public void printSeatMap() {
        String separatorLine = "-".repeat(90);
        System.out.printf("%1$s%n%2$s Seat Map%n%1$s%n", separatorLine, theatreName);
        int index = 0;
        for (Seat s : seats) {
            System.out.printf("%-8s%s", s.seatNum + ((s.reserved) ? "●" : ""),
                    ((index++ + 1) % seatPerRow == 0) ? "\n" : "");
        }
        System.out.println(separatorLine);
    }

    public String reserveSeat(char row, int seatNumber) {
        Seat requestedSeat = new Seat(row, seatNumber);
        Seat possibleMatch = seats.floor(requestedSeat);
        if (possibleMatch == null || !possibleMatch.seatNum.equals(requestedSeat.seatNum)) {
            System.out.printf("-> No such seat %s%n", requestedSeat.seatNum);
            System.out.printf(": Seat must be between %s and %s %n", seats.first().seatNum, seats.last().seatNum);
        } else {
            if (!possibleMatch.reserved) {
                possibleMatch.reserved = true;
                return possibleMatch.seatNum;
            } else {
                System.out.println("Seat already reserved!");
            }
        }
        return null;
    }

    public Set<Seat> reserveSeats(int count, char minRow, char maxRow,
                                  int minSeat, int maxSeat) {

        char lastValid = seats.last().seatNum.charAt(0);
        maxRow = (maxRow < lastValid) ? maxRow : lastValid;

        if (!validate(count, minRow, maxRow, minSeat, maxSeat)) {
            return null;
        }

        NavigableSet<Seat> selected = null;

        for (char letter = minRow; letter <= maxRow; letter++) {
            NavigableSet<Seat> contagious = seats.subSet(
                    new Seat(letter, minSeat), true,
                    new Seat(letter, maxSeat), true
            );
            int index = 0;
            Seat firstSeat = null;

            for (Seat current : contagious) {
                if (current.reserved) {
                    index = 0;
                    continue;
                }
                firstSeat = (index == 0) ? current : firstSeat;
                if (++index == count) {
                    selected = contagious.subSet(firstSeat, true, current, true);
                    break;
                }

            }
            if (selected != null) {
                break;
            }
        }
        Set<Seat> reservedSeat = null;
        if (selected != null) {
            selected.forEach(seat -> seat.reserved = true);
            reservedSeat = new TreeSet<>(selected);
        }
        return reservedSeat;
    }

    private boolean validate(int count, char first, char last, int min, int max) {
        boolean result = (min > 0 || seatPerRow >= count || (max - min + 1) >= count);
        result = result && seats.contains(new Seat(first, min));
        if (!result) {
            System.out.printf("Invalid! %1$d Seats between" +
                    "%2$c[%3$d-%4$d]- %5$c[%3$d-%4$d] Try again!", count, first, min, max, last
            );
            System.out.printf(": Seats must be between %s and %s", seats.first(), seats.last());
        }
        return true;
    }
}
