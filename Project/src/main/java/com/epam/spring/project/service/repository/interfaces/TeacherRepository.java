package com.epam.spring.project.service.repository.interfaces;

import com.epam.spring.project.service.model.user.Teacher;

import java.util.List;

public interface TeacherRepository {
    Teacher createTeacher(Teacher teacher);

    Teacher updateTeacher(String email, Teacher teacher);

    Teacher getTeacher(String email);

    void deleteTeacher(String email);

    List<Teacher> listTeachers();
}
