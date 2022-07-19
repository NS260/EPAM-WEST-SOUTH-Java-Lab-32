package com.epam.spring.project.service.impl;

import com.epam.spring.project.controller.dto.TeacherDTO;
import com.epam.spring.project.service.interfaces.TeacherService;
import com.epam.spring.project.service.mapper.TeacherMapper;
import com.epam.spring.project.service.model.user.Teacher;
import com.epam.spring.project.service.repository.interfaces.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Override
    public TeacherDTO createTeacher(TeacherDTO teacher) {
        Teacher newTeacher = teacherRepository.createTeacher(TeacherMapper.INSTANCE.mapToEntity(teacher));
        return TeacherMapper.INSTANCE.mapToDto(newTeacher);
    }

    @Override
    public TeacherDTO updateTeacher(String email, TeacherDTO teacher) {
        Teacher newTeacher = TeacherMapper.INSTANCE.mapToEntity(teacher);
        newTeacher = teacherRepository.updateTeacher(email, newTeacher);
        return TeacherMapper.INSTANCE.mapToDto(newTeacher);
    }

    @Override
    public TeacherDTO getTeacher(String email) {
        Teacher teacher = teacherRepository.getTeacher(email);
        return TeacherMapper.INSTANCE.mapToDto(teacher);
    }

    @Override
    public void deleteTeacher(String email) {
        teacherRepository.deleteTeacher(email);
    }

    @Override
    public List<TeacherDTO> listTeachers() {
        return teacherRepository
                .listTeachers()
                .stream()
                .map(TeacherMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }
}
