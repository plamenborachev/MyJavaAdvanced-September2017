package P05ObjectsClassesCollectionsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class P02MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<Long> stack = new ArrayDeque<>();
        ArrayDeque<Long> stackMax = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] command = reader.readLine().split("\\s+");
            String action = command[0];

            if (action.equals("1")) {
                Long element = Long.parseLong(command[1]);
                stack.push(element);
                if (stackMax.isEmpty()) {
                    stackMax.push(element);
                } else {
                    if (element > stackMax.peek()){
                        stackMax.push(element);
                    } else {
                        stackMax.push(stackMax.peek());
                    }
                }
            } else if (action.equals("2") && !stack.isEmpty() && !stackMax.isEmpty()) {
                stack.pop();
                stackMax.pop();
            } else if (action.equals("3")) {
                System.out.println(stackMax.peek());
            }
        }
    }
}
