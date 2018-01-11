package JavaAdvancedExam22Oct2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class P02LittleAlchemy {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (numbers.length > 0) {
            for (int i = 0; i < numbers.length; i++) {
                queue.add(numbers[i]);
            }
        }

        String input = reader.readLine();

        while (!"Revision".equalsIgnoreCase(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[2]);

            if ("Apply".equalsIgnoreCase(command)) {
                for (int i = 0; i < value; i++) {
                    if (!queue.isEmpty()) {
                        int currentStrone = queue.remove();
                        if (currentStrone > 1) {
                            queue.add(currentStrone - 1);
                        } else {
                            stack.push(0);
                        }
                    }
                }
            } else if ("Air".equalsIgnoreCase(command)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                    queue.add(value);
                }
            }
            input = reader.readLine();
        }
        System.out.println(queue.toString().replaceAll("[\\[\\],]", ""));
        System.out.println(stack.size());
    }
}
