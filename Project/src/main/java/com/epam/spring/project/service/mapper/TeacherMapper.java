package com.epam.spring.project.service.mapper;

import com.epam.spring.project.controller.dto.TeacherDTO;
import com.epam.spring.project.service.model.user.Teacher;
import org.mapstruct.factory.Mappers;

public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    TeacherDTO mapToDto(Teacher teacher);

    Teacher mapToEntity(TeacherDTO teacherDto);
}
