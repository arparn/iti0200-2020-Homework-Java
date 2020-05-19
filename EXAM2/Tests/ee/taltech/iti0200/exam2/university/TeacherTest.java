package ee.taltech.iti0200.exam2.university;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {
    public static final int NUM50 = 50;
    University talTech = new University("TalTech");

    Course math = new Course("Math", true, NUM50, talTech, Course.Type.VABA6PE);

    Teacher ago = new Teacher("Ago");

    @Test
    void getName() {
        assertEquals("Ago", ago.getName());
    }

    @Test
    void getCourses() {
        talTech.addTeacher(ago);
        ago.setUniversity(talTech);
        ago.addCourse(math);
        assertEquals(1, ago.getCourses().size());
    }

    @Test
    void setUniversity() {
        ago.setUniversity(talTech);
        assertEquals("TalTech", ago.getUniversity().get().getName());
    }

}
