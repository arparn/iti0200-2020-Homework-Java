package ee.taltech.iti0200.exam2.university;

import java.util.*;

public class Course {

    public enum Type {
        VABA6PE, ERIALA, ULD6PE
    }

    private String name;
    private boolean forAGrade;
    private int eap;
    private University university;
    private Type type;


    private List<Student> students = new LinkedList<>();
    private List<Teacher> teachers = new LinkedList<>();

    private Map<Student, Object> studentsAndGrades = new HashMap<>();

    public Course(String name, boolean forAGrade, int eap, University university, Type type) {
        this.name = name;
        this.forAGrade = forAGrade;
        this.eap = eap;
        this.university = university;
        this.type = type;
    }

    public void addTeacher(Teacher teacher) {
        if (university.getTeachers().contains(teacher) && !teachers.contains(teacher)) {
            teachers.add(teacher);
            teacher.addCourse(Course.this);
        }
    }

    public Type getType() {
        return type;
    }

    public University getUniversity() {
        return university;
    }

    public String getName() {
        return name;
    }

    public boolean isForAGrade() {
        return forAGrade;
    }

    public int getEap() {
        return eap;
    }

    public Optional<Map<Student, Object>> getStudentsAndGrades() {
        if (studentsAndGrades.keySet().size() > 0) {
            return Optional.of(studentsAndGrades);
        } else {
            return Optional.empty();
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public boolean putAGrade(Student student, Object grade) {
        if (students.contains(student)) {
            if (forAGrade && grade.getClass().equals(Integer.class) && ((Integer) grade >= 0 && (Integer) grade <= 5)) {
                studentsAndGrades.put(student, grade);
                if ((Integer) grade > 0) {
                    student.passedCourses.add(Course.this);
                } else {
                    student.notPassedCourses.add(Course.this);
                }
                student.getCourses().remove(Course.this);
                students.remove(student);
                return true;
            } else if (!forAGrade && grade.getClass().equals(Boolean.class)) {
                studentsAndGrades.put(student, grade);
                if ((Boolean) grade) {
                    student.passedCourses.add(Course.this);
                } else {
                    student.notPassedCourses.add(Course.this);
                }
                student.getCourses().remove(Course.this);
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public void addPersonToCourse(Student person) {
        if (!students.contains(person) && person.getUniversity().isPresent()
                && person.getUniversity().get().equals(university)) {
            students.add(person);
        }
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudentsWhoPassed() {
        List<Student> studentsWhoPassed = new LinkedList<>();
        for (Student person : studentsAndGrades.keySet()) {
            if (studentsAndGrades.get(person).getClass().equals(Integer.class)
                    && (Integer) studentsAndGrades.get(person) > 0) {
                studentsWhoPassed.add(person);
            } else if (studentsAndGrades.get(person).getClass().equals(Boolean.class)
                    && (Boolean) studentsAndGrades.get(person)) {
                studentsWhoPassed.add(person);
            }
        }
        return studentsWhoPassed;
    }

    public List<Student> getStudentsWhoNotPassed() {
        List<Student> studentsWhoNotPassed = new LinkedList<>();
        for (Student person : studentsAndGrades.keySet()) {
            if (studentsAndGrades.get(person).getClass().equals(Boolean.class)
                    && !(Boolean) studentsAndGrades.get(person)) {
                studentsWhoNotPassed.add(person);
            } else if (studentsAndGrades.get(person).getClass().equals(Integer.class)
                    && (Integer) studentsAndGrades.get(person) == 0) {
                studentsWhoNotPassed.add(person);
            }
        }
        return studentsWhoNotPassed;
    }

    public void clearGradeMap() {
        studentsAndGrades.clear();
    }
}
