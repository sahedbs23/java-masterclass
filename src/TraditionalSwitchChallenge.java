public class TraditionalSwitchChallenge {

    public static void main(String[] args) {
        char natoChar = 'J';

        printNatoWord(natoChar);
    }

    public static void printNatoWord(char character) {

        switch (character) {
            case 'A' -> System.out.print(character + " => Able");
            case 'B' -> System.out.print(character + " => Baker");
            case 'C' -> System.out.print(character + " => Charle");
            case 'D' -> System.out.print(character + " => Dog");
            case 'E' -> System.out.print(character + " => Easy");
            case 'F' -> System.out.print(character + " => Fox");
            case 'G' -> System.out.print(character + " => Gorge");
            case 'H' -> System.out.print(character + " => How");
            case 'I' -> System.out.print(character + " => Item");
            case 'J' -> System.out.print(character + " => Jig");
            case 'K' -> System.out.print(character + " => King");
            case 'L' -> System.out.print(character + " => Love");
            case 'M' -> System.out.print(character + " => Make");
            case 'N' -> System.out.print(character + " => Nano");
            case 'O' -> System.out.print(character + " => Ovi");
            case 'P' -> System.out.print(character + " => Peter");
            case 'Q' -> System.out.print(character + " => Queen");
            case 'R' -> System.out.print(character + " => Roger");
            case 'S' -> System.out.print(character + " => Sugar");
            case 'T' -> System.out.print(character + " => Tare");
            case 'U' -> System.out.print(character + " => Uncle");
            case 'V' -> System.out.print(character + " => Victor");
            case 'W' -> System.out.print(character + " => William");
            case 'X' -> System.out.print(character + " => X-ray");
            case 'Y' -> System.out.print(character + " => Yoke");
            case 'Z' -> System.out.print(character + " => Zebra");
            default -> System.out.print("Not found");
        }
    }

}
