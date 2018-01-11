package P04DataRepresentationAndManipulationExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01ReverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        reverseArray(numbers, 0, numbers.length - 1);

        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\],]", ""));
    }

    private static void reverseArray(int[] arr, int start, int end){
        if (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            reverseArray(arr, start + 1, end - 1);
        }
    }
}
