package fis.java.project.dao.storage;

import fis.java.project.model.Storage;

public interface IDAOStorage {
    public void add(Storage storage);
    public Storage remove(int code);
    public Storage update(Storage storage);
}
