package P01IntroToJavaExercises;

import java.util.ArrayList;
import java.util.Scanner;

public class P06HitTheTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int target = scanner.nextInt();

        ArrayList<Integer> addedNumbers = new ArrayList<Integer>();
        ArrayList<Integer> subtractedNumbers = new ArrayList<Integer>();

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i + j == target) {
                    addedNumbers.add(i);
                    addedNumbers.add(j);
                }
                if (i - j == target) {
                    subtractedNumbers.add(i);
                    subtractedNumbers.add(j);
                }
            }
        }

        for (int i = 0; i < addedNumbers.size(); i += 2) {
            System.out.printf("%d + %d = %d", addedNumbers.get(i), addedNumbers.get(i + 1), target);
            System.out.println();
        }
        for (int i = 0; i < subtractedNumbers.size(); i += 2) {
            System.out.printf("%d - %d = %d", subtractedNumbers.get(i), subtractedNumbers.get(i + 1), target);
            System.out.println();
        }
    }
}
