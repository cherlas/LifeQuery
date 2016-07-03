package com.weather.yogurt.lifequery.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Yogurt on 16/7/3.
 */
public class QueryDatabaseOpenHelper extends SQLiteOpenHelper{

    /*
       电话归属地建表语句
     */
    public static final String CREATE_TELEPHONE_HOME_OWNERSHIP="create table TelephoneHomeOwnership("
            +"id integer primary key autoincrement,"
            +"telephone_number text"
            +"telephone_search_date text)";
    /*
      IP地址建表语句
    */
    public static final String CREATE_IP_ADDRESS="create table IpAddress("
            +"id integer primary key autoincrement,"
            +"ip_address text"
            +"ip_address_search_date text)";
    /*
      Apple序列号建表语句
    */
    public static final String CREATE_APPLE_SERIAL_NUMBER="create table AppleSerialNumber("
            +"id integer primary key autoincrement,"
            +"apple_serial_number text"
            +"apple_serial_number_search_date text)";
    /*
      AppleIMEI建表语句
    */
    public static final String CREATE_APPLE_IMEI_NUMBER="create table AppleIMEINumber("
            +"id integer primary key autoincrement,"
            +"apple_imei_number text"
            +"apple_imei_number_search_date text)";
    /*
      快递建表语句
    */
    public static final String CREATE_EXPRESS="create table Express("
            +"id integer primary key autoincrement,"
            +"express_number text"
            +"express_search_date text)";
    /*
      银行卡建表语句
    */
    public static final String CREATE_BANK_CARD="create table BankCard("
            +"id integer primary key autoincrement,"
            +"bank_card_number text"
            +"bank_card_search_date text)";
    /*
      股票建表语句
    */
    public static final String CREATE_SHARES="create table Shares("
            +"id integer primary key autoincrement,"
            +"shares text"
            +"shares_search_date text)";
    /*
      火车票建表语句
    */
    public static final String CREATE_TRAIN_TICKETS="create table TrainTickets("
            +"id integer primary key autoincrement,"
            +"train_tickets_number text"
            +"train_tickets_search_date text)";
    /*
      邮编建表语句
    */
    public static final String CREATE_ZIP_CODE="create table ZipCode("
            +"id integer primary key autoincrement,"
            +"zip_code_number text"
            +"zip_code_search_date text)";
    /*
      汇率建表语句
    */
    public static final String CREATE_EXCHANGE_RATE="create table ExchangeRate("
            +"id integer primary key autoincrement,"
            +"exchange_rate text"
            +"exchange_rate_search_date text)";
    /*
      商标建表语句
    */
    public static final String CREATE_TRADEMARK="create table Trademark("
            +"id integer primary key autoincrement,"
            +"trademark text"
            +"trademark_search_date text)";
    /*
      景点名票建表语句 去哪儿网
    */
    public static final String CREATE_ATTRACTIONSTICKETS_PRICE="create table AttractionsTickets("
            +"id integer primary key autoincrement,"
            +"attractions_name text"
            +"attractions_search_date text)";
    /*
      万年历建表语句
    */
    public static final String CREATE_PERPETUAL_CALENDAR="create table PerpetualCalendar\n("
            +"id integer primary key autoincrement,"
            +"perpetual_calendar text"
            +"perpetual_calendar_search_date text)";


    public QueryDatabaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TELEPHONE_HOME_OWNERSHIP);
        db.execSQL(CREATE_IP_ADDRESS);
        db.execSQL(CREATE_APPLE_SERIAL_NUMBER);
        db.execSQL(CREATE_APPLE_IMEI_NUMBER);
        db.execSQL(CREATE_EXPRESS);
        db.execSQL(CREATE_BANK_CARD);
        db.execSQL(CREATE_SHARES);
        db.execSQL(CREATE_TRAIN_TICKETS);
        db.execSQL(CREATE_ZIP_CODE);
        db.execSQL(CREATE_EXCHANGE_RATE);
        db.execSQL(CREATE_TRADEMARK);
        db.execSQL(CREATE_ATTRACTIONSTICKETS_PRICE);
        db.execSQL(CREATE_PERPETUAL_CALENDAR);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
