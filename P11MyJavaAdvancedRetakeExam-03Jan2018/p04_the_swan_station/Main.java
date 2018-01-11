package p04_the_swan_station;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] firstInputLine = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> theNumbers = new ArrayDeque<>();

        for (int i = 0; i < firstInputLine.length; i++) {
            theNumbers.add(firstInputLine[i]);
        }

        int[] secondInputLine = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> integers = new ArrayDeque<>();

        for (int i = 0; i < secondInputLine.length; i++) {
            integers.add(secondInputLine[i]);
        }

        List<Integer> result = new ArrayList<>();

        while (result.size() < 6){
            int currentInteger = integers.poll();
            int firstNumber = theNumbers.peek();
            if (currentInteger % firstNumber == 0){
                result.add(currentInteger);
                theNumbers.poll();
            } else {
                integers.add(currentInteger + 1);
            }
        }

        System.out.println(result.toString().replaceAll("[\\[\\]]", ""));
    }
}
