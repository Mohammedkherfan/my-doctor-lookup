package com.leeds.dr.lookup.usecase.interfaces;

import com.leeds.dr.lookup.response.GetMedicalSpecialtyResponse;

public interface GetMedicalSpecialtyUseCase {

    GetMedicalSpecialtyResponse getMedicalSpecialty(Long medicalSpecialtyCode);
}
