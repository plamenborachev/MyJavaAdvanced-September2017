package P06FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P06ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = Integer.parseInt(reader.readLine());

        List<Integer> result = new ArrayList<>();

        Predicate<Integer> check = number -> number % n != 0;
        Consumer<List<Integer>> print = list -> System.out.println(list.toString().replaceAll("[\\[\\],]", ""));

        for (int i = numbers.length - 1; i >= 0 ; i--) {
            if (check.test(numbers[i])){
                result.add(numbers[i]);
            }
        }

        print.accept(result);
    }
}
