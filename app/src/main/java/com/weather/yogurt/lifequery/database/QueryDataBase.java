package com.weather.yogurt.lifequery.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
    private QueryDataBase(Context context){
        QueryDatabaseOpenHelper dbHelper=new QueryDatabaseOpenHelper(context,DB_NAME,null,VERSION);
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
            ContentValues values=new ContentValues();
            values.put("telephone_number",telephoneNumberOwnership.getTelephoneNumber());
            values.put("telephone_search_date",telephoneNumberOwnership.getSearchDate());
            db.insert("TelephoneHomeOwnership",null,values);
        }
    }
    //ip地址
    public void saveIpAddressInformation(IPAddress ipAddress){
        if (ipAddress!=null){
            ContentValues values=new ContentValues();
            values.put("ip_address",ipAddress.getIpAddress());
            values.put("ip_address_search_date",ipAddress.getSearchDate());
            db.insert("IpAddress",null,values);
        }
    }

    //AppleSerialNumber
    public void saveAppleSerialNumberInformation(AppleSerialNumber appleSerialNumber){
        if (appleSerialNumber!=null){
            ContentValues values=new ContentValues();
            values.put("apple_serial_number",appleSerialNumber.getAppleSerialNumber());
            values.put("apple_serial_number_search_date",appleSerialNumber.getSearchDate());
            db.insert("AppleSerialNumber",null,values);
        }
    }

    //Apple IMEI
    public void saveAppleIMEINumberInformation(AppleIMEINumber appleIMEINumber){
        if (appleIMEINumber!=null){
            ContentValues values=new ContentValues();
            values.put("apple_imei_number",appleIMEINumber.getAppleIMEINumber());
            values.put("apple_imei_number_search_date",appleIMEINumber.getSearchDate());
            db.insert("AppleIMEINumber",null,values);
        }
    }

    //Express
    public void saveExpressInformation(Express express){
        if (express!=null){
            ContentValues values=new ContentValues();
            values.put("express_number",express.getExpress());
            values.put("express_search_date",express.getSearchDate());
            db.insert("Express",null,values);
        }
    }

    //BankCard
    public void saveBankCardInformation(BankCard bankCard){
        if (bankCard!=null){
            ContentValues values=new ContentValues();
            values.put("bank_card_number",bankCard.getBankCardNumber());
            values.put("bank_card_search_date",bankCard.getSearchDate());
            db.insert("BankCard",null,values);
        }
    }

    //Shares
    public void saveSharesInformation(Shares shares){
        if (shares!=null){
            ContentValues values=new ContentValues();
            values.put("shares",shares.getShares());
            values.put("shares_search_date",shares.getSearchDate());
            db.insert("Shares",null,values);
        }
    }

    //TrainTickets
    public void saveTrainTicketsInformation(TrainTickets trainTickets){
        if (trainTickets!=null){
            ContentValues values=new ContentValues();
            values.put("train_tickets_number",trainTickets.getTrainTicketsNumber());
            values.put("train_tickets_search_date",trainTickets.getSearchDate());
            db.insert("TrainTickets",null,values);
        }
    }

    //ZipCode
    public void saveZipCodeInformation(ZipCode zipCode){
        if (zipCode!=null){
            ContentValues values=new ContentValues();
            values.put("zip_code_number",zipCode.getZipCodeNumber());
            values.put("zip_code_search_date",zipCode.getSearchDate());
            db.insert("ZipCode",null,values);
        }
    }

    //ExchangeRate
    public void saveExchangeRateInformation(ExchangeRate exchangeRate){
        if (exchangeRate!=null){
            ContentValues values=new ContentValues();
            values.put("exchange_rate",exchangeRate.getExchangeRate());
            values.put("exchange_rate_search_date",exchangeRate.getSearchDate());
            db.insert("ExchangeRate",null,values);
        }
    }

    //Trademark
    public void saveTrademarkInformation(Trademark trademark){
        if (trademark!=null){
            ContentValues values=new ContentValues();
            values.put("trademark",trademark.getTrademark());
            values.put("trademark_search_date",trademark.getSearchDate());
            db.insert("Trademark",null,values);
        }
    }

    //AttractionsTickets
    public void saveAttractionsTicketsInformation(AttractionsTicketsPrice attractionsTicketsPrice){
        if (attractionsTicketsPrice!=null){
            ContentValues values=new ContentValues();
            values.put("attractions_name",attractionsTicketsPrice.getAttractionName());
            values.put("attractions_search_date",attractionsTicketsPrice.getSearchDate());
            db.insert("AttractionsTickets",null,values);
        }
    }

    //PerpetualCalendar
    public void savePerpetualCalendarInformation(PerpetualCalendar perpetualCalendar){
        if (perpetualCalendar!=null){
            ContentValues values=new ContentValues();
            values.put("perpetual_calendar",perpetualCalendar.getPerpetualCalendar());
            values.put("perpetual_calendar_search_date",perpetualCalendar.getSearchDate());
            db.insert("PerpetualCalendar",null,values);
        }
    }


}
