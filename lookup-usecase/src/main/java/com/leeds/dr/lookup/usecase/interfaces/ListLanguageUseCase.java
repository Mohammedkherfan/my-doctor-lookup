package com.leeds.dr.lookup.usecase.interfaces;

import com.leeds.dr.lookup.response.ListLanguageResponse;

import java.util.Collection;

public interface ListLanguageUseCase {

    Collection<ListLanguageResponse> listLanguages();
}
