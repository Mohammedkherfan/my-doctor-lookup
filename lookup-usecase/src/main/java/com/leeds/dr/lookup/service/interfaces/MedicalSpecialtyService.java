package com.leeds.dr.lookup.service.interfaces;

import com.leeds.dr.lookup.response.GetMedicalSpecialtyResponse;
import com.leeds.dr.lookup.response.ListMedicalSpecialtyResponse;

import java.util.Collection;

public interface MedicalSpecialtyService {

    Collection<ListMedicalSpecialtyResponse> listMedicalSpecialty();

    GetMedicalSpecialtyResponse getMedicalSpecialty(Long medicalSpecialtyCode);
}
