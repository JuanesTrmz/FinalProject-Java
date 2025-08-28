import java.lang.Class;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Teacher> teachersList = new ArrayList<>();
        Teacher teacher1 = new TeacherFullTime("Santiago", 4);
        Teacher teacher2 = new TeacherFullTime("Isabella", 7);
        Teacher teacher3 = new TeacherPartTime("Sofía", 16);
        Teacher teacher4 = new TeacherPartTime("Jhon", 10);
        teachersList.add(teacher1);
        teachersList.add(teacher2);
        teachersList.add(teacher3);
        teachersList.add(teacher4);

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Juanes", 0,15));
        studentList.add(new Student("Diego", 1,15));
        studentList.add(new Student("Sebastian", 2,16));
        studentList.add(new Student("Juliana", 3,15));
        studentList.add(new Student("Mariana", 4,14));
        studentList.add(new Student("Elena", 5,17));

        List<Class_> classesList = new ArrayList<>();
        Class_ class1 = new Class_("Test Automation", 1, studentList, teacher1);
        Class_ class2 = new Class_("Java Basic", 2, studentList, teacher2);
        Class_ class3 = new Class_("Defects", 3, studentList, teacher3);
        Class_ class4 = new Class_("Ping Pong Fundamentals", 4, studentList, teacher4);



    }
}