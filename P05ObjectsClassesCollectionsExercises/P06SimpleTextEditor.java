package P05ObjectsClassesCollectionsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class P06SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push(sb.toString());

        for (int i = 0; i < n; i++) {
            String[] command = reader.readLine().split("\\s+");
            if (command[0].equals("1")) {
                String toAppend = command[1];
                sb.append(toAppend);
                stack.push(sb.toString());
            } else if (command[0].equals("2")) {
                int lastElememtsToErase = Integer.parseInt(command[1]);
                sb.delete(sb.length() - lastElememtsToErase, sb.length());
                stack.push(sb.toString());
            } else if (command[0].equals("3")) {
                int index = Integer.parseInt(command[1]);
                System.out.println(sb.charAt(index - 1));
            } else if (command[0].equals("4")) {
                stack.pop();
                try{
                    sb = new StringBuilder(stack.peek());
                } catch (NullPointerException e){

                }
            }
        }
    }
}
