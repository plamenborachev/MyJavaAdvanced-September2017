package P10JavaAdvancedRetakeExam22August2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P03NMS {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = reader.readLine();

        while (!"---NMS SEND---".equalsIgnoreCase(input)){
            sb.append(input);
            input = reader.readLine();
        }
        String messages = sb.toString();
        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < messages.length() - 1; i++) {
            if (word.length() == 0){
                word.append(messages.charAt(i));
            }
            if (messages.toLowerCase().charAt(i) <= messages.toLowerCase().charAt(i + 1)){
                word.append(messages.charAt(i + 1));
            } else {
                words.add(word.toString());
                word = new StringBuilder();
                if (i == messages.length() - 2){
                    word.append(messages.charAt(i + 1));
                }
            }
        }

        if (word.length() > 0){
            words.add(word.toString());
        }

        String delimiter = reader.readLine();
        StringBuilder print = new StringBuilder();

        for (int i = 0; i < words.size(); i++) {
            print.append(words.get(i));
            if (i != words.size() - 1){
                print.append(delimiter);
            }
        }

        System.out.println(print.toString());
    }
}
