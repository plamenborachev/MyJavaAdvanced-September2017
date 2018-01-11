package P03StringProcessingExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P10MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String pattern = "^\\+359([ -])2\\1\\d{3}\\1\\d{4}$";

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
