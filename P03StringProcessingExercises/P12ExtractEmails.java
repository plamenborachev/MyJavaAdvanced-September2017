package P03StringProcessingExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P12ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String pattern = "\\b(?<!\\S)[a-z][a-z0-9\\.\\-_]+[a-z0-9]*@[a-z][a-z\\-]+\\.[a-z][a-z\\.]+[a-z]?\\b";

        while (!input.equals("end")) {
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(input);

            while (matcher.find()) {
               System.out.println(matcher.group());
            }

            input = scanner.nextLine();
        }
    }
}
