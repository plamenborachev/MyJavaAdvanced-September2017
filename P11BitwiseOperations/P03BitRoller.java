//D:\SoftUni\4.JavaAdvanced-September2017\Docs\[ExamPreparations]\Exam Preparation II\03. BitRoller_Условие.docx

package P00BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03BitRoller {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());
        int forzenBit = Integer.parseInt(reader.readLine());
        int roll = Integer.parseInt(reader.readLine());

        int pillarBit = (number >> forzenBit) & 1;
        number = number &~(1 << forzenBit);

        for (int i = 0, j = 1; i < roll; j++, i++){
            int freeze = number & 1;
            if (freeze == 1) {
                number = number >> 1 | 1 << 18;
            } else {
                number = number >> 1;
            }
            if (((number>>forzenBit)&1)==1) {
                number = number | (1 << forzenBit - 1);
                number = number & ~(1 << forzenBit);
            }
        }

        number = number | (pillarBit << forzenBit);

        System.out.println(number);
    }
}
