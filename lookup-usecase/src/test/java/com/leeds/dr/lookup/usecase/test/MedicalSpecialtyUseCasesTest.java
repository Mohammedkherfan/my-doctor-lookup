package com.leeds.dr.lookup.usecase.test;

import com.leeds.dr.lookup.exception.MedicalSpecialtyException;
import com.leeds.dr.lookup.repository.MedicalSpecialtyRepository;
import com.leeds.dr.lookup.response.GetMedicalSpecialtyResponse;
import com.leeds.dr.lookup.response.ListMedicalSpecialtyResponse;
import com.leeds.dr.lookup.service.imp.MedicalSpecialtyServiceImp;
import com.leeds.dr.lookup.service.interfaces.MedicalSpecialtyService;
import com.leeds.dr.lookup.usecase.repository.MedicalSpecialtyMockRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MedicalSpecialtyUseCasesTest {

    private MedicalSpecialtyService medicalSpecialtyService;
    private MedicalSpecialtyRepository medicalSpecialtyRepository;

    @Before
    public void setUp() throws Exception {
        medicalSpecialtyRepository = new MedicalSpecialtyMockRepository();
        medicalSpecialtyService = new MedicalSpecialtyServiceImp(medicalSpecialtyRepository);
    }

    @Test
    public void whenGetListOfMedicalSpecialty_AndMedicalSpecialtyRepositoryIsNotEmpty_ThenShouldReturnListOfMedicalSpecialty() {
        Collection<ListMedicalSpecialtyResponse> collection = medicalSpecialtyService.listMedicalSpecialty();
        assertTrue(!collection.isEmpty());
    }

    @Test(expected = MedicalSpecialtyException.class)
    public void whenGetMedicalSpecialty_AndMedicalSpecialtyCodeIsNull_ThenShouldReturnException() {
        medicalSpecialtyService.getMedicalSpecialty(null);
    }

    @Test(expected = MedicalSpecialtyException.class)
    public void whenGetMedicalSpecialty_AndMedicalSpecialtyNotExist_ThenShouldReturnException() {
        medicalSpecialtyService.getMedicalSpecialty(10001L);
    }

    @Test
    public void whenGetMedicalSpecialty_AndMedicalSpecialtyExistInRepository_ThenShouldPersistMedicalSpecialtyFromRepository() {
        GetMedicalSpecialtyResponse getMedicalSpecialtyResponse = medicalSpecialtyService.getMedicalSpecialty(101L);
        assertNotNull(getMedicalSpecialtyResponse);
    }
}
