package Lab.lab4;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CustomInputMismatchException {
    private static final Logger logger = Logger.getLogger(CustomInputMismatchException.class.getName());
    public static void main(String[] args) {
        System.out.print("Введите число: ");
        Scanner scan = new Scanner(System.in);
        try{
            int number =  scan.nextInt();
            System.out.println("Вывод: " + number);
            scan.close();
        } catch (InputMismatchException ex){
            System.out.println("Необходимо ввести именно число!");
            logException(ex);
        } catch (java.lang.IllegalStateException ex){
            System.out.println("Reading error");
            logException(ex);
    }
}
    private static void logException(Exception ex) {
        try {
            FileHandler fileHandler = new FileHandler("D:/ITIP_LABS/LABS/src/lab4/exceptions.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.log(Level.SEVERE, "Произошло исключение!", ex);
            fileHandler.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



