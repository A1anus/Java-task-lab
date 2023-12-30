package Lab.lab7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(new Loader(warehouse, 1));
        executor.submit(new Loader(warehouse, 2));
        executor.submit(new Loader(warehouse, 3));
        executor.shutdown();
    }
}

class Warehouse {
    private static final int MAX_WEIGHT = 150;
    private AtomicInteger totalWeight = new AtomicInteger(0);
    private AtomicInteger nextLoaderNumber = new AtomicInteger(1);

    public void load(int weight) {
        totalWeight.addAndGet(weight);
        if (totalWeight.get() >= MAX_WEIGHT) {
            System.out.println("Склад достиг максимального веса, грузчики отправляются на другой склад");
            System.exit(0);
        }
    }

    public int getTotalWeight() {
        return totalWeight.get();
    }

    public int getNextLoaderNumber() {
        return nextLoaderNumber.get();
    }

    public void incrementNextLoaderNumber() {
        nextLoaderNumber.incrementAndGet();
        if (nextLoaderNumber.get() > 3) {
            nextLoaderNumber.set(1);
        }
    }
}

class Loader implements Runnable {
    private Warehouse warehouse;
    private int loaderNumber;

    public Loader(Warehouse warehouse, int loaderNumber) {
        this.warehouse = warehouse;
        this.loaderNumber = loaderNumber;
    }

    @Override
    public void run() {
        while (true) {
            int weight = (int) (Math.random() * 16) + 5;
            synchronized (warehouse) {
                try {
                    while (loaderNumber != warehouse.getNextLoaderNumber()) {
                        warehouse.wait();
                    }
                    warehouse.load(weight);
                    System.out.println("Грузчик " + loaderNumber + " поднял товар весом " + weight + ", общий вес на складе: " + warehouse.getTotalWeight());
                    if (warehouse.getTotalWeight() == 150) {
                        System.out.println("Последний грузчик " + loaderNumber + " принес товар, заполнив склад ровно на 150 кг");
                    }
                    warehouse.incrementNextLoaderNumber();
                    warehouse.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
