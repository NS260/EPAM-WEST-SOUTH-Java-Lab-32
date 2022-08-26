package com.epam.spring.project.controller.controllers;

import com.epam.spring.project.controller.api.interfaces.CourseApi;
import com.epam.spring.project.controller.dto.CourseDTO;
import com.epam.spring.project.controller.dto.TeacherDTO;
import com.epam.spring.project.service.interfaces.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor

public class CourseController implements CourseApi {

    private final CourseService courseService;

    @Override
    public CourseDTO createCourse(@RequestBody CourseDTO course) {
        log.info("CourseController was executed with createCourse func");
        return courseService.createCourse(course);
    }

    @Override
    public CourseDTO updateCourse(@PathVariable String name, @RequestBody CourseDTO course) {
        log.info("CourseController was executed with updateCourse func. Course name: " + name);
        return courseService.updateCourseByName(name, course);
    }

    @Override
    public CourseDTO getCourse(@PathVariable String name) {
        log.info("CourseController was executed with getCourse func. Course name: " + name);
        return courseService.getCourseByName(name);
    }

    @Override
    public void deleteCourse(@PathVariable String name) {
        log.info("CourseController was executed with deleteCourse func. Course name: " + name);
        courseService.deleteCourseByName(name);
    }

    @Override
    public List<CourseDTO> listCourses() {
        log.info("CourseController was executed with listCourse func");
        return courseService.listCourses();
    }

    @Override
    public CourseDTO setTeacherOnCourse(@PathVariable String courseName, @RequestBody TeacherDTO teacher) {
        log.info("CourseController was executed with setTeacherOnCourse func. Course name: " + courseName);
        return courseService.setTeacherOnCourseByName(courseName, teacher);
    }

    @Override
    public List<CourseDTO> getCoursesByTeacher(@PathVariable String email) {
        log.info("CourseController was executed with getCoursesByTeacher func. Teacher email: " + email);
        return courseService.getCoursesByTeacherEmail(email);
    }
}
