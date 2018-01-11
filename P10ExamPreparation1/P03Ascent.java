package P10ExamPreparation1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String pattern = "([,_])([A-Za-z]+)(\\d)";
        Pattern regex = Pattern.compile(pattern);

        Map<String, String> map = new LinkedHashMap<>();

        while (!"Ascend".equalsIgnoreCase(input)) {
            for (Map.Entry<String, String> stringStringEntry: map.entrySet()) {
                input = input.replaceAll(stringStringEntry.getKey(), stringStringEntry.getValue());
            }
            Matcher matcher = regex.matcher(input);
            while (matcher.find()) {
                String match = matcher.group();
                String firstChar = matcher.group(1);
                String message = matcher.group(2);
                Integer digit = Integer.parseInt(matcher.group(3));
                StringBuilder sb = new StringBuilder();
                if (",".equals(firstChar)) {
                    for (int i = 0; i < message.length(); i++) {
                        sb.append((char)(message.charAt(i) + digit));
                    }
                } else if ("_".equals(firstChar)) {
                    for (int i = 0; i < message.length(); i++) {
                        sb.append((char)(message.charAt(i) - digit));
                    }
                }

                map.put(match, sb.toString());
                input = input.replace(match, sb.toString());
            }
            System.out.println(input);
            input = reader.readLine();
        }
    }
}
