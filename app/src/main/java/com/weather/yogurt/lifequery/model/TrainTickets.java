package com.weather.yogurt.lifequery.model;

/**
 * Created by Yogurt on 16/7/3.
 */
public class TrainTickets {
    private String trainTicketsNumber;
    private String searchDate;

    public String getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(String searchDate) {
        this.searchDate = searchDate;
    }

    public String getTrainTicketsNumber() {
        return trainTicketsNumber;
    }

    public void setTrainTicketsNumber(String trainTicketsNumber) {
        this.trainTicketsNumber = trainTicketsNumber;
    }
}
