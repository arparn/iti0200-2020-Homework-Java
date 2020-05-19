package ee.taltech.iti0200.exam2.university;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniversityTest {

    public static final int NUM40 = 40;
    public static final int NUM50 = 50;
    public static final int NUM80 = 80;
    public static final int NUM65 = 65;
    public static final int NUM20 = 20;
    public static final int NUM19 = 19;
    public static final int NUM18 = 18;
    public static final int NUM70 = 70;
    public static final int NUM16 = 16;

    University talTech = new University("TalTech");
    University tartuUlikool = new University("Tartu Ülikool");

    Course proge = new Course("Programming", true, NUM40, talTech, Course.Type.ERIALA);
    Course math = new Course("Math", true, NUM50, talTech, Course.Type.VABA6PE);
    Course arvutivorgud = new Course("Arvutivõrgud", false, NUM80, talTech, Course.Type.ULD6PE);
    Course inzineeria = new Course("Inzineeria", true, NUM50, tartuUlikool, Course.Type.ERIALA);
    Course economy = new Course("Econoomika", false, NUM65, tartuUlikool, Course.Type.VABA6PE);
    Course opSusteemid = new Course("OP süsteemid", true, NUM70, tartuUlikool, Course.Type.ULD6PE);

    Course wrongCourse = new Course("Wrong", true, 0, talTech, Course.Type.VABA6PE);

    Student mati = new Student(NUM19, "Mati");
    Student max = new Student(NUM20, "Max");
    Student katrin = new Student(NUM18, "Katrin");
    Student marika = new Student(NUM16, "Maarika");

    Teacher ago = new Teacher("Ago");
    Teacher elerin = new Teacher("Elerin");

    StudyProgramme iaib = new StudyProgramme("IAIB", talTech);
    StudyProgramme sdfg = new StudyProgramme("SDFG", tartuUlikool);


    @Test
    void getTeachers() {
        talTech.addTeacher(ago);
        tartuUlikool.addTeacher(elerin);
        assertEquals("Ago", talTech.getTeachers().get(0).getName());
        assertEquals("Elerin", tartuUlikool.getTeachers().get(0).getName());

    }

    @Test
    void getStudyProgrammes() {
        iaib.addCourse(proge);
        iaib.addCourse(math);
        iaib.addCourse(arvutivorgud);

        sdfg.addCourse(inzineeria);
        sdfg.addCourse(economy);
        sdfg.addCourse(opSusteemid);

        talTech.addCourse(proge);
        talTech.addCourse(math);
        talTech.addCourse(arvutivorgud);

        tartuUlikool.addCourse(inzineeria);
        tartuUlikool.addCourse(economy);
        tartuUlikool.addCourse(opSusteemid);

        talTech.setStudyProgramme(iaib);
        tartuUlikool.setStudyProgramme(sdfg);

        assertEquals("IAIB", talTech.getStudyProgrammes().get(0).getName());
        assertEquals("SDFG", tartuUlikool.getStudyProgrammes().get(0).getName());
    }

    @Test
    void getStudents() {
        iaib.addCourse(proge);
        iaib.addCourse(math);
        iaib.addCourse(arvutivorgud);

        sdfg.addCourse(inzineeria);
        sdfg.addCourse(economy);
        sdfg.addCourse(opSusteemid);

        talTech.addCourse(proge);
        talTech.addCourse(math);
        talTech.addCourse(arvutivorgud);

        tartuUlikool.addCourse(inzineeria);
        tartuUlikool.addCourse(economy);
        tartuUlikool.addCourse(opSusteemid);

        talTech.setStudyProgramme(iaib);
        tartuUlikool.setStudyProgramme(sdfg);
        talTech.addStudent(mati, iaib);
        tartuUlikool.addStudent(max, sdfg);
        assertEquals("Mati", talTech.getStudents().get(0).getName());
        assertEquals("Max", tartuUlikool.getStudents().get(0).getName());
    }

    @Test
    void getName() {
        assertEquals("TalTech", talTech.getName());
        assertEquals("Tartu Ülikool", tartuUlikool.getName());
    }

    @Test
    void addTeacher() {
        talTech.addTeacher(elerin);
        assertEquals("Elerin", talTech.getTeachers().get(0).getName());
    }

    @Test
    void addStudent() {
        iaib.addCourse(proge);
        iaib.addCourse(math);
        iaib.addCourse(arvutivorgud);
        sdfg.addCourse(inzineeria);
        sdfg.addCourse(economy);
        sdfg.addCourse(opSusteemid);
        talTech.addCourse(proge);
        talTech.addCourse(math);
        talTech.addCourse(arvutivorgud);
        tartuUlikool.addCourse(inzineeria);
        tartuUlikool.addCourse(economy);
        tartuUlikool.addCourse(opSusteemid);
        talTech.setStudyProgramme(iaib);
        talTech.addStudent(katrin, iaib);
        talTech.addStudent(marika, iaib);
        tartuUlikool.setStudyProgramme(sdfg);
        tartuUlikool.addStudent(katrin, iaib);

        assertEquals(1, talTech.getStudents().size());
        assertEquals(0, tartuUlikool.getStudents().size());
    }

    @Test
    void addCourse() {
        talTech.addCourse(proge);
        talTech.addCourse(math);
        talTech.addCourse(arvutivorgud);
        talTech.addCourse(wrongCourse);
        assertEquals(3, talTech.getCourses().size());
    }

    @Test
    void getCourses() {
        talTech.addCourse(math);
        assertEquals("Math", talTech.getCourses().get(0).getName());
    }

    @Test
    void setStudyProgramme() {
        iaib.addCourse(proge);
        iaib.addCourse(math);
        iaib.addCourse(arvutivorgud);
        talTech.addCourse(proge);
        talTech.addCourse(math);
        talTech.addCourse(arvutivorgud);
        talTech.setStudyProgramme(iaib);
        assertEquals("IAIB", talTech.getStudyProgrammes().get(0).getName());
    }
}
