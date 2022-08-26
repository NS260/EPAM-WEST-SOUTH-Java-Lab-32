package com.epam.spring.project.service.repository.interfaces;

import com.epam.spring.project.service.model.course.Course;
import com.epam.spring.project.service.model.user.Student;

import java.util.List;

public interface StudentRepository {
    Student createStudent(Student student);

    Student updateStudent(String email, Student student);

    Student getStudent(String email);

    void deleteStudent(String email);

    List<Student> listStudents();

    void blockStudent(String email);

    void unblockStudent(String email);

    Student setStudentOnCourse(Course course, String email);
}
