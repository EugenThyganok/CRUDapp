package Bean;

import DAO.IntrerfaceDAO;

/**
 * Created by Eugen on 7/6/2017.
 */
public class BeanClass<T> {
    private IntrerfaceDAO intrerfaceDAO;

    public void setIntrerfaceDAO(IntrerfaceDAO intrerfaceDAO) {
        this.intrerfaceDAO = intrerfaceDAO;
    }

    public void insert(T student) {
        intrerfaceDAO.insert(student);
    }

    public void delete(T student) {
        intrerfaceDAO.delete(student);
    }

    public T read(T student) {
       T st = (T) intrerfaceDAO.read(student);
        return st;
    }
    public void update(T student) {
        intrerfaceDAO.update(student);
    }
}
