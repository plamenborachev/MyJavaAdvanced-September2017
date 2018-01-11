package P03StringProcessingExercises;

import java.util.Scanner;

public class P03TextFilter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (int i = 0; i < bannedWords.length; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < bannedWords[i].toCharArray().length; j++) {
                sb.append("*");
            }

            text = text.replace(bannedWords[i], sb.toString());
        }

        System.out.println(text);
    }
}
