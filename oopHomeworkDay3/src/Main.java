import business.CategoryManager;
import business.CourseManager;
import business.InstructorManager;
import core.logging.DatabaseLogger;
import core.logging.FileLogger;
import core.logging.ILogger;
import core.logging.MailLogger;
import dataAccess.HibernateDao.HibernateCategoryDao;
import dataAccess.JdbcDao.JdbcCourseDao;
import dataAccess.JdbcDao.JdbcInstructorDao;
import entities.Category;
import entities.Course;
import entities.Instructor;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("_____________________________Course____________________________________");
        Course course1 = new Course("Java Kampı 2022",10);
        //Course course2 = new Course("C# Kampı 2022",0);


        List<Course> courseDatabase = new ArrayList<>();

        ILogger[] loggers = {new FileLogger(),new DatabaseLogger(),new MailLogger()};

        CourseManager courseManager = new CourseManager(new JdbcCourseDao(),loggers,courseDatabase);
        courseManager.add(course1);
        //courseManager.add(course2);
        System.out.println("_____________________________Category____________________________________");

        Category category1 = new Category("Nesne Yönelimli Programlama Eğitimi");
        //Category category2 = new Category("Siber Güvenlik Eğitimi");

        List<Category> categoryDataBase = new ArrayList<>();

        CategoryManager categoryManager = new CategoryManager(new HibernateCategoryDao(),loggers,categoryDataBase);
        categoryManager.add(category1);
        //categoryManager.add(category2);

        System.out.println("_____________________________Instructor____________________________________");

        Instructor instructor = new Instructor("Engin","Demiroğ",15000);
        InstructorManager instructorManager = new InstructorManager(new JdbcInstructorDao(),loggers);
        instructorManager.add(instructor);

    }
}
