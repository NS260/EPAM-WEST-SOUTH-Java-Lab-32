package com.epam.spring.project.service.mapper;

import com.epam.spring.project.controller.dto.CourseDTO;
import com.epam.spring.project.service.model.course.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDTO mapToDto(Course course);

    Course mapToEntity(CourseDTO courseDto);
}
