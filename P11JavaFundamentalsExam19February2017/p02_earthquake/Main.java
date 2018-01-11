package p02_earthquake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        ArrayDeque<List<Integer>> seismicActivities = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            List<Integer> waves = new ArrayList<>();
            String[] input = reader.readLine().split("\\s+");
            for (int j = 0; j < input.length; j++) {
                waves.add(Integer.parseInt(input[j]));
            }
            seismicActivities.addLast(waves);
        }

        List<Integer> seismicities = new ArrayList<>();

        while (seismicActivities.size() > 0){
            List<Integer> currentActivity = seismicActivities.poll();
            int seismicity = currentActivity.get(0);

            for (int i = 1; i < currentActivity.size(); i++) {
                if (seismicity < currentActivity.get(i)){
                    seismicActivities.addLast(currentActivity.subList(i, currentActivity.size()));
                    break;
                }
            }
            seismicities.add(seismicity);
        }
        System.out.println(seismicities.size());
        System.out.println(seismicities.toString().replaceAll("[,\\[\\]]", ""));
    }
}
