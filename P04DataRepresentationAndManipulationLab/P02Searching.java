package P04DataRepresentationAndManipulationLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02Searching {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int key = Integer.parseInt(reader.readLine());

        int index = -1;

        index = linearSearch(numbers, key, index);

        int start = 0;
        int end = numbers.length - 1;

//        index = binarySearch(numbers, key, index, start, end);

        System.out.println(index);
    }

    private static int linearSearch(int[] numbers, int num, int index) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == num){
                index = i;
            }
        }
        return index;
    }

    private static int binarySearch(int[] numbers, int key, int index, int start, int end) {
        while(end >= start){
            int middle = (start + end) / 2;
            if (numbers[middle] > key){
                end = middle - 1;
            } else if (numbers[middle] < key){
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
