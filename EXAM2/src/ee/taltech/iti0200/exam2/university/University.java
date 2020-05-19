package ee.taltech.iti0200.exam2.university;

import java.util.LinkedList;
import java.util.List;

public class University {
    public static final int NUM18 = 18;
    public static final int NUM120 = 120;

    private List<Student> students = new LinkedList<>();
    private List<Course> courses = new LinkedList<>();
    private List<Teacher> teachers = new LinkedList<>();
    private List<StudyProgramme> studyProgrammes = new LinkedList<>();
    private String name;

    public University(String name) {
        this.name = name;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<StudyProgramme> getStudyProgrammes() {
        return studyProgrammes;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public void addTeacher(Teacher teacher) {
        if (!teachers.contains(teacher) && teacher.getUniversity().isEmpty()) {
            teachers.add(teacher);
            teacher.setUniversity(University.this);
        }
    }

    public boolean addStudent(Student student, StudyProgramme studyProgramme) {
        if (student.getAge() >= NUM18 && !students.contains(student) && student.getUniversity().isEmpty()
                && studyProgrammes.contains(studyProgramme) && student.getStudyProgramme().isEmpty()) {
            students.add(student);
            student.setStudyProgramme(studyProgramme);
            student.setUniversity(University.this);
            return true;
        }
        return false;
    }

    public boolean addCourse(Course course) {
        if (!courses.contains(course) && course.getUniversity().equals(University.this) && course.getEap() > 0) {
            courses.add(course);
            return true;
        } else {
            return false;
        }
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setStudyProgramme(StudyProgramme studyProgramme) {
        if (studyProgramme.calculateEapTotal() >= NUM120 && !studyProgrammes.contains(studyProgramme)) {
            studyProgrammes.add(studyProgramme);
        }
    }
}
