package Lab.lab8;

import java.util.*;


public class AggregateProcessor {
    @DataProcessor
    public String aggregateData(HashMap<String, Integer> data) {
        // Реализуйте логику агрегации данных
        int sum = 0;
        for (Integer value : data.values()) {
            sum += value; // Пример агрегации: суммируем все значения
        }
        return "Sum: " + sum + "\n";
    }
}