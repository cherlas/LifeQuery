package com.weather.yogurt.lifequery.util;

import org.json.JSONException;

/**
 * Created by Yogurt on 16/7/7.
 */
public interface HttpCallbackListener {
    void onFinish(String result) throws JSONException;
    void onError(Exception e);
}
