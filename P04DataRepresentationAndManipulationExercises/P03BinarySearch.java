package P04DataRepresentationAndManipulationExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P03BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] elements = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int key = Integer.parseInt(reader.readLine());

        System.out.println(binarySearch(elements, key, 0, elements.length - 1));
    }

    private static int binarySearch(int[] nums, int key, int lo, int hi) {
        while(hi >= lo){
            int middle = (lo + hi) / 2;
            if (nums[middle] > key){
                hi = middle - 1;
            } else if (nums[middle] < key){
                lo = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
