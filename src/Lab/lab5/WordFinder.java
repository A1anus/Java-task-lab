package Lab.lab5;

import java.util.regex.*;

public class WordFinder{
    public static void main(String[] args){
        String text = "The MTUCI is one of the largest academic-research centers aimed at educating students and retraining professionals in the field of telecommunication, radio engineering and economics.\r\n" + //
                "The history of the University goes back to the Moscow Institute of Electrical Engineering and Public Communications founded in 1921.\r\n" + //
                "In 1992 the Institute was transformed into the Moscow Technical University of Communications and Informatics.\r\n" + //
                "The teaching staff of the University consists of a lot of professors, assistant professors and lecturers of whom seventy percent have scientific degrees of Doctor of Science or Candidate of Science.";
        Pattern pattern = Pattern.compile("\\ba[A-Za-z]+\\b");
        Matcher matcher = pattern.matcher(text);
        boolean finder = false;
        while (matcher.find()){
            System.out.println(matcher.group());
            finder = true;
        }
        if (!finder) {
            System.out.println("Word not found");
        }
        
    }
}