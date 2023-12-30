package Lab.lab2;

public class Audiobook extends Book{

    private String format;
    private double duration;
    private int frequency;

    public Audiobook(){
        format = "FLAC";
        duration = 1.30;
        frequency = 44100;
    }
    public Audiobook(String format, double duration, int frequency) {
        this.format = format;
        this.duration = duration;
        this.frequency = frequency;
    }
    public Audiobook(String title, String author, int year, String format, double duration, int frequency) {
        super(title, author, year);
        this.format = format;
        this.duration = duration;
        this.frequency = frequency;
    }
    public String getFormat(){
        return format;
    }
    public double getDuration() {
        return duration;
    }
    public int getFrequency() {
        return frequency;
    }
    public void setFormat(String format) {
        this.format = format;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    @Override
    public double estimation() {
        return 7.9;
    }

}