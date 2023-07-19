public class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public void watchMovie(){
        String instanceName = this.getClass().getSimpleName();
        System.out.printf("%s is a %s movie%n", title, instanceName);
    }

    public static Movie getMovie(String title, String movieType){
        return switch (movieType.toLowerCase().charAt(0)){
            case 'a' -> new Adventure(title);
            case 'c' -> new Comedy(title);
            case 's' -> new ScienceFiction(title);
            default -> new Movie(title);
        };
    }
}
