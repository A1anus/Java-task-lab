package Lab.lab1;
public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            System.out.println(isPalindrome(s));
        }
    }
    public static String reverseString(String s) {
        String b = "";
        for (int i = 0; i < s.length(); i++) {
            b = s.charAt(i) + b;
        }
        return b;
    }
    public static boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }
} 