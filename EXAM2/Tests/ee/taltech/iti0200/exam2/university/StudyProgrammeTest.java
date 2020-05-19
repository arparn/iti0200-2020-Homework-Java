package ee.taltech.iti0200.exam2.university;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudyProgrammeTest {
    public static final int NUM40 = 40;
    public static final int NUM50 = 50;
    public static final int NUM80 = 80;
    public static final int NUM170 = 170;

    University talTech = new University("TalTech");
    University tartuUlikool = new University("Tartu Ülikool");

    Course proge = new Course("Programming", true, NUM40, talTech, Course.Type.ERIALA);
    Course math = new Course("Math", true, NUM50, talTech, Course.Type.VABA6PE);
    Course arvutivorgud = new Course("Arvutivõrgud", false, NUM80, talTech, Course.Type.ULD6PE);


    StudyProgramme iaib = new StudyProgramme("IAIB", talTech);


    @Test
    void getUniversity() {
        assertEquals("TalTech", iaib.getUniversity().getName());
    }

    @Test
    void getName() {
        assertEquals("IAIB", iaib.getName());
    }

    @Test
    void getCourses() {
        iaib.addCourse(proge);
        iaib.addCourse(math);
        iaib.addCourse(arvutivorgud);
        assertEquals(3, iaib.getCourses().size());
    }

    @Test
    void calculateEapTotal() {
        iaib.addCourse(proge);
        iaib.addCourse(math);
        iaib.addCourse(arvutivorgud);
        assertEquals(NUM170, iaib.calculateEapTotal());
    }

}
