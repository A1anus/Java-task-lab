package Lab.lab2;

public abstract class Book {

    private String title;
    private String author;
    private int year;
    private static int countObject;

    public Book() {
        title = "Преступление и наказание";
        author = "Фёдор Достоевский";
        year = 1866;
        countObject++;
    }

    public Book (String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        countObject++;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getYear() {
        return this.year;
    }

    public void setTitle(String tit) {
        this.title = tit;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static int getCountObject() {
        return countObject;
    }

    public abstract double estimation();

}