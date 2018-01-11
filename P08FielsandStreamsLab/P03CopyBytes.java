package P08FielsandStreamsLab;

import java.io.*;

public class P03CopyBytes {
    public static void main(String[] args) {
        String pathInput = "D:\\SoftUni\\4.JavaAdvanced-September2017\\Docs\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOutput = "D:\\SoftUni\\4.JavaAdvanced-September2017\\Docs\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        try (InputStream in = new FileInputStream(pathInput);
             OutputStream out = new FileOutputStream(pathOutput)) {
            int oneByte = in.read();
            while (oneByte >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    out.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        out.write(digits.charAt(i));
                    }
                }
                oneByte = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
