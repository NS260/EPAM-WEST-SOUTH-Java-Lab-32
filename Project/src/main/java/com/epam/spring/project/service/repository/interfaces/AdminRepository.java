package com.epam.spring.project.service.repository.interfaces;

import com.epam.spring.project.service.model.user.Admin;

import java.util.List;

public interface AdminRepository {
    Admin createAdmin(Admin admin);

    Admin updateAdmin(String email, Admin admin);

    Admin getAdmin(String email);

    void deleteAdmin(String email);

    List<Admin> listAdmins();
}
