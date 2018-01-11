package P02AbstractionExercises;

import java.util.Scanner;

public class P07CollectTheCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[4][];

        for (int row = 0; row < 4; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        char[] commands = scanner.nextLine().toCharArray();

        int coins = 0;
        int hits = 0;

        int[] currentCoordinates = {0, 0};

        for (int i = 0; i < commands.length; i++) {
            char command = commands[i];

            if (command == 'V'){
                currentCoordinates[0]++;
            } else if (command == '>'){
                currentCoordinates[1]++;
            } else if (command == '^'){
                currentCoordinates[0]--;
            } else if (command == '<'){
                currentCoordinates[1]--;
            }

            int currentRow = currentCoordinates[0];
            int currentCol = currentCoordinates[1];

            try { if (matrix[currentRow][currentCol] == '$'){
                coins++;
            }
            } catch (IndexOutOfBoundsException e) {
                hits++;
                if (command == 'V'){
                    currentCoordinates[0]--;
                } else if (command == '>'){
                    currentCoordinates[1]--;
                } else if (command == '^'){
                    currentCoordinates[0]++;
                } else if (command == '<'){
                    currentCoordinates[1]++;
                }
            }
        }

        System.out.printf("Coins = %d%n", coins);
        System.out.printf("Walls = %d", hits);
    }
}
