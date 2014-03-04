package dao.interfaces;

import domain_objects.Category;

public interface DAOCategory extends DAO<Category> {
    public void swap(int id1, int id2);
}
