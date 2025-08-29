public class TeacherPartTime extends Teacher{
    private int hoursWeek;

    public TeacherPartTime(String name, float baseSalary, int hoursWeek) {
        super(name);
        setBaseSalary(baseSalary);
        this.hoursWeek = hoursWeek;
    }

    public float calculateSalary() {
        float baseSalary = getBaseSalary();
        return baseSalary *= hoursWeek;
    }
}
