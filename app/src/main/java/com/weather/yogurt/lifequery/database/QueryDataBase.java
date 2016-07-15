package com.weather.yogurt.lifequery.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.weather.yogurt.lifequery.model.AppleIMEINumber;
import com.weather.yogurt.lifequery.model.AppleSerialNumber;
import com.weather.yogurt.lifequery.model.AttractionsTicketsPrice;
import com.weather.yogurt.lifequery.model.BankCard;
import com.weather.yogurt.lifequery.model.ExchangeRate;
import com.weather.yogurt.lifequery.model.Express;
import com.weather.yogurt.lifequery.model.IPAddress;
import com.weather.yogurt.lifequery.model.PerpetualCalendar;
import com.weather.yogurt.lifequery.model.Shares;
import com.weather.yogurt.lifequery.model.TelephoneNumberOwnership;
import com.weather.yogurt.lifequery.model.Trademark;
import com.weather.yogurt.lifequery.model.TrainTickets;
import com.weather.yogurt.lifequery.model.ZipCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yogurt on 16/7/3.
 */
public class QueryDataBase {

    /*
        数据库名
     */
    public static final String DB_NAME="QueryDatabase";
    /*
        数据库版本
     */
    private static final int VERSION=1;

    private static QueryDataBase queryDB;
    private SQLiteDatabase db;
    private QueryDatabaseOpenHelper dbHelper;
    private QueryDataBase(Context context){
        dbHelper=new QueryDatabaseOpenHelper(context,DB_NAME,null,VERSION);
        db=dbHelper.getWritableDatabase();
    }

    //获取QueryDatabase实例
    public synchronized static QueryDataBase getInstance(Context context){
        if (queryDB==null){
            queryDB=new QueryDataBase(context);
        }
        return queryDB;
    }

    //存储电话归属地数据
    public void saveTelephoneNumberOwnershipInformation(TelephoneNumberOwnership telephoneNumberOwnership){
        if (telephoneNumberOwnership!=null){
            String number=telephoneNumberOwnership.getTelephoneNumber();
            Cursor cursor=query("TelephoneHomeOwnership","telephone_number",telephoneNumberOwnership.getTelephoneNumber());
            int s=cursor.getCount();
            Log.d("SSS",String.valueOf(s));
            if (cursor.getCount()!=0){
                ContentValues values=new ContentValues();
                values.put("telephone_search_date",telephoneNumberOwnership.getSearchDate());
                db.update("TelephoneHomeOwnership",values,"telephone_number=?",new String[]{telephoneNumberOwnership.getTelephoneNumber()});
            }else {
                ContentValues values=new ContentValues();
                values.put("telephone_number",telephoneNumberOwnership.getTelephoneNumber());
                values.put("telephone_search_date",telephoneNumberOwnership.getSearchDate());
                db.insert("TelephoneHomeOwnership",null,values);
            }

        }
    }

    private Cursor query(String tableName, String cloums,String searchNumber) {
        Cursor cursor=db.query(tableName,new String[]{cloums},cloums+"=?",new String[]{searchNumber},null,null,null);
        return cursor;
    }

    //ip地址
    public void saveIpAddressInformation(IPAddress ipAddress){
        if (ipAddress!=null){
            Cursor cursor=query("IpAddress","ip_address",ipAddress.getIpAddress());
            if (cursor.getCount()!=0){
                ContentValues values=new ContentValues();
                values.put("ip_address_search_date",ipAddress.getSearchDate());
                db.update("IpAddress",values,"ip_address=?",new String[]{ipAddress.getIpAddress()});
            }else {
                ContentValues values=new ContentValues();
                values.put("ip_address",ipAddress.getIpAddress());
                values.put("ip_address_search_date",ipAddress.getSearchDate());
                db.insert("IpAddress",null,values);
            }
        }
    }

    //AppleSerialNumber
    public void saveAppleSerialNumberInformation(AppleSerialNumber appleSerialNumber){
        if (appleSerialNumber!=null){
            Cursor cursor=query("AppleSerialNumber","apple_serial_number",appleSerialNumber.getAppleSerialNumber());
            if (cursor.getCount()!=0){
                ContentValues values=new ContentValues();
                values.put("apple_serial_number_search_date",appleSerialNumber.getSearchDate());
                db.update("AppleSerialNumber",values,"apple_serial_number=?",new String[]{appleSerialNumber.getAppleSerialNumber()});
            }else {
                ContentValues values=new ContentValues();
                values.put("apple_serial_number",appleSerialNumber.getAppleSerialNumber());
                values.put("apple_serial_number_search_date",appleSerialNumber.getSearchDate());
                db.insert("AppleSerialNumber",null,values);
            }
        }
    }

