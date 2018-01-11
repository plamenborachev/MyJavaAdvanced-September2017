package P03StringProcessingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P14SumOfAllValuesNew {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String keyString = reader.readLine();

        Pattern keyPattern = Pattern.compile("^(?<startKey>[a-zA-Z_]+)(?=[0-9])(?:.*)\\d(?<endKey>[a-zA-Z_]+)$");
        Matcher matcher = keyPattern.matcher(keyString);

        String startKey = "";
        String endtKey = "";

        if (matcher.find()){
            startKey = matcher.group("startKey");
            endtKey = matcher.group("endKey");
        }

        String inputText = reader.readLine();

        if ("".equals(startKey) || "".equals(endtKey)){
            System.out.println("<p>A key is missing</p>");
            return;
        }

        Pattern numbersPattern = Pattern.compile(Pattern.quote(startKey)
                + "(?<number>-?\\d*(?:\\.?)\\d+)" + Pattern.quote(endtKey));

        Matcher numberMatcher = numbersPattern.matcher(inputText);

        BigDecimal number = BigDecimal.ZERO;

        while(numberMatcher.find()){
            String value = numberMatcher.group("number");
            number = number.add(new BigDecimal(value));
        }

        if(!number.equals(BigDecimal.ZERO)){
            DecimalFormat format = new DecimalFormat("#.##");
            System.out.println("<p>The total value is: <em>" + format.format(number) + "</em></p>");
        } else {
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        }
    }
}
