package P06FunctionalProgrammingLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Predicate;

public class P03CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        ArrayList<String> uppercaseWords = new ArrayList<>();

        Predicate<String> isUppercaseWord = word -> word.charAt(0) >= 65 && word.charAt(0) <= 90;


        for (int i = 0; i < input.length; i++) {
            if (isUppercaseWord.test(input[i])){
                uppercaseWords.add(input[i]);
            }
        }

        System.out.println(uppercaseWords.size());
        for (String word: uppercaseWords) {
            System.out.println(word);
        }
    }
}
