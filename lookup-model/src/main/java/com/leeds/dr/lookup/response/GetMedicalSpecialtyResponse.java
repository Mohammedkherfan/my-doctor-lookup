package com.leeds.dr.lookup.response;

public class GetMedicalSpecialtyResponse {

    private Long code;
    private String medicalSpecialty;

    public GetMedicalSpecialtyResponse(Long code, String medicalSpecialty) {
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
