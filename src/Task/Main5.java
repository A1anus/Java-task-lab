package Task;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Main5 {
    public static boolean one(String str1, String str2) {
    if (str1.length() != str2.length()) {
        return false;
    }
    LinkedList<char[]> symbols = new LinkedList<>();
    for (int i = 0; i < str1.length(); i++) {
        for (char[] chars : symbols) {
            if (str1.charAt(i) == chars[0]) {
                if (str2.charAt(i) != chars[1]) {
                    return false;
                }
            }
        }
        symbols.add(new char[]{str1.charAt(i), str2.charAt(i)});
    }
    return true;
    }
    
    public static String two(String spiderCord, String flyCord) {
        int spiderSymbol = spiderCord.charAt(0) - 65;
        int spiderNumber = Integer.parseInt(spiderCord.substring(1, 2));
        int flySymbol = flyCord.charAt(0) - 65;
        int flyNumber = Integer.parseInt(flyCord.substring(1, 2));
        if (flyNumber == 0) flySymbol = 0;

        double straightWay = 1;
        double[] ways = new double[5];
        for (int i = 0; i < 5; i++) ways[i] = i * Math.sqrt(2 - Math.sqrt(2));

        StringBuilder strWay1 = new StringBuilder(spiderCord);
        double intWay1 = 0;
        int nowSpiderSymbol1 = spiderSymbol;
        int nowSpiderNumber1 = spiderNumber;
        while (nowSpiderSymbol1 != flySymbol || nowSpiderNumber1 != flyNumber) {
            if (nowSpiderNumber1 == 0) {
                nowSpiderSymbol1 = flySymbol;
                nowSpiderNumber1 = 1;
            } else if (nowSpiderSymbol1 == spiderSymbol) {
                nowSpiderNumber1 -= 1;
                if (nowSpiderNumber1 == 0) nowSpiderSymbol1 = 0;
            } else {
                nowSpiderNumber1 += 1;
            }
            strWay1.append("-").append((char) (nowSpiderSymbol1 + 65)).append(nowSpiderNumber1);
            intWay1 += straightWay;
        }

        StringBuilder strWay2 = new StringBuilder(spiderCord);
        double intWay2 = 0;
        int nowSpiderSymbol2 = spiderSymbol;
        int nowSpiderNumber2 = spiderNumber;
        if (nowSpiderNumber2 > flyNumber) {
            while (nowSpiderNumber2 != flyNumber) {
                nowSpiderNumber2 -= 1;
                strWay2.append("-").append((char) (nowSpiderSymbol2 + 65)).append(nowSpiderNumber2);
                intWay2 += straightWay;
            }
            while (nowSpiderSymbol2 != flySymbol) {
                int clock = flySymbol - nowSpiderSymbol2;
                if (clock < 0) clock += 8;
                if (clock <= 4) {
                    nowSpiderSymbol2 = (nowSpiderSymbol2 + 1) % 8;

                }
                else {
                    nowSpiderSymbol2 = (nowSpiderSymbol2 + 7) % 8;
                }
                strWay2.append("-").append((char) (nowSpiderSymbol2 + 65)).append(nowSpiderNumber2);
                intWay2 += ways[nowSpiderNumber2];
            }
        }
        else {
            while (nowSpiderSymbol2 != flySymbol) {
                int clock = flySymbol - nowSpiderSymbol2;
                if (clock < 0) clock += 8;
                if (clock <= 4) {
                    nowSpiderSymbol2 = (nowSpiderSymbol2 + 1) % 8;

                }
                else {
                    nowSpiderSymbol2 = (nowSpiderSymbol2 + 7) % 8;
                }
                strWay2.append("-").append((char) (nowSpiderSymbol2 + 65)).append(nowSpiderNumber2);
                intWay2 += ways[nowSpiderNumber2];
            }
            while (nowSpiderNumber2 != flyNumber) {
                nowSpiderNumber2 += 1;
                strWay2.append("-").append((char) (nowSpiderSymbol2 + 65)).append(nowSpiderNumber2);
                intWay2 += straightWay;
            }
        }
        if (intWay1 <= intWay2) {
            return strWay1.toString();
        }
        return strWay2.toString();
    }

    
    public static int three(long number) {
        if (number < 10) {
            return 1;
        }
        return three(number / 10) + 1;
    }

    public static int four(String[] words, String scrambledWord) {
        int answer = 0;
        LinkedList<String> uniqueWords = new LinkedList<>();
        uniqueWordList:
        for (String word: words) {
            for (String uniqueWord: uniqueWords) {
                if (uniqueWord.equals(word)) {
                    continue uniqueWordList;
                }
            }
            uniqueWords.add(word);
        }
        wordCheck:
        for (String word: uniqueWords) {
            if (word.length() > 2) {
                for (char symbol : word.toCharArray()) {
                    int symbolCount1 = word.length() - word.replace(String.valueOf(symbol), "").length();
                    int symbolCount2 = scrambledWord.length() - scrambledWord.replace(
                            String.valueOf(symbol), "").length();
                    if (symbolCount1 > symbolCount2) continue wordCheck;
                }
                answer += word.length() - 2;
                if (word.length() == 6) {
                    answer += 50;
                }
            }
        }
        return answer;
    }

    public static List<List<Integer>> five(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == 8) {
                    result.add(Arrays.asList(nums[i], nums[j]));
                }
            }
        }

        result.sort((a, b) -> {
            int sumA = a.get(0) + a.get(1);
            int sumB = b.get(0) + b.get(1);
            if (sumA == sumB) {
                return a.get(0) - b.get(0);
            } else {
                return sumA - sumB;
            }
        });

        return result;
    }

    public static String takeDownAverage(String[] percentages) {
        int sumNum = 0;
        int n = percentages.length;
        for (String percentage : percentages) {
            int num = Integer.parseInt(percentage.replace("%", ""));
            sumNum += num;
        }
        double average = (double) sumNum / n;
        int myPercentage = (int) ((average - 5) * (n + 1) - sumNum);
        return myPercentage + "%";
    }

    public static String seven(String mode, String message, int shift) {
        StringBuilder result = new StringBuilder();

        message = message.toUpperCase();

        if (mode.equals("encode")) {
            for (int i = 0; i < message.length(); i++) {
                char ch = message.charAt(i);
                if (Character.isLetter(ch)) {
                    char encryptedChar = (char) ((ch - 'A' + shift) % 26 + 'A');
                    result.append(encryptedChar);
                } else {
                    result.append(ch);
                }
            }
        } else if (mode.equals("decode")) {
            for (int i = 0; i < message.length(); i++) {
                char ch = message.charAt(i);
                if (Character.isLetter(ch)) {
                    char decryptedChar = (char) ((ch - 'A' - shift + 26) % 26 + 'A');
                    result.append(decryptedChar);
                } else {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }

    public static int eight(int n, int k) {
        if (k == 1) {
            return n;
        }
        return n * eight(n - 1, k - 1);
    }

    public static String nine(String cityA, String timestampA, String cityB) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm", Locale.US);

        LocalDateTime localDateTimeA = LocalDateTime.parse(timestampA, formatter);

        ZoneId zoneA = ZoneId.of(getTimeZone(cityA));
        ZoneId zoneB = ZoneId.of(getTimeZone(cityB));


        ZonedDateTime zonedDateTimeA = ZonedDateTime.of(localDateTimeA, zoneA);
        ZonedDateTime zonedDateTimeB = zonedDateTimeA.withZoneSameInstant(zoneB);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm");
        return zonedDateTimeB.format(outputFormatter);
    }
    static String getTimeZone(String city) {
        switch (city) {
            case "Los Angeles":
                return "America/Los_Angeles";
            case "New York":
                return "America/New_York";
            case "Caracas":
                return "America/Caracas";
            case "Buenos Aires":
                return "America/Argentina/Buenos_Aires";
            case "London":
                return "Europe/London";
            case "Rome":
                return "Europe/Rome";
            case "Moscow":
                return "Europe/Moscow";
            case "Tehran":
                return "Asia/Tehran";
            case "New Delhi":
                return "Asia/Kolkata";
            case "Beijing":
                return "Asia/Shanghai";
            case "Canberra":
                return "Australia/Sydney";
            default:
                throw new IllegalArgumentException("Unknown city: " + city);
        }
    }
    
    public static boolean ten(int num) {
        String str = String.valueOf(num);
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) != '0' && str.charAt(i) < str.charAt(0)) {
                return false;
            }
        }
        return true;
    }

