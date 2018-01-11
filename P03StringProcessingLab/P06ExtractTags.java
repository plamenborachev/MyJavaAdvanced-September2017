package P03StringProcessingLab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06ExtractTags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String pattern = "<.*?>";

            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(input);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }

            input = scanner.nextLine();
        }
    }
}
