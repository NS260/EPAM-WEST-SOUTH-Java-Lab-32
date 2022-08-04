package com.epam.spring.project.controller.controllers;

import com.epam.spring.project.controller.api.interfaces.TeacherApi;
import com.epam.spring.project.controller.dto.TeacherDTO;
import com.epam.spring.project.service.interfaces.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TeacherController implements TeacherApi {
    private final TeacherService teacherService;

    @Override
    public TeacherDTO createTeacher(@RequestBody TeacherDTO teacher) {
        log.info("TeacherController was executed with createTeacher func");
        return teacherService.createTeacher(teacher);
    }

    @Override
    public TeacherDTO updateTeacher(@PathVariable String email, @RequestBody TeacherDTO teacher) {
        log.info("TeacherController was executed with updateTeacher func. Teacher email: " + email);
        return teacherService.updateTeacher(email, teacher);
    }

    @Override
    public TeacherDTO getTeacher(@PathVariable String email) {
        log.info("TeacherController was executed with getTeacher func. Teacher email: " + email);
        return teacherService.getTeacher(email);
    }

    @Override
    public void deleteTeacher(@PathVariable String email) {
        log.info("TeacherController was executed with deleteTeacher func. Teacher email: " + email);
        teacherService.deleteTeacher(email);
    }

    @Override
    public List<TeacherDTO> listTeachers() {
        log.info("TeacherController was executed with listTeachers func");
        return teacherService.listTeachers();
    }
}
