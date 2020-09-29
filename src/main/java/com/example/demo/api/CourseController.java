package com.example.demo.api;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/course")
@RestController
public class CourseController {
  private final CourseService courseService;

  @Autowired
  public CourseController(CourseService courseService) {
    this.courseService = courseService;
  }

  @PostMapping
  public void addCourse(@RequestBody Course course) {
    courseService.addCourse(course);
  }

  @GetMapping
  public List<Course> selectAllCourses() {
    return courseService.selectAllCourses();
  }

  @GetMapping(path = "{id}")
  public Course selectCourseBuID(@PathVariable("id") UUID id) {
    return courseService.selectCourseBuID(id).orElse(null);
  }

  @DeleteMapping(path = "{id}")
  public void deleteCourseByID(@PathVariable("id") UUID id) {
    courseService.deleteCourseByID(id);
  }

  @PutMapping(path = "{id}")
  public void updateCourseByID(@PathVariable("id") UUID id, @RequestBody Course courseToUpdate) {
    courseService.updateCourseByID(id, courseToUpdate);
  }
}