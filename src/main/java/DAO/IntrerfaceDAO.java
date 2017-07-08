package DAO;

/**
 * Created by Eugen on 7/6/2017.
 */
public interface IntrerfaceDAO<T> {
    Boolean insert(T student);
    T read(T student);
    T update(T student);
    Boolean delete(T student);

}

/*
* CRUD - CREATE READ UPDATE DELETE
* OOP  - INSERT SELECT UPDATE DELETE
* */