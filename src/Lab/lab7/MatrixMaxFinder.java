package Lab.lab7;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MatrixMaxFinder implements Runnable {
    private int[] row;
    private int max;

    public MatrixMaxFinder(int[] row) {
        this.row = row;
        this.max = Integer.MIN_VALUE;
    }

    @Override
    public void run() {
        for (int element : row) {
            if (element > max) {
                max = element;
            }
        }
    }

    public int getMax() {
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        ExecutorService executorService = Executors.newFixedThreadPool(matrix.length);
        MatrixMaxFinder[] finders = new MatrixMaxFinder[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            finders[i] = new MatrixMaxFinder(matrix[i]);
            executorService.execute(finders[i]);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int globalMax = Integer.MIN_VALUE;

        for (MatrixMaxFinder finder : finders) {
            globalMax = Math.max(globalMax, finder.getMax());
        }

        System.out.println("Наибольший элемент матрицы: " + globalMax);
    }
}