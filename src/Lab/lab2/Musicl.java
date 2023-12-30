package Lab.lab2;


public class Musicl extends Film {

    private int musnumb;

    public Musicl() {
        musnumb = 5;
    }

    public Musicl(int musnumb) {
        this.musnumb = musnumb;
    }

    public Musicl(int musnumb, String title, String author, int year, int ager,String quality) {
        super(title, author, year, ager, quality);
        this.musnumb = musnumb;
    }

    public int getMusnumb() {
        return musnumb;
    }

    public void setMusnumb(int musnumb) {
        this.musnumb = musnumb;
    }

    @Override
    public double estimation() {
        return 8.9;
    }
}