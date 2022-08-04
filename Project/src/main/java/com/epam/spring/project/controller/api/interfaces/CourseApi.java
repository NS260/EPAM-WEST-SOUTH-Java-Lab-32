package com.epam.spring.project.controller.api.interfaces;

import com.epam.spring.project.controller.dto.CourseDTO;
import com.epam.spring.project.controller.dto.TeacherDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Course Api")
@RequestMapping("api/v1/courses")
public interface CourseApi {
    @ApiOperation("Create course")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    CourseDTO createCourse(@RequestBody CourseDTO course);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "Course name")
    })
    @ApiOperation("Update course")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{name}")
    CourseDTO updateCourse(@PathVariable String name, @RequestBody CourseDTO course);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "Course name")
    })
    @ApiOperation("Get course")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{name}")
    CourseDTO getCourse(@PathVariable String name);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "Course name")
    })
    @ApiOperation("Delete course")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{name}")
    void deleteCourse(@PathVariable String name);

    @ApiOperation("Get list of courses")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<CourseDTO> listCourses();

    @ApiImplicitParams({
            @ApiImplicitParam(name = "courseName", paramType = "path", required = true, value = "Course name")
    })
    @ApiOperation("Register teacher on course")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/register/{courseName}")
    CourseDTO setTeacherOnCourse(@PathVariable String courseName, @RequestBody TeacherDTO teacher);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "Teacher email")
    })
    @ApiOperation("Get courses by teacher")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/teacher/{email}")
    List<CourseDTO> getCoursesByTeacher(@PathVariable String email);
}
