package util;

import model.Student;
import java.io.*;
import java.util.ArrayList;

public class FileUtil {

    private static final String FILE_NAME = "students.dat";

    // Save students to file
    public static boolean saveStudents(ArrayList<Student> students) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(students);
            return true;

        } catch (IOException e) {
            System.out.println("Error saving students.");
            return false;
        }
    }

    // Load students from file
    @SuppressWarnings("unchecked")
    public static ArrayList<Student> loadStudents() {

        try (ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (ArrayList<Student>) ois.readObject();

        } catch (Exception e) {
            return new ArrayList<>();
        }   
    }
}