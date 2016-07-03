package com.weather.yogurt.lifequery.model;

/**
 * Created by Yogurt on 16/7/3.
 */
public class BankCard {
    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(String searchDate) {
        this.searchDate = searchDate;
    }

    private String bankCardNumber;
    private String searchDate;

}
