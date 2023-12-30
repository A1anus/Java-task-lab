package Lab.lab1;
public class Primes {
    public static void main(String[] args) {
        int n = 2;
        while (n != 101) {
            boolean a = isPrime(n);
            if(a == (boolean)true) {
                System.out.print(n + " ");
            }
            n++;
        }

    }
    public static boolean isPrime(int n) {
        for(int i = 2; i < n; i++) {
            if(n % i == 0 && n!=i)
                return false;
        }
        return true;
    } 
} 