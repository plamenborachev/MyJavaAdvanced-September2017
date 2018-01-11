package P03StringProcessingLab;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P07ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayList<String> result = new ArrayList<>();

        while (!input.equals("END")) {

            String pattern = "^[A-Za-z0-9-_]{3,16}$";

            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(input);

            if (matcher.find()) {
                result.add("valid");
            } else {
                result.add("invalid");
            }

            input = scanner.nextLine();
        }

        if(result.contains("valid")) {
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }
        }
    }
}