    //Apple IMEI
    public void saveAppleIMEINumberInformation(AppleIMEINumber appleIMEINumber){
        if (appleIMEINumber!=null){
            Cursor cursor=query("AppleIMEINumber","apple_imei_number",appleIMEINumber.getAppleIMEINumber());
            if (cursor.getCount()!=0){
                ContentValues values=new ContentValues();
                values.put("apple_imei_number_search_date",appleIMEINumber.getSearchDate());
                db.update("AppleIMEINumber",values,"apple_imei_number=?",new String[]{appleIMEINumber.getAppleIMEINumber()});
            }else {
                ContentValues values=new ContentValues();
                values.put("apple_imei_number",appleIMEINumber.getAppleIMEINumber());
                values.put("apple_imei_number_search_date",appleIMEINumber.getSearchDate());
                db.insert("AppleIMEINumber",null,values);
            }
        }
    }

    //Express
    public void saveExpressInformation(Express express){
        if (express!=null){
            Cursor cursor=query("Express","express_number",express.getExpress());
            if (cursor.getCount()!=0){
                ContentValues values=new ContentValues();
                values.put("express_search_date",express.getSearchDate());
                db.update("Express",values,"express_number=?",new String[]{express.getExpress()});
            }else {
                ContentValues values=new ContentValues();
                values.put("express_number",express.getExpress());
                values.put("express_search_date",express.getSearchDate());
                db.insert("Express",null,values);
            }
        }
    }

    //BankCard
    public void saveBankCardInformation(BankCard bankCard){
        if (bankCard!=null){
            Cursor cursor=query("BankCard","bank_card_number",bankCard.getBankCardNumber());
            if (cursor.getCount()!=0){
                ContentValues values=new ContentValues();
                values.put("bank_card_search_date",bankCard.getSearchDate());
                db.update("BankCard",values,"bank_card_number=?",new String[]{bankCard.getBankCardNumber()});
            }else {
                ContentValues values=new ContentValues();
                values.put("bank_card_number",bankCard.getBankCardNumber());
                values.put("bank_card_search_date",bankCard.getSearchDate());
                db.insert("BankCard",null,values);
            }
        }
    }

    //Shares
    public void saveSharesInformation(Shares shares){
        if (shares!=null){
            Cursor cursor=query("Shares","shares",shares.getShares());
            if (cursor.getCount()!=0){
                ContentValues values=new ContentValues();
                values.put("shares_search_date",shares.getSearchDate());
                db.update("Shares",values,"shares=?",new String[]{shares.getShares()});
            }else {
                ContentValues values=new ContentValues();
                values.put("shares",shares.getShares());
                values.put("shares_search_date",shares.getSearchDate());
                db.insert("Shares",null,values);
            }
        }
    }

    //TrainTickets
    public void saveTrainTicketsInformation(TrainTickets trainTickets){
        if (trainTickets!=null){
            Cursor cursor=query("TrainTickets","train_tickets_number",trainTickets.getTrainTicketsNumber());
            if (cursor.getCount()!=0){
                ContentValues values=new ContentValues();
                values.put("train_tickets_search_date",trainTickets.getSearchDate());
                db.update("TrainTickets",values,"train_tickets_number=?",new String[]{trainTickets.getTrainTicketsNumber()});
            }else {
                ContentValues values=new ContentValues();
                values.put("train_tickets_number",trainTickets.getTrainTicketsNumber());
                values.put("train_tickets_search_date",trainTickets.getSearchDate());
                db.insert("TrainTickets",null,values);
            }
        }
    }

    //ZipCode
    public void saveZipCodeInformation(ZipCode zipCode){
        if (zipCode!=null){
            Cursor cursor=query("ZipCode","zip_code_number",zipCode.getZipCodeNumber());
            if (cursor.getCount()!=0){
                ContentValues values=new ContentValues();
                values.put("zip_code_search_date",zipCode.getSearchDate());
                db.update("ZipCode",values,"zip_code_number=?",new String[]{zipCode.getZipCodeNumber()});
            }else {
                ContentValues values=new ContentValues();
                values.put("zip_code_number",zipCode.getZipCodeNumber());
                values.put("zip_code_search_date",zipCode.getSearchDate());
                db.insert("ZipCode",null,values);
            }
        }
    }

