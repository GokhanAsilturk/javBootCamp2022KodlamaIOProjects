package dataAccess.HibernateDao;

import dataAccess.Interface.IInstructorDao;
import entities.Instructor;

public class HibernateInstructorDao implements IInstructorDao {
    @Override
    public void add(Instructor instructor) {
        System.out.println("Insturctor added to database with 'Hibernate'. ID: "+ instructor.getId());
    }
}
