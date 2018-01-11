package P06FunctionalProgrammingLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class P02SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(", ");
        Function<String, Integer> parseToInt = x -> Integer.parseInt(x);
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += parseToInt.apply(input[i]);
        }

        System.out.println("Count = " + input.length);
        System.out.println("Sum = " + sum);
    }
}
