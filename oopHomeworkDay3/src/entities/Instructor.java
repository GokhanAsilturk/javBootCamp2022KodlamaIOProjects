package entities;

import business.TranslateManager;

public class Instructor {


    private String instructorName;
    private String instructorSurname;
    private double instructorSalary;
    private String id;

    public Instructor() {
    }

    public Instructor(String instructorName, String instructorSurname, double instructorSalary) {
        this.instructorName = instructorName;
        this.instructorSurname = instructorSurname;
        this.instructorSalary = instructorSalary;
    }


    public String getInstructorName() {
        return instructorName;
    }

    public String getId() {
        TranslateManager translate = new TranslateManager();
        return translate.TurkishToEnglish(instructorSurname.replaceAll("\\s","").toLowerCase()) + instructorName.length();
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorSurname() {
        return instructorSurname;
    }

    public void setInstructorSurname(String instructorSurname) {
        this.instructorSurname = instructorSurname;
    }

    public double getInstructorSalary() {
        return instructorSalary;
    }

    public void setInstructorSalary(double instructorSalary) {
        this.instructorSalary = instructorSalary;
    }


}
