package com.leeds.dr.lookup.repository;

import com.leeds.dr.lookup.model.MedicalSpecialty;

import java.util.Collection;

public interface MedicalSpecialtyRepository {

    Collection<MedicalSpecialty> listMedicalSpecialty();

    MedicalSpecialty getMedicalSpecialty(Long medicalSpecialtyCode);
}
