package com.leeds.dr.lookup.usecase.imp;

import com.leeds.dr.lookup.exception.LanguageException;
import com.leeds.dr.lookup.model.Language;
import com.leeds.dr.lookup.repository.LanguageRepository;
import com.leeds.dr.lookup.request.AddLanguageRequest;
import com.leeds.dr.lookup.usecase.interfaces.AddLanguageUseCase;

public class AddLanguageUseCaseImp implements AddLanguageUseCase {

    private LanguageRepository repository;

    public AddLanguageUseCaseImp(LanguageRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long addLanguage(AddLanguageRequest request) {
        try {
            Language language = new Language.Builder()
                    .code(request.getCode())
                    .language(request.getLanguage())
                    .build();
            return repository.addLanguage(language);
        }catch (Exception ex) {
            throw new LanguageException(ex.getMessage());
        }
    }
}
