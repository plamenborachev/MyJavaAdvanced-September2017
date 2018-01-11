package P04DataRepresentationAndManipulationExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P07FindTheMissingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] numbers = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != i + 1){
                System.out.println(i + 1);
                break;
            }
            if (i == numbers.length - 1){
                System.out.println(i + 2);
            }
        }
    }
}
