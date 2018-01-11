package P07StreamAPILab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class P02UpperStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> input = Arrays.asList(reader.readLine().split("\\s+"));

        input.stream()
                .map(x -> x.toUpperCase())
                .forEach(x -> System.out.print(x + " "));
    }
}
