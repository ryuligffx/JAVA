import java.util.*;
import java.io.*;

class Student {
    private int id;
    private String name;
    private int age;
    private String grade;
    private String email;
    private String phone;

    public Student(int id, String name, int age, String grade, String email, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.email = email;
        this.phone = phone;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Age: %d | Grade: %s | Email: %s | Phone: %s",
                id, name, age, grade, email, phone);
    }
}

class StudentManagementSystem {
    private List<Student> students;
    private static final String FILE_NAME = "students.dat";

    public StudentManagementSystem() {
        students = new ArrayList<>();
        loadFromFile();
    }

    // Add a new student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // View all students
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found in the system.");
            return;
        }

        System.out.println("\n========== ALL STUDENTS ==========");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("Total students: " + students.size());
    }

    // Search student by ID
    public Student searchStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    // Search students by name
    public List<Student> searchStudentByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(student);
            }
        }
        return result;
    }

    // Update student information
    public boolean updateStudent(int id, String name, int age, String grade, String email, String phone) {
        Student student = searchStudentById(id);
        if (student != null) {
            student.setName(name);
            student.setAge(age);
            student.setGrade(grade);
            student.setEmail(email);
            student.setPhone(phone);
            System.out.println("Student information updated successfully!");
            return true;
        }
        System.out.println("Student with ID " + id + " not found!");
        return false;
    }

    // Delete student by ID
    public boolean deleteStudent(int id) {
        Student student = searchStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
            return true;
        }
        System.out.println("Student with ID " + id + " not found!");
        return false;
    }

    // Get statistics
    public void displayStatistics() {
        if (students.isEmpty()) {
            System.out.println("No students to display statistics.");
            return;
        }

        System.out.println("\n========== STATISTICS ==========");
        System.out.println("Total students: " + students.size());

        // Count by grade
        Map<String, Integer> gradeCount = new HashMap<>();
        for (Student student : students) {
            gradeCount.put(student.getGrade(), gradeCount.getOrDefault(student.getGrade(), 0) + 1);
        }

        System.out.println("\nStudents by Grade:");
        for (Map.Entry<String, Integer> entry : gradeCount.entrySet()) {
            System.out.println("Grade " + entry.getKey() + ": " + entry.getValue() + " students");
        }

        // Age statistics
        int totalAge = 0;
        int minAge = Integer.MAX_VALUE;
        int maxAge = Integer.MIN_VALUE;

        for (Student student : students) {
            int age = student.getAge();
            totalAge += age;
            minAge = Math.min(minAge, age);
            maxAge = Math.max(maxAge, age);
        }

        double averageAge = (double) totalAge / students.size();
        System.out.println("\nAge Statistics:");
        System.out.println("Minimum Age: " + minAge);
        System.out.println("Maximum Age: " + maxAge);
        System.out.println("Average Age: " + String.format("%.2f", averageAge));
    }

    // Save data to file
    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load data from file
    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (ArrayList<Student>) ois.readObject();
            System.out.println("Data loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}

public class StudentRecordSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentManagementSystem sms = new StudentManagementSystem();

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("   STUDENT RECORD MANAGEMENT SYSTEM   ");
        System.out.println("======================================");

        while (true) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    addStudentMenu();
                    break;
                case 2:
                    sms.viewAllStudents();
                    break;
                case 3:
                    searchStudentMenu();
                    break;
                case 4:
                    updateStudentMenu();
                    break;
                case 5:
                    deleteStudentMenu();
                    break;
                case 6:
                    sms.displayStatistics();
                    break;
                case 7:
                    sms.saveToFile();
                    break;
                case 8:
                    System.out.println("Thank you for using Student Record Management System!");
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }

    private static void displayMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. Add New Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student Information");
        System.out.println("5. Delete Student");
        System.out.println("6. View Statistics");
        System.out.println("7. Save Data to File");
        System.out.println("8. Exit");
        System.out.println("================================");
    }

    private static void addStudentMenu() {
        System.out.println("\n========== ADD NEW STUDENT ==========");

        int id = getIntInput("Enter Student ID: ");

        // Check if ID already exists
        if (sms.searchStudentById(id) != null) {
            System.out.println("Student with ID " + id + " already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        int age = getIntInput("Enter Age: ");

        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        Student student = new Student(id, name, age, grade, email, phone);
        sms.addStudent(student);
    }

    private static void searchStudentMenu() {
        System.out.println("\n========== SEARCH STUDENT ==========");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        int choice = getIntInput("Enter your choice: ");

        switch (choice) {
            case 1:
                int id = getIntInput("Enter Student ID to search: ");
                Student student = sms.searchStudentById(id);
                if (student != null) {
                    System.out.println("\nStudent Found:");
                    System.out.println(student);
                } else {
                    System.out.println("Student with ID " + id + " not found!");
                }
                break;

            case 2:
                System.out.print("Enter Student Name to search: ");
                String name = scanner.nextLine();
                List<Student> students = sms.searchStudentByName(name);
                if (!students.isEmpty()) {
                    System.out.println("\nFound " + students.size() + " student(s):");
                    for (Student s : students) {
                        System.out.println(s);
                    }
                } else {
                    System.out.println("No students found with name containing: " + name);
                }
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }

    private static void updateStudentMenu() {
        System.out.println("\n========== UPDATE STUDENT ==========");
        int id = getIntInput("Enter Student ID to update: ");

        Student student = sms.searchStudentById(id);
        if (student == null) {
            System.out.println("Student with ID " + id + " not found!");
            return;
        }

        System.out.println("Current Information:");
        System.out.println(student);
        System.out.println("\nEnter new information (leave blank to keep current value):");

        System.out.print("Name [" + student.getName() + "]: ");
        String name = scanner.nextLine();
        if (name.trim().isEmpty()) {
            name = student.getName();
        }

        System.out.print("Age [" + student.getAge() + "]: ");
        String ageStr = scanner.nextLine();
        int age = ageStr.trim().isEmpty() ? student.getAge() : Integer.parseInt(ageStr);

        System.out.print("Grade [" + student.getGrade() + "]: ");
        String grade = scanner.nextLine();
        if (grade.trim().isEmpty()) {
            grade = student.getGrade();
        }

        System.out.print("Email [" + student.getEmail() + "]: ");
        String email = scanner.nextLine();
        if (email.trim().isEmpty()) {
            email = student.getEmail();
        }

        System.out.print("Phone [" + student.getPhone() + "]: ");
        String phone = scanner.nextLine();
        if (phone.trim().isEmpty()) {
            phone = student.getPhone();
        }

        sms.updateStudent(id, name, age, grade, email, phone);
    }

    private static void deleteStudentMenu() {
        System.out.println("\n========== DELETE STUDENT ==========");
        int id = getIntInput("Enter Student ID to delete: ");

        System.out.print("Are you sure you want to delete student with ID " + id + "? (yes/no): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            sms.deleteStudent(id);
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }
}