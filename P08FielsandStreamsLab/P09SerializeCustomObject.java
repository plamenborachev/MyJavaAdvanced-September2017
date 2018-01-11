package P08FielsandStreamsLab;

import java.io.*;

public class P09SerializeCustomObject {
    public static void main(String[] args) throws IOException {
        Cube cube = new Cube();
        cube.color = "green";
        cube.width = 15.3d;
        cube.height = 12.4d;
        cube.depth = 3d;

        String path = "D:\\SoftUni\\4.JavaAdvanced-September2017\\Docs\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\save.ser";

        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(cube);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)){
            Cube c = (Cube) ois.readObject();
            System.out.println(c.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Cube implements Serializable{
    String color;
    double width;
    double height;
    double depth;

    @Override
    public String toString() {
        return "Cube{" +
                "color='" + color + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                '}';
    }
}