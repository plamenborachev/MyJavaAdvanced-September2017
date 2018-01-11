//D:\SoftUni\4.JavaAdvanced-September2017\Docs\[ExamPreparations]\Exam Preparation I\01. Bit Flipper_Условие.docx

package P00BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P01BitFlipperByStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger num = new BigInteger(reader.readLine());
        String numberToBits = num.toString(2);

        if (numberToBits.length() < 64){
            int diff = 64 - numberToBits.length();
            for (int i = 0; i < diff; i++) {
                numberToBits = "0" + numberToBits;
            }
        }

        char[] bits = numberToBits.toCharArray();

        for (int i = 0; i < bits.length - 2; i++) {
            if (bits[i] == bits[i + 1] && bits[i + 1] == bits[i + 2]){
                if (bits[i] == '0'){
                    bits[i] = '1';
                    bits[i + 1] = '1';
                    bits[i + 2] = '1';
                } else {
                    bits[i] = '0';
                    bits[i + 1] = '0';
                    bits[i + 2] = '0';
                }
                i += 2;
            }
        }

        num = new BigInteger(String.valueOf(bits), 2);
        System.out.println(num);
    }
}
