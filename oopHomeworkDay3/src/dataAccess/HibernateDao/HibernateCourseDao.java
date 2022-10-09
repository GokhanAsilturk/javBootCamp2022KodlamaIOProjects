package dataAccess.HibernateDao;

import dataAccess.Interface.ICourseDao;
import entities.Course;

public class HibernateCourseDao implements ICourseDao {
    @Override
    public void add(Course course) {
        System.out.println("Course added to database with 'Hibernate'. ID: "+course.getId());
    }
}
