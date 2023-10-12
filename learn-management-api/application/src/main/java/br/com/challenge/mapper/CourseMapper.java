package br.com.challenge.mapper;

import br.com.challenge.domain.Course;
import br.com.challenge.presentation.representation.CourseRepresentation;

public class CourseMapper {
  public static Course convertToCourse(CourseRepresentation courseRepresentation) {
    Course course = new Course();
    course.setCourseCode(courseRepresentation.getCourseCode());
    course.setCourseName(courseRepresentation.getCourseName());
    course.setStartDate(courseRepresentation.getStartDate());
    course.setFinalDate(courseRepresentation.getFinalDate());
    course.setDescription(courseRepresentation.getDescription());
    return course;
  }

  public static CourseRepresentation convertToCourseRepresentation(Course course) {
    CourseRepresentation courseRepresentation = new CourseRepresentation();
    courseRepresentation.setId(course.getId());
    courseRepresentation.setCourseCode(course.getCourseCode());
    courseRepresentation.setCourseName(course.getCourseName());
    courseRepresentation.setStartDate(course.getStartDate());
    courseRepresentation.setFinalDate(course.getFinalDate());
    courseRepresentation.setDescription(course.getDescription());
    return courseRepresentation;
  }
}
