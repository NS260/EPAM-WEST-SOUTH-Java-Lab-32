package com.epam.spring.project.service.mapper;

import com.epam.spring.project.controller.dto.AdminDTO;
import com.epam.spring.project.service.model.user.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    AdminDTO mapToDto(Admin admin);

    Admin mapToEntity(AdminDTO adminDto);
}
