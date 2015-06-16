package ui.kpi.pti.task4.db;

import org.junit.Test;
import ui.kpi.pti.task4.data.Course;

import java.util.List;

import static org.junit.Assert.*;

public class CourseDbTest {

    @Test
    public void testFindByTeacher() throws Exception {
        CourseDb db = new CourseDb();
        List<Course> courses = db.findByTeacher(1L);

        assertEquals(1, courses.size());

        Course course = courses.get(0);
        assertEquals("Фрезировщик", course.getName());
        assertEquals("Мастер класс от Ивана Дулина", course.getDescription());

    }
}