package in.akra_ubuntu.mcsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="MediCareIIIT";

    public static final String TABLE_NAME1 ="Pat_pro";
    public static final String TABLE_NAME2 ="Doc_pro";
    public static final String TABLE_NAME3 ="Treatment_Details";

    public static final String Pid ="Pid";
    public static final String Password ="Password";
    public static final String Name ="Name";
    public static final String Sex ="Sex";
    public static final String Age ="Age";
    public static final String DOB ="DOB";
    public static final String Mob_no ="Mob_no";
    public static final String Hostel ="Hostel";
    public static final String Roomno ="Roomno";
    public static final String Bloodgrp ="Bloodgrp";
    public static final String Weight ="Weight";

    public static final String colm_1 ="Did";
    public static final String colm_2 ="Password";
    public static final String colm_3 ="Name";
    public static final String colm_4 ="Specialization";
    public static final String colm_5 ="Shift_type";
    public static final String colm_6 ="Mob_no";
    public static final String colm_7 ="Sex";
    public static final String colm_8 ="Age";

    public static final String pid ="Pid";
    public static final String did ="Did";
    public static final String treat_date ="Treatment_date";
    public static final String slot ="Slot";
    public static final String diag ="Diagnosis";
    public static final String pres ="Prescription";
    public static final String remark ="Remarks";


    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " +TABLE_NAME1+ " (Pid varchar(15) primary key not null, Password varchar(15) not null, Name varchar(15) , Sex varchar(6), age int , dob date, mob_no varchar(15) not null, hostel varchar(15), roomno int, bloodgrp varchar(5), weight int ) ");
    db.execSQL(" create table "+ TABLE_NAME2+ " (Did varchar(15) primary key not null, Password varchar(15) not null, Name varchar(15) , Specialization varchar(15) , Shift_type varchar(15) , Mob_no varchar(15) , Sex varchar(15) , Age int ) ");
    db.execSQL(" create table "+ TABLE_NAME3 + " (Pid varchar(15) not null , Did varchar(15) not null , Treatment_date date not  null , Slot varchar(15) not null , Diagnosis varchar(100) not null , Prescription varchar(150) not null , Remarks varchar(150) default null, primary key(Pid,Did,Treatment_date,Slot) ) ");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists "+ TABLE_NAME1);
        db.execSQL("drop table if exists "+ TABLE_NAME2);
        db.execSQL("drop table if exists "+ TABLE_NAME3);
        onCreate(db);
    }

    public boolean insert_pat(String name,String pid, String sex,String weight, String age,String dob, String bloodgrp, String mob_no, String hostel, String roomno, String password ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentval = new ContentValues();
        contentval.put(Pid,pid);
        contentval.put(Password,password);
        contentval.put(Name,name);
        contentval.put(Sex,sex);
        contentval.put(Age,age);
        contentval.put(DOB,dob);
        contentval.put(Mob_no,mob_no);
        contentval.put(Hostel,hostel);
        contentval.put(Roomno,roomno);
        contentval.put(Bloodgrp,bloodgrp);
        contentval.put(Weight,weight);

        long result = db.insert(TABLE_NAME1,null,contentval);
        if(result==-1)
            return false;
        else
            return true;
    }


    public boolean insert_doc(String Name, String Did, String Specialization, String Shift_type, String Mob_no, String Sex, String Age, String Password ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentval2 = new ContentValues();
        contentval2.put(colm_1,Did);
        contentval2.put(colm_2,Password);
        contentval2.put(colm_3,Name);
        contentval2.put(colm_4,Specialization);
        contentval2.put(colm_5,Shift_type);
        contentval2.put(colm_6,Mob_no);
        contentval2.put(colm_7,Sex);
        contentval2.put(colm_8,Age);

        long result = db.insert(TABLE_NAME2,null,contentval2);
        if(result==-1)
            return false;
        else
            return true;
    }


    public boolean insert_treatment_details(String Did, String Pid, String Treatment_date, String Slot, String Diagnosis, String Prescription, String Remarks ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentval3 = new ContentValues();
        contentval3.put(pid,Pid);
        contentval3.put(did,Did);
        contentval3.put(treat_date,Treatment_date);
        contentval3.put(slot,Slot);
        contentval3.put(diag,Diagnosis);
        contentval3.put(pres,Prescription);
        contentval3.put(remark,Remarks);

        long result = db.insert(TABLE_NAME3,null,contentval3);
        if(result==-1)
            return false;
        else
            return true;
    }

    public Cursor getDocAttendedData(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
       Cursor result = db.rawQuery( "select * from " +TABLE_NAME3 + " where Did = " + "'" +username+ "'" ,null );
       //Cursor result = db.rawQuery( "select * from " +TABLE_NAME3 ,null );
            return  result;
    }

    public Cursor getPatData(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery( "select * from " +TABLE_NAME3+ " where Pid = " + "'" +username+ "'" ,null );
        //Cursor result = db.rawQuery( "select * from " +TABLE_NAME3 ,null );
        return  result;
    }

}



