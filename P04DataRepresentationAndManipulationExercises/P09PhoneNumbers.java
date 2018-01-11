package P04DataRepresentationAndManipulationExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

        public class P09PhoneNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        String pattern = "(?<name>[A-Z][A-Za-z]*)(?:[^A-Za-z+]*?)(?<number>\\+?[0-9][0-9\\(\\)\\/.\\- ]+)";
        Pattern regex = Pattern.compile(pattern);
        boolean matchesFound = false;
        StringBuilder sb = new StringBuilder();

        while (!input.equals("END")) {
            Matcher matcher = regex.matcher(input);

            while (matcher.find()) {
                String name = matcher.group("name").trim();
                String number = matcher.group("number").trim().replaceAll("[\\(\\)\\/.\\- ]", "");
                sb.append("<li><b>" + name + ":</b> " + number + "</li>");
                matchesFound  = true;
            }
            input = reader.readLine();
        }

        if (matchesFound) {
            System.out.println("<ol>" + sb.toString() + "</ol>");

        } else {
            System.out.println("<p>No matches!</p>");
        }
    }
}
