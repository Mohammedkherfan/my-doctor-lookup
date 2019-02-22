package com.leeds.dr.lookup.usecase.imp;

import com.leeds.dr.lookup.exception.LanguageException;
import com.leeds.dr.lookup.repository.LanguageRepository;
import com.leeds.dr.lookup.usecase.interfaces.DeleteLanguageUseCase;

public class DeleteLanguageUseCaseImp implements DeleteLanguageUseCase {

    private LanguageRepository repository;

    public DeleteLanguageUseCaseImp(LanguageRepository repository) {
        this.repository = repository;
    }

    @Override
    public Boolean deleteLanguage(Long languageCode) {
        try {
            return repository.deleteLanguage(languageCode);
        }catch (Exception ex) {
            throw new LanguageException(ex.getMessage());
        }
    }
}
