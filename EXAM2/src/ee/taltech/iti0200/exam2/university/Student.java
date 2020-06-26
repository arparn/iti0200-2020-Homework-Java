package ee.taltech.iti0200.exam2.university;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Student {

    public static final int EAP_CHECK = 30;

    private int age;
    private String name;
    private University university;
    private StudyProgramme studyProgramme;
    private List<Course> courses = new LinkedList<>();
    public List<Course> passedCourses = new LinkedList<>();
    public List<Course> notPassedCourses = new LinkedList<>();
    private Declaration declaration;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
        this.declaration = new Declaration();
    }

    public void setStudyProgramme(StudyProgramme studyProgramme) {
        if (studyProgramme.getUniversity().equals(university)) {
            this.studyProgramme = studyProgramme;
        }
    }
     public Optional<StudyProgramme> getStudyProgramme() {
        if (studyProgramme != null) {
            return Optional.of(studyProgramme);
        } else {
            return Optional.empty();
        }
     }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void declareCourse(Course course) {
        if (courses.size() == 0 && university.getCourses().contains(course)) {
            declaration.addCourse(course);
        }
    }

    public boolean sendDeclaration() {
        if (declaration.calculateTotalEap() >= EAP_CHECK && courses.size() == 0) {
            for (Course course : declaration.getCoursesToTake()) {
                course.addPersonToCourse(Student.this);
            }
            courses.addAll(declaration.getCoursesToTake());
            declaration = new Declaration();
            return true;
        }
        return false;
    }

    public Optional<University> getUniversity() {
        if (university != null) {
            return Optional.of(university);
        } else {
            return Optional.empty();
        }
    }

    public void setUniversity(University university) {
        if (getUniversity().isEmpty()) {
            this.university = university;
        }
    }

    public List<Course> getPassedCourses() {
        return passedCourses;
    }

    public List<Course> getNotPassedCourses() {
        return notPassedCourses;
    }

    public Optional<Object> getGradeForACourse(Course course) {
        if (passedCourses.contains(course) || notPassedCourses.contains(course)) {
            if (course.getStudentsAndGrades().isPresent()) {
                return Optional.of(course.getStudentsAndGrades().get().get(Student.this));
            } else {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }
}
