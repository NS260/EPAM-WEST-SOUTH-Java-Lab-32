package com.epam.spring.project.service.repository.impl;

import com.epam.spring.project.service.model.user.Admin;
import com.epam.spring.project.service.repository.interfaces.AdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class AdminRepositoryImpl implements AdminRepository {
    private final List<Admin> adminList = new ArrayList<>();

    @Override
    public Admin createAdmin(Admin admin) {
        log.info("AdminRepoImpl was executed with createAdmin func");
        admin.setCreateDate(LocalDateTime.now());
        adminList.add(admin);
        return admin;
    }

    @Override
    public Admin updateAdmin(String email, Admin admin) {
        log.info("AdminRepoImpl was executed with updateAdmin func. Admin email: " + email);
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
        log.info("AdminRepoImpl was executed with getAdmin func. Admin email: " + email);
        return adminList.stream()
                .filter(a -> a.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Admin is not found"));
    }

    @Override
    public void deleteAdmin(String email) {
        log.info("AdminRepoImpl was executed with deleteAdmin func. Admin email: " + email);
        adminList.removeIf(a -> a.getEmail().equals(email));
    }

    @Override
    public List<Admin> listAdmins() {
        log.info("AdminRepoImpl was executed with listAdmins func");
        return new ArrayList<>(adminList);
    }
}
