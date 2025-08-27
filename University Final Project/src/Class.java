import java.util.List;

public class Class {
    private String name;
    private int classroom;
    protected List<Student> studentsList;
    protected Teacher teacher;

    public Class(String name, int classroom, List<Student> studentsList, Teacher teacher) {
        this.name = name;
        this.classroom = classroom;
        this.studentsList = studentsList;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
