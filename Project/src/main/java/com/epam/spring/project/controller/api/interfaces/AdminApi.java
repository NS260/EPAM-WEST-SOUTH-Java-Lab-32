package com.epam.spring.project.controller.api.interfaces;

import com.epam.spring.project.controller.dto.AdminDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Admin Api")
@RequestMapping("api/v1/admins")
public interface AdminApi {
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "Admin email")
    })
    @ApiOperation(value = "Get admin")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    AdminDTO getAdmin(@PathVariable String email);

    @ApiOperation("Create admin")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    AdminDTO createAdmin(@RequestBody AdminDTO admin);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "Admin email")
    })
    @ApiOperation("Update admin")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{email}")
    AdminDTO updateAdmin(@PathVariable String email, @RequestBody AdminDTO admin);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "Admin email")
    })
    @ApiOperation(("Delete admin"))
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{email}")
    void deleteAdmin(@PathVariable String email);

    @ApiOperation("Get admins")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<AdminDTO> listAdmins();
}
