package dataAccess.HibernateDao;

import dataAccess.Interface.ICategoryDao;
import entities.Category;

public class HibernateCategoryDao implements ICategoryDao {
    @Override
    public void add(Category category) {
        System.out.println("Course added to database with 'Hibernate'. ID: " + category.getId());
    }
}
