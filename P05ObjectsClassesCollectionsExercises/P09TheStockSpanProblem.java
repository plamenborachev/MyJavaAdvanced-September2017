package P05ObjectsClassesCollectionsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class P09TheStockSpanProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] prices = new int[n];


        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(reader.readLine());
        }

        int[] result = new int[n];
        result[0] = 1;
        ArrayDeque<Integer> stack= new ArrayDeque<>();
        stack.push(0);

        for (int i = 1; i < n; i++)
        {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i])
                stack.pop();
            result[i] = (stack.isEmpty())? (i + 1) : (i - stack.peek());
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < result.length; i++) {
            sb.append(result[i] + "\n");
        }

        System.out.print(sb.toString());
    }
}
