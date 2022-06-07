package fis.java.project.dao.person;

import fis.java.project.model.Person;

public interface IDAOPerson {
    public void add(Person person);
    public Person remove(int code);
    public Person update(Person person);
}
