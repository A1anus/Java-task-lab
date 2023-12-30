package Task;

public class Main {
    public static double convert(int gallons) {
        return gallons * 3.785;
    }
    public static int fitCalc(int time, int intensity) {
        int calories = time * intensity;
            return calories;
    }
    public static int containers(int boxes, int bags, int barrels) {
        int itemsInBox = 20;
        int itemsInBag = 50;
        int itemsInBarrel = 100;
        int totalItems = (boxes * itemsInBox) + (bags * itemsInBag) + (barrels * itemsInBarrel);
            return totalItems;
    }
    public static String triangleType(float x, float y, float z) {
        if ((x != y && x != z && y != z) && (x+y>z && x+z>y && y+z>x))
            return "different-sided";
        if ((x==y && y==z) && (x+y>z && x+z>y && y+z>x))
            return "isosceles";
        if ((x == y || x == z || z == y) && (x+y>z && x+z>y && y+z>x))
            return "equilateral";
        else
            return "not a triangle";
    }
    public static int ternaryEvaluation(int a, int b) {
        return Math.max(a, b);
    }
    public static int howManyItems(double x, double y, double z) {
        return (int) (x/(y*z*2));
    }
    public static long factorial(int a) {
        int res = 1;
        for (int i = 1; i <= a; i++){
            res *= i;
        }
        return res;
    }
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
        }
    public static int ticketSaler(int a, int b) {
        return ((a*b/100)*72);
    }
    public static int tables(float a, float b) {
        float c = a/2;
        int v = (int) Math.ceil(c);
        return Math.max((int) (v - b), 0);
    }
    public static void main(String[] args) {
    // Первое задание
    
    System.out.println("Получено " + convert(5) + " литров");
    System.out.println("Получено " + convert(3) + " литров");
    System.out.println("Получено " + convert(8) + " литров");

    // Второе задание
    
    System.out.println("\nYou burned " + fitCalc(15,1) +  " calories");//вывод
    System.out.println("You burned " + fitCalc(24,2) +  " calories");
    System.out.println("You burned " + fitCalc(41,3) +  " calories");

    // Третье задание
    
    System.out.println("\nОбщее количество товаров на складе: " + containers(3, 4, 2));
    System.out.println("Общее количество товаров на складе: " + containers(5,0,2));
    System.out.println("Общее количество товаров на складе: " + containers(4,1,4));

    // Четвёртое задание

    System.out.println("\n" + triangleType(5, 5, 5));
    System.out.println(triangleType(5, 4, 5));
    System.out.println(triangleType(3, 4, 5));
    System.out.println(triangleType(5, 1, 1));

    // Пятое задание

    System.out.println("\nБольшее из этих двух чисел: " + ternaryEvaluation(8, 4));
    System.out.println("Большее из этих двух чисел: " + ternaryEvaluation(1, 11));
    System.out.println("Большее из этих двух чисел: " + ternaryEvaluation(5, 9));

    // Шестое задание 

    System.out.println("\nТы сможешь сшить " + howManyItems(22, 1.4, 2) + " пододеяльников");
    System.out.println("Ты сможешь сшить " + howManyItems(45, 1.8, 1.9) + " пододеяльников");
    System.out.println("Ты сможешь сшить " + howManyItems(100, 2, 2) + " пододеяльников");

    //Седьмое задание

    System.out.println("\nФакторила числа 3: " + factorial(3));
    System.out.println("Факторила числа 5: " + factorial(5));
    System.out.println("Факторила числа 7: " + factorial(7));

    //Восьмое задание

    System.out.println("\nНаибольший общий делитель: " + gcd(48, 18));
    System.out.println("Наибольший общий делитель: " + gcd(52, 8));
    System.out.println("Наибольший общий делитель: " + gcd(259, 28));

    //Девятое задание

    System.out.println("\nВыручка: " + ticketSaler(70, 1500));
    System.out.println("Выручка: " + ticketSaler(24, 950));
    System.out.println("Выручка: " + ticketSaler(53, 1250));

    //Десятое задание

    System.out.println("\nНе хватает " + tables(5, 2) + " столов");
    System.out.println("Не хватает " + tables(31, 20) + " столов");
    System.out.println("Не хватает " + tables(123, 58) + " столов");
    }

}