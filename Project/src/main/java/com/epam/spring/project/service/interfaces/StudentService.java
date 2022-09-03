package com.epam.spring.project.service.interfaces;

import com.epam.spring.project.controller.dto.CourseDTO;
import com.epam.spring.project.controller.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO student);

    StudentDTO updateStudentByEmail(String email, StudentDTO student);

    StudentDTO getStudentByEmail(String email);

    void deleteStudentByEmail(String email);

    List<StudentDTO> listStudents();

    void blockStudentByEmail(String email);

    void unblockStudentByEmail(String email);

    StudentDTO setStudentOnCourseByEmail(CourseDTO course, String email);
}
