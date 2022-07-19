package com.epam.spring.project.controller.controllers;

import com.epam.spring.project.controller.dto.CourseDTO;
import com.epam.spring.project.controller.dto.StudentDTO;
import com.epam.spring.project.service.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO student) {
        log.info("StudentController was executed with createStudent func");
        return studentService.createStudent(student);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{email}")
    public StudentDTO updateStudent(@PathVariable String email, @RequestBody StudentDTO student) {
        log.info("StudentController was executed with updateStudent func. Student email: " + email);
        return studentService.updateStudent(email, student);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    public StudentDTO getStudent(@PathVariable String email) {
        log.info("StudentController was executed with getStudent func. Student email: " + email);
        return studentService.getStudent(email);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{email}")
    public void deleteStudent(@PathVariable String email) {
        log.info("StudentController was executed with deleteStudent func. Student email: " + email);
        studentService.deleteStudent(email);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/block/{blockEmail}")
    public void blockStudent(@PathVariable String blockEmail) {
        log.info("StudentController was executed with blockStudent func. Student email: " + blockEmail);
        studentService.blockStudent(blockEmail);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/unblock/{unblockEmail}")
    public void unblockStudent(@PathVariable String unblockEmail) {
        log.info("StudentController was executed with unblockStudent func. Student email: " + unblockEmail);
        studentService.unblockStudent(unblockEmail);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/set/{registerEmail}")
    public StudentDTO setStudentOnCourse(@RequestBody CourseDTO course, @PathVariable String registerEmail) {
        log.info("StudentController was executed with registerStudentOnCourse func. Student email: " + registerEmail);
        return studentService.setStudentOnCourse(course, registerEmail);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<StudentDTO> listStudents() {
        log.info("StudentController was executed with listStudents func");
        return studentService.listStudents();
    }
}
