public class TeacherFullTime extends Teacher{
    private float experienceYears;

    public TeacherFullTime(String name, int experienceYears) {
        super(name);
        this.experienceYears = experienceYears;
    }

    public float calculateSalary() {
        float baseSalary = getBaseSalary();
        experienceYears *= 1.1f;
        return baseSalary * experienceYears;
    }
}
