package P08FielsandStreamsLab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class P06SortLines {
    public static void main(String[] args) {
        Path inPath = Paths.get("D:\\SoftUni\\4.JavaAdvanced-September2017\\Docs\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path outPath = Paths.get("D:\\SoftUni\\4.JavaAdvanced-September2017\\Docs\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt");

        try {
            List<String> lines = Files.readAllLines(inPath);
            Collections.sort(lines);
            Files.write(outPath, lines);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
