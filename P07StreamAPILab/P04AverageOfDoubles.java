package P07StreamAPILab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class P04AverageOfDoubles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(s -> !s.isEmpty())
                .mapToDouble(Double::parseDouble)
                .toArray();

        DoubleStream doubleStream = DoubleStream.of(numbers);

        OptionalDouble average = doubleStream.average();

        if (average.isPresent()){
            System.out.printf("%.2f", average.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
