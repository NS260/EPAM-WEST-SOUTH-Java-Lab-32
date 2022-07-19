package com.epam.spring.project.service.repository.interfaces;

import com.epam.spring.project.service.model.course.Course;
import com.epam.spring.project.service.model.user.Teacher;

import java.util.List;

public interface CourseRepository {
    Course createCourse(Course course);

    Course updateCourse(String name, Course course);

    Course getCourse(String name);

    void deleteCourse(String name);

    List<Course> listCourses();

    Course setTeacherOnCourse(String courseName, Teacher teacher);

    List<Course> getCoursesByTeacher(String email);
}
