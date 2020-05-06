package ee.taltech.iti0200.kt0.university;

import java.util.LinkedList;
import java.util.List;

public class Course {

    List<Student> students = new LinkedList<>();

    private int eap;
    private boolean finished;
    private University university;
    private String name;

    public Course(String name, int eap, University university) {
        this.eap = eap;
        this.finished = false;
        this.university = university;
        this.name = name;
    }

    public boolean addStudent(Student student) {
        if (!students.contains(student) && university.getStudents().contains(student)) {
            students.add(student);
            return true;
        } else {
            return false;
        }
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public boolean finish() {
        if (!finished) {
            for (Student student : students) {
                student.setEap(student.getEap() + eap);
            }
            finished = true;
            return true;
        } else {
            return  false;
        }
    }

    public boolean isFinished() {
        return finished;
    }

    public String toString() {
        return university.getName() + ": " + name + " (" + eap + ")";
    }

    public String getName() {
        return name;
    }

    public int getEapIfStudentRegistred(Student student) {
        if (students.contains(student)) {
            return eap;
        } else {
            return 0;
        }
    }
}
