package P08FielsandStreamsLab;

import java.io.*;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) {
        String pathInput = "D:\\SoftUni\\4.JavaAdvanced-September2017\\Docs\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOutput = "D:\\SoftUni\\4.JavaAdvanced-September2017\\Docs\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(pathInput));
            PrintWriter out = new PrintWriter(new FileWriter(pathOutput))) {
            String s = reader.readLine();
            int counter = 1;
            while(s != null){
                if(counter % 3 == 0){
                    out.println(s);
                }
                s = reader.readLine();
                counter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
