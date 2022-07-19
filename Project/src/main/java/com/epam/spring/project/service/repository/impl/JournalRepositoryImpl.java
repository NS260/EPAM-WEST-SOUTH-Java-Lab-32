package com.epam.spring.project.service.repository.impl;

import com.epam.spring.project.service.model.course.Course;
import com.epam.spring.project.service.model.journal.Journal;
import com.epam.spring.project.service.model.user.Student;
import com.epam.spring.project.service.repository.interfaces.JournalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class JournalRepositoryImpl implements JournalRepository {
    private final List<Journal> journalRowList = new ArrayList<>();

    @Override
    public Journal addRow(Student student, Course course) {
        log.info("JournalRepoImpl was executed with addRow func");
        return Journal.builder().course(course).student(student).build();
    }

    @Override
    public Integer rate(String studentEmail, String courseName, Integer mark) {
        log.info("JournalRepoImpl was executed with rate func. Student email: " + studentEmail + " Course name: " + courseName);
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
        log.info("JournalRepoImpl was executed with clearRow func. Student email: " + studentEmail + " Course name: " + courseName);
        journalRowList.removeIf(j -> j.getCourse().getName().equals(courseName) && j.getStudent().getEmail().equals(studentEmail));
    }

    @Override
    public List<Journal> journal() {
        log.info("JournalRepoImpl was executed with journal func");
        return new ArrayList<>(journalRowList);
    }
}
