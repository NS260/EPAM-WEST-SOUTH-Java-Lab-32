package com.epam.spring.project.service.impl;

import com.epam.spring.project.controller.dto.CourseDTO;
import com.epam.spring.project.controller.dto.StudentDTO;
import com.epam.spring.project.service.interfaces.StudentService;
import com.epam.spring.project.service.mapper.CourseMapper;
import com.epam.spring.project.service.mapper.StudentMapper;
import com.epam.spring.project.service.model.user.Student;
import com.epam.spring.project.service.repository.interfaces.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public StudentDTO createStudent(StudentDTO student) {
        Student newStudent = StudentMapper.INSTANCE.mapToEntity(student);
        newStudent = studentRepository.createStudent(newStudent);
        return StudentMapper.INSTANCE.mapToDto(newStudent);
    }

    @Override
    public StudentDTO updateStudent(String email, StudentDTO student) {
        Student newStudent = StudentMapper.INSTANCE.mapToEntity(student);
        newStudent = studentRepository.updateStudent(email, newStudent);
        return StudentMapper.INSTANCE.mapToDto(newStudent);
    }

    @Override
    public StudentDTO getStudent(String email) {
        Student student = studentRepository.getStudent(email);
        return StudentMapper.INSTANCE.mapToDto(student);
    }

    @Override
    public void deleteStudent(String email) {
        studentRepository.deleteStudent(email);
    }

    @Override
    public List<StudentDTO> listStudents() {
        return studentRepository
                .listStudents()
                .stream()
                .map(StudentMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void blockStudent(String email) {
        studentRepository.blockStudent(email);
    }

    @Override
    public void unblockStudent(String email) {
        studentRepository.unblockStudent(email);
    }

    @Override
    public StudentDTO setStudentOnCourse(CourseDTO course, String email) {
        studentRepository.setStudentOnCourse(CourseMapper.INSTANCE.mapToEntity(course), email);
        Student student = studentRepository.getStudent(email);
        return StudentMapper.INSTANCE.mapToDto(student);
    }
}
