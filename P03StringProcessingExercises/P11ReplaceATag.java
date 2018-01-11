package P03StringProcessingExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P11ReplaceATag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder sb = new StringBuilder();

        while(!input.equals("END")){
            sb.append(input + "\n");

            input = scanner.nextLine();
        }

        String pattern = "(<a\\shref=.+?>)(?:\\n|.)+?(<\\/a>)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(sb.toString());

        while(matcher.find()){
            String replacement1 = matcher.group(1).replace("<a", "[URL").replace(">", "]");
            String replacement2 = matcher.group(2).replace("</a>", "[/URL]");

            int startIndexRep1 = sb.indexOf(matcher.group(1));
            int endIndexRep1 = startIndexRep1 + matcher.group(1).indexOf(">") + 1;

            int startIndexRep2 = sb.indexOf(matcher.group(2));
            int endIndexRep2 = startIndexRep2 + matcher.group(2).length();

            sb.replace(startIndexRep2, endIndexRep2, replacement2).replace(startIndexRep1, endIndexRep1, replacement1);
        }

        System.out.println(sb.toString());

    }
}
