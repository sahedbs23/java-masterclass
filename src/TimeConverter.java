public class TimeConverter {

    public static void main(String[] args) {
        System.out.println(getDurationString(3600));
        System.out.println(getDurationString(130, 30));
    }

    public static String getDurationString(int seconds){
        if (seconds <=0){
            return "Invalid value";
        }
        return getHours(seconds) + "h " + getMinutes(seconds) + "m "+ getSeconds(seconds)+"s";
    }

    public static String getDurationString(int minutes, int seconds){
        if (minutes<=0 || seconds<=0 || seconds >= 59){
            return "invalid value, minutes must be greater than 0, seconds must be between 1-59";
        }
        return getDurationString( minutes * 60 + seconds);
    }

    private static int getHours(int seconds){
        return seconds / secondsInHour();
    }

    private static int getMinutes(int seconds){
        int secondsLeftAfterHour = seconds % secondsInHour();
        return secondsLeftAfterHour / secondsInMinute();
    }

    private static int getSeconds(int seconds){
        int secondsLeftAfterHour = seconds % secondsInHour();
        return secondsLeftAfterHour % secondsInMinute();
    }

    private static int secondsInHour(){
        return 60 * 60;
    }

    private static int secondsInMinute(){
        return 60;
    }
}
