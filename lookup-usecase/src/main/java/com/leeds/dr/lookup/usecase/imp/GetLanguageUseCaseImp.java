package com.leeds.dr.lookup.usecase.imp;

import com.leeds.dr.lookup.exception.LanguageException;
import com.leeds.dr.lookup.model.Language;
import com.leeds.dr.lookup.repository.LanguageRepository;
import com.leeds.dr.lookup.response.GetLanguageResponse;
import com.leeds.dr.lookup.usecase.interfaces.GetLanguageUseCase;

public class GetLanguageUseCaseImp implements GetLanguageUseCase {

    private LanguageRepository repository;

    public GetLanguageUseCaseImp(LanguageRepository repository) {
        this.repository = repository;
    }

    @Override
    public GetLanguageResponse getLanguage(Long languageCode) {
        try {
            Language language = repository.getLanguage(languageCode);
            return new GetLanguageResponse(language.getCode(), language.getLanguage());
        }catch (Exception ex) {
            throw new LanguageException(ex.getMessage());
        }
    }
}
