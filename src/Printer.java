public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.pagesPrinted = 0;
        this.duplex = duplex;
        if (tonerLevel < 0) {
            this.tonerLevel = 0;
        } else {
            this.tonerLevel = Math.min(tonerLevel, 100);
        }
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public int addToner(int tonerAmount) {

        if (tonerAmount <= 0 || tonerAmount > 100) {
            return -1;
        }
        int totalTonerLevel = tonerLevel + tonerAmount;
        if (totalTonerLevel > 100){
            return -1;
        }
        tonerLevel = totalTonerLevel;
        return tonerLevel;
    }

    public int printPages(int pages) {
        if (duplex) {
            System.out.println("It's a duplex print");
        }
        int pageWillBePrinted = duplex ? (pages / 2) + (pages % 2) : pages;
        pagesPrinted = pagesPrinted + pageWillBePrinted;
        return pageWillBePrinted;
    }

}
