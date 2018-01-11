package JavaAdvancedExam22Oct2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04RegularExtensions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String pattern = reader.readLine();

        while (!"Print".equalsIgnoreCase(pattern)) {
            if (pattern.contains("%")){
                pattern = pattern.replace("%", "\\S*");
                pattern = pattern.replace(".", "\\.");

                Pattern regex = Pattern.compile(pattern);
                Matcher matcher = regex.matcher(input);

                while (matcher.find()) {
                    input = input.replace(matcher.group(), new StringBuilder(matcher.group()).reverse().toString());
                }
            } else {
                input = input.replace(pattern, new StringBuilder(pattern).reverse().toString());
            }
            pattern = reader.readLine();
        }
        System.out.println(input);
    }
}
