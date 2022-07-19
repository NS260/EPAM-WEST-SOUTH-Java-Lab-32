package com.epam.spring.project.service.mapper;

import com.epam.spring.project.controller.dto.StudentDTO;
import com.epam.spring.project.service.model.user.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO mapToDto(Student student);

    Student mapToEntity(StudentDTO studentDto);

}
