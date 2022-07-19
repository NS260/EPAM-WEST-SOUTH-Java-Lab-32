package com.epam.spring.project.controller.controllers;

import com.epam.spring.project.controller.dto.CourseDTO;
import com.epam.spring.project.controller.dto.JournalDTO;
import com.epam.spring.project.controller.dto.StudentDTO;
import com.epam.spring.project.service.interfaces.JournalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/journal")
public class JournalController {
    private final JournalService journalService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public JournalDTO addRow(@RequestBody StudentDTO student, @RequestBody CourseDTO course) {
        log.info("JournalController was executed with addRow func");
        return journalService.addRow(student, course);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping({"/{studentEmail}", "/{courseName}", "/{mark}"})
    public Integer rate(@PathVariable String studentEmail, @PathVariable String courseName, @PathVariable Integer mark) {
        log.info("JournalController was executed with rate func. Student email: " + studentEmail + "and Course name : " + courseName);
        return journalService.rate(studentEmail, courseName, mark);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping({"/{studentEmail}", "/{courseName}"})
    public void clearRow(@PathVariable String studentEmail, @PathVariable String courseName) {
        log.info("JournalController was executed with clearRow func. Student email: " + studentEmail + "and Course name : " + courseName);
        journalService.clearRow(studentEmail, courseName);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<JournalDTO> journal() {
        log.info("JournalController was executed with journal func.");
        return journalService.journal();
    }
}