package P08FielsandStreamsLab;

import java.io.File;
import java.util.ArrayDeque;

public class P08NestedFolders {
    public static void main(String[] args) {
        File root = new File("D:\\SoftUni\\4.JavaAdvanced-September2017\\Docs\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.add(root);
        int count = 0;
        while (queue.size() > 0) {
            File current = queue.poll();
            System.out.println(current.getName());
            count++;

            for (File dir: current.listFiles()) {
                if (dir.isDirectory()){
                    queue.offer(dir);
                }
            }
        }
        System.out.println(count + " folders");
    }
}
