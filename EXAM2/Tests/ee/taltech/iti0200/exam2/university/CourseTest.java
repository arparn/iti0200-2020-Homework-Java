package ee.taltech.iti0200.exam2.university;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    public static final int NUM40 = 40;
    public static final int NUM50 = 50;
    public static final int NUM80 = 80;
    public static final int NUM65 = 65;
    public static final int NUM20 = 20;
    public static final int NUM19 = 19;
    public static final int NUM24 = 24;
    public static final int NUM18 = 18;


    University talTech = new University("TalTech");
    University tartuUlikool = new University("Tartu Ülikool");

    Course proge = new Course("Programming", true, NUM40, talTech, Course.Type.ERIALA);
    Course math = new Course("Math", true, NUM50, talTech, Course.Type.VABA6PE);
    Course arvutivorgud = new Course("Arvutivõrgud", false, NUM80, talTech, Course.Type.ULD6PE);

    Course inzineeria = new Course("Inzineeria", true, NUM50, tartuUlikool, Course.Type.ERIALA);
    Course economy = new Course("Econoomika", false, NUM65, tartuUlikool, Course.Type.VABA6PE);

    Student artur = new Student(NUM20, "Artur");
    Student mati = new Student(NUM19, "Mati");
    Student juri = new Student(NUM24, "Juri");
    Student katrin = new Student(NUM18, "Katrin");

    Teacher ago = new Teacher("Ago");
    Teacher elerin = new Teacher("Elerin");

    StudyProgramme iaib = new StudyProgramme("IAIB", talTech);

    @Test
    void addTeacher() {
        talTech.addTeacher(ago);
        proge.addTeacher(ago);
        assertEquals("Ago", proge.getTeachers().get(0).getName());

    }

    @Test
    void getType() {
        assertEquals(Course.Type.VABA6PE, math.getType());
    }

    @Test
    void getUniversity() {
        assertEquals("TalTech", arvutivorgud.getUniversity().getName());
    }

    @Test
    void getName() {
        assertEquals("Arvutivõrgud", arvutivorgud.getName());
    }

    @Test
    void isForAGrade() {
        assertTrue(proge.isForAGrade());
    }

    @Test
    void getEAP() {
        assertEquals(NUM50, inzineeria.getEap());
    }

    @Test
    void getStudentsAndGrades() {
        Map<Student, Integer> map = new HashMap<>();
        talTech.addCourse(proge);
        iaib.addCourse(proge);
        mati.setUniversity(talTech);
        mati.setStudyProgramme(iaib);
        mati.declareCourse(proge);
        mati.sendDeclaration();
        proge.putAGrade(mati, 3);
        map.put(mati, 3);
        assertEquals(map, proge.getStudentsAndGrades().get());
    }

    @Test
    void getStudents() {
        talTech.addCourse(math);
        iaib.addCourse(math);
        mati.setUniversity(talTech);
        mati.setStudyProgramme(iaib);
        mati.declareCourse(math);
        mati.sendDeclaration();
        assertEquals(1, math.getStudents().size());
    }

    @Test
    void addPersonToCourse() {
        artur.setUniversity(talTech);
        math.addPersonToCourse(artur);
        assertEquals(1, math.getStudents().size());
    }

    @Test
    void getTeachers() {
        tartuUlikool.addTeacher(elerin);
        economy.addTeacher(elerin);
        assertEquals(1, economy.getTeachers().size());
    }

    @Test
    void getStudentsWhoPassed() {
        juri.setUniversity(talTech);
        katrin.setUniversity(talTech);
        math.addPersonToCourse(juri);
        math.addPersonToCourse(katrin);
        math.putAGrade(katrin, 0);
        math.putAGrade(juri, 2);
        assertEquals(1, math.getStudentsWhoPassed().size());
    }

    @Test
    void getStudentsWhoNotPassed() {
        juri.setUniversity(talTech);
        katrin.setUniversity(talTech);
        arvutivorgud.addPersonToCourse(juri);
        arvutivorgud.addPersonToCourse(katrin);
        arvutivorgud.putAGrade(katrin, false);
        arvutivorgud.putAGrade(juri, false);
        assertEquals(2, arvutivorgud.getStudentsWhoNotPassed().size());
    }
}
