package P08FielsandStreamsLab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class P01ReadFile {
    public static void main(String[] args) {
        String path = "D:\\SoftUni\\4.JavaAdvanced-September2017\\Docs\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try(InputStream in = new FileInputStream(path)){
            int oneByte = in.read();
            while (oneByte >= 0){
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = in.read();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
