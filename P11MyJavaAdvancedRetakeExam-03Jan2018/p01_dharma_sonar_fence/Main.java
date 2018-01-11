package p01_dharma_sonar_fence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        List<BigInteger> result = new ArrayList<>();

        BigInteger one = new BigInteger("1");
        BigInteger three = new BigInteger("3");

        while (!"Reprogram".equals(input)){
            BigInteger number = new BigInteger(input);
            for (int i = 31; i > 0; i--) {
                BigInteger currentBit = number.shiftRight(i).and(one);
                BigInteger nextBit = number.shiftRight(i - 1).and(one);
                if (currentBit.equals(nextBit)){
                    number = number.xor(three.shiftLeft(i - 1));
                    i--;
                }
            }
            result.add(number);
            input = reader.readLine();
        }

        for (BigInteger number : result) {
            System.out.println(number);
        }
    }
}
