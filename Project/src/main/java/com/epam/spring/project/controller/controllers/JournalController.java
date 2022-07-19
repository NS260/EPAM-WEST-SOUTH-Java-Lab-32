package com.epam.spring.project.controller.controllers;

import com.epam.spring.project.controller.dto.CourseDTO;
import com.epam.spring.project.controller.dto.JournalDTO;
import com.epam.spring.project.controller.dto.StudentDTO;
import com.epam.spring.project.service.interfaces.JournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/journal")
public class JournalController {
    private final JournalService journalService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public JournalDTO addRow(@RequestBody StudentDTO student, @RequestBody CourseDTO course) {

        return journalService.addRow(student, course);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping({"/{studentEmail}", "/{courseName}", "/{mark}"})
    public Integer rate(@PathVariable String studentEmail, @PathVariable String courseName, @PathVariable Integer mark) {
        return journalService.rate(studentEmail, courseName, mark);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping({"/{studentEmail}", "/{courseName}"})
    public void clearRow(@PathVariable String studentEmail, @PathVariable String courseName) {
        journalService.clearRow(studentEmail, courseName);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<JournalDTO> journal() {
        return journalService.journal();
    }
}
