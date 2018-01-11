package P05ObjectsClassesCollectionsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class P01BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] inputLine1 = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] inputLine2 = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int numberOfElementsToPush = inputLine1[0];
        int numberOfElementsToPop = inputLine1[1];
        int elementToCheck = inputLine1[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numberOfElementsToPush; i++) {
            stack.push(inputLine2[i]);
        }

        for (int i = 0; i < numberOfElementsToPop; i++) {
            stack.pop();
        }

        if (stack.contains(elementToCheck)){
            System.out.println(stack.contains(elementToCheck));
        } else {
            if (stack.isEmpty()){
                System.out.println("0");
            } else {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < stack.size(); i++) {
                    int current = stack.pop();
                    if (current < min){
                        min = current;
                    }
                }
                System.out.println(min);
            }
        }
    }
}
