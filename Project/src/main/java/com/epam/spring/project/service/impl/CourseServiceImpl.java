package com.epam.spring.project.service.impl;

import com.epam.spring.project.controller.dto.CourseDTO;
import com.epam.spring.project.controller.dto.TeacherDTO;
import com.epam.spring.project.service.interfaces.CourseService;
import com.epam.spring.project.service.mapper.CourseMapper;
import com.epam.spring.project.service.mapper.TeacherMapper;
import com.epam.spring.project.service.model.course.Course;
import com.epam.spring.project.service.repository.interfaces.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public CourseDTO createCourse(CourseDTO course) {
        log.info("CourseServiceImpl was executed with createCourse func");
        Course newCourse = CourseMapper.INSTANCE.mapToEntity(course);
        newCourse = courseRepository.createCourse(newCourse);
        return CourseMapper.INSTANCE.mapToDto(newCourse);
    }

    @Override
    public CourseDTO updateCourse(String name, CourseDTO course) {
        log.info("CourseServiceImpl was executed with createCourse func. Course name: " + name);
        Course newCourse = CourseMapper.INSTANCE.mapToEntity(course);
        newCourse = courseRepository.updateCourse(name, newCourse);
        return CourseMapper.INSTANCE.mapToDto(newCourse);
    }

    @Override
    public CourseDTO getCourseByEmail(String name) {
        log.info("CourseServiceImpl was executed with getCourse func. Course name: " + name);
        Course course = courseRepository.getCourse(name);
        return CourseMapper.INSTANCE.mapToDto(course);
    }

    @Override
    public void deleteCourse(String name) {
        log.info("CourseServiceImpl was executed with deleteCourse func. Course name: " + name);
        courseRepository.deleteCourse(name);
    }

    @Override
    public List<CourseDTO> listCourses() {
        log.info("CourseServiceImpl was executed with listCourses func");
        return courseRepository
                .listCourses()
                .stream()
                .map(CourseMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO setTeacherOnCourse(String courseName, TeacherDTO teacher) {
        log.info("CourseServiceImpl was executed with registerTeacherOnCourse func. Course name: " + courseName);
        Course course = courseRepository.setTeacherOnCourse(courseName, TeacherMapper.INSTANCE.mapToEntity(teacher));
        return CourseMapper.INSTANCE.mapToDto(course);
    }

    @Override
    public List<CourseDTO> getCoursesByTeacherEmail(String email) {
        log.info("CourseServiceImpl was executed with getCoursesByTeacher func. Teacher email: " + email);
        return courseRepository
                .getCoursesByTeacher(email)
                .stream()
                .map(CourseMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }
}
