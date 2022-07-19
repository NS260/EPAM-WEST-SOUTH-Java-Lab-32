package com.epam.spring.project.service.impl;

import com.epam.spring.project.controller.dto.CourseDTO;
import com.epam.spring.project.controller.dto.TeacherDTO;
import com.epam.spring.project.service.interfaces.CourseService;
import com.epam.spring.project.service.mapper.CourseMapper;
import com.epam.spring.project.service.mapper.TeacherMapper;
import com.epam.spring.project.service.model.course.Course;
import com.epam.spring.project.service.repository.interfaces.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public CourseDTO createCourse(CourseDTO course) {
        Course newCourse = CourseMapper.INSTANCE.mapToEntity(course);
        newCourse = courseRepository.createCourse(newCourse);
        return CourseMapper.INSTANCE.mapToDto(newCourse);
    }

    @Override
    public CourseDTO updateCourse(String name, CourseDTO course) {
        Course newCourse = CourseMapper.INSTANCE.mapToEntity(course);
        newCourse = courseRepository.updateCourse(name, newCourse);
        return CourseMapper.INSTANCE.mapToDto(newCourse);
    }

    @Override
    public CourseDTO getCourse(String name) {
        Course course = courseRepository.getCourse(name);
        return CourseMapper.INSTANCE.mapToDto(course);
    }

    @Override
    public void deleteCourse(String name) {
        courseRepository.deleteCourse(name);
    }

    @Override
    public List<CourseDTO> listCourses() {
        return courseRepository
                .listCourses()
                .stream()
                .map(CourseMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO setTeacherOnCourse(String courseName, TeacherDTO teacher) {
        Course course = courseRepository.setTeacherOnCourse(courseName, TeacherMapper.INSTANCE.mapToEntity(teacher));
        return CourseMapper.INSTANCE.mapToDto(course);
    }

    @Override
    public List<CourseDTO> getCoursesByTeacher(String email) {
        return courseRepository
                .getCoursesByTeacher(email)
                .stream()
                .map(CourseMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }
}
