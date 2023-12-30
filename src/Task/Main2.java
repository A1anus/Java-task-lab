package Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main2 {
    public static boolean first(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        int i = 0;
        int l = chars.length;
        while (i != l) {
            for (int j = i + 1; j < l; j++) {
                if (chars[i] == chars[j]) {
                    return true;
                }
            }
            i++;
        }

        return false;
    }
    public static String two(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                String a = String.valueOf(text.charAt(0)) + String.valueOf(text.charAt(i+1));
                return a;
            }
        }
        return "ошибка";
    }
    public static int three(String three) {
        int chot = 0;
        int nechot = 0;
        String[] threes = three.split(", ");
        for (int i = 0; i < threes.length; i++) {
            int b = Integer.parseInt(threes[i]);
            if (b % 2 == 0) {
                chot += b;
            }
            else {
                nechot += b;
            }
        }
        return (chot - nechot);
    }
    public static boolean four(String four) {
        float a = 0f;
        String[] fours = four.split(", ");
        for (int i = 0; i < fours.length; i++) {
            float b = Float.valueOf(fours[i]);
            a += b;
        }
        a = a/fours.length;
        for (int j = 0; j < fours.length; j++) {
            if (j == a){
                return true;
            }
        }
        return false;
    }      
    public static List five(String five) {
        int a = 0;
        String[] fives = five.split(", ");
        int[] out = new int[fives.length];
        for (int i = 0; i < fives.length; i++) {
            int b = Integer.parseInt(fives[i]);
            a = (b * i);
            out[i] = a;
    }   
        List list = new ArrayList();
        for (int j = 0; j < fives.length; j++) {
            String str = String.valueOf(out[j]);
            list.add(str);
            
    }
    return list;
    }
    public static String six(String six) {
        return new StringBuilder(six).reverse().toString();
    }
    public static int seven(int n) {
        int x1 = 0;
        int x2 = 0;
        int x3 = 1;
        if (n == 0 || n == 1 || n == 2){
            return 0;}
        if (n == 3){
            return 1;}
        else {
            for (int i = 3; i < n; i++) {
                int curr = x1 + x2 + x3;
                x1 = x2;
                x2 = x3;
                x3 = curr;
            }
        }
        return x3;
    }
    public static String eight(int n) {
        StringBuilder eight = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int randomIndex = random.nextInt(16); //generating random index to select from numbers and letters
            if (randomIndex < 10) { //java uses unicode -> ascii is subset of unicode
                eight.append((char) (randomIndex + '0')); //'0' value is 48 + random value
            } else {
                eight.append((char) (randomIndex - 10 + 'a')); //'a' ascii value is 97, every next letter has +1 value
            }
        }
        return eight.toString();
    }
    public static String nine(String input) {
        input = input.toLowerCase();
        if (input.contains("help")) {
            return "calling for a staff member";
        } else {
            return "keep waiting";
        }
    }
    public static boolean ten(String input1, String input2) {
        input1 = input1.replaceAll("\\s", "").toLowerCase();
        input2 = input2.replaceAll("\\s", "").toLowerCase();
        char[] charArray1 = input1.toCharArray(); //turn strings into arrays
        char[] charArray2 = input2.toCharArray();
        Arrays.sort(charArray1); //sort arrays
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2); //checking if they r equal
    }

    public static void main(String[] args) {
        System.out.println("\nЗадание 1");
        System.out.println("\nDonald => " + first("Donald") );
        System.out.println("orange => " + first("orange") );

        System.out.println("\nЗадание 2");
        System.out.println("\nRyan Gosling => " + two("Ryan Gosling") );
        System.out.println("Barack Obama => " + two("Barack Obama") );

        System.out.println("\nЗадание 3");
        System.out.println("\nПервый массив (44, 32, 86, 19) => " + three("44, 32, 86, 19") );
        System.out.println("Второй массив (22, 50, 16, 63, 31, 55) => " + three("22, 50, 16, 63, 31, 55") );

        System.out.println("\nЗадание 4");
        System.out.println("\nПервый массив (1, 2, 3, 4, 5) => " + four("1, 2, 3, 4, 5") );
        System.out.println("Второй массив (1, 2, 3, 4, 5, 6) => " + four("1, 2, 3, 4, 5, 6") );

        System.out.println("\nЗадание 5");
        System.out.println("\nПервый массив (1, 2, 3) => " + five("1, 2, 3") );
        System.out.println("Второй массив (3, 3, -2, 408, 3, 31) => " + five("3, 3, -2, 408, 3, 31") );

        System.out.println("\nЗадание 6");
        System.out.println("\nHello world => " + six("Hello world") );
        System.out.println("The quick brown fox. => " + six("The quick brown fox.") );

        System.out.println("\nЗадание 7");
        System.out.println("\n(7) => " + seven(7) );
        System.out.println("(11) => " + seven(11) );

        System.out.println("\nЗадание 8");
        System.out.println("\n(5) => " + eight(5) );
        System.out.println("(10) => " + eight(10) );
        System.out.println("(0) => " + eight(0) );

        System.out.println("\nЗадание 9");
        System.out.println("\nHello, I'm under the water, please help me => " + nine("Hello, I'm under the water, please help me"));
        System.out.println("Two pepperoni pizzas please => " + nine("Two pepperoni pizzas please") );

        System.out.println("\nЗадание 10");
        System.out.println("listen, silent => " + ten("listen", "silent"));
        System.out.println("eleven plus two, twelve plus one => " + ten("eleven plus two", "twelve plus one") );
        System.out.println("hello, world => " + ten("hello", "world") );
    } 
}