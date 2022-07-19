package com.epam.spring.project.controller.controllers;

import com.epam.spring.project.controller.dto.CourseDTO;
import com.epam.spring.project.controller.dto.TeacherDTO;
import com.epam.spring.project.service.interfaces.CourseService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course) {
        return courseService.createCourse(course);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{name}")
    public CourseDTO updateCourse(@PathVariable String name, @RequestBody CourseDTO course) {
        return courseService.updateCourse(name, course);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{name}")
    public CourseDTO getCourse(@PathVariable String name) {
        return courseService.getCourse(name);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{name}")
    public void deleteCourse(@PathVariable String name) {
        courseService.deleteCourse(name);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CourseDTO> listCourses() {
        return courseService.listCourses();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/set/{courseName}")
    public CourseDTO setTeacherOnCourse(@PathVariable String courseName, @RequestBody TeacherDTO teacher) {
        return courseService.setTeacherOnCourse(courseName, teacher);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    public List<CourseDTO> getCoursesByTeacher(@PathVariable String email) {
        return courseService.getCoursesByTeacher(email);
    }
}
