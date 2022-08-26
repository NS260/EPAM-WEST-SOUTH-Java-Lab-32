package com.epam.spring.project.service.interfaces;

import com.epam.spring.project.controller.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    AdminDTO createAdmin(AdminDTO admin);

    AdminDTO updateAdmin(String email, AdminDTO admin);

    AdminDTO getAdminByEmail(String email);

    void deleteAdmin(String email);

    List<AdminDTO> listAdmins();
}
