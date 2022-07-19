package com.epam.spring.project.service.repository.impl;

import com.epam.spring.project.service.model.user.Teacher;
import com.epam.spring.project.service.repository.interfaces.TeacherRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherRepositoryImpl implements TeacherRepository {
    private final List<Teacher> teacherList = new ArrayList<>();

    @Override
    public Teacher createTeacher(Teacher teacher) {
        teacher.setCreateDate(LocalDateTime.now());
        teacherList.add(teacher);
        return teacher;
    }

    @Override
    public Teacher updateTeacher(String email, Teacher teacher) {
        boolean isDeleted = teacherList.removeIf(t -> t.getEmail().equals(email));
        if (isDeleted) {
            teacherList.add(teacher);
        } else {
            throw new RuntimeException("Teacher is not found");
        }
        return teacher;
    }

    @Override
    public Teacher getTeacher(String email) {
        return teacherList
                .stream()
                .filter(t -> t.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Teacher is not found"));
    }

    @Override
    public void deleteTeacher(String email) {
        teacherList.removeIf(t -> t.getEmail().equals(email));
    }

    @Override
    public List<Teacher> listTeachers() {
        return new ArrayList<>(teacherList);
    }
}
