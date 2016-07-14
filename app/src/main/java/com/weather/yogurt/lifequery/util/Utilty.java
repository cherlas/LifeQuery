package com.weather.yogurt.lifequery.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.weather.yogurt.lifequery.database.QueryDataBase;
import com.weather.yogurt.lifequery.model.BankCard;
import com.weather.yogurt.lifequery.model.IPAddress;
import com.weather.yogurt.lifequery.model.TelephoneNumberOwnership;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * Created by Yogurt on 16/7/7.
 */
public class Utilty {

    private static DateFormat format=DateFormat.getDateTimeInstance();

    public static boolean parseShares(Context context, JSONObject object, String inputContent, QueryDataBase dataBase) {
        return false;
    }

    public static boolean parseExpress(Context context, JSONObject object, String inputContent, QueryDataBase dataBase) {
        return false;
    }

    public static boolean parseTrainTickets(Context context, JSONObject object, String inputContent, QueryDataBase dataBase) {
        return false;
    }

    public static boolean parseTrademark(Context context, JSONObject object, String inputContent, QueryDataBase dataBase) {
        return false;
    }

    public static boolean parseExchangeRate(Context context, JSONObject object, String inputContent, QueryDataBase dataBase) {
        return false;
    }

    public static boolean parseAppleIMEINumber(Context context, JSONObject object, String inputContent, QueryDataBase dataBase) {
        return false;
    }

    public static boolean parseAttractionsTicketsPrice(Context context, JSONObject object, String inputContent, QueryDataBase dataBase) {
        return false;
    }

    public static boolean parsePerpetualCalendar(Context context, JSONObject object, String inputContent, QueryDataBase dataBase) {
        return false;
    }

    public static boolean parseAppleSerialNumber(Context context, JSONObject object, String inputContent, QueryDataBase dataBase) {
        return false;
    }

    public static boolean parseBankCard(Context context, JSONObject object, String inputContent, QueryDataBase dataBase) throws JSONException {
        String status=object.getString("status");
        if (status.equals("1")){
            BankCard bankCard=new BankCard();
            bankCard.setBankCardNumber(inputContent);

            Calendar calendar=Calendar.getInstance();

            String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
            if (month.length()<2) month="0"+month;

            String day=String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
            if (day.length()<2) day="0"+day;

            String hour=String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
            if (hour.length()<2) hour="0"+hour;

            String minute=String.valueOf(calendar.get(Calendar.MINUTE));
            if (minute.length()<2) minute="0"+minute;


            String time=month+"-"+day+" "+hour+":"+minute;

            bankCard.setSearchDate(time);
            dataBase.saveBankCardInformation(bankCard);
            JSONObject retData=object.getJSONObject("data");
            SharedPreferences.Editor editor= PreferenceManager.getDefaultSharedPreferences(context).edit();
            StringBuffer stringBuffer=new StringBuffer();
            stringBuffer.append("银行卡的类型: ").append(retData.getString("cardtype")).append("\r\n")
                    .append("银行卡的长度: ").append(retData.getString("cardlength")).append("\r\n")
                    .append("银行卡前缀: ").append(retData.getString("cardprefixnum")).append("\r\n")
                    .append("银行卡名称: ").append(retData.getString("cardname")).append("·").append("\r\n")
                    .append("归属银行: ").append(retData.getString("bankname")).append("\r\n")
                    .append("内部结算代码: ").append(retData.getString("banknum"));
            editor.putString("result",stringBuffer.toString());
            editor.commit();
            return true;

        }else if (status.equals("-1")){
            SharedPreferences.Editor editor= PreferenceManager.getDefaultSharedPreferences(context).edit();
            editor.putString("result","无效的卡号");
            editor.commit();
            return true;
        }
        return false;
    }

    public static boolean parseZipCode(Context context, JSONObject object, String inputContent, QueryDataBase dataBase) {
        return false;
    }

    public static boolean parseIpAddress(Context context, JSONObject object, String inputContent, QueryDataBase dataBase) throws JSONException {
        String errNum=object.getString("errNum");
        if (errNum.equals("0")){
            IPAddress ipAddress=new IPAddress();
            ipAddress.setIpAddress(inputContent);
            Calendar calendar=Calendar.getInstance();

            String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
            if (month.length()<2) month="0"+month;

            String day=String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
            if (day.length()<2) day="0"+day;

            String hour=String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
            if (hour.length()<2) hour="0"+hour;

            String minute=String.valueOf(calendar.get(Calendar.MINUTE));
            if (minute.length()<2) minute="0"+minute;

            String time=month+"-"+day+"  "+hour+":"+minute;

            ipAddress.setSearchDate(time);
            dataBase.saveIpAddressInformation(ipAddress);
            if (object.getString("retMsg").equals("success")){
                JSONObject retData=object.getJSONObject("retData");
                SharedPreferences.Editor editor= PreferenceManager.getDefaultSharedPreferences(context).edit();
                StringBuffer stringBuffer=new StringBuffer();
                stringBuffer.append("IP地址: ").append(retData.getString("ip")).append("\r\n")
                        .append("国家: ").append(retData.getString("country")).append("\r\n");
                String province=retData.getString("province");
                String city=retData.getString("city");
                String district=retData.getString("district");
                if (province.equals("none"))
                    stringBuffer.append("国外省份").append("\r\n");
                else stringBuffer.append(province).append("\r\n");

                if (city.equals("none"))
                    stringBuffer.append("国外城市").append("\r\n");
                else stringBuffer.append(city).append("\r\n");

                if (district.equals("none"))
                    stringBuffer.append("国外地区").append("\r\n");
                else stringBuffer.append(district).append("\r\n");

                stringBuffer.append("运营商: ").append(retData.getString("carrier"));
                editor.putString("result",stringBuffer.toString());
                editor.commit();
                return true;
            }
        }else if (errNum.equals("-1")){
            return false;
        }
        return false;
    }

    public static boolean parsePhoneNumberOwnership(Context context, JSONObject object, String inputContent,QueryDataBase dataBase) throws JSONException {
        String errNum=object.getString("errNum");
        if (errNum.equals("0")){
            TelephoneNumberOwnership ownership=new TelephoneNumberOwnership();
            ownership.setTelephoneNumber(inputContent);
            Calendar calendar=Calendar.getInstance();

            String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
            if (month.length()<2) month="0"+month;

            String day=String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
            if (day.length()<2) day="0"+day;

            String hour=String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
            if (hour.length()<2) hour="0"+hour;

            String minute=String.valueOf(calendar.get(Calendar.MINUTE));
            if (minute.length()<2) minute="0"+minute;


            String time=month+"-"+day+"  "+hour+":"+minute;
            ownership.setSearchDate(time);
            dataBase.saveTelephoneNumberOwnershipInformation(ownership);
            if (object.getString("retMsg").equals("success")){
                JSONObject retData=object.getJSONObject("retData");
                SharedPreferences.Editor editor= PreferenceManager.getDefaultSharedPreferences(context).edit();
                StringBuffer stringBuffer=new StringBuffer();
                stringBuffer.append("手机号码: ").append(retData.getString("phone")).append("\r\n")
                            .append("手机号前七位: ").append(retData.getString("prefix")).append("\r\n")
                            .append("手机运营商: ").append(retData.getString("supplier")).append("\r\n")
                            .append("手机归属地: ").append(retData.getString("province")).append("·").append(retData.getString("city")).append("\r\n")
                            .append("卡号类别: ").append(retData.getString("suit"));
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
