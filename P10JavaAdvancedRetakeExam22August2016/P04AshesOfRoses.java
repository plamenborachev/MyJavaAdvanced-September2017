package P10JavaAdvancedRetakeExam22August2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04AshesOfRoses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String pattern = "^Grow <(?<region>[A-Z][a-z]+)> <(?<color>[A-Za-z0-9]+)> (?<amount>\\d+)$";
        Pattern regex = Pattern.compile(pattern);

        Map<String, BigInteger> regionsByAmount = new LinkedHashMap<>();
        Map<String, LinkedHashMap<String, BigInteger>> regionsByColorAndAmount = new TreeMap<>();

        while (!"Icarus, Ignite!".equalsIgnoreCase(input)) {

            Matcher matcher = regex.matcher(input);

            if (matcher.find()) {
                String region = matcher.group("region");
                String color = matcher.group("color");
                BigInteger amount = BigInteger.valueOf(Long.parseLong(matcher.group("amount")));

                regionsByAmount.putIfAbsent(region, BigInteger.ZERO);
                regionsByAmount.put(region, regionsByAmount.get(region).add(amount));

                regionsByColorAndAmount.putIfAbsent(region, new LinkedHashMap<>());
                regionsByColorAndAmount.get(region).putIfAbsent(color, BigInteger.ZERO);
                regionsByColorAndAmount.get(region).put(color, regionsByColorAndAmount.get(region).get(color).add(amount));
            }

            input = reader.readLine();
        }

        Comparator<Map.Entry<String, BigInteger>> byAmount =
                Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder());
        Comparator<Map.Entry<String, BigInteger>> byRegionName =
                Comparator.comparing(Map.Entry::getKey);

        Comparator<Map.Entry<String, BigInteger>> colorsByAmount =
                Comparator.comparing(stringBigIntegerEntry -> stringBigIntegerEntry.getValue());
        Comparator<Map.Entry<String, BigInteger>> colorsByName =
                Comparator.comparing(Map.Entry::getKey);

        regionsByAmount.entrySet().stream()
                .sorted(byAmount.thenComparing(byRegionName))
                .forEach(r -> {
                    System.out.println(r.getKey());
                    regionsByColorAndAmount.get(r.getKey()).entrySet().stream()
                            .sorted(colorsByAmount.thenComparing(colorsByName))
                            .forEach(c -> System.out.println("*--" + c.getKey() + " | " + c.getValue()));
                });
    }
}
