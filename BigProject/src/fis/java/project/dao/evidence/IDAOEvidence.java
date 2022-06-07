package fis.java.project.dao.evidence;

import fis.java.project.model.Evidence;

public interface IDAOEvidence {
    public void add(Evidence evidence);
    public Evidence remove(int code);
    public Evidence update(Evidence evidence);
}
