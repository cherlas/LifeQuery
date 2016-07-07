package com.weather.yogurt.lifequery.util;

/**
 * Created by Yogurt on 16/7/7.
 */
public interface HttpCallbackListener {
    void onFinish(String result);
    void onError(Exception e);
}
