package Lab.lab2;


public class Film extends Book {

    private int ager;
    private String quality;

    public Film() {
        ager = 18;
        quality = "4k";
    }

    public Film(int ager,String quality) {
        this.ager = ager;
        this.quality = quality; 
    }

    public Film(String title, String author, int year, int ager,String quality) {
        super(title, author, year);
        this.ager = ager;
        this.quality = quality; 
    }

    public int getAger() {
        return ager;
    }

    public String getQuality() {
        return quality;
    }

    public void setAger(int ager) {
        this.ager = ager;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
    @Override
    public double estimation() {
        return 8.7;
    }

}