public class TeacherPartTime extends Teacher{
    private int hoursWeek;

    public TeacherPartTime(String name, int hoursWeek) {
        super(name);
        this.hoursWeek = hoursWeek;
    }

    public float calculateSalary() {
        float baseSalary = getBaseSalary();
        return baseSalary *= hoursWeek;
    }
}