public static void main(String[] args) {
    System.out.println("Задание 1");
    System.out.println(one("ABAB", "CDCD")); 
    System.out.println(one("ABCBA", "BCDCB")); 
    System.out.println(one("FFGG", "CDCD")); 
    System.out.println(one("FFFF", "ABCD")); 

    System.out.println("\nЗадание 2");
    String shortestPath = two("H3", "E2");
    System.out.println(shortestPath); 
    String shortestPath1 = two("A4", "B2");
    System.out.println(shortestPath1); 
    String shortestPath2 = two("A4", "C2");
    System.out.println(shortestPath2); 

    System.out.println("\nЗадание 3");
    System.out.println(three(4666)); // 4
    System.out.println(three(544)); // 3
    System.out.println(three(121317)); // 6
    System.out.println(three(0)); // 1
    System.out.println(three(12345)); // 5
    System.out.println(three(1289396387328L)); // 13

    System.out.println("\nЗадание 4");
    System.out.println(four(new String[]{"cat", "create", "sat"}, "caster"));
    System.out.println(four(new String[]{"trance", "recant"}, "recant"));
    System.out.println(four(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));


    System.out.println("\nЗадание 5");
    int[] nums = {1, 2, 3, 4, 5};
    System.out.println(five(nums));  // [[3, 5]]
    nums = new int[]{1, 2, 3, 7, 9};
    System.out.println(five(nums));  // [[1, 7]]
    nums = new int[]{10, 9, 7, 2, 8};
    System.out.println(five(nums));  // []
    nums = new int[]{1, 6, 5, 4, 8, 2, 3, 7};
    System.out.println(five(nums));  // [[2, 6], [3, 5], [1, 7]]

    System.out.println("\nЗадание 6");
    System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"}));
    System.out.println(takeDownAverage(new String[]{"10%"}));
    System.out.println(takeDownAverage(new String[]{"53%", "79%"}));
    System.out.println();

    System.out.println("\nЗадание 7");
    String encodedMessage = seven("encode", "hello world", 3);
    System.out.println(encodedMessage); // "KHOOR ZRUOG"
    String decodedMessage = seven("decode", "almost last task!", 4);
    System.out.println(decodedMessage); // "EPQSWX PEWX XEWO!"

    System.out.println("\nЗадание 8");
    System.out.println(eight(5, 3));
    System.out.println(eight(7, 3));

    System.out.println("\nЗадание 9");
    System.out.println(nine("Los Angeles", "April 1, 2011 23:23", "Canberra"));
    System.out.println(nine("London", "July 31, 1983 23:01", "Rome"));
    System.out.println(nine("New York", "December 31, 1970 13:40", "Beijing"));
    
    System.out.println("\nЗадание 10");
    System.out.println(ten(3));
    System.out.println(ten(30));
    System.out.println(ten(321));
    System.out.println(ten(123));
    }
}