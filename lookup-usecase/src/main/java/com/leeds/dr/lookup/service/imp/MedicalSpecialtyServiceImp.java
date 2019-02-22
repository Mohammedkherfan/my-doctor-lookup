package com.leeds.dr.lookup.service.imp;

import com.leeds.dr.lookup.exception.MedicalSpecialtyException;
import com.leeds.dr.lookup.repository.MedicalSpecialtyRepository;
import com.leeds.dr.lookup.response.GetMedicalSpecialtyResponse;
import com.leeds.dr.lookup.response.ListMedicalSpecialtyResponse;
import com.leeds.dr.lookup.service.interfaces.MedicalSpecialtyService;
import com.leeds.dr.lookup.usecase.imp.GetMedicalSpecialtyUseCaseImp;
import com.leeds.dr.lookup.usecase.imp.ListMedicalSpecialtyUseCaseImp;
import com.leeds.dr.lookup.usecase.interfaces.GetMedicalSpecialtyUseCase;
import com.leeds.dr.lookup.usecase.interfaces.ListMedicalSpecialtyUseCase;

import java.util.Collection;

import static java.util.Objects.isNull;

public class MedicalSpecialtyServiceImp implements MedicalSpecialtyService {

    private ListMedicalSpecialtyUseCase listMedicalSpecialtyUseCase;
    private GetMedicalSpecialtyUseCase getMedicalSpecialtyUseCase;

    public MedicalSpecialtyServiceImp(MedicalSpecialtyRepository repository) {
        this.listMedicalSpecialtyUseCase = new ListMedicalSpecialtyUseCaseImp(repository);
        this.getMedicalSpecialtyUseCase = new GetMedicalSpecialtyUseCaseImp(repository);
    }

    @Override
    public Collection<ListMedicalSpecialtyResponse> listMedicalSpecialty() {
        return listMedicalSpecialtyUseCase.listMedicalSpecialty();
    }

    @Override
    public GetMedicalSpecialtyResponse getMedicalSpecialty(Long medicalSpecialtyCode) {
        if (isNull(medicalSpecialtyCode)) throw new MedicalSpecialtyException("Invalid Medical Specialty Code");
        return getMedicalSpecialtyUseCase.getMedicalSpecialty(medicalSpecialtyCode);
    }
}
