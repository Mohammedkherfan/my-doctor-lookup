package com.leeds.dr.lookup.response;

public class ListMedicalSpecialtyResponse {

    private Long code;
    private String medicalSpecialty;

    public ListMedicalSpecialtyResponse(Long code, String medicalSpecialty) {
        this.code = code;
        this.medicalSpecialty = medicalSpecialty;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMedicalSpecialty() {
        return medicalSpecialty;
    }

    public void setMedicalSpecialty(String medicalSpecialty) {
        this.medicalSpecialty = medicalSpecialty;
    }
}
