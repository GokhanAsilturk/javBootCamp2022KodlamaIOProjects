package entities;

import business.TranslateManager;

public class Course {

    private String courseName;
    private double coursePrice;
    private String id;

    public Course(){

    }

    public Course(String courseName, double coursePrice) {
        this.courseName = courseName;
        this.coursePrice = coursePrice;
    }

    public String getId() {
        TranslateManager translate = new TranslateManager();
        return translate.TurkishToEnglish(courseName.toLowerCase().replaceAll("\\s","")) + (int)coursePrice;//replaceAll methodu ile boşlukları siliyoruz.
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(double coursePrice) {
        this.coursePrice = coursePrice;
    }


}
