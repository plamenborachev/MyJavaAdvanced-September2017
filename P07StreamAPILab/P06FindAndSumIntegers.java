package P07StreamAPILab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class P06FindAndSumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        Optional<Integer> sum = Arrays.stream(input)
                .filter(x -> isNumber(x))
                .map(Integer::valueOf)
                .reduce((x, y) -> x + y);

        if (sum.isPresent()){
            System.out.println(sum.get());
        } else {
            System.out.println("No match");
        }
    }

    private static boolean isNumber(String x) {
        try{
            int number = Integer.parseInt(x);
        } catch (NumberFormatException e){
            return  false;
        }
        return true;
    }
}
