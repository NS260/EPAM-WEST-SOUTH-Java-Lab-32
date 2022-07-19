package com.epam.spring.project.controller.controllers;

import com.epam.spring.project.controller.dto.TeacherDTO;
import com.epam.spring.project.service.interfaces.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TeacherDTO createTeacher(@RequestBody TeacherDTO teacher) {
        log.info("TeacherController was executed with createTeacher func");
        return teacherService.createTeacher(teacher);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{email}")
    public TeacherDTO updateTeacher(@PathVariable String email, @RequestBody TeacherDTO teacher) {
        log.info("TeacherController was executed with updateTeacher func. Teacher email: " + email);
        return teacherService.updateTeacher(email, teacher);
    }

    @GetMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    public TeacherDTO getTeacher(@PathVariable String email) {
        log.info("TeacherController was executed with getTeacher func. Teacher email: " + email);
        return teacherService.getTeacher(email);
    }

    @DeleteMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeacher(@PathVariable String email) {
        log.info("TeacherController was executed with deleteTeacher func. Teacher email: " + email);
        teacherService.deleteTeacher(email);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TeacherDTO> listTeachers() {
        log.info("TeacherController was executed with listTeachers func");
        return teacherService.listTeachers();
    }
}
