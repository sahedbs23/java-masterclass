public class Comedy extends Movie{
    public Comedy(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf("...%s%n".repeat(3),"Johny English", "3 Idiots", "Once upon a time in the west");
    }
    public void watchComedyMovie(){
        watchMovie();
        System.out.println("Watching comedy movie");
    }
}
