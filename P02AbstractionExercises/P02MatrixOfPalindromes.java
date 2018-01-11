package P02AbstractionExercises;

import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        String[][] matrix = new String[r][c];

        fillTheMatrix(r, c, matrix);

        printTheMatrix(matrix);
    }

    private static void fillTheMatrix(int r, int c, String[][] matrix) {
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                matrix[row][col] = Character.toString((char)(row + 97)) + Character.toString((char)(row  + col + 97)) + Character.toString((char)(row + 97));
            }
        }
    }

    private static void printTheMatrix(String[][] matrix) {
        for (String[] rows : matrix) {
            for (String element : rows) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
