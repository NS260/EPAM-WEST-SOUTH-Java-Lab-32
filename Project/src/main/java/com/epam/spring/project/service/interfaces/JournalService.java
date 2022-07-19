package com.epam.spring.project.service.interfaces;

import com.epam.spring.project.controller.dto.CourseDTO;
import com.epam.spring.project.controller.dto.JournalDTO;
import com.epam.spring.project.controller.dto.StudentDTO;

import java.util.List;

public interface JournalService {
    JournalDTO addRow(StudentDTO student, CourseDTO course);

    Integer rate(String studentEmail, String courseName, Integer mark);

    void clearRow(String studentEmail, String courseName);

    List<JournalDTO> journal();
}
