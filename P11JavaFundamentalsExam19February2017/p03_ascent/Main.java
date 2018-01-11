package p03_ascent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String message = reader.readLine();
        String pattern = "[,_][a-zA-Z]+\\d";
        Pattern regex = Pattern.compile(pattern);

        Map<String, String> encodedDecoded = new LinkedHashMap<>();

        while (!"Ascend".equals(message)){
            for (Map.Entry<String, String> encoded : encodedDecoded.entrySet()) {
                if (message.contains(encoded.getKey())){
                    message = message.replace(encoded.getKey(), encoded.getValue());
                }
            }
            Matcher matcher = regex.matcher(message);
            while (matcher.find()){
                String encoded = matcher.group();
                int digit = Integer.parseInt(encoded.substring(encoded.length() - 1));
                StringBuilder sb = new StringBuilder();
                if (encoded.startsWith(",")){
                    for (int i = 1; i < encoded.length() - 1; i++) {
                        sb.append((char) (encoded.charAt(i) + digit));
                    }
                } else if (encoded.startsWith("_")){
                    for (int i = 1; i < encoded.length() - 1; i++) {
                        sb.append((char) (encoded.charAt(i) - digit));
                    }
                }
                String decoded = sb.toString();
                message = message.replace(encoded, decoded);
                encodedDecoded.putIfAbsent(encoded, decoded);
            }
            System.out.println(message);
            message = reader.readLine();
        }
    }
}
