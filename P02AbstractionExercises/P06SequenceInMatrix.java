package P02AbstractionExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P06SequenceInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        String[][] matrix = new String[rows][cols];

        fillTheMatrix(scanner, rows, cols, matrix);

        String finalElement = null;
        int finalCounter = 1;

        String currentElement = null;
        int currentCounter = 1;

        for (int col = 0, row = 0; col < matrix[0].length - 1; col++, row++) {

                if (matrix[row][col].equals(matrix[row + 1][col + 1])){
                    currentElement = matrix[row][col];
                    currentCounter++;
                } else {
                    if (currentCounter > finalCounter){
                        finalCounter = currentCounter;
                        finalElement = currentElement;
                    }
                    currentElement = null;
                    currentCounter = 1;
                }
        }

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length -1; col++) {
                if (matrix[row][col].equals(matrix[row][col + 1])){
                    currentElement = matrix[row][col];
                    currentCounter++;
                } else {
                    if (currentCounter > finalCounter){
                        finalCounter = currentCounter;
                        finalElement = currentElement;
                    }
                    currentElement = null;
                    currentCounter = 1;
                }
            }
        }

        for (int col = 0; col < matrix[0].length; col++) {

            for (int row = 0; row < matrix.length - 1; row++) {
                if (matrix[row][col].equals(matrix[row + 1][col])){
                    currentElement = matrix[row][col];
                    currentCounter++;
                } else {
                    if (currentCounter > finalCounter){
                        finalCounter = currentCounter;
                        finalElement = currentElement;
                    }
                    currentElement = null;
                    currentCounter = 1;
                }
            }
        }

        if (currentCounter > finalCounter){
            finalCounter = currentCounter;
            finalElement = currentElement;
        }

        System.out.println(finalElement);
        System.out.println(finalCounter);
    }

    private static void fillTheMatrix(Scanner scanner, int rows, int cols, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = tokens[col];
            }
        }
    }

}
