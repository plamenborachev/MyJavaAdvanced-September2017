package P04DataRepresentationAndManipulationExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P08MultiplyBigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstNumber = reader.readLine();
        String secondNumber = reader.readLine();

        firstNumber = getString(firstNumber);
        secondNumber = getString(secondNumber);

        int secondNum = Integer.parseInt(secondNumber);

        StringBuilder sb = new StringBuilder();
        int inMind = 0;

        for (int i = firstNumber.length() - 1; i >= 0; i--) {
            int firstDigit = Integer.parseInt(firstNumber.toCharArray()[i] + "");

            int productDigit = firstDigit * secondNum + inMind;
            int reminder = productDigit % 10;

            sb.append(String.valueOf(reminder));
            inMind = productDigit / 10;
        }

        if(inMind != 0){
            sb.append(String.valueOf(inMind));
        }
        if(secondNum == 0){
            System.out.println("0");
        } else {
            System.out.println(sb.reverse());
        }
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
