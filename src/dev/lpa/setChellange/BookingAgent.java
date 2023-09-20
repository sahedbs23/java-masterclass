package dev.lpa.setChellange;

public class BookingAgent {
    public static void main(String[] args) {
        Theatre rodgersNYC = new Theatre("Star Cineplex", 10, 100);
        rodgersNYC.printSeatMap();

        rodgersNYC.printSeatMap();

        bookSeat(rodgersNYC, 'A', 3);
        bookSeat(rodgersNYC, 'A', 3);

        bookSeat(rodgersNYC, 'B', 1);
        bookSeat(rodgersNYC, 'B', 11);
        bookSeat(rodgersNYC, 'M', 1);

        bookSeats(rodgersNYC, 3, 'F', 3, 7);
        bookSeats(rodgersNYC, 6, 'B', 'C', 3, 10);
        bookSeats(rodgersNYC, 4, 'B', 1, 9);
        bookSeats(rodgersNYC, 4, 'B', 'C', 1, 10);
        bookSeats(rodgersNYC, 1, 'B', 'C', 1, 10);
        bookSeats(rodgersNYC, 4, 'M', 'Z', 1, 10);
        bookSeats(rodgersNYC, 10, 'A', 'E', 1, 10);
    }

    private static void bookSeat(Theatre theatre, char row, int seatNumber) {
        String seat = theatre.reserveSeat(row, seatNumber);
        if (seat != null) {
            System.out.println("Congratulations! Your reserved seatNumber is " + seat);
            theatre.printSeatMap();
        } else {
            System.out.println("Sorry! Unable to reserve " + row + seatNumber);
        }
    }

    private static void bookSeats(Theatre theatre, int requestedSeat, char row,
                                  int minSeat, int maxSeat) {
        bookSeats(theatre, requestedSeat, row, row, minSeat, maxSeat);
    }

    private static void bookSeats(Theatre theatre, int requestedSeat, char startRow, char endRow,
                                  int minSeat, int maxSeat) {
        var result = theatre.reserveSeats(requestedSeat, startRow, endRow, minSeat, maxSeat);
        if (result != null) {
            System.out.println("Congratulations! Your reserved seat is " + result);
            theatre.printSeatMap();
        } else {
            System.out.println("Sorry! No matching contiguous seats in rows: "
                    + startRow + " - " + endRow);
        }
    }
}
