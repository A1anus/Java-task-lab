package Lab.lab2;


public class Main {
    public static void main(String[] args) {
        Audiobook audiobook = new Audiobook();
        Film film = new Film();
        Musicl musicl = new Musicl();
        
        Audiobook audiobook1 = new Audiobook("OGG", 2.20, 96200);
        Film film1 = new Film(0,"Full HD");
        Musicl musicl1 = new Musicl(4);
        
        System.out.println("--- Get-metod ---\n" + audiobook.getTitle());
        System.out.println(film.getAger());
        System.out.println(musicl.getAuthor() + "\n");


        audiobook.setTitle("Сон");
        film.setAger(18);
        musicl.setAuthor("Джером Роббинс");

        System.out.println("--- Audiobook ---\n" + "Title: " + audiobook.getTitle() + "\nAuthor: " + audiobook.getAuthor() + "\nYear: " + audiobook.getYear() + 
        "\nFormat: " + audiobook.getFormat() + "\nDuration: " + audiobook.getDuration() + "\nFrequency: " + audiobook.getFrequency() + "\nEstimation: " + audiobook.estimation() +"\n");
        System.out.println("--- Audiobook1 ---\n" + "Title: " + audiobook1.getTitle() + "\nAuthor: " + audiobook1.getAuthor() + "\nYear: " + audiobook1.getYear() + 
        "\nFormat: " + audiobook1.getFormat() + "\nDuration: " + audiobook1.getDuration() + "\nFrequency: " + audiobook1.getFrequency() + "\nEstimation: " + audiobook1.estimation() +"\n");

        System.out.println("--- Film ---\n" + "Title: " + film.getTitle() + "\nAuthor: " + film.getAuthor() + "\nYear: " + film.getYear() + 
        "\nAger: " + film.getAger() + "\nQuality: " + film.getQuality() + "\nEstimation: " + film.estimation() + "\n");
        System.out.println("--- Film1 ---\n" + "Title: " + film1.getTitle() + "\nAuthor: " + film1.getAuthor() + "\nYear: " + film1.getYear() + 
        "\nAger: " + film1.getAger() + "\nQuality: " + film1.getQuality() + "\nEstimation: " + film1.estimation() + "\n");

        System.out.println("--- Musicl ---\n" + "Title: " + musicl.getTitle() + "\nAuthor: " + musicl.getAuthor() + "\nYear: " + musicl.getYear() +
        "\nAger: " + musicl.getAger() + "\nQuality: " + musicl.getQuality() + "\nMusnumb: " + musicl.getMusnumb() + "\nEstimation: " + musicl.estimation() + "\n");
        System.out.println("--- Musicl1 ---\n" + "Title: " + musicl1.getTitle() + "\nAuthor: " + musicl1.getAuthor() + "\nYear: " +  musicl1.getYear() +
        "\nAger: " + musicl1.getAger() + "\nQuality: " + musicl1.getQuality() + "\nMusnumb: " + musicl1.getMusnumb() + "\nEstimation: " + musicl1.estimation() + "\n");
        System.out.println(Book.getCountObject());
    }
}