package com.epam.spring.project.controller.api.interfaces;

import com.epam.spring.project.controller.dto.TeacherDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Teacher Api")
@RequestMapping("api/v1/teacher")
public interface TeacherApi {
    @ApiOperation("Create teacher")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    TeacherDTO createTeacher(@RequestBody TeacherDTO teacher);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "Teacher email")
    })
    @ApiOperation("Update teacher")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{email}")
    TeacherDTO updateTeacher(@PathVariable String email, @RequestBody TeacherDTO teacher);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "Teacher email")
    })
    @ApiOperation("Get teacher by email")
    @GetMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    TeacherDTO getTeacher(@PathVariable String email);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "Teacher email")
    })
    @ApiOperation("Delete teacher")
    @DeleteMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTeacher(@PathVariable String email);

    @ApiOperation("Get teachers")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<TeacherDTO> listTeachers();
}
