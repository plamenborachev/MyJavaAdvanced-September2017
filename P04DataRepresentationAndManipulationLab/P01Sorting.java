package P04DataRepresentationAndManipulationLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01Sorting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

//        bubbleSort(numbers);
        selectionSort(numbers);

        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\],]", ""));
    }

    private static void bubbleSort(int[] numbers) {
        boolean swapped = true;
        do {
            swapped = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]){
                    swapElements(numbers, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    private static void selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int min = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[min]){
                    min = j;
                }
            }
            swapElements(numbers, i, min);
        }
    }

    private static void swapElements(int[] numbers, int i, int min) {
        int temp = numbers[i];
        numbers[i] = numbers[min];
        numbers[min] = temp;
    }
}
