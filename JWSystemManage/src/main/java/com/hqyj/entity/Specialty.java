package com.hqyj.entity;

public class Specialty {
    private Integer specialtyId;

    private String specialtyName;

    private Integer fkDivisionId;

    public Integer getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Integer specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName == null ? null : specialtyName.trim();
    }

    public Integer getFkDivisionId() {
        return fkDivisionId;
    }

    public void setFkDivisionId(Integer fkDivisionId) {
        this.fkDivisionId = fkDivisionId;
    }
}