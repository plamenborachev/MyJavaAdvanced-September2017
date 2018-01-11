package P03StringProcessingExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P02SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstNumber = scanner.nextLine();
        String secondNumber = scanner.nextLine();

        firstNumber = getString(firstNumber);
        secondNumber = getString(secondNumber);

        int length = Math.max(firstNumber.length(), secondNumber.length());

        if (firstNumber.length() > secondNumber.length()) {
            secondNumber = String.format("%1$" + length + "s", secondNumber);
        } else if (firstNumber.length() < secondNumber.length()) {
            firstNumber = String.format("%1$" + length + "s", firstNumber);
        }

        StringBuilder sb = new StringBuilder();
        int inMind = 0;

        for (int i = length - 1; i >= 0; i--) {
            int firstDigit = 0;
            try{
                firstDigit = Integer.parseInt(firstNumber.toCharArray()[i] + "");
            } catch (NumberFormatException nfe) {

            }

            int secondDigit = 0;
            try{
                secondDigit = Integer.parseInt(secondNumber.toCharArray()[i] + "");
            } catch (NumberFormatException nfe) {

            }

            int sum = firstDigit + secondDigit + inMind;
            int reminder = sum % 10;

            sb.append(String.valueOf(reminder));
            inMind = sum / 10;
        }

        if(inMind != 0){
            sb.append(String.valueOf(inMind));
        }

        System.out.println(sb.reverse());


    }

    private static String getString(String number) {
        int startIndex = 0;

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != '0'){
                startIndex = i;
                break;
            }
        }

        number = number.substring(startIndex);
        return number;
    }
}
