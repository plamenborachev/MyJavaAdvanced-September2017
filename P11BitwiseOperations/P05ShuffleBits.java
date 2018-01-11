//D:\SoftUni\4.JavaAdvanced-September2017\Docs\[ExamPreparations]\Programming Basics Exam - 8 November 2015 - Problem05-Shuffle-Bits\05.ShuffleBits.docx

package P00BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P05ShuffleBits {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger num1 = new BigInteger(reader.readLine());
        BigInteger num2 = new BigInteger(reader.readLine());

        BigInteger one = new BigInteger("1");
        BigInteger three = new BigInteger("3");

        BigInteger result = BigInteger.ZERO;

        if (num1.compareTo(num2) == 1 || num1.compareTo(num2) == 0) {
            for (int i = 31, j = 63; i >= 0; i--, j -= 2) {
                result = result.or(((num1.shiftRight(i)).and(one)).shiftLeft(j));
                result = result.or(((num2.shiftRight(i)).and(one)).shiftLeft(j - 1));
            }
        } else {
            for (int i = 30, j = 62; i >= 0; i -= 2, j -= 4) {
                result = result.or(((num1.shiftRight(i)).and(three)).shiftLeft(j));
                result = result.or(((num2.shiftRight(i)).and(three)).shiftLeft(j - 2));
            }
        }
        System.out.println(result);
    }
}