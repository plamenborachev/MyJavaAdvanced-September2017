package P05ObjectsClassesCollectionsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class P03BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] inputLine1 = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] inputLine2 = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int numberOfElementsToEnqueue = inputLine1[0];
        int numberOfElementsToDequeue = inputLine1[1];
        int elementToCheck = inputLine1[2];

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> queueMin = new ArrayDeque<>();

        for (int i = 0; i < numberOfElementsToEnqueue; i++) {
            int currentElement = inputLine2[i];
            queue.add(currentElement);
            if (queueMin.isEmpty()){
                queueMin.add(currentElement);
            } else {
                if (currentElement < queueMin.peek()){
                    queueMin.add(currentElement);
                    queueMin.remove();
                } else {
                    queueMin.add(queueMin.peek());
                }
            }
        }

        for (int i = 0; i < numberOfElementsToDequeue; i++) {
            queue.remove();
        }

        if (queue.contains(elementToCheck)){
            System.out.println(queue.contains(elementToCheck));
        } else {
            if (queue.isEmpty()){
                System.out.println("0");
            } else {
                System.out.println(queueMin.peek());
            }
        }
    }
}
