package P03StringProcessingExercises;

import java.util.Scanner;

public class P01CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase();
        String substring = scanner.nextLine().toLowerCase();

        int indexOfSubstring = text.indexOf(substring);

        int count = 0;

        if(indexOfSubstring != -1){
            count++;
        }

        while(indexOfSubstring > -1){
            indexOfSubstring = text.indexOf(substring, indexOfSubstring + 1);
            if (indexOfSubstring > -1){
                count++;
            }
        }

        System.out.println(count);
    }
}
