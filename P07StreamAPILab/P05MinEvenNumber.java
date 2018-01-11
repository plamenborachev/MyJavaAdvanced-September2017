package P07StreamAPILab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class P05MinEvenNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        OptionalDouble minEvenNumber = Arrays.stream(input)
                .filter(s -> !s.isEmpty())
                .mapToDouble(Double::parseDouble)
                .filter(x -> x % 2 == 0)
                .sorted()
                .findFirst();

        if (minEvenNumber.isPresent()){
            System.out.printf("%.2f", minEvenNumber.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
