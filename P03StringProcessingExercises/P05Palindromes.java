package P03StringProcessingExercises;

import java.util.*;

public class P05Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("[ ,.?!:]");

        Set<String> palindromes = new TreeSet<>();

        for (int i = 0; i < input.length; i++) {
            char[] currentWord = input[i].toCharArray();

            boolean isPalindrome = true;

            for (int j = 0; j < currentWord.length / 2; j++) {
                if (currentWord[j] != currentWord[currentWord.length - 1 - j]) {
                    isPalindrome = false;
                }
            }

            if (isPalindrome && !input[i].equals("")) {
                palindromes.add(input[i]);
            }
        }

        System.out.println(palindromes);
    }
}
