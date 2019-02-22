package com.leeds.dr.lookup.usecase.repository;

import com.leeds.dr.lookup.exception.MedicalSpecialtyException;
import com.leeds.dr.lookup.model.MedicalSpecialty;
import com.leeds.dr.lookup.repository.MedicalSpecialtyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class MedicalSpecialtyMockRepository implements MedicalSpecialtyRepository {

    private Collection<MedicalSpecialty> collection;

    public MedicalSpecialtyMockRepository() {
        this.collection = new ArrayList<>();

        collection.add(new MedicalSpecialty.Builder().code(101L).medicalSpecialty("Internal medicine").build());
        collection.add(new MedicalSpecialty.Builder().code(102L).medicalSpecialty("Radiology").build());
        collection.add(new MedicalSpecialty.Builder().code(103L).medicalSpecialty("Dermatology").build());
    }

    @Override
    public Collection<MedicalSpecialty> listMedicalSpecialty() {
        return this.collection;
    }

    @Override
    public MedicalSpecialty getMedicalSpecialty(Long medicalSpecialtyCode) {
        Boolean check = collection.stream().filter(e -> e.getCode().equals(medicalSpecialtyCode)).findFirst().isPresent();
        if (check)
            return collection.stream().filter(e -> e.getCode().equals(medicalSpecialtyCode)).findFirst().get();
        else
            throw new MedicalSpecialtyException("Medical Specialty Not Found");
    }
}
