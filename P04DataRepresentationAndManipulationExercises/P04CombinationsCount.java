package P04DataRepresentationAndManipulationExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P04CombinationsCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        BigInteger x = calculateFactoriel(n);
        BigInteger y = calculateFactoriel(n - k);
        BigInteger z = calculateFactoriel(k);

        BigInteger result = x.divide(y.multiply(z));

        System.out.println(result);
    }

    private static BigInteger calculateFactoriel(int n) {
        if (n == 1){
            return BigInteger.valueOf(n);
        }
        return BigInteger.valueOf(n).multiply(calculateFactoriel(n - 1));
    }
}
