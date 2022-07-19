package com.epam.spring.project.service.impl;

import com.epam.spring.project.controller.dto.CourseDTO;
import com.epam.spring.project.controller.dto.JournalDTO;
import com.epam.spring.project.controller.dto.StudentDTO;
import com.epam.spring.project.service.interfaces.JournalService;
import com.epam.spring.project.service.mapper.CourseMapper;
import com.epam.spring.project.service.mapper.JournalMapper;
import com.epam.spring.project.service.mapper.StudentMapper;
import com.epam.spring.project.service.model.journal.Journal;
import com.epam.spring.project.service.repository.interfaces.JournalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JournalServiceImpl implements JournalService {
    private final JournalRepository journalRepository;

    @Override
    public JournalDTO addRow(StudentDTO student, CourseDTO course) {
        Journal row = journalRepository.addRow(
                StudentMapper.INSTANCE.mapToEntity(student),
                CourseMapper.INSTANCE.mapToEntity(course));
        return JournalMapper.INSTANCE.mapToDto(row);
    }

    @Override
    public Integer rate(String studentEmail, String courseName, Integer mark) {
        return journalRepository.rate(studentEmail, courseName, mark);
    }

    @Override
    public void clearRow(String studentEmail, String courseName) {
        journalRepository.clearRow(studentEmail, courseName);
    }

    @Override
    public List<JournalDTO> journal() {
        return journalRepository
                .journal()
                .stream()
                .map(JournalMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }
}
