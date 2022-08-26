package com.epam.spring.project.service.repository.interfaces;

import com.epam.spring.project.service.model.course.Course;
import com.epam.spring.project.service.model.journal.Journal;
import com.epam.spring.project.service.model.user.Student;

import java.util.List;

public interface JournalRepository {
    Journal addRow(Student student, Course course);

    Integer rate(String studentEmail, String courseName, Integer mark);

    void clearRow(String studentEmail, String courseName);

    List<Journal> journal();
}
