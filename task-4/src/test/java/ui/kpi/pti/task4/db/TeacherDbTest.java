package ui.kpi.pti.task4.db;

import org.junit.Test;
import ui.kpi.pti.task4.data.Teacher;

import static org.junit.Assert.*;

public class TeacherDbTest {

    @Test
    public void testGet() throws Exception {
        TeacherDb db = new TeacherDb();
        Teacher teacher = db.get("Ivan Dulin");

        assertEquals(1L, teacher.getId().longValue());
        assertEquals("Ivan Dulin", teacher.getName());
    }

}