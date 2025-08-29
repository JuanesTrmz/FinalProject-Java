import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Teacher> teacherList;
    private List<Student> studentList;
    private List<Class_> classList;
    private Scanner scanner = new Scanner(System.in);

    public Menu(List<Teacher> teacherList, List<Student> studentList, List<Class_> classList) {
        this.teacherList = teacherList;
        this.studentList = studentList;
        this.classList = classList;
    }

    public void printData() {
        int option = 0;
        while (option != 6) {
            System.out.println("\n=== University System Menu ===");
            System.out.println("1. Print all professors");
            System.out.println("2. Print all classes");
            System.out.println("3. Create a new student and add to a class");
            System.out.println("4. Create a new class");
            System.out.println("5. List all classes by student ID");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1)
                printTeachers();
            else if (option == 2)
                printClasses();
            else if (option == 3)
                createStudent();
            else if (option == 4)
                createClass();
            else if (option == 5)
                listClassesByStudent();
            else if (option == 6)
                System.out.println("Exiting... Bye!");
            else
                System.out.println("Invalid option, try again.");
        }
    }

    private void printTeachers() {
        System.out.println("\n--- Professors ---");
        for (Teacher teacher : teacherList) {
            System.out.println("Name: " + teacher.getName()
                    + " | Base Salary: " + teacher.getBaseSalary()
                    + " | Calculated Salary: " + teacher.calculateSalary());
        }
    }

    private void printClasses() {
        System.out.println("\n--- Classes ---");
        for (int i = 0; i < classList.size(); i++) {
            System.out.println((i+1) + ". " + classList.get(i).getName());
        }
        System.out.print("Select a class number to see details: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < classList.size()) {
            Class_ class_ = classList.get(index);
            System.out.println("\nClass: " + class_.getName());
            System.out.println("Classroom: " + class_.getClassroom());
            System.out.println("Teacher: " + class_.getTeacher().getName());
            System.out.println("Students:");
            for (Student student : class_.getStudentsList()) {
                System.out.println("- " + student.getName() + " (ID: " + student.getId() + ", Age: " + student.getAge() + ")");
            }
        } else {
            System.out.println("Invalid class number.");
        }
    }

    private void createStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        Student newStudent = new Student(name, id, age);
        studentList.add(newStudent);

        System.out.println("Choose a class to add the student:");
        for (int i = 0; i < classList.size(); i++) {
            System.out.println((i+1) + ". " + classList.get(i).getName());
        }
        int classIndex = scanner.nextInt() - 1;
        if (classIndex >= 0 && classIndex < classList.size()) {
            classList.get(classIndex).getStudentsList().add(newStudent);
            System.out.println("Student added to " + classList.get(classIndex).getName());
        } else {
            System.out.println("Invalid class number.");
        }
    }

    private void createClass() {
        System.out.print("Enter class name: ");
        String name = scanner.nextLine();
        System.out.print("Enter classroom number: ");
        int classroom = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Choose a teacher for this class:");
        for (int i = 0; i < teacherList.size(); i++) {
            System.out.println((i+1) + ". " + teacherList.get(i).getName());
        }
        int teacherIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        Teacher teacher = teacherList.get(teacherIndex);

        List<Student> newClassStudents = new java.util.ArrayList<>();
        System.out.println("Add students to this class (enter -1 to stop):");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println((i+1) + ". " + studentList.get(i).getName());
        }
        int studentChoice;
        do {
            System.out.print("Choose student number: ");
            studentChoice = scanner.nextInt();
            if (studentChoice > 0 && studentChoice <= studentList.size()) {
                newClassStudents.add(studentList.get(studentChoice - 1));
            }
        } while (studentChoice != -1);

        Class_ newClass = new Class_(name, classroom, newClassStudents, teacher);
        classList.add(newClass);
        System.out.println("New class created!");
    }

    private void listClassesByStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Classes for student with ID " + id + ":");
        for (Class_ class_ : classList) {
            for (Student student : class_.getStudentsList()) {
                if (student.getId() == id) {
                    System.out.println("- " + class_.getName());
                }
            }
        }
    }
}
