package com.epam.spring.project.controller.controllers;

import com.epam.spring.project.controller.dto.AdminDTO;
import com.epam.spring.project.service.interfaces.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/admins")
public class AdminController {
    private final AdminService adminService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    public AdminDTO getAdmin(@PathVariable String email) {
        log.info("AdminController was executed with getAdmin func. User email: " + email);
        return adminService.getAdmin(email);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AdminDTO createAdmin(@RequestBody AdminDTO admin) {
        log.info("AdminController was executed with createAdmin func");
        return adminService.createAdmin(admin);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{email}")
    public AdminDTO updateAdmin(@PathVariable String email, @RequestBody AdminDTO admin) {
        log.info("AdminController was executed with updateAdmin func. User email: " + email);
        return adminService.updateAdmin(email, admin);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{email}")
    public void deleteAdmin(@PathVariable String email) {
        log.info("AdminController was executed with deleteAdmin func. User email: " + email);
        adminService.deleteAdmin(email);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<AdminDTO> listAdmins() {
        log.info("AdminController was executed with listAdmins func");
        return adminService.listAdmins();
    }
}
