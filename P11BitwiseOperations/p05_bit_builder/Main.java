//  C# Basics Exam 8 November 2014
//  https://judge.softuni.bg/Contests/36/CSharp-Basics-Exam-8-November-2014

package p05_bit_builder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long number = Long.parseLong(reader.readLine());

        String inputLine = reader.readLine();

        while (!"quit".equals(inputLine)){
            String order = reader.readLine();
            int position = Integer.parseInt(inputLine);
            long mask = 0L;
            if (position > 0){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < position; i++) {
                    sb.append("1");
                }
                String maskString = sb.toString();
                mask = Long.parseLong(maskString, 2);
            }

            long rightbits = number & mask;

            switch (order){
                case "flip":
                    number = number ^ (1L << position);
                    break;
                case "remove":
                    number = number >> (position + 1L) << position;
                    number = number | rightbits;
                    break;
                case "insert":
                    number = number >> (position) << (position + 1L);
                    number = number | (1L << position);
                    number = number | rightbits;
                    break;
                case "skip":
                    break;
            }
            inputLine = reader.readLine();
        }
        System.out.println(number);
    }
}
