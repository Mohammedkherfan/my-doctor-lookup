package com.leeds.dr.lookup.usecase.imp;

import com.leeds.dr.lookup.repository.LanguageRepository;
import com.leeds.dr.lookup.response.ListLanguageResponse;
import com.leeds.dr.lookup.usecase.interfaces.ListLanguageUseCase;

import java.util.ArrayList;
import java.util.Collection;

public class ListLanguageUseCaseImp implements ListLanguageUseCase {

    private LanguageRepository repository;

    public ListLanguageUseCaseImp(LanguageRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<ListLanguageResponse> listLanguages() {
        Collection<ListLanguageResponse> collection = new ArrayList<>();
        repository.listLanguages().forEach(e -> {
            collection.add(new ListLanguageResponse(e.getCode(), e.getLanguage()));
        });
        return collection;
    }
}
