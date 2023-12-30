package Lab.lab7;

public class SummationThread implements Runnable {
    private int[] array;
    private int start;
    private int end;
    private int result;

    public SummationThread(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        result = calculateSum();
    }

    public int getResult() {
        return result;
    }

    private int calculateSum() {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += array[i];
        }
        return sum;
    }
}

class MainThread{
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int middle = array.length / 2;

        SummationThread thread1 = new SummationThread(array, 0, middle - 1);
        SummationThread thread2 = new SummationThread(array, middle, array.length - 1);

        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int result = thread1.getResult() + thread2.getResult();
        System.out.println("Сумма элементов массива: " + result);
    }
}

