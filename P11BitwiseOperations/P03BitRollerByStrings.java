//D:\SoftUni\4.JavaAdvanced-September2017\Docs\[ExamPreparations]\Exam Preparation II\03. BitRoller_Условие.docx

package P00BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03BitRollerByStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int f = Integer.parseInt(reader.readLine());
        int r = Integer.parseInt(reader.readLine());

        String numberToBits = Integer.toBinaryString(n);

        if (numberToBits.length() < 19){
            int diff = 19 - numberToBits.length();
            for (int i = 0; i < diff; i++) {
                numberToBits = "0" + numberToBits;
            }
        }

        int indexFreezed = numberToBits.length() - 1 - f;
        char freezed = numberToBits.charAt(indexFreezed);
        String rotate = numberToBits.substring(0, indexFreezed) + numberToBits.substring(indexFreezed + 1);

        for (int i = 0; i < r; i++) {
            rotate = rotate.charAt(rotate.length() - 1) + rotate.substring(0, rotate.length() - 1);
        }

        rotate = rotate.substring(0, indexFreezed) + freezed + rotate.substring(indexFreezed);
        n = Integer.parseInt(rotate, 2);
        System.out.println(n);

    }
}
