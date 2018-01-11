package P06FunctionalProgrammingLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Function;

public class P04AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] input = Arrays.stream(reader.readLine().split(", ")).mapToDouble(Double::parseDouble).toArray();
        Function<Double, Double> calculatePriceInclVAT = price -> price * 1.2;

        System.out.println("Prices with VAT:");
        for (int i = 0; i < input.length; i++) {
            String output = String.format("%.2f", calculatePriceInclVAT.apply(input[i])).replace(".", ",");
            System.out.println(output);
        }
    }
}
