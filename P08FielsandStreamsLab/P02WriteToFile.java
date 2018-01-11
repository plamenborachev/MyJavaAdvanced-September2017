package P08FielsandStreamsLab;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P02WriteToFile {
    public static void main(String[] args) {
        String pathInput = "D:\\SoftUni\\4.JavaAdvanced-September2017\\Docs\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOutput = "D:\\SoftUni\\4.JavaAdvanced-September2017\\Docs\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, ',', '.', '!', '?');

        try(InputStream in = new FileInputStream(pathInput);
            OutputStream out = new FileOutputStream(pathOutput)){
            int oneByte = in.read();
            while (oneByte >= 0){
                char symbol = (char) oneByte;
                if (!symbols.contains(symbol)){
                    System.out.printf("%s", symbol);
                    out.write(symbol);
                }
                oneByte = in.read();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
