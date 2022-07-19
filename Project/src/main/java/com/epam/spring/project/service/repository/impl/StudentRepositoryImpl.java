package com.epam.spring.project.service.repository.impl;

import com.epam.spring.project.service.model.course.Course;
import com.epam.spring.project.service.model.user.Student;
import com.epam.spring.project.service.model.user.constant.Block;
import com.epam.spring.project.service.repository.interfaces.StudentRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentRepositoryImpl implements StudentRepository {
    private final List<Student> studentList = new ArrayList<>();

    @Override
    public Student createStudent(Student student) {
        student.setCreateDate(LocalDateTime.now());
        student.setCourseList(new ArrayList<>());
        studentList.add(student);
        return student;
    }

    @Override
    public Student updateStudent(String email, Student student) {
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
        return studentList
                .stream()
                .filter(s -> s.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student is not found"));
    }

    @Override
    public void deleteStudent(String email) {
        studentList.removeIf(u -> u.getEmail().equals(email));
    }

    @Override
    public List<Student> listStudents() {
        return new ArrayList<>(studentList);
    }

    @Override
    public void blockStudent(String email) {
        studentList
                .stream()
                .filter(s -> s.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student is not found"))
                .setBlock(Block.BLOCKED);
    }

    @Override
    public void unblockStudent(String email) {
        studentList
                .stream()
                .filter(s -> s.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student is not found"))
                .setBlock(Block.UNBLOCKED);
    }

    @Override
    public Student setStudentOnCourse(Course course, String email) {
        studentList.stream()
                .filter(s -> s.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student is not found"))
                .getCourseList().add(course);
        return getStudent(email);
    }
}
