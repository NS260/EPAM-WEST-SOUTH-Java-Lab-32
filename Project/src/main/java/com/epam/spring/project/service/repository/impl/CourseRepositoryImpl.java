package com.epam.spring.project.service.repository.impl;

import com.epam.spring.project.service.model.course.Course;
import com.epam.spring.project.service.model.user.Teacher;
import com.epam.spring.project.service.repository.interfaces.CourseRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseRepositoryImpl implements CourseRepository {
    private final List<Course> courseList = new ArrayList<>();

    @Override
    public Course createCourse(Course course) {
        course.setStartDate(LocalDateTime.now());
        courseList.add(course);
        return course;
    }

    @Override
    public Course updateCourse(String name, Course course) {
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
        return courseList.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Course is not found"));
    }

    @Override
    public void deleteCourse(String name) {
        courseList.removeIf(c -> c.getName().equals(name));
    }

    @Override
    public List<Course> listCourses() {
        return new ArrayList<>(courseList);
    }

    @Override
    public Course setTeacherOnCourse(String courseName, Teacher teacher) {
        courseList.stream()
                .filter(c -> c.getName().equals(courseName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Course is not found"))
                .setTeacher(teacher);
        return getCourse(courseName);
    }

    @Override
    public List<Course> getCoursesByTeacher(String email) {
        return courseList.stream()
                .filter(c -> c.getTeacher().getEmail().equals(email))
                .collect(Collectors.toList());
    }
}
