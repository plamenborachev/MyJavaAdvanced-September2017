package P05ObjectsClassesCollectionsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P07InfixToPostfix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String[] tokens = input.split(" ");

        Map<String,Integer> priorites = new HashMap<>();
        priorites.put("*", 3);
        priorites.put("/", 3);
        priorites.put("+", 2);
        priorites.put("-", 2);
        priorites.put("(", 1);

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (checkOperand(token)) {
                queue.add(token);
            }
            if (checkOperator(token)) {
                while(!stack.isEmpty() && priorites.get(stack.peek()) >= priorites.get(token)){
                    queue.add(stack.pop());
                }
                stack.push(token);
            }
            if (token.equals("(")) {
                stack.push(token);
            }
            if (token.equals(")")) {
                while (!stack.peek().equals("(")) {
                    queue.add(stack.pop());
                }
                stack.pop();
            }
        }

        for (String element: stack) {
            queue.add(element);
        }

        System.out.println(queue.toString().replaceAll("[\\[\\],]", ""));
    }

    private static boolean checkOperator(String token) {
        String patternOperator = "[\\/*+-]";
        Pattern regexOperator = Pattern.compile(patternOperator);
        Matcher matcherOperator = regexOperator.matcher(token);
        if (!matcherOperator.find()) {
            return false;
        }
        return true;
    }

    private static boolean checkOperand(String token) {
        String patternOperand = "[0-9a-z]+";
        Pattern regexOperand = Pattern.compile(patternOperand);
        Matcher matcherOperand = regexOperand.matcher(token);
        if (!matcherOperand.find()) {
            return false;
        }
        return true;
    }
}