    //ExchangeRate
    public void saveExchangeRateInformation(ExchangeRate exchangeRate){
        if (exchangeRate!=null){
            Cursor cursor=query("ExchangeRate","exchange_rate",exchangeRate.getExchangeRate());
            if (cursor.getCount()!=0){
                ContentValues values=new ContentValues();
                values.put("exchange_rate_search_date",exchangeRate.getSearchDate());
                db.update("ExchangeRate",values,"exchange_rate=?",new String[]{exchangeRate.getExchangeRate()});
            }else {
                ContentValues values=new ContentValues();
                values.put("exchange_rate",exchangeRate.getExchangeRate());
                values.put("exchange_rate_search_date",exchangeRate.getSearchDate());
                db.insert("ExchangeRate",null,values);
            }
        }
    }

    //Trademark
    public void saveTrademarkInformation(Trademark trademark){
        if (trademark!=null){
            Cursor cursor=query("Trademark","trademark",trademark.getTrademark());
            if (cursor.getCount()!=0){
                ContentValues values=new ContentValues();
                values.put("trademark_search_date",trademark.getSearchDate());
                db.update("Trademark",values,"trademark=?",new String[]{trademark.getTrademark()});
            }else {
                ContentValues values=new ContentValues();
                values.put("trademark",trademark.getTrademark());
                values.put("trademark_search_date",trademark.getSearchDate());
                db.insert("Trademark",null,values);
            }
        }
    }

    //AttractionsTickets
    public void saveAttractionsTicketsInformation(AttractionsTicketsPrice attractionsTicketsPrice){
        if (attractionsTicketsPrice!=null){
            Cursor cursor=query("AttractionsTickets","attractions_name",attractionsTicketsPrice.getAttractionName());
            if (cursor.getCount()!=0){
                ContentValues values=new ContentValues();
                values.put("attractions_search_date",attractionsTicketsPrice.getSearchDate());
                db.update("AttractionsTickets",values,"attractions_name=?",new String[]{attractionsTicketsPrice.getAttractionName()});
            }else {
                ContentValues values=new ContentValues();
                values.put("attractions_name",attractionsTicketsPrice.getAttractionName());
                values.put("attractions_search_date",attractionsTicketsPrice.getSearchDate());
                db.insert("AttractionsTickets",null,values);
            }
        }
    }

    //PerpetualCalendar
    public void savePerpetualCalendarInformation(PerpetualCalendar perpetualCalendar){
        if (perpetualCalendar!=null){
            Cursor cursor=query("PerpetualCalendar","perpetual_calendar",perpetualCalendar.getPerpetualCalendar());
            if (cursor.getCount()!=0){
                ContentValues values=new ContentValues();
                values.put("perpetual_calendar_search_date",perpetualCalendar.getSearchDate());
                db.update("PerpetualCalendar",values,"perpetual_calendar=?",new String[]{perpetualCalendar.getPerpetualCalendar()});
            }else {
                ContentValues values=new ContentValues();
                values.put("perpetual_calendar",perpetualCalendar.getPerpetualCalendar());
                values.put("perpetual_calendar_search_date",perpetualCalendar.getSearchDate());
                db.insert("PerpetualCalendar",null,values);
            }
        }
    }

    public void deleteDatabaseInformation(String tableName,String keyWord,String key){
        db.delete(tableName,keyWord+"=?",new String[]{key});
    }

    //查询
    public List<String> queryInformationFromDatabase(String tableName, String keyWord, String order){
        Cursor cursor=db.query(tableName,new String[]{keyWord,order},null,null,null,null,order);
        List<String> res=new LinkedList<>();
        if (cursor.getCount()==0) return res;
        for (cursor.moveToLast();!cursor.isBeforeFirst();cursor.moveToPrevious()){
            String data=cursor.getString(cursor.getColumnIndex(order))+"      "+cursor.getString(cursor.getColumnIndex(keyWord));
            res.add(data);
        }
        cursor.close();
        return res;
    }
}
