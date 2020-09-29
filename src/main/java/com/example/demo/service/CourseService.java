package com.example.demo.service;

import com.example.demo.dao.CourseDao;
import com.example.demo.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseService {
  private final CourseDao courseDao;

  @Autowired
  public CourseService(@Qualifier("fakeDao") CourseDao courseDao) {
    this.courseDao = courseDao;
  }

  public int addCourse(Course course) {
    return courseDao.insertCourse(course);
  }

  public List<Course> selectAllCourses() {
    return courseDao.selectAllCourses();
  }

  public Optional<Course> selectCourseBuID(UUID id) {
    return courseDao.selectCourseByID(id);
  }

  public int deleteCourseByID(UUID id) {
    return courseDao.deleteCourseByID(id);
  }

  public int updateCourseByID(UUID id, Course course) {
    return courseDao.updateCourseByID(id, course);
  }
}