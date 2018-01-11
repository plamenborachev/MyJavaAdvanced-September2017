package P06FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class P04FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] bounds = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int lowerBound = bounds[0];
        int upperBound = bounds[1];
        String command = reader.readLine();

        Predicate<Integer> isEven = number -> number % 2 == 0;

        if (command.equalsIgnoreCase("odd")){
            printOdd(lowerBound, upperBound, isEven);
        } else if (command.equalsIgnoreCase("even")){
            printEven(lowerBound, upperBound, isEven);
        }
    }

    private static void printEven(int lowerBound, int upperBound, Predicate<Integer> isEven) {
        for (int i = lowerBound; i <= upperBound; i++) {
            if (isEven.test(i)){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static void printOdd(int lowerBound, int upperBound, Predicate<Integer> isEven) {
        for (int i = lowerBound; i <= upperBound; i++) {
            if (!isEven.test(i)){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
