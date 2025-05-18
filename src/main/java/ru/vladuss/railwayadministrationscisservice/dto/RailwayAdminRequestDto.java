package ru.vladuss.railwayadministrationscisservice.dto;

import org.antlr.v4.runtime.misc.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RailwayAdminRequestDto {
    @NotNull
    private Long codeJa;

    @NotBlank
    @Size(max = 255)
    private String fullNameJa;

    @NotBlank
    @Size(max = 10)
    private String abbrJa;

    public RailwayAdminRequestDto(Long codeJa, String fullNameJa, String abbrJa) {
        this.codeJa = codeJa;
        this.fullNameJa = fullNameJa;
        this.abbrJa = abbrJa;
    }

    public RailwayAdminRequestDto() {
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