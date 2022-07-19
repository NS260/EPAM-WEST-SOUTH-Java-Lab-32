package com.epam.spring.project.controller.controllers;

import com.epam.spring.project.controller.dto.CourseDTO;
import com.epam.spring.project.controller.dto.StudentDTO;
import com.epam.spring.project.service.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO student) {

        return studentService.createStudent(student);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{email}")
    public StudentDTO updateStudent(@PathVariable String email, @RequestBody StudentDTO student) {
        return studentService.updateStudent(email, student);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    public StudentDTO getStudent(@PathVariable String email) {
        return studentService.getStudent(email);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{email}")
    public void deleteStudent(@PathVariable String email) {
        studentService.deleteStudent(email);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/block/{blockEmail}")
    public void blockStudent(@PathVariable String blockEmail) {
        studentService.blockStudent(blockEmail);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/unblock/{unblockEmail}")
    public void unblockStudent(@PathVariable String unblockEmail) {
        studentService.unblockStudent(unblockEmail);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/set/{registerEmail}")
    public StudentDTO setStudentOnCourse(@RequestBody CourseDTO course, @PathVariable String registerEmail) {
        return studentService.setStudentOnCourse(course, registerEmail);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<StudentDTO> listStudents() {
        return studentService.listStudents();
    }
}
