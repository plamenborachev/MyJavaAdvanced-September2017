//D:\SoftUni\4.JavaAdvanced-September2017\Docs\07. Java-Advanced-Stream-API-Exercises.pdf

package P00Streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P11StudentsJoinedТoSpecialties {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        List<StudentSpecialty> specialties = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        while (!"Students:".equalsIgnoreCase(input)) {
            String[] specialtyTokens = input.split("\\s+");
            String specialtyName = specialtyTokens[0] + " " + specialtyTokens[1];
            int facultyNumber = Integer.parseInt(specialtyTokens[2]);
            specialties.add(new StudentSpecialty(specialtyName, facultyNumber));
            input = reader.readLine();
        }

        input = reader.readLine();

        while (!"END".equalsIgnoreCase(input) && !"Students:".equalsIgnoreCase(input)) {
            String[] studentTokens = input.split("\\s+");
            int facultyNumber = Integer.parseInt(studentTokens[0]);
            String studentName = studentTokens[1] + " " + studentTokens[2];
            students.add(new Student(studentName, facultyNumber));
            input = reader.readLine();
        }

        students.stream().sorted(Comparator.comparing(Student::getStudentName))
                .forEach(student -> {specialties.stream()
                            .filter((spec) -> spec.getFacultyNumber().equals(student.getFacultyNumber()))
                            .forEach(specialty -> {System.out.printf("%s %s %s\n",
                                        student.getStudentName(), student.getFacultyNumber(), specialty.getSpecialtyName());
                            });
                });
    }
}

class StudentSpecialty {
    String specialtyName;
    Integer facultyNumber;

    StudentSpecialty(String specialtyName, Integer facultyNumber) {
        this.specialtyName = specialtyName;
        this.facultyNumber = facultyNumber;
    }

    String getSpecialtyName() {
        return this.specialtyName;
    }

    private void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    Integer getFacultyNumber() {
        return this.facultyNumber;
    }

    private void setFacultyNumber(Integer facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}

class Student {
    String studentName;
    Integer facultyNumber;

    Student(String studentName, Integer facultyNumber) {
        this.studentName = studentName;
        this.facultyNumber = facultyNumber;
    }

    String getStudentName() {
        return this.studentName;
    }

    private void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    Integer getFacultyNumber() {
        return this.facultyNumber;
    }

    private void setFacultyNumber(Integer facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}

