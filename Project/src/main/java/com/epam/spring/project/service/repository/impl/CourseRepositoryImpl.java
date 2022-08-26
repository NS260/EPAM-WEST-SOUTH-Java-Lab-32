package com.epam.spring.project.service.repository.impl;

import com.epam.spring.project.service.model.course.Course;
import com.epam.spring.project.service.model.user.Teacher;
import com.epam.spring.project.service.repository.interfaces.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class CourseRepositoryImpl implements CourseRepository {
    private final List<Course> courseList = new ArrayList<>();

    @Override
    public Course createCourse(Course course) {
        log.info("CourseRepoImpl was executed with createCourse func");
        course.setStartDate(LocalDateTime.now());
        courseList.add(course);
        return course;
    }

    @Override
    public Course updateCourse(String name, Course course) {
        log.info("CourseRepoImpl was executed with updateCourse func. Course name: " + name);
        boolean isDeleted = courseList.removeIf(c -> c.getName().equals(name));
        if (isDeleted) {
            courseList.add(course);
        } else {
            throw new RuntimeException("Course is not found");
        }
        return course;
    }

    @Override
    public Course getCourse(String name) {
        log.info("CourseRepoImpl was executed with getCourse func. Course name: " + name);
        return courseList.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Course is not found"));
    }

    @Override
    public void deleteCourse(String name) {
        log.info("CourseRepoImpl was executed with deleteCourse func. Course name: " + name);
        courseList.removeIf(c -> c.getName().equals(name));
    }

    @Override
    public List<Course> listCourses() {
        log.info("CourseRepoImpl was executed with listCourses func");
        return new ArrayList<>(courseList);
    }

    @Override
    public Course setTeacherOnCourse(String courseName, Teacher teacher) {
        log.info("CourseRepoImpl was executed with setTeacherOnCourse func. Course name: " + courseName);
        courseList.stream()
                .filter(c -> c.getName().equals(courseName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Course is not found"))
                .setTeacher(teacher);
        return getCourse(courseName);
    }

    @Override
    public List<Course> getCoursesByTeacher(String email) {
        log.info("CourseRepoImpl was executed with getCourseByTeacher func. Teacher email: " + email);
        return courseList.stream()
                .filter(c -> c.getTeacher().getEmail().equals(email))
                .collect(Collectors.toList());
    }
}
