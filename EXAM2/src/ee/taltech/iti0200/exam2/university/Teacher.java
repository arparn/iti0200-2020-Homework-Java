package ee.taltech.iti0200.exam2.university;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Teacher {

    private String name;
    private University university;
    private List<Course> courses = new LinkedList<>();

    public Teacher(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Optional<University> getUniversity() {
        if (university != null) {
            return Optional.of(university);
        } else {
            return Optional.empty();
        }
    }

    public void addCourse(Course course) {
        if (course.getUniversity().equals(university) && !courses.contains(course)) {
            courses.add(course);
            course.addTeacher(Teacher.this);
        }
    }
}
