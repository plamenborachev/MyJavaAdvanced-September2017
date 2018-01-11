package P06FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class P10ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            boolean isDivisible = true;
            for (int j = 0; j < numbers.length; j++) {
                int divisor = numbers[j];
                Predicate<Integer> divisible = number -> number % divisor == 0;
                if (!divisible.test(i)){
                    isDivisible = false;
                    break;
                }
            }
            if (isDivisible){
                result.add(i);
            }
        }
        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }
}
