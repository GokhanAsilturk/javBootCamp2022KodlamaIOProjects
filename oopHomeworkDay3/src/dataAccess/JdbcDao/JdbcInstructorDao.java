package dataAccess.JdbcDao;

import dataAccess.Interface.IInstructorDao;
import entities.Instructor;

public class JdbcInstructorDao implements IInstructorDao {
    @Override
    public void add(Instructor instructor) {
        System.out.println("Instructor added to database with 'JDBC'. ID: "+instructor.getId());
    }
}
