package ui.kpi.pti.task4.db;

import org.junit.Test;
import ui.kpi.pti.task4.data.Student;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class StudentDbTest {

//    @Test
//    public void testGet() throws Exception {
//        StudentDb db = new StudentDb();
//        Student student = db.get("Ivan Dulin");
//
//        assertEquals(1L, student.getId().longValue());
//        assertEquals("Ivan Dulin", student.getName());
//    }

    @Test
    public void testNoStudent() {
        StudentDb db = new StudentDb();
        Student student = db.get("No student name");
        assertNull(student);
    }
}