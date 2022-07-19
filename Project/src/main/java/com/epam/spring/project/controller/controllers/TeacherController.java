package com.epam.spring.project.controller.controllers;

import com.epam.spring.project.controller.dto.TeacherDTO;
import com.epam.spring.project.service.interfaces.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TeacherDTO createTeacher(@RequestBody TeacherDTO teacher) {
        return teacherService.createTeacher(teacher);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{email}")
    public TeacherDTO updateTeacher(@PathVariable String email, @RequestBody TeacherDTO teacher) {
        return teacherService.updateTeacher(email, teacher);
    }

    @GetMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    public TeacherDTO getTeacher(@PathVariable String email) {
        return teacherService.getTeacher(email);
    }

    @DeleteMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeacher(@PathVariable String email) {
        teacherService.deleteTeacher(email);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TeacherDTO> listTeachers() {
        return teacherService.listTeachers();
    }
}
