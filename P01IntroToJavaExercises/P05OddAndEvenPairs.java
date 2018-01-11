package P01IntroToJavaExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P05OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (nums.length % 2 != 0){
            System.out.println("invalid length");
        } else {
            for (int i = 0; i < nums.length; i += 2) {
                if (nums[i] % 2 != 0 && nums[i + 1] % 2 != 0){
                    System.out.printf("%d, %d -> both are odd", nums[i], nums[i + 1]);
                    System.out.println();
                } else if (nums[i] % 2 == 0 && nums[i + 1] % 2 == 0) {
                    System.out.printf("%d, %d -> both are even", nums[i], nums[i + 1]);
                    System.out.println();
                } else {
                    System.out.printf("%d, %d -> different", nums[i], nums[i + 1]);
                    System.out.println();
                }
            }
        }
    }
}
