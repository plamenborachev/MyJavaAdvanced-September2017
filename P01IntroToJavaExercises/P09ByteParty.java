package P01IntroToJavaExercises;

import java.util.Scanner;

public class P09ByteParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            numbers[i] = num;
        }

        String command = scanner.nextLine();

        while (!command.equals("party over")) {

            String[] tokens = command.split(" ");

            int action = Integer.parseInt(tokens[0]);
            int position = Integer.parseInt(tokens[1]);

            int mask = 1 << position;

            switch (action) {

                case -1:
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] ^ mask;
                    }
                    break;
                case 0:
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] & ~mask;
                    }
                    break;
                case 1:
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] | mask;
                    }
                    break;
                default:
                    break;
            }
            command = scanner.nextLine();
        }

        for (int number: numbers) {
            System.out.println(number);
        }
    }
}
