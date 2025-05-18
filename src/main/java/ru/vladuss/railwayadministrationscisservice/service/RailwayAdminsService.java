package ru.vladuss.railwayadministrationscisservice.service;

import org.springframework.transaction.annotation.Transactional;
import ru.vladuss.railwayadministrationscisservice.dto.RailwayAdminRequestDto;
import ru.vladuss.railwayadministrationscisservice.dto.RailwayAdminResponseDto;
import ru.vladuss.railwayadministrationscisservice.entity.RailwayAdmins;

import javax.validation.Valid;
import java.util.List;

public interface RailwayAdminsService {

    @Transactional
    RailwayAdminResponseDto create(@Valid RailwayAdminRequestDto dto);


    @Transactional
    void delete(Long codeJa);

    @Transactional(readOnly = true)
    RailwayAdminResponseDto getById(Long codeJa);

    @Transactional(readOnly = true)
    List<RailwayAdminResponseDto> getALl();

    @Transactional
    RailwayAdminResponseDto update(Long codeJa, @Valid RailwayAdminRequestDto dto);
}
