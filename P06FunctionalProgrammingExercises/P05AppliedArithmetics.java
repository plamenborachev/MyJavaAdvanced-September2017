package P06FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P05AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = reader.readLine();
        Function<Integer, Integer> add = number -> number + 1;
        Function<Integer, Integer> multiply = number -> number * 2;
        Function<Integer, Integer> subtract = number -> number - 1;
        Consumer<List<Integer>> print = arr -> System.out.println(numbers.toString()
                .replaceAll("[\\[\\],]", ""));

        while (!command.equalsIgnoreCase("end")) {
            if (command.equalsIgnoreCase("add")) {
                for (int i = 0; i < numbers.size(); i++) {
                    numbers.set(i, add.apply(numbers.get(i)));
                }
            } else if (command.equalsIgnoreCase("print")) {
                print.accept(numbers);
            } else if (command.equalsIgnoreCase("multiply")) {
                for (int i = 0; i < numbers.size(); i++) {
                    numbers.set(i, multiply.apply(numbers.get(i)));
                }
            } else if (command.equalsIgnoreCase("subtract")) {
                for (int i = 0; i < numbers.size(); i++) {
                    numbers.set(i, subtract.apply(numbers.get(i)));
                }
            }
            command = reader.readLine();
        }
    }
}
