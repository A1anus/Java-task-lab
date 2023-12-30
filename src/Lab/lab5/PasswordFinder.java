package Lab.lab5;

import java.util.regex.*;

public class PasswordFinder{
    public static void main(String[] args){
        String pass = "Qwerty123uiop";
        Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[A-Z])[A-Za-z\\d]{8,16}$");
        Matcher matcher = pattern.matcher(pass);
        if (matcher.matches()) {
            System.out.println("Success");
        } else {
            System.out.println("Pssword incorrect");
        }
    }
}