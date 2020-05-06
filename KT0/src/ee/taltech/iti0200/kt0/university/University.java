package ee.taltech.iti0200.kt0.university;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class University {

    private String name;

    List<Student> students = new LinkedList<>();
    List<Course> courses = new LinkedList<>();

    public University(String name) {
        this.name = name;
    }

    public boolean addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            return true;
        } else {
            return false;
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public Optional<Course> createCourse(String name, int eap) {
        if (eap >= 1 && !name.equals("")) {
            boolean check = true;
            for (Course course : courses) {
                if (course.getName().equals(name)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                Course course = new Course(name, eap, University.this);
                courses.add(course);
                return Optional.of(course);
            }
        }
        return Optional.empty();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Course> getFinishedCourses() {
        List<Course> finishedCourses = new LinkedList<>();
        for (Course course : courses) {
            if (course.isFinished()) {
                finishedCourses.add(course);
            }
        }
        return finishedCourses;
    }

    public List<Student> getStudentsOrderedByResults() {
        List<Student> bestStudents = new LinkedList<>();
        Student bestStudent = students.get(0);
        for (int i = 0; i < students.size(); i++) {
            for (Student student : students) {
                if (!bestStudents.contains(student) && student.getEap() > bestStudent.getEap()) {
                    bestStudent = student;
                } else if (!bestStudents.contains(student) && student.getEap() == bestStudent.getEap()) {
                    int studentsEap = student.getEap();
                    int bestStudentsEap = bestStudent.getEap();
                    for (Course course : courses) {
                        studentsEap += course.getEapIfStudentRegistred(student);
                        bestStudentsEap += course.getEapIfStudentRegistred(bestStudent);
                    }
                    if (studentsEap > bestStudentsEap) {
                        bestStudent = student;
                    }
                }
            }
            if (!bestStudents.contains(bestStudent)) {
                bestStudents.add(bestStudent);
            }
        }
        return bestStudents;
    }
}
