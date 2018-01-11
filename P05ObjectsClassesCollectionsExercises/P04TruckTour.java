package P05ObjectsClassesCollectionsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P04TruckTour {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt((reader.readLine()));

        long[] petrolFromPums = new long[n];
        long[] distances = new long[n];

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            long petrol = Long.parseLong(input[0]);
            long distance = Long.parseLong(input[1]);

            petrolFromPums[i] = petrol;
            distances[i] = distance;
        }

        long tank = 0L;
        int start = 0;
        int end = n;

        for (int i = start; i < end; i++) {
            long petrolFromPump = petrolFromPums[i % n];
            long distanceToNextPump = distances[i % n];
            tank += petrolFromPump;

            if (tank < distanceToNextPump){
                start++;
                end++;
            } else {
                tank -= distanceToNextPump;
            }
        }

        System.out.println(start);
    }
}
