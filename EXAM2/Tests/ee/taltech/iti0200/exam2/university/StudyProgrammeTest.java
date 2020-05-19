package ee.taltech.iti0200.exam2.university;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudyProgrammeTest {

    University talTech = new University("TalTech");
    University tartuUlikool = new University("Tartu Ülikool");

    Course proge = new Course("Programming", true, 40, talTech, Course.Type.ERIALA);
    Course math = new Course("Math", true, 50, talTech, Course.Type.VABA6PE);
    Course arvutivorgud = new Course("Arvutivõrgud", false, 80, talTech, Course.Type.ULD6PE);

    Course inzineeria = new Course("Inzineeria", true, 50, tartuUlikool, Course.Type.ERIALA);
    Course economy = new Course("Econoomika", false, 65, tartuUlikool, Course.Type.VABA6PE);
    Course opSusteemid = new Course("OP süsteemid", true, 70, tartuUlikool, Course.Type.ULD6PE);

    Course wrongCourse = new Course("Wrong", true, 0, talTech, Course.Type.VABA6PE);

    Student mati = new Student( 19, "Mati");
    Student max = new Student(21, "Max");
    Student katrin = new Student(18, "Katrin");
    Student marika = new Student( 16, "Maarika");

    Teacher ago = new Teacher("Ago");
    Teacher elerin = new Teacher("Elerin");

    StudyProgramme iaib = new StudyProgramme("IAIB", talTech);
    StudyProgramme sdfg = new StudyProgramme("SDFG", tartuUlikool);


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
        assertEquals(170, iaib.calculateEapTotal());
    }

}