package P02AbstractionExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P09TerroristsWin {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        String pattern = "\\|(?<bomb>.+?)\\|";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);

        while (matcher.find()) {
            String bomb = matcher.group("bomb");
            int bombCharactersSum = 0;

            for (int i = 0; i < bomb.length(); i++) {
                bombCharactersSum += bomb.toCharArray()[i];
            }

            int bombPower = bombCharactersSum % 10;

            int startIndexToReplace = input.indexOf(bomb) - 1 - bombPower;
            if (startIndexToReplace < 0) {
                startIndexToReplace = 0;
            }
            int endIndexToReplace = input.indexOf(bomb) + bomb.length() + 1 + bombPower;
            if (endIndexToReplace > input.length() - 1) {
                endIndexToReplace = input.length() - 1;
            }

            StringBuilder toReplace = new StringBuilder();
            StringBuilder replacer = new StringBuilder();

            for (int i = input.indexOf(bomb) - 2; i >= startIndexToReplace; i--) {
                if (input.charAt(i) == '|') {
                    break;
                }
                toReplace.append(input.charAt(i));
                replacer.append(".");
            }

            toReplace = toReplace.reverse();

            toReplace.append("|");
            replacer.append(".");

            for (int i = 0; i < bomb.length(); i++) {
                toReplace.append(bomb.charAt(i));
                replacer.append(".");
            }

            toReplace.append("|");
            replacer.append(".");

            for (int i = input.indexOf(bomb) + bomb.length() + 1; i < endIndexToReplace; i++) {
                if (input.charAt(i) == '|') {
                    break;
                }
                toReplace.append(input.charAt(i));
                replacer.append(".");
            }

            input = input.replace(toReplace.toString(), replacer.toString());
        }
        System.out.println(input);
    }
}
