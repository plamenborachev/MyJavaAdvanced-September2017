package P03StringProcessingExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P09MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String pattern = "^[A-Z][a-z]+ [A-Z][a-z]+$";

        Pattern regex = Pattern.compile(pattern);

        while(!input.equals("end")){
            Matcher matcher = regex.matcher(input);

            if (matcher.find()){
                System.out.println(input);
            }

            input = scanner.nextLine();
        }
    }
}
