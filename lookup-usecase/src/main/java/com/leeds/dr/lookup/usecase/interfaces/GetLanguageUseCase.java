package com.leeds.dr.lookup.usecase.interfaces;

import com.leeds.dr.lookup.response.GetLanguageResponse;

public interface GetLanguageUseCase {

    GetLanguageResponse getLanguage(Long languageCode);
}
