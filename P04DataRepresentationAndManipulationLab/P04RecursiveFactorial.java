package P04DataRepresentationAndManipulationLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P04RecursiveFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        System.out.println(calculateFactoriel(num));
    }

    private  static int calculateFactoriel (int num){
        if (num == 1){
            return num;
        }
        return num * calculateFactoriel(num - 1);
    }
}
