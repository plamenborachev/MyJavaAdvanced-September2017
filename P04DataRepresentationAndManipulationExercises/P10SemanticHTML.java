package P04DataRepresentationAndManipulationExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P10SemanticHTML {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        String openTagPattern = "(div)(?:.*?)((id|class)\\s*=\\s*\"(\\w+)\")[^>]*";
        String closeTagPattern = "<\\/div>\\s*<!--\\s*(\\w+)\\s*-->";

        Pattern openTagRegex = Pattern.compile(openTagPattern);
        Pattern closeTagRegex = Pattern.compile(closeTagPattern);

        while(!input.equals("END")){
            Matcher matcher1 = openTagRegex.matcher(input);
            Matcher matcher2 = closeTagRegex.matcher(input);

            boolean matchFound = false;

            if (matcher1.find()){
                String output = "<" + matcher1.group()
                        .replace("div", matcher1.group(4))
                        .replace(matcher1.group(2), "");
                output = output
                        .replaceAll("\\s{2,}", " ")
                        .trim() + ">";
                System.out.println(output);
                matchFound = true;
            }
            if (matcher2.find()){
                System.out.println("</" + matcher2.group(1) + ">");
                matchFound = true;
            }
            if (!matchFound){
                System.out.println(input);
            }
            input = reader.readLine();
        }
    }
}
