package ee.taltech.iti0200.exam2.university;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    public static final int NUM40 = 40;
    public static final int NUM50 = 50;
    public static final int NUM80 = 80;
    public static final int NUM20 = 20;
    public static final int NUM19 = 19;

    Student artur = new Student(NUM20, "Artur");
    Student mati = new Student(NUM19, "Mati");
    Student juri = new Student(NUM20, "Juri");

    University talTech = new University("TalTech");
    University tartuUlikool = new University("Tartu Ülikool");

    Course proge = new Course("Programming", true, NUM40, talTech, Course.Type.ERIALA);
    Course math = new Course("Math", true, NUM50, talTech, Course.Type.VABA6PE);
    Course arvutivorgud = new Course("Arvutivõrgud", false, NUM80, talTech, Course.Type.ULD6PE);

    StudyProgramme iaib = new StudyProgramme("IAIB", talTech);


    @Test
    void setStudyProgramme() {
        iaib.addCourse(proge);
        iaib.addCourse(math);
        iaib.addCourse(arvutivorgud);

        artur.setUniversity(talTech);
        artur.setStudyProgramme(iaib);


        assertEquals("IAIB", artur.getStudyProgramme().get().getName());
    }

    @Test
    void getStudyProgramme() {
        iaib.addCourse(proge);
        iaib.addCourse(math);
        iaib.addCourse(arvutivorgud);

        mati.setUniversity(talTech);
        mati.setStudyProgramme(iaib);

        assertEquals("IAIB", mati.getStudyProgramme().get().getName());
    }

    @Test
    void getAge() {
        assertEquals(NUM20, juri.getAge());
        assertEquals(NUM20, artur.getAge());
    }

    @Test
    void getName() {
        assertEquals("Mati", mati.getName());
        assertEquals("Juri", juri.getName());
    }

    @Test
    void getCourses() {
        talTech.addCourse(proge);
        talTech.addCourse(math);
        iaib.addCourse(proge);
        iaib.addCourse(math);
        juri.setUniversity(talTech);
        juri.setStudyProgramme(iaib);
        juri.declareCourse(proge);
        juri.declareCourse(math);
        juri.sendDeclaration();

        assertEquals(2, juri.getCourses().size());
    }

    @Test
    void declareCourse() {
        talTech.addCourse(arvutivorgud);
        iaib.addCourse(arvutivorgud);
        mati.setUniversity(talTech);
        mati.setStudyProgramme(iaib);
        mati.declareCourse(arvutivorgud);
        mati.sendDeclaration();

        assertEquals(1, mati.getCourses().size());
    }

    @Test
    void sendDeclaration() {
        talTech.addCourse(proge);
        iaib.addCourse(proge);
        artur.setUniversity(talTech);
        artur.setStudyProgramme(iaib);
        artur.declareCourse(proge);
        artur.sendDeclaration();

        assertEquals(1, artur.getCourses().size());
    }

    @Test
    void getUniversity() {
        artur.setUniversity(talTech);
        assertEquals("TalTech", artur.getUniversity().get().getName());
    }

    @Test
    void setUniversity() {
        mati.setUniversity(tartuUlikool);
        assertEquals("Tartu Ülikool", mati.getUniversity().get().getName());
    }

    @Test
    void getPassedCourses() {
        talTech.addCourse(proge);
        iaib.addCourse(proge);
        juri.setUniversity(talTech);
        juri.setStudyProgramme(iaib);
        juri.declareCourse(proge);
        juri.sendDeclaration();
        proge.putAGrade(juri, 5);
        assertEquals("Programming", juri.getPassedCourses().get(0).getName());
    }

    @Test
    void getNotPassedCourses() {
        talTech.addCourse(arvutivorgud);
        iaib.addCourse(arvutivorgud);
        juri.setUniversity(talTech);
        juri.setStudyProgramme(iaib);
        juri.declareCourse(arvutivorgud);
        juri.sendDeclaration();
        arvutivorgud.putAGrade(juri, false);
        assertEquals("Arvutivõrgud", juri.getNotPassedCourses().get(0).getName());
    }

    @Test
    void getGradeForACourse() {
        talTech.addCourse(math);
        iaib.addCourse(math);
        juri.setUniversity(talTech);
        juri.setStudyProgramme(iaib);
        juri.declareCourse(math);
        juri.sendDeclaration();
        math.putAGrade(juri, 3);
        assertEquals(3, juri.getGradeForACourse(math).get());
    }
}
