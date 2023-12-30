package Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main4 {
    public static String first(String s) {
        if (!s.isEmpty()) {
            String sim = Character.toString(s.charAt(0));
            return sim + first(s.replace(sim, ""));
        } else return "";
    }
    public static List<String> second(int n) {
        List<String> result = new ArrayList<>();
        second(result, "", 0, 0, n);
        return result;
    }

    private static void second(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        if (open < max) {
            second(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            second(result, current + ")", open, close + 1, max);
        }
    }

    public static List<String> three(int n) {
        List<String> combinations = new ArrayList<>();
        generate("", n, combinations);
        return combinations;
    }

    private static void generate(String current, int n, List<String> combinations) {
        if (current.length() == n) {
            combinations.add(current);
            return;
        }

        if (current.length() == 0 || current.charAt(current.length() - 1) == '1') {
            generate(current + "0", n, combinations);
        }

        generate(current + "1", n, combinations);
    }
    public static String four(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        
        String longestRow = "";
        String currentRow = "" + str.charAt(0);
        
        for (int i = 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            char previousChar = str.charAt(i - 1);
            
            if (currentChar == previousChar + 1 || currentChar == previousChar - 1) {
                if (currentRow.indexOf(currentChar) == -1) {
                currentRow += currentChar;
                }
            } else {
                if (currentRow.length() > longestRow.length()) {
                    longestRow = currentRow;
                }
                currentRow = "" + currentChar;
            }
            if (currentRow.length() > longestRow.length()) {
            longestRow = currentRow;
        }
        }     
        
        // Удаляем повторяющиеся символы из самого длинного ряда
        String uniqueLongestRow = "";
        for (int i = 0; i < longestRow.length(); i++) {
            char currentChar = longestRow.charAt(i);
            if (uniqueLongestRow.indexOf(currentChar) == -1) {
                uniqueLongestRow += currentChar;
            }
        }
        
        return uniqueLongestRow;
    }
    /*
    5. Напишите функцию, которая принимает строку и подсчитывает количество идущих подряд символов,
    заменяя соответствующим числом повторяющиеся символы.
    Отсортируйте строку по возрастанию длины буквенного паттерна.
     */
    public static String five(String string) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : string.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        StringBuilder res = new StringBuilder();
        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values);
        while (!values.isEmpty() && !map.isEmpty()) {
            for (Character key : map.keySet()) {
                if (map.get(key).equals(values.get(0))) {
                    res.append(key);
                    res.append(values.get(0));
                    map.remove(key);
                    values.remove(0);
                    break;
                }
            }
        }
        return res.toString();
    }
    /*6. Напишите функцию, принимающую положительное целое число в строковом формате, не превышающее 1000, и возвращающую его целочисленное представление. */ 
    public static int convertToNum(String numberString) {
        Map<String, Integer> numberMap = new HashMap<>();
        numberMap.put("zero", 0);
        numberMap.put("one", 1);
        numberMap.put("two", 2);
        numberMap.put("three", 3);
        numberMap.put("four", 4);
        numberMap.put("five", 5);
        numberMap.put("six", 6);
        numberMap.put("seven", 7);
        numberMap.put("eight", 8);
        numberMap.put("nine", 9);
        numberMap.put("ten", 10);
        numberMap.put("eleven", 11);
        numberMap.put("twelve", 12);
        numberMap.put("thirteen", 13);
        numberMap.put("fourteen", 14);
        numberMap.put("fifteen", 15);
        numberMap.put("sixteen", 16);
        numberMap.put("seventeen", 17);
        numberMap.put("eighteen", 18);
        numberMap.put("nineteen", 19);
        numberMap.put("twenty", 20);
        numberMap.put("thirty", 30);
        numberMap.put("forty", 40);
        numberMap.put("fifty", 50);
        numberMap.put("sixty", 60);
        numberMap.put("seventy", 70);
        numberMap.put("eighty", 80);
        numberMap.put("ninety", 90);
        numberMap.put("hundred", 100);

        String[] words = numberString.split(" ");
        int current = 0;

        for (String word : words) {
            int value = numberMap.get(word);

            if (value == 100) {
                current = current * value;
            } else {
                current += value;
            }
        }
        return current;
        }
        /*7. Напишите функцию, принимающую строку цифр, выполняющую
        поиск подстроки максимальной длины с уникальными элементами. 
        Если найдено несколько подстрок одинаковой длины, верните первую. */
        public static String uniqueSubstring(String input) {
            String result = "";
            int maxLength = 0;
    
            for (int i = 0; i < input.length(); i++) {
                String substring = "";
                for (int j = i; j < input.length(); j++) {
                    char currentChar = input.charAt(j);
                    if (substring.contains(String.valueOf(currentChar))) {
                        break; // если найден повторяющийся символ, прекратить построение подстроки
                    } else {
                        substring += currentChar;
                    }
                }
    
                if (substring.length() > maxLength) {
                    maxLength = substring.length();
                    result = substring;
                }
            }
    
            return result;
        }
        /*8. Напишите функцию поисковик наименьшего матричного пути.
        На вход поступает двумерный массив, размера n x n, ваша задача найти путь с минимальной суммой чисел, передвигаясь только вправо или вниз.  */
        public static int shortestWay(int[][] matrix) {
            int n = matrix.length;
            int[][] dp = new int[n][n];
            
            dp[0][0] = matrix[0][0];
            
            // заполняем первую строку
            for (int j = 1; j < n; j++) {
                dp[0][j] = dp[0][j-1] + matrix[0][j];
            }
            
            // заполняем первый столбец
            for (int i = 1; i < n; i++) {
                dp[i][0] = dp[i-1][0] + matrix[i][0];
            }
            
            // заполняем оставшиеся ячейки
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
                }
            }
            
            return dp[n-1][n-1];
        }
        /*9. Создайте функцию, принимающую строку, содержащую числа внутри слов. Эти числа представляют расположение слова для новой строящейся строки. */
        public static String nine(String input) {
            // Разделяем строку на отдельные слова
            String[] words = input.split(" ");
    
            // Создаем массив для хранения слов в правильном порядке
            String[] orderedWords = new String[words.length];
    
            // Проходим по каждому слову в исходной строке
            for (String word : words) {
                // Ищем числовое значение внутри слова
                int order = 0;
                for (char c : word.toCharArray()) {
                    if (Character.isDigit(c)) {
                        order = Character.getNumericValue(c);
                        break;
                    }
                }
    
                // Помещаем слово в соответствующую позицию в массиве orderedWords
                orderedWords[order - 1] = word.replaceAll("[^a-zA-Z]", "");
            }
    
            // Собираем отсортированные слова в новую строку
            StringBuilder result = new StringBuilder();
            for (String word : orderedWords) {
                result.append(word).append(" ");
            }
    
            return result.toString();
        }
        /*10. Напишите функцию, принимающую два числа, которая делает второе число
        максимально возможным за счет замены своих элементов элементами первого числа. Брать цифру можно только один раз */
        public static int ten(int num1, int num2) {
        // Преобразуем второе число в массив символов
        char[] num2Digits = String.valueOf(num2).toCharArray();
        
        // Сортируем массив символов в порядке убывания
        Arrays.sort(num2Digits);
        
        // Преобразуем первое число в массив символов
        char[] num1Digits = String.valueOf(num1).toCharArray();
        
        // Заменяем цифры второго числа цифрами первого числа, начиная с самой большой
        for (int i = 0; i < num2Digits.length; i++) {
            for (int j = 0; j < num1Digits.length; j++) {
                int a = Character.getNumericValue(num1Digits[j]);
                int b = Character.getNumericValue(num2Digits[j]);
                if (a < b) {
                    num1Digits[j] = num2Digits[i];
                    break;
                }
            }
        }
        
        // Преобразуем массив символов в число и возвращаем результат
        return Integer.parseInt(String.valueOf(num1Digits));
    }
    public static void main(String[] args) {
        System.out.println("\nЗадание 1");
        System.out.println("\nabracadabra => " + first("abracadabra") );
        System.out.println("\npaparazzi => " + first("paparazzi") );

        System.out.println("\nЗадание 2");
        List<String> combinations1 = second(1);
        List<String> combinations2 = second(2);
        List<String> combinations3 = second(3);
        System.out.println("\n1 => " + combinations1);
        System.out.println("\n2 => " + combinations2);
        System.out.println("\n3 => " + combinations3);

        System.out.println("\nЗадание 3");
        List<String> comb1 = three(3);
        List<String> comb2 = three(4);
        System.out.println("\n3 => " + comb1);
        System.out.println("\n4 => " + comb2);

        System.out.println("\nЗадание 4");
        System.out.println("\nabcdjuwx => " + four("abcdjuwx"));
        System.out.println("\nklmabzyxw => " + four("klmabzyxw"));

        System.out.println("\nЗадание 5");
        System.out.println(five("aaabbcdd"));
        System.out.println(five("vvvvaajaaaaa"));

        System.out.println("\nЗадание 6");
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven")); 
        System.out.println(convertToNum("thirty one")); 

        System.out.println("\nЗадание 7");
        System.out.println(uniqueSubstring("123412324")); // "1234"
        System.out.println(uniqueSubstring("111111")); // "1"
        System.out.println(uniqueSubstring("77897898")); // "789"

        System.out.println("\nЗадание 8");
        int[][] matrix1 = {{1, 3, 1},
                           {1, 5, 1},
                           {4, 2, 1}};
        int[][] matrix2 = {{2, 7, 3},
                           {1, 4, 8},
                           {4, 5, 9}};
        
        System.out.println(shortestWay(matrix1)); 
        System.out.println(shortestWay(matrix2)); 

        System.out.println("\nЗадание 9");
        System.out.println(nine("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(nine("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        System.out.println("\nЗадание 10");
        System.out.println(ten(519, 723)); 
        System.out.println(ten(491, 3912)); 
        System.out.println(ten(6274, 71259));
    }
}