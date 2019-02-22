package com.leeds.dr.lookup.repository;

import com.leeds.dr.lookup.model.Language;

import java.util.Collection;

public interface LanguageRepository {

    Long addLanguage(Language language);

    Collection<Language> listLanguages();

    Boolean deleteLanguage(Long languageCode);

    Language getLanguage(Long languageCode);
}
