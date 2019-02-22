package com.leeds.dr.lookup.usecase.repository;

import com.leeds.dr.lookup.exception.LanguageException;
import com.leeds.dr.lookup.model.Language;
import com.leeds.dr.lookup.repository.LanguageRepository;

import java.util.ArrayList;
import java.util.Collection;

public class LanguageMockRepository implements LanguageRepository {

    private Collection<Language> collection;

    public LanguageMockRepository() {
        this.collection = new ArrayList<>();
    }

    @Override
    public Long addLanguage(Language language) {
        collection.forEach(e -> {
            if (language.getCode().equals(e.getCode()))
                throw new LanguageException("Language Code Already Exist");
        });
        collection.add(language);
        return language.getCode();
    }

    @Override
    public Collection<Language> listLanguages() {
        return collection;
    }

    @Override
    public Boolean deleteLanguage(Long languageCode) {
        Boolean check = collection.stream().filter(e -> e.getCode().equals(languageCode)).findFirst().isPresent();
        if (check)
            collection.remove(languageCode);
        else
            throw new LanguageException("Language Not Found");
        return Boolean.TRUE;
    }

    @Override
    public Language getLanguage(Long languageCode) {
        Boolean check = collection.stream().filter(e -> e.getCode().equals(languageCode)).findFirst().isPresent();
        if (check)
            return collection.stream().filter(e -> e.getCode().equals(languageCode)).findFirst().get();
        else
            throw new LanguageException("Language Not Found");
    }
}
