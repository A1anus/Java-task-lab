package Lab.lab8;

import java.util.*;

public class TransformProcessor {
    @DataProcessor
    public String transformData(HashMap<String, Integer> data) {
        // Реализуйте логику трансформации данных
        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            output.append(entry.getKey()).append(" ").append(entry.getValue() * 2).append("\n"); // Пример трансформации: удваиваем значение
        }
        return output.toString();
    }
}