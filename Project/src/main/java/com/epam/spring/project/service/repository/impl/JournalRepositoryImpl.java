package com.epam.spring.project.service.repository.impl;

import com.epam.spring.project.service.model.course.Course;
import com.epam.spring.project.service.model.journal.Journal;
import com.epam.spring.project.service.model.user.Student;
import com.epam.spring.project.service.repository.interfaces.JournalRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JournalRepositoryImpl implements JournalRepository {
    private final List<Journal> journalRowList = new ArrayList<>();

    @Override
    public Journal addRow(Student student, Course course) {
        return Journal.builder().course(course).student(student).build();
    }

    @Override
    public Integer rate(String studentEmail, String courseName, Integer mark) {
        journalRowList
                .stream()
                .filter(j -> j.getCourse().getName().equals(courseName) && j.getStudent().getEmail().equals(studentEmail))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Row is not found"))
                .setMark(mark);
        return mark;
    }

    @Override
    public void clearRow(String studentEmail, String courseName) {
        journalRowList.removeIf(j -> j.getCourse().getName().equals(courseName) && j.getStudent().getEmail().equals(studentEmail));
    }

    @Override
    public List<Journal> journal() {
        return new ArrayList<>(journalRowList);
    }
}
