package P08FielsandStreamsLab;

import java.io.File;

public class P07ListFiles {
    public static void main(String[] args) {
        File file = new File("D:\\SoftUni\\4.JavaAdvanced-September2017\\Docs\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        if (file.exists()){
            if(file.isDirectory()){
                File[] files = file.listFiles();
                for (File item: files) {
                    if (!item.isDirectory()){
                        System.out.printf("%s: %d\n", item.getName(), item.length());
                    }
                }
            }
        }
    }
}
