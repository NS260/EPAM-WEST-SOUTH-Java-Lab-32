package com.epam.spring.project.controller.controllers;

import com.epam.spring.project.controller.api.interfaces.JournalApi;
import com.epam.spring.project.controller.dto.CourseDTO;
import com.epam.spring.project.controller.dto.JournalDTO;
import com.epam.spring.project.controller.dto.StudentDTO;
import com.epam.spring.project.service.interfaces.JournalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class JournalController implements JournalApi {
    private final JournalService journalService;

    @Override
    public JournalDTO addRow(@RequestBody StudentDTO student, @RequestBody CourseDTO course) {
        log.info("JournalController was executed with addRow func");
        return journalService.addRow(student, course);
    }

    @Override
    public Integer rate(@PathVariable String studentEmail, @PathVariable String courseName, @PathVariable Integer mark) {
        log.info("JournalController was executed with rate func. Student email: " + studentEmail + "and Course name : " + courseName);
        return journalService.rate(studentEmail, courseName, mark);
    }

    @Override
    public void clearRow(@PathVariable String studentEmail, @PathVariable String courseName) {
        log.info("JournalController was executed with clearRow func. Student email: " + studentEmail + "and Course name : " + courseName);
        journalService.clearRow(studentEmail, courseName);
    }

    @Override
    public List<JournalDTO> journal() {
        log.info("JournalController was executed with journal func.");
        return journalService.journal();
    }
}
