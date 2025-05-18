package ru.vladuss.railwayadministrationscisservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "railway_admins")
public class RailwayAdmins {
    @Id
    @Column(name = "code_ja", nullable = false)
    private Long codeJa;

    @Column(name = "full_name_ja", nullable = false)
    private String fullNameJa;

    @Column(name = "abbr_ja", nullable = false)
    private String abbrJa;

    public RailwayAdmins(Long codeJa, String fullNameJa, String abbrJa) {
        this.codeJa = codeJa;
        this.fullNameJa = fullNameJa;
        this.abbrJa = abbrJa;
    }

    public RailwayAdmins() {
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
