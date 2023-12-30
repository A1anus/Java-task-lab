package Lab.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TopWords {
     public static void main(String[] args){
        File text = new File("D:/ITIP_LABS/LABS/src/lab6/text.txt");
        Scanner scanner;
        try{
            scanner = new Scanner(text);
        } catch(FileNotFoundException e){
            System.out.println("file not found");
            return;
        }
        HashMap<String, Integer> wordsCollection = new HashMap<String, Integer>();
        while (scanner.hasNext()){
            String nextWord = scanner.next().replaceAll("\\pP", "").toLowerCase();
            if (!wordsCollection.containsKey(nextWord)){
                wordsCollection.put(nextWord, 1);
            } else{
                wordsCollection.replace(nextWord, wordsCollection.get(nextWord)+1);
            }
        }
        scanner.close();
        int topsize = wordsCollection.entrySet().size() >= 10 ? 10: wordsCollection.entrySet().size();
        for (int i = 1; i <= topsize;i++){
            Map.Entry<String, Integer> maxcount = null;
            for (Map.Entry<String, Integer> word : wordsCollection.entrySet()){
                if (maxcount == null || maxcount.getValue() < word.getValue()){
                    maxcount = Map.entry(word.getKey(), word.getValue());
                }
            }
            System.out.println(maxcount.getKey() + ": " + maxcount.getValue());
            wordsCollection.remove(maxcount.getKey());
        }
     }
}

