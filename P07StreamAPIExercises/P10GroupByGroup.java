package P07StreamAPIExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P10GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> students = new ArrayList<>();

        String input = reader.readLine();

        while (!"END".equalsIgnoreCase(input)){
            String[] tokens = input.split("\\s+");
            String name = tokens[0] + " " + tokens[1];
            int group = Integer.parseInt(tokens[2]);
            students.add(new Person(name, group));
            input = reader.readLine();
        }

        Map<Integer, List<Person>> result = students.stream().collect(Collectors.groupingBy(p -> p.getGroup()));

        for (Map.Entry group: result.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(group.getKey() + " - ");
            for (Person student: result.get(group.getKey())) {
                sb.append(student.getName() + ", ");
            }
            sb.deleteCharAt(sb.length() - 2);
            System.out.println(sb.toString());
        }
    }
}

class Person{
    String name;
    Integer group;

    public Person(String name, Integer group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Integer getGroup() {
        return this.group;
    }

    private void setGroup(Integer group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
