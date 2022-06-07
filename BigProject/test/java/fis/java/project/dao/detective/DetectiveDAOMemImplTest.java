package fis.java.project.dao.detective;

import fis.java.project.model.Detective;
import fis.java.project.model.DetectiveTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DetectiveDAOMemImplTest {
    @Test
    void get() {
        IDetectiveDAO iDetectiveDAO = DetectiveDAOMemImpl.getInstance();

        List<Detective> list = DetectiveTest.create3Detective();
        list.forEach(iDetectiveDAO::add);

        Detective detective = iDetectiveDAO.get(1L);

        assertEquals("Phuoc", detective.getPerson().getFirstName());
        assertNotEquals("Phuc", detective.getPerson().getFirstName());

        detective = iDetectiveDAO.get(2L);
        assertNull(detective);
    }

    @Test
    void remove(){
        IDetectiveDAO iDetectiveDAO = DetectiveDAOMemImpl.getInstance();

        List<Detective> list = DetectiveTest.create3Detective();
        list.forEach(iDetectiveDAO::add);

        int numOfDetective = iDetectiveDAO.getAll().size();

        Detective detective = iDetectiveDAO.remove(1L);

        assertNotNull(detective);
        assertEquals("Phuoc", detective.getPerson().getFirstName());

        assertEquals(numOfDetective - 1, iDetectiveDAO.getAll().size());

        detective = iDetectiveDAO.remove(2L);
        assertNull(detective);
    }
}