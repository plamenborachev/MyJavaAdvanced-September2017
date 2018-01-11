package P10ExamPreparation1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class P02Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<List<Integer>> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            ArrayList<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < input.length; j++) {
                tempList.add(Integer.parseInt(input[j]));
            }
            queue.add(tempList);
        }

        ArrayList<Integer> seismicities = new ArrayList<>();

        while (!queue.isEmpty()) {
            List<Integer> currentActivity = queue.poll();
            int seismicity = currentActivity.get(0);
            for (int i = 1; i < currentActivity.size(); i++) {
                if (seismicity < currentActivity.get(i)) {
                    queue.add(currentActivity.subList(i, currentActivity.size()));
                    break;
                }
            }
            seismicities.add(seismicity);
        }
        System.out.println(seismicities.size());
        System.out.println(seismicities.toString().replaceAll("[\\[\\],]", ""));
    }
}

