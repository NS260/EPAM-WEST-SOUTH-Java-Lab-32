package com.epam.spring.project.service.impl;

import com.epam.spring.project.controller.dto.AdminDTO;
import com.epam.spring.project.service.interfaces.AdminService;
import com.epam.spring.project.service.mapper.AdminMapper;
import com.epam.spring.project.service.model.user.Admin;
import com.epam.spring.project.service.repository.interfaces.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    @Override
    public AdminDTO createAdmin(AdminDTO admin) {

        Admin newAdmin = adminRepository.createAdmin(AdminMapper.INSTANCE.mapToEntity(admin));
        return AdminMapper.INSTANCE.mapToDto(newAdmin);
    }

    @Override
    public AdminDTO updateAdmin(String email, AdminDTO admin) {
        Admin newAdmin = adminRepository.updateAdmin(email, AdminMapper.INSTANCE.mapToEntity(admin));
        return AdminMapper.INSTANCE.mapToDto(newAdmin);
    }

    @Override
    public AdminDTO getAdmin(String email) {
        return AdminMapper.INSTANCE.mapToDto(adminRepository.getAdmin(email));
    }

    @Override
    public void deleteAdmin(String email) {
        adminRepository.deleteAdmin(email);
    }

    @Override
    public List<AdminDTO> listAdmins() {
        return adminRepository
                .listAdmins()
                .stream()
                .map(AdminMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }
}
