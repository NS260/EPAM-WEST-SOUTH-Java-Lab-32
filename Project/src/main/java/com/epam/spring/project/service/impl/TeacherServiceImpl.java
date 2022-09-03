package com.epam.spring.project.service.impl;

import com.epam.spring.project.controller.dto.TeacherDTO;
import com.epam.spring.project.service.interfaces.TeacherService;
import com.epam.spring.project.service.mapper.TeacherMapper;
import com.epam.spring.project.service.model.user.Teacher;
import com.epam.spring.project.service.repository.interfaces.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Override
    public TeacherDTO createTeacher(TeacherDTO teacher) {
        log.info("TeacherServiceImpl was executed with createTeacher func");
        Teacher newTeacher = teacherRepository.createTeacher(TeacherMapper.INSTANCE.mapToEntity(teacher));
        return TeacherMapper.INSTANCE.mapToDto(newTeacher);
    }

    @Override
    public TeacherDTO updateTeacherByEmail(String email, TeacherDTO teacher) {
        log.info("TeacherServiceImpl was executed with updateTeacher func. Teacher email: " + email);
        Teacher newTeacher = TeacherMapper.INSTANCE.mapToEntity(teacher);
        newTeacher = teacherRepository.updateTeacher(email, newTeacher);
        return TeacherMapper.INSTANCE.mapToDto(newTeacher);
    }

    @Override
    public TeacherDTO getTeacherByEmail(String email) {
        log.info("TeacherServiceImpl was executed with getTeacher func. Teacher email: " + email);
        Teacher teacher = teacherRepository.getTeacher(email);
        return TeacherMapper.INSTANCE.mapToDto(teacher);
    }

    @Override
    public void deleteTeacherByEmail(String email) {
        log.info("TeacherServiceImpl was executed with deleteTeacher func. Teacher email: " + email);
        teacherRepository.deleteTeacher(email);
    }

    @Override
    public List<TeacherDTO> listTeachers() {
        log.info("TeacherServiceImpl was executed with listTeachers func");
        return teacherRepository
                .listTeachers()
                .stream()
                .map(TeacherMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }
}
