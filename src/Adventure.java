public class Adventure extends Movie{
    public Adventure(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf("...%s%n".repeat(3),"Nothing Special", "Kink Kong", "Something bad happend");
    }

    public void watchComedyMovie(){
        watchMovie();
        System.out.println("Watching Adventure movie...");
    }
}
