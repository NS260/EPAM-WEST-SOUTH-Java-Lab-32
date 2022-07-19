package com.epam.spring.project.controller.controllers;

import com.epam.spring.project.controller.dto.AdminDTO;
import com.epam.spring.project.service.interfaces.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admins")
public class AdminController {
    private final AdminService adminService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    public AdminDTO getAdmin(@PathVariable String email) {
        return adminService.getAdmin(email);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AdminDTO createAdmin(@RequestBody AdminDTO admin) {
        return adminService.createAdmin(admin);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{email}")
    public AdminDTO updateAdmin(@PathVariable String email, @RequestBody AdminDTO admin) {
        return adminService.updateAdmin(email, admin);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{email}")
    public void deleteAdmin(@PathVariable String email) {
        adminService.deleteAdmin(email);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<AdminDTO> listAdmins() {
        return adminService.listAdmins();
    }
}
