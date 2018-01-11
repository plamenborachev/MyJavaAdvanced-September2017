package P03StringProcessingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P16ExtractHyperlinks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        StringBuilder text = new StringBuilder();

        String pattern = "<a\\s+([^>]+)?href\\s*=\\s*('([^']*)'|\"([^\"]*)\"|([^>\\s]+))[^>]*>";
        Pattern regex = Pattern.compile(pattern);

        while (!line.equals("END")){
            text.append(line);
            line = reader.readLine();
        }

        Matcher matcher = regex.matcher(text);

        while (matcher.find()){
            for (int i = 5; i >= 0; i--) {
                String result = matcher.group(i);
                if (result != null){
                    System.out.println(result);
                    break;
                }
            }
        }
    }
}
