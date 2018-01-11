package P07StreamAPIExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10LittleJohn {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder input = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            input.append(reader.readLine() + "\r\n");
        }

        String largeArrow = ">>>----->>";
        String medArrow = ">>----->";
        String smallArrow = ">----->";

        int largeArrows = countArrows(input, largeArrow);
        int mediumArrows = countArrows(input, medArrow);
        int smallArrows = countArrows(input, smallArrow);

        String countString = Integer.toString(smallArrows) + Integer.toString(mediumArrows) + Integer.toString(largeArrows) + "";
        int countDecimal = Integer.parseInt(countString);
        String binary = Integer.toBinaryString(countDecimal);
        String newBinary = binary + new StringBuilder(binary).reverse().toString();
        int message = Integer.parseInt(newBinary, 2);

        System.out.println(message);
    }

    private static int countArrows(StringBuilder input, String arrow) {
        int index = input.indexOf(arrow);
        int count = 0;
        while (index != -1){
            count++;
            input.delete(index, index + arrow.length() + 1);
            index = input.indexOf(arrow);
        }
        return count;
    }
}
