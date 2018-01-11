package P03StringProcessingLab;

import java.util.Scanner;

public class P04SeriesOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();

        StringBuilder output = new StringBuilder();

        int state = 0;
        char prev = input[0];

        for (int i = 0; i < input.length; i++) {
            switch (state) {
                case 0:
                    state = 1;
                    prev = input[i];
                    break;
                case 1:
                    output.append(prev);
                    if (input[i] == prev) {
                        state = 2;
                    }
                    prev = input[i];
                    break;
                case 2:
                    if (input[i] != prev) {
                        state = 1;
                    }
                    prev = input[i];
                    break;
            }
            if (input[i - 2] != prev) {
                output.append(prev);
            }
        }

        System.out.println(output.toString());
    }
}
