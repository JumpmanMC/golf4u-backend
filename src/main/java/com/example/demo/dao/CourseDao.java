package com.example.demo.dao;

import com.example.demo.model.Course;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseDao {
  int insertCourse(UUID id, Course course);

  default int insertCourse(Course course) {
    UUID id = UUID.randomUUID();
    return insertCourse(id, course);
  }

  List<Course> selectAllCourses();

  Optional<Course> selectCourseByID(UUID id);

  int deleteCourseByID(UUID id);

  int updateCourseByID(UUID id, Course course);
}