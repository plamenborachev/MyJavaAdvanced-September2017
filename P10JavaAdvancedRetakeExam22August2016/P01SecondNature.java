package P10JavaAdvancedRetakeExam22August2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01SecondNature {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] flowers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] buckets = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> secondNature = new ArrayList<>();
        int indexCurrentFlower = 0;

        for (int i = buckets.length - 1; i >= 0; i--) {
            for (int j = indexCurrentFlower; j < flowers.length; j++) {
                int currentFlower = flowers[j];
                if (currentFlower > buckets[i]) {
                    flowers[j] -= buckets[i];
                } else if (currentFlower < buckets[i]) {
                    if (i == 0) {
                        buckets[i] = buckets[i] - currentFlower;
                    } else {
                        buckets[i - 1] += (buckets[i] - currentFlower);
                    }
                    flowers[j] = 0;
                    indexCurrentFlower++;
                } else {
                    flowers[j] = 0;
                    secondNature.add(currentFlower);
                    indexCurrentFlower++;
                }
                buckets[i] = 0;
            }
        }

        List<Integer> flowersLeft = new ArrayList<>();

        for (int i = 0; i < flowers.length; i++) {
            if (flowers[i] != 0) {
                flowersLeft.add(flowers[i]);
            }
        }

        List<Integer> bucketsLeft = new ArrayList<>();

        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != 0) {
                bucketsLeft.add(buckets[i]);
            }
        }
        if (!bucketsLeft.isEmpty()){
            System.out.println(bucketsLeft.toString().replaceAll("[\\[\\],]", ""));
        } else {
            System.out.println(flowersLeft.toString().replaceAll("[\\[\\],]", ""));
        }

        if (!secondNature.isEmpty()) {
            System.out.println(secondNature.toString().replaceAll("[\\[\\],]", ""));
        } else {
            System.out.println("None");
        }
    }
}
