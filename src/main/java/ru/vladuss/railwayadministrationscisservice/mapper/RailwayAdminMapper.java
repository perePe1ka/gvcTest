package ru.vladuss.railwayadministrationscisservice.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.vladuss.railwayadministrationscisservice.dto.RailwayAdminRequestDto;
import ru.vladuss.railwayadministrationscisservice.dto.RailwayAdminResponseDto;
import ru.vladuss.railwayadministrationscisservice.entity.RailwayAdmins;

@Mapper(componentModel = "spring")
public interface RailwayAdminMapper {

    RailwayAdmins toEntity(RailwayAdminRequestDto dto);

    RailwayAdminResponseDto toDto(RailwayAdmins entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget RailwayAdmins entity,
                      RailwayAdminRequestDto dto);
}
