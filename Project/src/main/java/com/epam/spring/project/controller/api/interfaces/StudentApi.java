package com.epam.spring.project.controller.api.interfaces;

import com.epam.spring.project.controller.dto.CourseDTO;
import com.epam.spring.project.controller.dto.StudentDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Student Api")
@RequestMapping("api/v1/students")
public interface StudentApi {
    @ApiOperation("Create student")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    StudentDTO createStudent(@RequestBody StudentDTO student);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "Student email")
    })
    @ApiOperation("Update student")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{email}")
    StudentDTO updateStudent(@PathVariable String email, @RequestBody StudentDTO student);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "Student email")
    })
    @ApiOperation("Get student")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    StudentDTO getStudent(@PathVariable String email);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "Student email")
    })
    @ApiOperation("Delete student")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{email}")
    void deleteStudent(@PathVariable String email);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "Student email")
    })
    @ApiOperation("Block student")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/block/{blockEmail}")
    void blockStudent(@PathVariable String blockEmail);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "Student email")
    })
    @ApiOperation("Unblock student")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/unblock/{unblockEmail}")
    void unblockStudent(@PathVariable String unblockEmail);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "Student email")
    })
    @ApiOperation("Register student on course")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/register/{registerEmail}")
    StudentDTO setStudentOnCourse(@RequestBody CourseDTO course, @PathVariable String registerEmail);

    @ApiOperation("Get students")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<StudentDTO> listStudents();
}
