package P10JavaAdvancedRetakeExam03May2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class P01HandScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int handScore = 0;
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            String currentCard = input[i];
            String suitCurrent = currentCard.charAt(currentCard.length() - 1) + "";

            if (stack.isEmpty()) {
                stack.push(currentCard);
            } else {
                String previousCard = stack.peek();
                String suitPrev = previousCard.charAt(previousCard.length() - 1) + "";

                if (suitCurrent.equalsIgnoreCase(suitPrev)) {
                    stack.push(currentCard);
                } else {
                    handScore = getHandScore(handScore, stack);
                    stack.add(currentCard);
                }
            }
        }
        if (!stack.isEmpty()){
            handScore = getHandScore(handScore, stack);
        }
        System.out.println(handScore);
    }

    private static int getHandScore(int handScore, ArrayDeque<String> stack) {
        String previousCard;
        int currentSum = 0;
        int countOfCardsInStack = stack.size();

        while(!stack.isEmpty()){
            previousCard = stack.pop();
            String facePrev = previousCard.substring(0, previousCard.length() - 1);
            currentSum += calculateCardValue(facePrev);
        }
        handScore += currentSum * countOfCardsInStack;
        return handScore;
    }

    private static Integer calculateCardValue(String face) {
        Integer cardValue = 0;
        try {
            cardValue = Integer.parseInt(face);
        } catch (NumberFormatException e) {
            if ("J".equalsIgnoreCase(face)) {
                cardValue = 12;
            } else if ("Q".equalsIgnoreCase(face)) {
                cardValue = 13;
            } else if ("K".equalsIgnoreCase(face)) {
                cardValue = 14;
            } else if ("A".equalsIgnoreCase(face)) {
                cardValue = 15;
            }
        }
        return cardValue;
    }
}
