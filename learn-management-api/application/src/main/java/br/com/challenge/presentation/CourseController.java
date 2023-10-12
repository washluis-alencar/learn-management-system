package br.com.challenge.presentation;

import br.com.challenge.domain.Course;
import br.com.challenge.mapper.CourseMapper;
import br.com.challenge.presentation.representation.CourseRepresentation;
import br.com.challenge.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPath.COURSES)
public class CourseController {

    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public CourseRepresentation save(@RequestBody CourseRepresentation courseRepresentation) {
        Course course = CourseMapper.convertToCourse(courseRepresentation);
        Course savedCourse = courseService.createCourse(course, courseRepresentation.getAdminUserName());
        return CourseMapper.convertToCourseRepresentation(savedCourse);
    }

    @GetMapping
    public List<Course> findAllCourses() {
        return courseService.findAllCourses();
    }
}
