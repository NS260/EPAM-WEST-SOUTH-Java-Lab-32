package com.epam.spring.project.service.repository.impl;

import com.epam.spring.project.service.model.user.Teacher;
import com.epam.spring.project.service.repository.interfaces.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class TeacherRepositoryImpl implements TeacherRepository {
    private final List<Teacher> teacherList = new ArrayList<>();

    @Override
    public Teacher createTeacher(Teacher teacher) {
        log.info("TeacherRepoImpl was executed with createTeacher func");
        teacher.setCreateDate(LocalDateTime.now());
        teacherList.add(teacher);
        return teacher;
    }

    @Override
    public Teacher updateTeacher(String email, Teacher teacher) {
        log.info("TeacherRepoImpl was executed with updateTeacher func. Teacher email: " + email);
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
        log.info("TeacherRepoImpl was executed with getTeacher func. Teacher email: " + email);
        return teacherList
                .stream()
                .filter(t -> t.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Teacher is not found"));
    }

    @Override
    public void deleteTeacher(String email) {
        log.info("TeacherRepoImpl was executed with deleteTeacher func. Teacher email: " + email);
        teacherList.removeIf(t -> t.getEmail().equals(email));
    }

    @Override
    public List<Teacher> listTeachers() {
        log.info("TeacherRepoImpl was executed with listTeachers func");
        return new ArrayList<>(teacherList);
    }
}
