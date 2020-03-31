package com.hqyj.entity;

public class Division {
    private Integer universityDivisionId;

    private String divisionName;

    public Integer getUniversityDivisionId() {
        return universityDivisionId;
    }

    public void setUniversityDivisionId(Integer universityDivisionId) {
        this.universityDivisionId = universityDivisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName == null ? null : divisionName.trim();
    }
}