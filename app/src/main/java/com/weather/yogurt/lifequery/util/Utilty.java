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

    public static boolean parseShares(Context context,JSONObject object) {

    }

    public static boolean parseExpress(Context context,JSONObject object) {

    }

    public static boolean parseTrainTickets(Context context,JSONObject object) {

    }

    public static boolean parseTrademark(Context context,JSONObject object) {

    }

    public static boolean parseExchangeRate(Context context,JSONObject object) {

    }

    public static boolean parseAppleIMEINumber(Context context,JSONObject object) {
    }

    public static boolean parseAttractionsTicketsPrice(Context context,JSONObject object) {
    }

    public static boolean parsePerpetualCalendar(Context context,JSONObject object) {

    }

    public static boolean parseAppleSerialNumber(Context context,JSONObject object) {
    }

    public static boolean parseBankCard(Context context,JSONObject object) {
    }

    public static boolean parseZipCode(Context context,JSONObject object) {
    }

    public static boolean parseIpAddress(Context context,JSONObject object) {
    }

    public static boolean parsePhoneNumberOwnership(Context context, JSONObject object) throws JSONException {
        String errNum=object.getString("errNum");
        if (errNum.equals("0")){
            if (object.getString("retMsg").equals("success")){
                JSONObject retData=object.getJSONObject("retData");
                SharedPreferences.Editor editor= PreferenceManager.getDefaultSharedPreferences(context).edit();
                StringBuffer stringBuffer=new StringBuffer();
                stringBuffer.append("   手机号码: ").append(retData.getString("phone")).append("\n")
                            .append("手机号前七位: ").append(retData.getString("prefix")).append("\n")
                            .append(  "手机运营商: ").append(retData.getString("supplier")).append("\n")
                            .append("  手机归属地: ").append(retData.getString("province")).append("·").append(retData.getString("city")).append("\n")
                            .append("    卡号类别: ").append(retData.getString("suit"));
                editor.putString("result",stringBuffer.toString());
                editor.commit();
                return true;
            }
        }else if (errNum.equals("-1")){
            return false;
        }
        return false;
    }
}
