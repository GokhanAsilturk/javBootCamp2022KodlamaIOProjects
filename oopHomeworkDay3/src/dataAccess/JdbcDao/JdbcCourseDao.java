package dataAccess.JdbcDao;

import dataAccess.Interface.ICourseDao;
import entities.Course;

public class JdbcCourseDao implements ICourseDao {
    @Override
    public void add(Course course) {
        System.out.println("Category added to database with 'JDBC'. ID: "+course.getId());
    }
}
