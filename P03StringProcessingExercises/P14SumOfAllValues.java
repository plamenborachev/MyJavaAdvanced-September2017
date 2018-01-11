package P03StringProcessingExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P14SumOfAllValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keyString = scanner.nextLine();
        String textString = scanner.nextLine();

        int startKeyEndIndex = 0;

        for (int i = 0; i < keyString.toCharArray().length; i++) {
            char c = new Character(keyString.toCharArray()[i]);
            if (Character.isDigit(c)){
                startKeyEndIndex = i;
                break;
            }
        }

        String startKey = null;

        if (startKeyEndIndex != 0){
            startKey = keyString.substring(0, startKeyEndIndex);
        }

        int endKeyStartIndex = 0;

        for (int i = keyString.toCharArray().length - 1; i >= 0 ; i--) {
            char c = new Character(keyString.toCharArray()[i]);
            if (Character.isDigit(c)){
                endKeyStartIndex = i + 1;
                break;
            }
        }
        String endKey = null;

        if (endKeyStartIndex != 0){
            endKey = keyString.substring(endKeyStartIndex);
        }

        String keysPattern = "[a-zA-z_]+";
        Pattern keysRegex = Pattern.compile(keysPattern);
        Matcher matcher1 = keysRegex.matcher(startKey);
        Matcher matcher2 = keysRegex.matcher(endKey);

        double sum = 0;

        if (matcher1.find() && matcher2.find()){

            int fromIndex = -1;

            while(fromIndex >= -1){
                int startIndexCheck = textString.indexOf(startKey, fromIndex) + startKey.length();
                int endIndexCheck = textString.indexOf(endKey, startIndexCheck);

                String stringToCheck = textString.substring(startIndexCheck, endIndexCheck);

                String pattern = "\\b\\d+\\.?\\d+?\\b";
                Pattern regex = Pattern.compile(pattern);
                Matcher matcher = regex.matcher(stringToCheck);

                if (matcher.find()){
                    double num = Double.parseDouble(matcher.group());
                    sum += num;
                }

                fromIndex = endIndexCheck + endKey.length();

                if (fromIndex > textString.length()){
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}
