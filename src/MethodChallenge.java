import java.math.BigDecimal;
import java.math.RoundingMode;

public class MethodChallenge {

    private static final int TIN_MIN_AGE = 13;
    private static final int TIN_MAX_AGE = 19;

    public static int tinMaxAge = 19;

    public static void main(String[] args) {
        displayHighScorePosition("Sahadat", calculateHighScorePosition(1500));
        displayHighScorePosition("Sahed", calculateHighScorePosition(1000));
        displayHighScorePosition("Rejuana", calculateHighScorePosition(499));
        displayHighScorePosition("Promy", calculateHighScorePosition(100));
        displayHighScorePosition("Rahman", calculateHighScorePosition(25));
        System.out.println(areEqualByThreeDecimalPlaces(3.1756, 3.1755));


    }

    /**
     * @param playerName    String player Name
     * @param scorePosition int player score position in the high score list
     */
    public static void displayHighScorePosition(String playerName, int scorePosition) {
        System.out.println("The position in high score table for " + playerName + " is : " + scorePosition);
    }

    /**
     * @param score int player score
     * @return int position in the score lists.
     */
    public static int calculateHighScorePosition(int score) {
        if (score >= 1000) {
            return 1;
        }

        if (score >= 500) {
            return 2;
        }

        if (score >= 100) {
            return 3;
        }
        return 4;
    }


    public static boolean areEqualByThreeDecimalPlaces(double originalNum, double comparableNum) {
        double originalNumUntil3Precision = new BigDecimal(originalNum).setScale(3, RoundingMode.CEILING).doubleValue();
        double comparableNumUntil3Precision = new BigDecimal(comparableNum).setScale(3, RoundingMode.UNNECESSARY).doubleValue();
        System.out.println(originalNumUntil3Precision);
        System.out.println(comparableNumUntil3Precision);
        return Double.compare(originalNumUntil3Precision, comparableNumUntil3Precision) == 0;

    }

    public static boolean hasTeen(int personOne, int personTwo, int personThree) {

        return isTeen(personOne) || isTeen(personTwo) || isTeen(personThree);
    }

    public static boolean isTeen(int age) {
        return age >= TIN_MIN_AGE && age <= TIN_MAX_AGE;
    }
}
