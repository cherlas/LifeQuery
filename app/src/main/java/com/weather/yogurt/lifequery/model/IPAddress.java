package com.weather.yogurt.lifequery.model;

/**
 * Created by Yogurt on 16/7/3.
 */
public class IPAddress {
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(String searchDate) {
        this.searchDate = searchDate;
    }

    private String ipAddress;
    private String searchDate;
}
