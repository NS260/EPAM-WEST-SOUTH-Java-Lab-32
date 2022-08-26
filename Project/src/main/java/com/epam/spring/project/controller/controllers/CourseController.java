package com.epam.spring.project.controller.controllers;

import com.epam.spring.project.controller.dto.CourseDTO;
import com.epam.spring.project.controller.dto.TeacherDTO;
import com.epam.spring.project.service.interfaces.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course) {
        log.info("CourseController was executed with createCourse func");
        return courseService.createCourse(course);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{name}")
    public CourseDTO updateCourse(@PathVariable String name, @RequestBody CourseDTO course) {
        log.info("CourseController was executed with updateCourse func. Course name: " + name);
        return courseService.updateCourse(name, course);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{name}")
    public CourseDTO getCourse(@PathVariable String name) {
        log.info("CourseController was executed with getCourse func. Course name: " + name);
        return courseService.getCourseByName(name);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{name}")
    public void deleteCourse(@PathVariable String name) {
        log.info("CourseController was executed with deleteCourse func. Course name: " + name);
        courseService.deleteCourse(name);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CourseDTO> listCourses() {
        log.info("CourseController was executed with listCourse func");
        return courseService.listCourses();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/set/{courseName}")
    public CourseDTO setTeacherOnCourse(@PathVariable String courseName, @RequestBody TeacherDTO teacher) {
        log.info("CourseController was executed with registerTeacherOnCourse func. Course name: " + courseName);
        return courseService.setTeacherOnCourse(courseName, teacher);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    public List<CourseDTO> getCoursesByTeacher(@PathVariable String email) {
        log.info("CourseController was executed with getCoursesByTeacher func. Teacher email: " + email);
        return courseService.getCoursesByTeacherEmail(email);
    }
}
