package Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main3 {
    public static String first(String text) {
        text = text.replaceAll("[aoeiuy]" , "*");
        return text;
    }
    public static String second(String text2) {
        String b = "";
        String [] text= text2.split(""); 
        for(int i = 1; i < text.length; i++) {
            if (text[i - 1].equals(text[i])) {
                String c1 = text[i].toUpperCase();
                b+= "Double" + c1;
                i++;}
            else
                b+= text[i-1];
            }
        int w = text.length;
        if (text[w-1].equals(text[w-2]))
            return b;
        b+= text[w-1];
        return b; 
    }
    public static boolean three(int a, int b, int c, int w, int h) {
        if ((a <= w && b <= h) || (a <= h && b <= w))  // Проверяем условие: высота блока должна быть меньше или равна ширине отверстия,
                return true;
        if ((b <= w && c <= h) || (b <= h && c <= w))  // ширина блока должна быть меньше или равна высоте отверстия,
                return true;
        if ((c <= w && a <= h) || (c <= h && a <= w))  // глубина блока должна быть меньше или равна глубине отверстия.
                return true;
        return false;
    }
    public static boolean four(int number) {
        int remainder = number % 2;
        int number1 = 0;
        while (number > 0) {
            int a = number % 10;
            number1 += a * a;
            number = number / 10;
        }
        int remainder1 = number1 % 2;
        if (remainder != 0 && remainder1 != 0 || remainder == 0 && remainder1 == 0) {
            return true;
        }
        return false;
    }
    public static int five(String[] five) {
        int a = Integer.parseInt(five[0]);
        int b = Integer.parseInt(five[1]);
        int c = Integer.parseInt(five[2]);
        for(int i = 0; i<1;i++){
            double d = b*b - 4*a*c;
            if (d > 0) {
                double x1 = (-b + Math.sqrt(d))/(2*a);
                double x2 = (-b - Math.sqrt(d))/(2*a);
                if (x1 % 1 == 0 && x2 % 1 == 0 && x1 != x2) {
                    return 2;
                }
                if (x1 % 1 != 0 && x2 % 1 == 0 || x1 % 1 == 0 && x2 % 1 != 0) {
                    return 1;
                }
            }
            else if (d == 0) {
                double x3 = (-b + Math.sqrt(d))/(2*a);
                if (x3 % 1 == 0)
                    return 1;
            }
        }
        return 0;
    }
        public static List<String> six(String[][] arr) {
        List<String> result = new ArrayList<>();
        List<String> lookingFor = Arrays.asList("Shop1", "Shop2", "Shop3", "Shop4");
        for (String[] array : arr) {
            List<String> tempList = new ArrayList<>(Arrays.asList(array));
            boolean containsAll = true;
            for (String shop : lookingFor) {
                if (!tempList.contains(shop)) {
                    containsAll = false;
                    break;
                }
            }
            if (containsAll) {
                tempList.removeAll(lookingFor);
                result.add(tempList.toString());
            }
        }

        return result;
    }
     public static boolean seven(String seven) {
        boolean prov = true;
        String[] words = seven.toLowerCase().split(" ");
        int startIndex = words.length;
        for (int i = startIndex - 1; i >= 1; i--) {
            char w = words[i].charAt(0);
            char w2 = words[i-1].charAt(words[i-1].length() - 1);
            if (w == w2 && prov != false) {
                prov = true;
            }
            else
                prov = false;
        }
        return prov;
    }  
    public static boolean eight(String eight) {
        String[] arr = eight.split(", ");
        for (int i = 1; i < arr.length - 1; i++) {
            if ((Integer.parseInt(arr[i]) > Integer.parseInt(arr[i - 1]) && Integer.parseInt(arr[i]) > Integer.parseInt(arr[i + 1]))
            || (Integer.parseInt(arr[i]) < Integer.parseInt(arr[i - 1]) && Integer.parseInt(arr[i]) < Integer.parseInt(arr[i + 1]))) {
                return true;
            }  
        }
        return false;
    }
    public static char nine(String nine) {
        int[] vowelsCounter = new int[5];

        for (char c : nine.toCharArray()) {

            if (c == 'a' || c == 'A') {
                vowelsCounter[0]++;
            } else if (c == 'e' || c == 'E') {
                vowelsCounter[1]++;
            } else if (c == 'i' || c == 'I') {
                vowelsCounter[2]++;
            } else if (c == 'o' || c == 'O') {
                vowelsCounter[3]++;
            } else if (c == 'u' || c == 'U') {
                vowelsCounter[4]++;
            }
        }

        int maxIndex = 0;
        for (int i = 1; i < vowelsCounter.length; i++) {
            if (vowelsCounter[i] > vowelsCounter[maxIndex]) {
                maxIndex = i;
            }
        }
        char mostCommonVowel;
        switch (maxIndex) {
            case 0:
                mostCommonVowel = 'a';
                break;
            case 1:
                mostCommonVowel = 'e';
                break;
            case 2:
                mostCommonVowel = 'i';
                break;
            case 3:
                mostCommonVowel = 'o';
                break;
            case 4:
                mostCommonVowel = 'u';
                break;
            default:
                mostCommonVowel = ' ';
        }
        return mostCommonVowel;
    }
    public static int[][] ten(int[][] ten) {
        int n = ten.length;
        int[] averages = new int[n];
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (i != j) {
                    sum += ten[i][j];
                }
            }
            averages[j] = Math.round((float) sum / (n-1)); //round округляет в нужную сторону
        }
        for (int i = 0; i < n; i++) {
            ten[i][i] = averages[i];
        }
        return ten;
    }
    public static String eleven(String text) {
        char[] charr = text.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = (char)(charr[i] + 1);
            result.append(ch);
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("\nЗадание 1");
        System.out.println("\napple => " + first("apple") );
        System.out.println("Even if you did this task not by yourself, you have to understand every single line of code. => " + first("Even if you did this task not by yourself, you have to understand every single line of code.") );

        System.out.println("\nЗадание 2");
        System.out.println("\nhello => " + second("hello") );
        System.out.println("\nbookkeeper => " + second("bookkeeper") );

        System.out.println("\nЗадание 3");
        System.out.println("\n1, 3, 5, 4, 5 => " + three(1, 3, 5, 4, 5) );
        System.out.println("\n1, 8, 1, 1, 1 => " + three(1, 8, 1, 1, 1) );
        System.out.println("\n1, 2, 2, 1, 1 => " + three(1, 2, 2, 1, 1) );

        System.out.println("\nЗадание 4");
        System.out.println("\n243 => " + four(243) );
        System.out.println("\n52 => " + four(52) );

        System.out.println("\nЗадание 5");
        String[] prov = {"1", "-3" , "2"};
        String[] prov1 = {"2", "5" , "2"};
        String[] prov2 = {"1", "-6" , "9"};
        System.out.println("\n[1, -3, 2] => " + five(prov));
        System.out.println("\n[2, 5, 2] => "+ five(prov1) );
        System.out.println("\n[1, -6, 9] => "+ five(prov2) );

        System.out.println("\nЗадание 6");
        System.out.println("\nмассив 1 => " + six(new String[][]{{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},{"Banana", "Shop2", "Shop3", "Shop4"}, {
            "Orange", "Shop1", "Shop3", "Shop4"}, {"Pear", "Shop2", "Shop4"}}));
        System.out.println("\nмассив 2 => " + six(new String[][]{{"Fridge", "Shop2", "Shop3"},{"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"}, {
            "Laptop", "Shop3", "Shop4"}, {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}}));

        System.out.println("\nЗадание 7");
        System.out.println("\n\"apple eagle egg goat\" => " + seven("apple eagle egg goat") );
        System.out.println("\n\"cat dog goose fish\" => " + seven("cat dog goose fish") );

        System.out.println("\nЗадание 8");
        System.out.println("\n\"1, 2, 3, 4, 5\" => " + eight("1, 2, 3, 4, 5") );
        System.out.println("\n\"1, 2, -6, 10, 3\" => " + eight("1, 2, -6, 10, 3") );

        System.out.println("\nЗадание 9");
        System.out.println("\n\"Hello world\" => " + nine("Hello world") );
        System.out.println("\n\"Actions speak louder than words.\" => " + nine("Actions speak louder than words.") );

        System.out.println("\nЗадание 10");
        int[][] mas1 = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {5, 5, 5, 5, 5},
            {7, 4, 3, 14, 2},
            {1, 0, 11, 10, 1}
        };
        int[][] result1 = ten(mas1);
        System.out.println("Массив 1 => " + Arrays.deepToString(result1));
        int[][] mas2 = {
            {6, 4, 19, 0, 0},
            {81, 25, 3, 1, 17},
            {48, 12, 60, 32, 14},
            {91, 47, 16, 65, 217},
            {5, 73, 0, 4, 21}
        };
        int[][] result2 = ten(mas2);
        System.out.println("Массив 2 => " + Arrays.deepToString(result2));

        System.out.println("\nЗадание 11");
        System.out.println("\n\"hello\" => " + eleven("abcd") );
        System.out.println("\n\"Actions speak louder than words.\" => " + nine("Actions speak louder than words.") );
    }
}