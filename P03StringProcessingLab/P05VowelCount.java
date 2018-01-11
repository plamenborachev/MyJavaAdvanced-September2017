package P03StringProcessingLab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05VowelCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String pattern = "[aeiouyAEIOUY]";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);

        int count = 0;

        while(matcher.find()){
            count++;
        }

        System.out.println("Vowels: " + count);
    }
}
