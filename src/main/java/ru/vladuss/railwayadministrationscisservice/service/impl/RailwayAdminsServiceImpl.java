package ru.vladuss.railwayadministrationscisservice.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vladuss.railwayadministrationscisservice.dto.RailwayAdminRequestDto;
import ru.vladuss.railwayadministrationscisservice.dto.RailwayAdminResponseDto;
import ru.vladuss.railwayadministrationscisservice.entity.RailwayAdmins;
import ru.vladuss.railwayadministrationscisservice.mapper.RailwayAdminMapper;
import ru.vladuss.railwayadministrationscisservice.repository.RailwayAdminsRepository;
import ru.vladuss.railwayadministrationscisservice.service.RailwayAdminsService;

import javax.validation.Valid;
import java.util.List;

@Service
public class RailwayAdminsServiceImpl implements RailwayAdminsService {
    private final RailwayAdminsRepository repository;
    private final RailwayAdminMapper mapper;

    @Autowired
    public RailwayAdminsServiceImpl(RailwayAdminsRepository repository, RailwayAdminMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public RailwayAdminResponseDto create(@Valid RailwayAdminRequestDto dto) {
        if (repository.existsById(dto.getCodeJa())) {
            throw new IllegalStateException("Admin with code " + dto.getCodeJa() + " already exists");
        }
        RailwayAdmins railwayAdmins = repository.save(mapper.toEntity(dto));
        return mapper.toDto(railwayAdmins);
    }

    @Transactional
    @Override
    public void delete(Long codeJa) {
        if (!repository.existsById(codeJa)) {
            throw new EntityNotFoundException("Admin code: " + codeJa + " not found");
        }
        repository.deleteById(codeJa);
    }

    @Transactional(readOnly = true)
    @Override
    public RailwayAdminResponseDto getById(Long codeJa) {
        return repository.findById(codeJa).map(mapper::toDto).orElseThrow(() -> new EntityNotFoundException("Admin code: " + codeJa + " not found"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<RailwayAdminResponseDto> getALl() {
        return repository.findAll(Sort.by("codeJa"))
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Transactional
    @Override
    public RailwayAdminResponseDto update(Long codeJa, @Valid RailwayAdminRequestDto dto) {
        RailwayAdmins railwayAdmins = repository.findById(codeJa).orElseThrow(() -> new EntityNotFoundException("Not found: " + codeJa));

        mapper.updateEntity(railwayAdmins, dto);
        return mapper.toDto(railwayAdmins);
    }

}
