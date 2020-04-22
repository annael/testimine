package school.data;

import java.util.List;
import java.util.stream.Collectors;

public class Student extends PersonImpl {

    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<String> getAllTeacherNames() {
        return this.getCourses().stream()
                    .map(Course::getName)
                    .collect(Collectors.toList());
    }

}
