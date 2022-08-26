package com.epam.spring.project.service.interfaces;

import com.epam.spring.project.controller.dto.TeacherDTO;

import java.util.List;

public interface TeacherService {
    TeacherDTO createTeacher(TeacherDTO teacher);

    TeacherDTO updateTeacherByEmail(String email, TeacherDTO teacher);

    TeacherDTO getTeacherByEmail(String email);

    void deleteTeacherByEmail(String email);

    List<TeacherDTO> listTeachers();
}
