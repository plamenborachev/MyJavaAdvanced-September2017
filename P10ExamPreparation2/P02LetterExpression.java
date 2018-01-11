package P10ExamPreparation2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02LetterExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        String numberPattern = "-?\\d+";
        Pattern numberRegex = Pattern.compile(numberPattern);
        Matcher numberMatcher = numberRegex.matcher(input);
        ArrayDeque<Integer> numbersQueue = new ArrayDeque<>();

        while (numberMatcher.find()) {
            numbersQueue.add(Integer.parseInt(numberMatcher.group()));
        }

        String operatorPattern = "\\D+";
        Pattern operatorRegex = Pattern.compile(operatorPattern);
        Matcher operatorMatcher = operatorRegex.matcher(input);
        ArrayDeque<String> operatorsQueue = new ArrayDeque<>();

        while (operatorMatcher.find()) {
            operatorsQueue.add(operatorMatcher.group());
        }

        int result = numbersQueue.poll();

        if (input.startsWith(operatorsQueue.peek())) {
            operatorsQueue.poll();
        }
        while (!numbersQueue.isEmpty()) {
            String operator = operatorsQueue.poll();
            int nextNumber = numbersQueue.poll();

            if (operator.length() % 2 == 0) {
                result += nextNumber;
            } else {
                result -= nextNumber;
            }
        }
        System.out.println(result);

    }
}
