package com.epam.spring.project.service.interfaces;

import com.epam.spring.project.controller.dto.TeacherDTO;

import java.util.List;

public interface TeacherService {
    TeacherDTO createTeacher(TeacherDTO teacher);

    TeacherDTO updateTeacher(String email, TeacherDTO teacher);

    TeacherDTO getTeacher(String email);

    void deleteTeacher(String email);

    List<TeacherDTO> listTeachers();
}
