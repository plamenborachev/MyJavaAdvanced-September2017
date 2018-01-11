package P08FielsandStreamsLab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) {
        String pathInput = "D:\\SoftUni\\4.JavaAdvanced-September2017\\Docs\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOutput = "D:\\SoftUni\\4.JavaAdvanced-September2017\\Docs\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(pathInput));
             PrintWriter out = new PrintWriter(new FileOutputStream(pathOutput))) {
            while (scanner.hasNext()){
                if (scanner.hasNextInt()){
                    out.println(scanner.nextInt());
                }
                scanner.next();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
