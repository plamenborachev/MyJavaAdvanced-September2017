package P02AbstractionExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P10PlusRemove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<char[]> originalMatrix = new ArrayList<>();
        List<char[]> copyMatrix = new ArrayList<>();

        while(!input.equals("END")){

            originalMatrix.add(input.toCharArray());
            copyMatrix.add(input.toUpperCase().toCharArray());


            input = scanner.nextLine();
        }

        manupulateMatrix(originalMatrix, copyMatrix);

        printOriginalMatrix(originalMatrix);
    }

    private static void printOriginalMatrix(List<char[]> originalMatrix) {
        for (int i = 0; i < originalMatrix.size(); i++) {
            System.out.println(Arrays.toString(originalMatrix.get(i)).replaceAll("[\\[\\], ]", ""));
        }
    }

    private static void manupulateMatrix(List<char[]> originalMatrix, List<char[]> copyMatrix) {
        for (int row = 0; row < originalMatrix.size() - 2; row++) {
            for (int col = 1; col < originalMatrix.get(row).length; col++) {
                try {
                    char a = copyMatrix.get(row)[col];
                    char b = copyMatrix.get(row + 1)[col - 1];
                    char c = copyMatrix.get(row + 1)[col];
                    char d = copyMatrix.get(row + 1)[col + 1];
                    char e = copyMatrix.get(row + 2)[col];

                    if (a == b && b == c && c == d && d == e){
                        originalMatrix.get(row)[col] = '\0';
                        originalMatrix.get(row + 1)[col - 1] = '\0';
                        originalMatrix.get(row + 1)[col] = '\0';
                        originalMatrix.get(row + 1)[col + 1] = '\0';
                        originalMatrix.get(row + 2)[col] = '\0';
                    }

                } catch (IndexOutOfBoundsException e){}
            }
        }
    }
}
