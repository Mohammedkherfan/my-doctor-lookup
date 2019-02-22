package com.leeds.dr.lookup.service.imp;

import com.leeds.dr.lookup.exception.LanguageException;
import com.leeds.dr.lookup.repository.LanguageRepository;
import com.leeds.dr.lookup.request.AddLanguageRequest;
import com.leeds.dr.lookup.response.GetLanguageResponse;
import com.leeds.dr.lookup.response.ListLanguageResponse;
import com.leeds.dr.lookup.service.interfaces.LanguageService;
import com.leeds.dr.lookup.usecase.imp.AddLanguageUseCaseImp;
import com.leeds.dr.lookup.usecase.imp.DeleteLanguageUseCaseImp;
import com.leeds.dr.lookup.usecase.imp.GetLanguageUseCaseImp;
import com.leeds.dr.lookup.usecase.imp.ListLanguageUseCaseImp;
import com.leeds.dr.lookup.usecase.interfaces.AddLanguageUseCase;
import com.leeds.dr.lookup.usecase.interfaces.DeleteLanguageUseCase;
import com.leeds.dr.lookup.usecase.interfaces.GetLanguageUseCase;
import com.leeds.dr.lookup.usecase.interfaces.ListLanguageUseCase;

import java.util.Collection;

import static java.util.Objects.isNull;

public class LanguageServiceImp implements LanguageService {

    private AddLanguageUseCase addLanguageUseCase;
    private ListLanguageUseCase listLanguageUseCase;
    private DeleteLanguageUseCase deleteLanguageUseCase;
    private GetLanguageUseCase getLanguageUseCase;

    public LanguageServiceImp(LanguageRepository repository) {
        this.addLanguageUseCase = new AddLanguageUseCaseImp(repository);
        this.listLanguageUseCase = new ListLanguageUseCaseImp(repository);
        this.deleteLanguageUseCase = new DeleteLanguageUseCaseImp(repository);
        this.getLanguageUseCase = new GetLanguageUseCaseImp(repository);
    }

    @Override
    public Long addLanguage(AddLanguageRequest request) {
        if (isNull(request)) throw new LanguageException("Invalid Add Language Request");
        return addLanguageUseCase.addLanguage(request);
    }

    @Override
    public Collection<ListLanguageResponse> listLanguages() {
        return listLanguageUseCase.listLanguages();
    }

    @Override
    public Boolean deleteLanguage(Long languageCode) {
        if (isNull(languageCode)) throw new LanguageException("Invalid Language Code");
        return deleteLanguageUseCase.deleteLanguage(languageCode);
    }

    @Override
    public GetLanguageResponse getLanguage(Long languageCode) {
        if (isNull(languageCode)) throw new LanguageException("Invalid Language Code");
        return getLanguageUseCase.getLanguage(languageCode);
    }
}
