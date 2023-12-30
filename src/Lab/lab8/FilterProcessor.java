package Lab.lab8;

import java.util.*;

public class FilterProcessor {
    @DataProcessor
    public String filterData(HashMap<String, Integer> data) {
        // Реализуйте логику фильтрации данных
        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            if (entry.getValue() > 10) { // Пример фильтрации: оставляем только элементы с значением больше 10
                output.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
            }
        }
        return output.toString();
    }
}