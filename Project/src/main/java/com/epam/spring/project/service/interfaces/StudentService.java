package com.epam.spring.project.service.interfaces;

import com.epam.spring.project.controller.dto.CourseDTO;
import com.epam.spring.project.controller.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO student);

    StudentDTO updateStudent(String email, StudentDTO student);

    StudentDTO getStudentByEmail(String email);

    void deleteStudent(String email);

    List<StudentDTO> listStudents();

    void blockStudent(String email);

    void unblockStudent(String email);

    StudentDTO setStudentOnCourse(CourseDTO course, String email);
}
