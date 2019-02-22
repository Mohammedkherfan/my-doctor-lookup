package com.leeds.dr.lookup.service.interfaces;

import com.leeds.dr.lookup.request.AddLanguageRequest;
import com.leeds.dr.lookup.response.GetLanguageResponse;
import com.leeds.dr.lookup.response.ListLanguageResponse;

import java.util.Collection;

public interface LanguageService {

    Long addLanguage(AddLanguageRequest request);

    Collection<ListLanguageResponse> listLanguages();

    Boolean deleteLanguage(Long languageCode);

    GetLanguageResponse getLanguage(Long languageCode);
}
