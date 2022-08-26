package com.epam.spring.project.service.repository.impl;

import com.epam.spring.project.service.model.course.Course;
import com.epam.spring.project.service.model.user.Student;
import com.epam.spring.project.service.model.user.constant.Block;
import com.epam.spring.project.service.repository.interfaces.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private final List<Student> studentList = new ArrayList<>();

    @Override
    public Student createStudent(Student student) {
        log.info("StudentRepoImpl was executed with createStudent func");
        student.setCreateDate(LocalDateTime.now());
        student.setCourseList(new ArrayList<>());
        studentList.add(student);
        return student;
    }

    @Override
    public Student updateStudent(String email, Student student) {
        log.info("StudentRepoImpl was executed with updateStudent func. Student email: " + email);
        boolean isDeleted = studentList.removeIf(u -> u.getEmail().equals(email));
        if (isDeleted) {
            studentList.add(student);
        } else {
            throw new RuntimeException("Student is not found");
        }
        return student;
    }

    @Override
    public Student getStudent(String email) {
        log.info("StudentRepoImpl was executed with getStudent func. Student email: " + email);
        return studentList
                .stream()
                .filter(s -> s.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student is not found"));
    }

    @Override
    public void deleteStudent(String email) {
        log.info("StudentRepoImpl was executed with deleteStudent func. Student email: " + email);
        studentList.removeIf(u -> u.getEmail().equals(email));
    }

    @Override
    public List<Student> listStudents() {
        log.info("StudentRepoImpl was executed with listStudents func");
        return new ArrayList<>(studentList);
    }

    @Override
    public void blockStudent(String email) {
        log.info("StudentRepoImpl was executed with blockStudent func. Student email: " + email);
        studentList
                .stream()
                .filter(s -> s.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student is not found"))
                .setBlock(Block.BLOCKED);
    }

    @Override
    public void unblockStudent(String email) {
        log.info("StudentRepoImpl was executed with unblockStudent func. Student email: " + email);
        studentList
                .stream()
                .filter(s -> s.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student is not found"))
                .setBlock(Block.UNBLOCKED);
    }

    @Override
    public Student setStudentOnCourse(Course course, String email) {
        log.info("StudentRepoImpl was executed with setStudentOnCourse func. Student email: " + email);
        studentList.stream()
                .filter(s -> s.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student is not found"))
                .getCourseList().add(course);
        return getStudent(email);
    }
}
