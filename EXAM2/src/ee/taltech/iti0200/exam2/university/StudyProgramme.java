package ee.taltech.iti0200.exam2.university;

import java.util.LinkedList;
import java.util.List;

public class StudyProgramme {

    private String name;
    private University university;
    private List<Course> courses = new LinkedList<>();

    public StudyProgramme(String name, University university) {
        this.name = name;
        this.university = university;
    }

    public University getUniversity() {
        return university;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public int calculateEapTotal() {
        int sum = 0;
        for (Course course : courses) {
            sum += course.getEAP();
        }
        return sum;
    }

    public void addCourse(Course course) {
        if (course.getUniversity().equals(university) && course.getEAP() > 0) {
            courses.add(course);
        }
    }
}
