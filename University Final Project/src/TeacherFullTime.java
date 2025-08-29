public class TeacherFullTime extends Teacher{
    private float experienceYears;

    public TeacherFullTime(String name, float baseSalary, int experienceYears) {
        super(name);
        setBaseSalary(baseSalary);
        this.experienceYears = experienceYears;
    }

    public float calculateSalary() {
        float baseSalary = getBaseSalary();
        experienceYears *= 1.1f;
        return baseSalary * experienceYears;
    }
}
