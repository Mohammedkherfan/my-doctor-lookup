package com.leeds.dr.lookup.model;

import com.leeds.dr.lookup.exception.LanguageException;

import static java.util.Objects.isNull;

public class Language {

    private Long code;
    private String language;

    public Language(Long code, String language) {
        if (isNull(code) || code.equals(0L))
            throw new LanguageException("Language Code is Null or Zero");
        if (isNull(language) || language.trim().isEmpty())
            throw new LanguageException("Langauge Name is Null or Empty");
        this.code = code;
        this.language = language;
    }

    public Long getCode() {
        return code;
    }

    public String getLanguage() {
        return language;
    }

    public static class Builder {

        private Long code;
        private String language;

        public Builder code(Long code) {
            this.code = code;
            return this;
        }

        public Builder language(String language) {
            this.language = language;
            return this;
        }

        public Language build() {
            return new Language(code, language);
        }
    }
}
