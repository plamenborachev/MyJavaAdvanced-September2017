package P02AbstractionExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P11StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] command = scanner.nextLine().split("[()]");

        int degrees = Integer.parseInt(command[1]) % 360;

        String input = scanner.nextLine();

        List<String> strings = new ArrayList<>();
        int maxLength = 0;

        while(!input.equals("END")){
            strings.add(input);
            int length = input.length();

            if (length > maxLength){
                maxLength = length;
            }

            input = scanner.nextLine();
        }

        char[][] originalMatrix = new char[strings.size()][maxLength];

        for (int i = 0; i < strings.size(); i++) {
            originalMatrix[i] = String.format("%1$-" + maxLength + "s", strings.get(i)).toCharArray();
        }

        if (degrees == 90){
            char[][] resultMatrix = new char[originalMatrix[0].length][originalMatrix.length];

            for (int row = 0; row < resultMatrix.length; row++) {
                for (int col = 0; col < resultMatrix[0].length; col++) {
                    resultMatrix[row][col] = originalMatrix[originalMatrix.length - col - 1][row];
                }
            }
            printMatrix(resultMatrix);
        } else if (degrees == 270) {
            char[][] resultMatrix = new char[originalMatrix[0].length][originalMatrix.length];

            for (int row = 0; row < resultMatrix.length; row++) {
                for (int col = 0; col < resultMatrix[0].length; col++) {
                    resultMatrix[row][col] = originalMatrix[col][originalMatrix[0].length - row - 1];
                }
            }
            printMatrix(resultMatrix);
        } else if (degrees == 180){
            char[][] resultMatrix = new char[originalMatrix.length][originalMatrix[0].length];

            for (int row = 0; row < resultMatrix.length; row++) {
                for (int col = 0; col < resultMatrix[0].length; col++) {
                    resultMatrix[row][col] = originalMatrix[originalMatrix.length - row - 1][originalMatrix[0].length - col - 1];
                }
            }
            printMatrix(resultMatrix);
        } else if (degrees == 0){
            for (int i = 0; i < originalMatrix.length; i++) {
                String line = String.valueOf(originalMatrix[i]);
                System.out.println(line);
            }
        }
    }

    private static void printMatrix(char[][] resultMatrix) {
        for (int i = 0; i < resultMatrix.length; i++) {
            String line = String.valueOf(resultMatrix[i]);
            System.out.println(line);
        }
    }
}
