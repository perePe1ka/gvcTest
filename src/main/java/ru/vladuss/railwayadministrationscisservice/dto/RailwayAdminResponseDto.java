package ru.vladuss.railwayadministrationscisservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public class RailwayAdminResponseDto {
    private Long   codeJa;

    private String fullNameJa;

    private String abbrJa;

    public RailwayAdminResponseDto(Long codeJa, String fullNameJa, String abbrJa) {
        this.codeJa = codeJa;
        this.fullNameJa = fullNameJa;
        this.abbrJa = abbrJa;
    }

    public RailwayAdminResponseDto() {
    }

    public Long getCodeJa() {
        return codeJa;
    }

    public void setCodeJa(Long codeJa) {
        this.codeJa = codeJa;
    }

    public String getFullNameJa() {
        return fullNameJa;
    }

    public void setFullNameJa(String fullNameJa) {
        this.fullNameJa = fullNameJa;
    }

    public String getAbbrJa() {
        return abbrJa;
    }

    public void setAbbrJa(String abbrJa) {
        this.abbrJa = abbrJa;
    }
}