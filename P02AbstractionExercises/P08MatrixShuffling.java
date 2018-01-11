package P02AbstractionExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P08MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = size[0];
        int cols = size[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }

        String[] commands = scanner.nextLine().split("\\s+");

        while (!commands[0].equals("END")) {

            if (commands.length == 5 && commands[0].equals("swap")){

                int row1 = Integer.parseInt(commands[1]);
                int col1 = Integer.parseInt(commands[2]);
                int row2 = Integer.parseInt(commands[3]);
                int col2 = Integer.parseInt(commands[4]);

                String tempElement = null;

                try {
                    tempElement = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = tempElement;

                    for (String[] row : matrix) {
                        for (String element : row) {
                            System.out.print(element + " ");
                        }
                        System.out.println();
                    }

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid input!");
                }

            } else {
                System.out.println("Invalid input!");
            }
            commands = scanner.nextLine().split("\\s+");
        }
    }
}
