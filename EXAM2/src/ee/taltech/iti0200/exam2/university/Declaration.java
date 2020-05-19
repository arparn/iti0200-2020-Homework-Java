package ee.taltech.iti0200.exam2.university;

import java.util.LinkedList;
import java.util.List;

public class Declaration {

    private List<Course> coursesToTake = new LinkedList<>();

    public boolean addCourse(Course course) {
        if (!coursesToTake.contains(course)) {
            coursesToTake.add(course);
            return true;
        }
        return false;
    }

    public List<Course> getCoursesToTake() {
        return coursesToTake;
    }

    public int calculateTotalEap () {
        int sum = 0;
        for (Course course : coursesToTake) {
            sum += course.getEAP();
        }
        return sum;
    }
}
