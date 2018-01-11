package P03StringProcessingExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P13SentenceExtractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keyword = scanner.nextLine();

        String text = scanner.nextLine();

        String[] sentences = text.split("[.!?]");

        String pattern = "\\b" + keyword + "\\b";

        for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i].trim();

            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(sentence);

            String fullSentence = text.substring(text.indexOf(sentence), text.indexOf(sentence) + sentence.length() + 1);

            if (matcher.find()){
                System.out.println(fullSentence);
            }
        }
    }
}
