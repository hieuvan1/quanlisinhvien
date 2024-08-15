import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Enter student information");
            System.out.println("2. Display student list");
            System.out.println("3. Delete student");
            System.out.println("4. Sort students by grade");
            System.out.println("5. Search student by name or code");
            System.out.println("6. Search students by grade");
            System.out.println("0. Exit");
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    printStudentList();
                    break;
                case 3:
                    deleteStudent(scanner);
                    break;
                case 4:
                    sortStudentsByGrade();
                    break;
                case 5:
                    findStudentByNameOrCode(scanner);
                    break;
                case 6:
                    findStudentsByGrade(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void addStudent(Scanner scanner) {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter age:");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume the leftover newline
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter phone:");
        String phone = scanner.nextLine();
        System.out.println("Enter code:");
        String code = scanner.nextLine();
        System.out.println("Enter gender (0 for male, 1 for female):");
        int gender = scanner.nextInt();
        System.out.println("Enter grade:");
        float grade = scanner.nextFloat();
        scanner.nextLine();

        Student student = new Student(name, age, email, phone, code, gender, grade);
        studentList.add(student);
        System.out.println("Student added successfully.");
    }

    public static void printStudentList() {
        if (studentList.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    public static void deleteStudent(Scanner scanner) {
        System.out.println("Enter student code to delete:");
        String code = scanner.nextLine();
        boolean removed = studentList.removeIf(student -> student.getCode().equals(code));
        if (removed) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void sortStudentsByGrade() {
        studentList.sort(Comparator.comparing(Student::getGrade).reversed());
        System.out.println("Students sorted by grade in descending order.");
    }

    public static void findStudentByNameOrCode(Scanner scanner) {
        System.out.println("Enter name or code to search:");
        String input = scanner.nextLine();
        for (Student student : studentList) {
            if (student.getCode().equalsIgnoreCase(input) || student.getName().equalsIgnoreCase(input)) {
                System.out.println(student);
            }
        }
    }

    public static void findStudentsByGrade(Scanner scanner) {
        System.out.println("Enter minimum grade to search:");
        float grade = scanner.nextFloat();
        scanner.nextLine();  // Consume the leftover newline
        for (Student student : studentList) {
            if (student.getGrade() >= grade) {
                System.out.println(student);
            }
        }
    }

    public static class Student {
        private String name;
        private int age;
        private String email;
        private String phone;
        private String code;
        private int gender;
        private float grade;

        public Student(String name, int age, String email, String phone, String code, int gender, float grade) {
            this.name = name;
            this.age = age;
            this.email = email;
            this.phone = phone;
            this.code = code;
            this.gender = gender;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public String getCode() {
            return code;
        }

        public int getGender() {
            return gender;
        }

        public float getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", email='" + email + '\'' +
                    ", phone='" + phone + '\'' +
                    ", code='" + code + '\'' +
                    ", gender=" + (gender == 0 ? "Male" : "Female") +
                    ", grade=" + grade +
                    '}';
        }
    }
}
