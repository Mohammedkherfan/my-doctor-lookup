package com.leeds.dr.lookup.model;

public class MedicalSpecialty {

    private Long code;
    private String medicalSpecialty;

    public MedicalSpecialty(Long code, String medicalSpecialty) {
        this.code = code;
        this.medicalSpecialty = medicalSpecialty;
    }

    public Long getCode() {
        return code;
    }

    public String getMedicalSpecialty() {
        return medicalSpecialty;
    }

    public static class Builder {

        private Long code;
        private String medicalSpecialty;

        public Builder code(Long code) {
            this.code = code;
            return this;
        }

        public Builder medicalSpecialty(String medicalSpecialty) {
            this.medicalSpecialty = medicalSpecialty;
            return this;
        }

        public MedicalSpecialty build() {
            return new MedicalSpecialty(code, medicalSpecialty);
        }
    }
}
