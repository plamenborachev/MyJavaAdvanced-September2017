package P06FunctionalProgrammingLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(reader.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            numbers.add(input[i]);
        }

        numbers.removeIf(n -> n % 2 != 0);
        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));

        numbers.sort((a, b) -> a.compareTo(b));
        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
    }
}
