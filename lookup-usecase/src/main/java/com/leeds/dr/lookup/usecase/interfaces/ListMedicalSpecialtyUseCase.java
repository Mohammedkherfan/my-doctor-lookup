package com.leeds.dr.lookup.usecase.interfaces;

import com.leeds.dr.lookup.response.ListMedicalSpecialtyResponse;

import java.util.Collection;

public interface ListMedicalSpecialtyUseCase {

    Collection<ListMedicalSpecialtyResponse> listMedicalSpecialty();
}
