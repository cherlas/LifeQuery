package com.weather.yogurt.lifequery.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Yogurt on 16/7/7.
 */
public class Utilty {

    public static boolean parseShares(JSONObject object) {

    }

    public static boolean parseExpress(JSONObject object) {

    }

    public static boolean parseTrainTickets(JSONObject object) {

    }

    public static boolean parseTrademark(JSONObject object) {

    }

    public static boolean parseExchangeRate(JSONObject object) {

    }

    public static boolean parseAppleIMEINumber(JSONObject object) {
    }

    public static boolean parseAttractionsTicketsPrice(JSONObject object) {
    }

    public static boolean parsePerpetualCalendar(JSONObject object) {

    }

    public static boolean parseAppleSerialNumber(JSONObject object) {
    }

    public static boolean parseBankCard(JSONObject object) {
    }

    public static boolean parseZipCode(JSONObject object) {
    }

    public static boolean parseIpAddress(JSONObject object) {
    }

    public static boolean parsePhoneNumberOwnership(Context context, JSONObject object) throws JSONException {
        String errNum=object.getString("errNum");
        if (errNum.equals("0")){
            if (object.getString("retMsg").equals("success")){
                JSONObject retData=object.getJSONObject("retData");
                SharedPreferences.Editor editor= PreferenceManager.getDefaultSharedPreferences(context).edit();
                editor.putString("phone",retData.getString("phone"));
                editor.putString("prefix",retData.getString("prefix"));
                editor.putString("supplier",retData.getString("supplier"));
                editor.putString("province",retData.getString("province"));
                editor.putString("city",retData.getString("city"));
                editor.putString("suit",retData.getString("suit"));
                editor.commit();
                return true;
            }
        }else if (errNum.equals("-1")){
            return false;
        }
        return false;
    }
}
