package service;

import model.Student;
import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students = util.FileUtil.loadStudents();

    // Add student
    public boolean addStudent(Student student) {

    // check if ID already exists
    for (Student s : students) {

        if (s.getId() == student.getId()) {
            return false;
        }
    }
    students.add(student);
    util.LoggerUtil.log("Student Added: ID=" + student.getId());
    util.FileUtil.saveStudents(students);

    return true;
}

    // View all students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Search student by ID
    public Student searchStudent(int id) {

        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }
    // Search students by name
    public void searchByName(String name) {

        boolean found = false;

        for (Student s : students) {

            if (s.getName().toLowerCase().contains(name.toLowerCase())) {

                System.out.println(s);
                found = true;

            }

        }

        if (!found) {
            System.out.println("No student found with that name.");
        }
    }

    // Delete student
    public boolean deleteStudent(int id) {

        Student student = searchStudent(id);

        if (student != null) {
            students.remove(student);
            util.LoggerUtil.log("Student Deleted: ID=" + id);
            util.FileUtil.saveStudents(students);
            return true;
        }

        return false;
    }

    // Update student
    public boolean updateStudent(int id, String name, int age, String course) {

        Student student = searchStudent(id);

        if (student != null) {
            student.setName(name);
            student.setAge(age);
            student.setCourse(course);
            util.LoggerUtil.log("Student Updated: ID=" + id);
            util.FileUtil.saveStudents(students);
            return true;
        }

        return false;
    }
    public ArrayList<Student> getStudents() {
    return students;
    }
    //sort by Id
    public void sortById() {

    students.sort((s1, s2) -> Integer.compare(s1.getId(), s2.getId()));

    System.out.println("Students sorted by ID.");
    util.FileUtil.saveStudents(students);
    }

    //sort by name
    public void sortByName() {

    students.sort((s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()));

    System.out.println("Students sorted by Name.");
    util.FileUtil.saveStudents(students);
    }

    //sort by age
    public void sortByAge() {

    students.sort((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()));

    System.out.println("Students sorted by Age.");
    util.FileUtil.saveStudents(students);
    }

}