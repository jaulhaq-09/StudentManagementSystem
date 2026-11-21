package main;

import model.Student;
import service.StudentService;
import util.InputUtil;

public class Main {

    public static void main(String[] args) {

        StudentService service = new StudentService();

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Sort by ID");
            System.out.println("8. Sort by Name");
            System.out.println("9. Sort by Age");
            System.out.println("10. Exit");

            int choice = InputUtil.readInt("Choose option: ");

            switch (choice) {

                case 1:
                    int id = InputUtil.readPositiveInt("Enter ID: ");
                    String name = InputUtil.readString("Enter Name: ");
                    int age = InputUtil.readAge("Enter Age: ");
                    String course = InputUtil.readString("Enter Course: ");

                    Student student = new Student(id, name, age, course);

                    boolean added = service.addStudent(student);

                    if (added) {
                        System.out.println("Student Added Successfully!");
                    } else {
                        System.out.println("Student ID already exists!");
                    }
                    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    int searchId = InputUtil.readPositiveInt("Enter ID: ");

                    Student found = service.searchStudent(searchId);

                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;
                case 4:
                    String searchName = InputUtil.readString("Enter name to search: ");
                    service.searchByName(searchName);
                    break;

                case 5:
                    int updateId = InputUtil.readPositiveInt("Enter student ID to update: ");
                    if (service.searchStudent(updateId) == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    String newName = InputUtil.readString("Enter new name: ");
                    int newAge = InputUtil.readAge("Enter new age: ");
                    String newCourse = InputUtil.readString("Enter new course: ");

                    boolean updated = service.updateStudent(updateId, newName, newAge, newCourse);
                    System.out.println(updated
                            ? "Student updated successfully!"
                            : "Student not found.");
                    break;

                case 6:
                    int deleteId = InputUtil.readPositiveInt("Enter ID to delete: ");
                    boolean deleted = service.deleteStudent(deleteId);
                    System.out.println(deleted ? "Student deleted." : "Student not found.");
                    break;

                case 7:
                    service.sortById();
                    break;

                case 8:
                    service.sortByName();
                    break;

                case 9:
                    service.sortByAge();
                    break;

                case 10:
                    if (util.FileUtil.saveStudents(service.getStudents())) {
                        System.out.println("Students saved. Exiting...");
                    } else {
                        System.out.println("Could not save students. Exiting...");
                    }
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}