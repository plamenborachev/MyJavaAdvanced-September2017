package P03StringProcessingExercises;

import java.util.HashMap;
import java.util.Scanner;

public class P06MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        char[] firstWord = words[0].toCharArray();
        char[] secondWord = words[1].toCharArray();

        HashMap<Character, Character> exchangeableChars = new HashMap<>();

        boolean areExchangeable = checkAreExchangeable(firstWord, secondWord, exchangeableChars);

        if (firstWord.length < secondWord.length){
            for (int i = firstWord.length; i < secondWord.length; i++) {
                if (!exchangeableChars.containsValue(secondWord[i])){
                    areExchangeable = false;
                }
            }
        } else if (firstWord.length > secondWord.length){
            for (int i = secondWord.length; i < firstWord.length; i++) {
                if (!exchangeableChars.containsValue(firstWord[i])){
                    areExchangeable = false;
                }
            }
        }
        System.out.println(areExchangeable);
    }

    private static boolean checkAreExchangeable(char[] firstWord, char[] secondWord, HashMap<Character, Character> exchangeableChars) {
        boolean areExchangeable = true;

        for (int i = 0; i < firstWord.length; i++) {
            char firstWordLetter = firstWord[i];
            char secondWordLetter = secondWord[i];

            if (!exchangeableChars.containsKey(firstWordLetter)){
                exchangeableChars.put(firstWordLetter, secondWordLetter);
            } else {
                if (secondWordLetter == exchangeableChars.get(firstWordLetter)){
                    areExchangeable = false;
                    break;
                }
            }
        }
        return areExchangeable;
    }
}
