package p05_shuffle_bits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger firstNumber = new BigInteger(reader.readLine());
        BigInteger secondNumber = new BigInteger(reader.readLine());

        BigInteger one = new BigInteger("1");
        BigInteger three = new BigInteger("3");

        BigInteger result = BigInteger.ZERO;

        if (firstNumber.compareTo(secondNumber) == 0 || firstNumber.compareTo(secondNumber) == 1) {
            for (int i = 31; i >= 0; i--) {
                BigInteger maskFirstNumber = firstNumber.shiftRight(i);
                BigInteger maskSecondNumber = secondNumber.shiftRight(i);

                BigInteger bitFirstNumber = maskFirstNumber.and(one);
                BigInteger bitSecondNumber = maskSecondNumber.and(one);

                result = result.or(bitFirstNumber.shiftLeft(i * 2 + 1));
                result = result.or(bitSecondNumber.shiftLeft(i * 2));
            }
        } else {
            for (int i = 30; i >= 0; i -= 2) {
                BigInteger maskFirstNumber = firstNumber.shiftRight(i);
                BigInteger maskSecondNumber = secondNumber.shiftRight(i);

                BigInteger bitFirstNumber = maskFirstNumber.and(three);
                BigInteger bitSecondNumber = maskSecondNumber.and(three);

                result = result.or(bitFirstNumber.shiftLeft(i * 2 + 2));
                result = result.or(bitSecondNumber.shiftLeft(i * 2));
            }
        }
        System.out.println(result);
    }
}
