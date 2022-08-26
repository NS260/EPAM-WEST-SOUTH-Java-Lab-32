package com.epam.spring.project.service.interfaces;

import com.epam.spring.project.controller.dto.CourseDTO;
import com.epam.spring.project.controller.dto.TeacherDTO;

import java.util.List;

public interface CourseService {
    CourseDTO createCourse(CourseDTO course);

    CourseDTO updateCourse(String email, CourseDTO course);

    CourseDTO getCourseByName(String name);

    void deleteCourse(String name);

    List<CourseDTO> listCourses();

    CourseDTO setTeacherOnCourse(String courseName, TeacherDTO teacher);

    List<CourseDTO> getCoursesByTeacherEmail(String email);
}
