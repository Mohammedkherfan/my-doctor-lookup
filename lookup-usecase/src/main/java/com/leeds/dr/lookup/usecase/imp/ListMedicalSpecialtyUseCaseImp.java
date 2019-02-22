package com.leeds.dr.lookup.usecase.imp;

import com.leeds.dr.lookup.repository.MedicalSpecialtyRepository;
import com.leeds.dr.lookup.response.ListMedicalSpecialtyResponse;
import com.leeds.dr.lookup.usecase.interfaces.ListMedicalSpecialtyUseCase;

import java.util.ArrayList;
import java.util.Collection;

public class ListMedicalSpecialtyUseCaseImp implements ListMedicalSpecialtyUseCase {

    private MedicalSpecialtyRepository repository;

    public ListMedicalSpecialtyUseCaseImp(MedicalSpecialtyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<ListMedicalSpecialtyResponse> listMedicalSpecialty() {
        Collection<ListMedicalSpecialtyResponse> collection = new ArrayList<>();
        repository.listMedicalSpecialty().forEach(e -> {
            collection.add(new ListMedicalSpecialtyResponse(e.getCode(), e.getMedicalSpecialty()));
        });
        return collection;
    }
}
