package P03StringProcessingLab;

import java.util.Scanner;

public class P03ParseTags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String openTag = "<upcase>";
        String closeTag = "</upcase>";

        while (text.contains(openTag)){

            int startIndex = text.indexOf(openTag) + openTag.length();
            int endIndex = text.indexOf(closeTag);

            String forReplacement = text.substring(startIndex, endIndex);

            text = text.replace(openTag + forReplacement + closeTag, forReplacement.toUpperCase());
        }

        System.out.println(text);
    }
}
