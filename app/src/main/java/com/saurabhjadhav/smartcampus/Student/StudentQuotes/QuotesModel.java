package com.saurabhjadhav.smartcampus.Student.StudentQuotes;

public class QuotesModel {
    private String quotesUrl;

    public QuotesModel() {

    }

    public QuotesModel(String quotesUrl) {
        this.quotesUrl = quotesUrl;
    }

    public String getQuotesUrl() {
        return quotesUrl;
    }

    public void setQuotesUrl(String quotesUrl) {
        this.quotesUrl = quotesUrl;
    }
}
