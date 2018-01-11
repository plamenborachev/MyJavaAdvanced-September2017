package P03StringProcessingExercises;

import java.util.Scanner;

public class P04UnicodeCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        for (int i = 0; i < input.toCharArray().length; i++) {
            char ch = input.toCharArray()[i];

            String chToUnicode = String.format("u%04x", (int)ch);

            System.out.printf("\\" + chToUnicode);
        }
    }
}
