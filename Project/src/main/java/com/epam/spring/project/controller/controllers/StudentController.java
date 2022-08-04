package com.epam.spring.project.controller.controllers;

import com.epam.spring.project.controller.api.interfaces.StudentApi;
import com.epam.spring.project.controller.dto.CourseDTO;
import com.epam.spring.project.controller.dto.StudentDTO;
import com.epam.spring.project.service.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StudentController implements StudentApi {
    private final StudentService studentService;

    @Override
    public StudentDTO createStudent(@RequestBody StudentDTO student) {
        log.info("StudentController was executed with createStudent func");
        return studentService.createStudent(student);
    }

    @Override
    public StudentDTO updateStudent(@PathVariable String email, @RequestBody StudentDTO student) {
        log.info("StudentController was executed with updateStudent func. Student email: " + email);
        return studentService.updateStudent(email, student);
    }

    @Override
    public StudentDTO getStudent(@PathVariable String email) {
        log.info("StudentController was executed with getStudent func. Student email: " + email);
        return studentService.getStudent(email);
    }

    @Override
    public void deleteStudent(@PathVariable String email) {
        log.info("StudentController was executed with deleteStudent func. Student email: " + email);
        studentService.deleteStudent(email);
    }

    @Override
    public void blockStudent(@PathVariable String blockEmail) {
        log.info("StudentController was executed with blockStudent func. Student email: " + blockEmail);
        studentService.blockStudent(blockEmail);
    }

    @Override
    public void unblockStudent(@PathVariable String unblockEmail) {
        log.info("StudentController was executed with unblockStudent func. Student email: " + unblockEmail);
        studentService.unblockStudent(unblockEmail);
    }

    @Override
    public StudentDTO setStudentOnCourse(@RequestBody CourseDTO course, @PathVariable String registerEmail) {
        log.info("StudentController was executed with setStudentOnCourse func. Student email: " + registerEmail);
        return studentService.setStudentOnCourse(course, registerEmail);
    }

    @Override
    public List<StudentDTO> listStudents() {
        log.info("StudentController was executed with listStudents func");
        return studentService.listStudents();
    }
}
