package p05_bit_swapper;

//  https://judge.softuni.bg/Contests/Practice/Index/37#4
//  C# Basics Exam 7 November 2014

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger number0 = new BigInteger(reader.readLine());
        BigInteger number1 = new BigInteger(reader.readLine());
        BigInteger number2 = new BigInteger(reader.readLine());
        BigInteger number3 = new BigInteger(reader.readLine());

        BigInteger[] numbers = {number0, number1, number2, number3};
        BigInteger[] masks = {
                new BigInteger("0"),
                new BigInteger("15"),
                new BigInteger("255"),
                new BigInteger("4095"),
                new BigInteger("65535"),
                new BigInteger("1048575"),
                new BigInteger("16777215"),
                new BigInteger("268435455")
                };
        BigInteger fifteen = new BigInteger("15");

        String[] inputLine1 = reader.readLine().split("\\s+");

        while (!"End".equals(inputLine1[0])) {
            String[] inputLine2 = reader.readLine().split("\\s+");

            int firstNumberIndex = Integer.parseInt(inputLine1[0]);
            int groupOfBitsFromFirstNumber = Integer.parseInt(inputLine1[1]);

            int secondNumberIndex = Integer.parseInt(inputLine2[0]);
            int groupOfBitsFromSecondNumber = Integer.parseInt(inputLine2[1]);

            BigInteger bitsFromFirstNumber = (numbers[firstNumberIndex].shiftRight(groupOfBitsFromFirstNumber * 4)).and(fifteen);
            BigInteger bitsFromSecondNumber = (numbers[secondNumberIndex].shiftRight(groupOfBitsFromSecondNumber * 4)).and(fifteen);

            numbers[firstNumberIndex] = numbers[firstNumberIndex]
                    .shiftRight(groupOfBitsFromFirstNumber * 4 + 4)
                    .shiftLeft(groupOfBitsFromFirstNumber * 4 + 4)
                    .or(bitsFromSecondNumber.shiftLeft(groupOfBitsFromFirstNumber * 4))
                    .or(numbers[firstNumberIndex].and(masks[groupOfBitsFromFirstNumber]));

            numbers[secondNumberIndex] = numbers[secondNumberIndex]
                    .shiftRight(groupOfBitsFromSecondNumber * 4 + 4)
                    .shiftLeft(groupOfBitsFromSecondNumber * 4 + 4)
                    .or(bitsFromFirstNumber.shiftLeft(groupOfBitsFromSecondNumber * 4))
                    .or(numbers[secondNumberIndex].and(masks[groupOfBitsFromSecondNumber]));

//            System.out.println(Integer.toBinaryString(numbers[firstNumberIndex]));
//            System.out.println(Integer.toBinaryString(numbers[secondNumberIndex]));
//            System.out.println("----------------------------------------");

            inputLine1 = reader.readLine().split("\\s+");
        }

        System.out.println(numbers[0]);
        System.out.println(numbers[1]);
        System.out.println(numbers[2]);
        System.out.println(numbers[3]);
    }
}
