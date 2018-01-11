//D:\SoftUni\4.JavaAdvanced-September2017\Docs\[ExamPreparations]\C# Basics Exam 8 November 2014 - Problem05-Bit-Builder\05.BitBuilder_.docx

package P00BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P05BitBuilder {
    static int bitCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long number = Long.parseLong(reader.readLine());

        while (true) {
            String input = reader.readLine();
            int position = 0;
            countBits(number);

            if (!"quit".equals(input)) {
                position = Integer.parseInt(input);
            } else {
                break;
            }

            String command = reader.readLine();

            switch (command) {
                case "flip":
                    number ^= (long)1 << position;
                    break;
                case "remove":
                    number = removeBit(position, number);
                    break;
                case "insert":
                    number = insertBit(position, number);
                    break;
            }
        }

        System.out.println(number);
    }

    private static long removeBit(int position, long number)
    {
        long currentNumber = 0;
        boolean changeOccured = false;

        for (int bit = 0; bit < bitCount; bit++) {
            long currentBit = (number >> bit) & 1;

            if (bit != position) {
                currentNumber >>= 1;
                currentNumber |= currentBit << (bitCount - 1);
            } else {
                changeOccured = true;
            }
        }

        if (changeOccured) {
            currentNumber >>= 1;
        }
        return currentNumber;
    }

    private static long insertBit(int position, long number)
    {
        long currentNum = 0;
        boolean changeOccured = false;

        for (int bit = 0; bit < bitCount; bit++){
            currentNum >>= 1;

            if (bit == position){
                currentNum |= (long)1 << bitCount;
                bit--;
                position = -1;
                changeOccured = true;
            } else {
                long currentBit = (number >> bit) & 1;
                currentNum |= currentBit << bitCount;
            }
        }

        if (!changeOccured) {
            currentNum >>= 1;
            currentNum |= (long)1 << position;
        }
        return currentNum;
    }

    private static void countBits(long number) {
        long numToCount = number;
        bitCount = 0;

        while (numToCount > 0) {
            bitCount++;
            numToCount >>= 1;
        }
    }
}
