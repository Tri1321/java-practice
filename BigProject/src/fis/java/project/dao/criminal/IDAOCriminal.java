package fis.java.project.dao.criminal;

import fis.java.project.model.CriminalCase;

public interface IDAOCriminal {
    public void add(CriminalCase criminalCase);
    public CriminalCase remove(int code);
    public CriminalCase update(CriminalCase criminalCase);

}
