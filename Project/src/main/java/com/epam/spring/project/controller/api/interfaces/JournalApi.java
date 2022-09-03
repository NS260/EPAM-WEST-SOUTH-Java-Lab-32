package com.epam.spring.project.controller.api.interfaces;

import com.epam.spring.project.controller.dto.CourseDTO;
import com.epam.spring.project.controller.dto.JournalDTO;
import com.epam.spring.project.controller.dto.StudentDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Journal Api")
@RequestMapping("api/v1/journal")
public interface JournalApi {
    @ApiOperation("Add row to the journal")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    JournalDTO addRow(@RequestBody StudentDTO student, @RequestBody CourseDTO course);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentEmail", paramType = "path", required = true, value = "Student email"),
            @ApiImplicitParam(name = "courseName", paramType = "path", required = true, value = "Course name")
    })
    @ApiOperation("Rate student")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{courseName}/{studentEmail}/{mark}")
    Integer rate(@PathVariable String studentEmail, @PathVariable String courseName, @PathVariable Integer mark);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentEmail", paramType = "path", required = true, value = "Student email"),
            @ApiImplicitParam(name = "courseName", paramType = "path", required = true, value = "Course name")
    })
    @ApiOperation("Delete row")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{courseName}/{studentEmail}")
    void clearRow(@PathVariable String studentEmail, @PathVariable String courseName);

    @ApiOperation("Get journal")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<JournalDTO> journal();
}
