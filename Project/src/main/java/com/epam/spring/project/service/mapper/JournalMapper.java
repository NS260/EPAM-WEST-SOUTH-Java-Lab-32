package com.epam.spring.project.service.mapper;

import com.epam.spring.project.controller.dto.JournalDTO;
import com.epam.spring.project.service.model.journal.Journal;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JournalMapper {
    JournalMapper INSTANCE = Mappers.getMapper(JournalMapper.class);

    JournalDTO mapToDto(Journal journalRow);

    Journal mapToEntity(JournalDTO journalDTO);
}
