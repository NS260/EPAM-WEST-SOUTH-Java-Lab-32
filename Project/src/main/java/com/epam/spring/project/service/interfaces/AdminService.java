package com.epam.spring.project.service.interfaces;

import com.epam.spring.project.controller.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    AdminDTO createAdmin(AdminDTO admin);

    AdminDTO updateAdminByEmail(String email, AdminDTO admin);

    AdminDTO getAdminByEmail(String email);

    void deleteAdminByEmail(String email);

    List<AdminDTO> listAdmins();
}
