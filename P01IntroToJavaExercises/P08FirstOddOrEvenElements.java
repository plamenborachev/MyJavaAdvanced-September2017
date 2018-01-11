package P01IntroToJavaExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P08FirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] tokens = scanner.nextLine().split(" ");

        int numberOfElements = Integer.parseInt(tokens[1]);
        String element = tokens[2];

        ArrayList<Integer> result = new ArrayList<>();

        if (element.equals("odd")) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 != 0){
                    result.add(nums[i]);
                }
            }
        } else if (element.equals("even")) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 == 0) {
                    result.add(nums[i]);
                }
            }
        }

        for (int i = 0; i < Math.min(numberOfElements, result.size()); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
