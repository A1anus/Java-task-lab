package Lab.lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinksFinder{
    public static void main(String[] args){
        String text = "https://mtuci.ru/ - официальный сайт университета связи и информатики";
        Pattern pattern = Pattern.compile("(https?://\\S+)");
        Matcher matcher = pattern.matcher(text);
        StringBuilder replacedText = new StringBuilder();
        while (matcher.find()) {
            String url = matcher.group();
            String replacement = url.replaceAll("https?://|\\/", "");
            matcher.appendReplacement(replacedText, replacement);
        }
        matcher.appendTail(replacedText);
        System.out.println(replacedText.toString());
    }
}