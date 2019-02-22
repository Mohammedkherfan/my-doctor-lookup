package com.leeds.dr.lookup.usecase.test;

import com.leeds.dr.lookup.exception.LanguageException;
import com.leeds.dr.lookup.repository.LanguageRepository;
import com.leeds.dr.lookup.request.AddLanguageRequest;
import com.leeds.dr.lookup.response.GetLanguageResponse;
import com.leeds.dr.lookup.response.ListLanguageResponse;
import com.leeds.dr.lookup.service.imp.LanguageServiceImp;
import com.leeds.dr.lookup.service.interfaces.LanguageService;
import com.leeds.dr.lookup.usecase.repository.LanguageMockRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LanguageUseCasesTest {

    private LanguageService languageService;
    private LanguageRepository languageRepository;
    private AddLanguageRequest addLanguageRequest;

    @Before
    public void setUp() throws Exception {
        languageRepository = new LanguageMockRepository();
        languageService = new LanguageServiceImp(languageRepository);
        addLanguageRequest = new AddLanguageRequest(103L, "French");
    }

    @Test(expected = LanguageException.class)
    public void whenAddNewLanguage_AndLanguageRequestIsNull_ThenShouldReturnException() {
        languageService.addLanguage(null);
    }

    @Test(expected = LanguageException.class)
    public void whenAddNewLanguage_AndLanguageCodeIsNull_ThenShouldReturnException() {
        addLanguageRequest.setCode(null);
        languageService.addLanguage(addLanguageRequest);
    }

    @Test(expected = LanguageException.class)
    public void whenAddNewLanguage_AndLanguageCodeEqualZero_ThenShouldReturnException() {
        addLanguageRequest.setCode(0L);
        languageService.addLanguage(addLanguageRequest);
    }

    @Test(expected = LanguageException.class)
    public void whenAddNewLanguage_AndLanguageNameIsNull_ThenShouldReturnException() {
        addLanguageRequest.setLanguage(null);
        languageService.addLanguage(addLanguageRequest);
    }

    @Test(expected = LanguageException.class)
    public void whenAddNewLanguage_AndLanguageNameIsEmpty_ThenShouldReturnException() {
        addLanguageRequest.setLanguage("");
        languageService.addLanguage(addLanguageRequest);
    }

    @Test(expected = LanguageException.class)
    public void whenAddNewLanguage_AndLanguageNameIsSpace_ThenShouldReturnException() {
        addLanguageRequest.setLanguage("   ");
        languageService.addLanguage(addLanguageRequest);
    }

    @Test(expected = LanguageException.class)
    public void whenAddNewLanguage_AndLanguageCodeAlreadyExist_ThenShouldReturnException() {
        Long languageCode = languageService.addLanguage(addLanguageRequest);
        addLanguageRequest.setCode(languageCode);
        languageService.addLanguage(addLanguageRequest);
    }

    @Test
    public void whenAddNewLanguage_AndLanguageIsValidToAdd_ThenShouldPersistToRepository() {
        Long languageCode = languageService.addLanguage(addLanguageRequest);
        assertNotNull(languageCode);
    }

    @Test
    public void whenGetListOfLanguages_AndLangaugeRepositoryIsEmpty_ThenShouldReturnEmptyListOfLanguages() {
        Collection<ListLanguageResponse> collection = languageService.listLanguages();
        assertTrue(collection.isEmpty());
    }

    @Test
    public void whenGetListOfLanguages_AndLangaugeRepositoryIsNotEmpty_ThenShouldReturnListOfLanguages() {
        languageService.addLanguage(addLanguageRequest);
        Collection<ListLanguageResponse> collection = languageService.listLanguages();
        assertTrue(!collection.isEmpty());
    }

    @Test(expected = LanguageException.class)
    public void whenDeleteLanguage_AndLangaugeCodeIsNull_ThenShouldReturnException() {
        languageService.deleteLanguage(null);
    }

    @Test(expected = LanguageException.class)
    public void whenDeleteLanguage_AndLangaugeNotExist_ThenShouldReturnException() {
        languageService.deleteLanguage(101L);
    }

    @Test
    public void whenDeleteLanguage_AndLangaugeExistInRepository_ThenShouldDeleteLanguage() {
        Long languageCode = languageService.addLanguage(addLanguageRequest);
        Boolean result = languageService.deleteLanguage(languageCode);
        assertTrue(result);
    }

    @Test(expected = LanguageException.class)
    public void whenGetLanguage_AndLanguageCodeIsNull_ThenShouldReturnException() {
        languageService.getLanguage(null);
    }

    @Test(expected = LanguageException.class)
    public void whenGetLanguage_AndLanguageNotExist_ThenShouldReturnException() {
        languageService.getLanguage(101L);
    }

    @Test
    public void whenGetLanguage_AndLanguageExistInRepository_ThenShouldPersistLanguageFromRepository() {
        Long languageCode = languageService.addLanguage(addLanguageRequest);
        GetLanguageResponse getLanguageResponse = languageService.getLanguage(languageCode);
        assertNotNull(getLanguageResponse);
    }
}
