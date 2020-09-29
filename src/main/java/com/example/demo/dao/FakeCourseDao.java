package com.example.demo.dao;

import com.example.demo.model.Course;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeCourseDao implements CourseDao {

  private static List<Course> DB = new ArrayList<>();

  @Override
  public int insertCourse(UUID id, Course course) {
    DB.add(new Course(id, course.getName(), course.getPar(), course.getHoles()));
    return 1;
  }

  @Override
  public List<Course> selectAllCourses() {
    return DB;
  }

  @Override
  public Optional<Course> selectCourseByID(UUID id) {
    return DB.stream()
            .filter(course -> course.getId().equals(id))
            .findFirst();
  }

  @Override
  public int deleteCourseByID(UUID id) {
    Optional<Course> courseMaybe = selectCourseByID(id);
    if(courseMaybe.isEmpty()) {
      return 0;
    }
    DB.remove(courseMaybe.get());
    return 1;
  }

  @Override
  public int updateCourseByID(UUID id, Course course) {
    return selectCourseByID(id).map(c -> {
      int indexOfCourseToDelete = DB.indexOf(c);
      if(indexOfCourseToDelete >= 0) {
        DB.set(indexOfCourseToDelete, new Course(id, course.getName(), course.getPar(), course.getHoles()));
        return 1;
      }
      return 0;
    }).orElse(0);
  }
}