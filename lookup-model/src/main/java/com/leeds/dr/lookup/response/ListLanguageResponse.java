package com.leeds.dr.lookup.response;

public class ListLanguageResponse {

    private Long code;
    private String language;

    public ListLanguageResponse(Long code, String language) {
        this.code = code;
        this.language = language;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
