package com.epam.spring.project.service.repository.impl;

import com.epam.spring.project.service.model.user.Admin;
import com.epam.spring.project.service.repository.interfaces.AdminRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class AdminRepositoryImpl implements AdminRepository {
    private final List<Admin> adminList = new ArrayList<>();

    @Override
    public Admin createAdmin(Admin admin) {
        admin.setCreateDate(LocalDateTime.now());
        adminList.add(admin);
        return admin;
    }

    @Override
    public Admin updateAdmin(String email, Admin admin) {
        boolean isDeleted = adminList.removeIf(a -> a.getEmail().equals(email));
        if (isDeleted) {
            adminList.add(admin);
        } else {
            throw new RuntimeException("Admin is not found");
        }
        return admin;
    }

    @Override
    public Admin getAdmin(String email) {
        return adminList.stream()
                .filter(a -> a.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Admin is not found"));
    }

    @Override
    public void deleteAdmin(String email) {
        adminList.removeIf(a -> a.getEmail().equals(email));
    }

    @Override
    public List<Admin> listAdmins() {
        return new ArrayList<>(adminList);
    }
}
