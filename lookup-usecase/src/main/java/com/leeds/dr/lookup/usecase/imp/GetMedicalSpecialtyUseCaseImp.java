package com.leeds.dr.lookup.usecase.imp;

import com.leeds.dr.lookup.exception.MedicalSpecialtyException;
import com.leeds.dr.lookup.model.MedicalSpecialty;
import com.leeds.dr.lookup.repository.MedicalSpecialtyRepository;
import com.leeds.dr.lookup.response.GetMedicalSpecialtyResponse;
import com.leeds.dr.lookup.usecase.interfaces.GetMedicalSpecialtyUseCase;

public class GetMedicalSpecialtyUseCaseImp implements GetMedicalSpecialtyUseCase {

    private MedicalSpecialtyRepository repository;

    public GetMedicalSpecialtyUseCaseImp(MedicalSpecialtyRepository repository) {
        this.repository = repository;
    }

    @Override
    public GetMedicalSpecialtyResponse getMedicalSpecialty(Long medicalSpecialtyCode) {
        try {
            MedicalSpecialty medicalSpecialty = repository.getMedicalSpecialty(medicalSpecialtyCode);
            return new GetMedicalSpecialtyResponse(medicalSpecialty.getCode(), medicalSpecialty.getMedicalSpecialty());
        }catch (Exception ex) {
            throw new MedicalSpecialtyException(ex.getMessage());
        }
    }
}
