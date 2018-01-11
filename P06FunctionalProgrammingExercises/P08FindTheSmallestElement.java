package P06FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class P08FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> findSmallestElementIndex = number ->{
            int indexOfSmallest = 0;
            int smallestElement = Integer.MAX_VALUE;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] <= smallestElement){
                    smallestElement = number[i];
                    indexOfSmallest = i;
                }
            }
            return indexOfSmallest;
        };
        System.out.println(findSmallestElementIndex.apply(numbers));
    }
}
