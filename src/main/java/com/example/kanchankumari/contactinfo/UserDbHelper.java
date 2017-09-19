package com.example.kanchankumari.contactinfo;

/**
 * Created by kanchan kumari on 6/6/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="USERIN.DB";
    private static final int DATABASE_VERSION=1;
    private static final String CREATE_QUERY="create table "+UserContact.NewUserInfo.TABLE_NAME+"("+UserContact.NewUserInfo.USER_NAME+" Text,"+
            UserContact.NewUserInfo.USER_MOB+" Text,"+UserContact.NewUserInfo.USER_EMAIL+" Text);";
    public UserDbHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("Database Operations","Database Created Operation ");
    }
    public void addInformation(String name,String mob,String email,SQLiteDatabase db){
        ContentValues cv=new ContentValues();
        cv.put(UserContact.NewUserInfo.USER_NAME,name);
        cv.put(UserContact.NewUserInfo.USER_MOB,mob);
        cv.put(UserContact.NewUserInfo.USER_EMAIL,email);
        db.insert(UserContact.NewUserInfo.TABLE_NAME, null, cv);
        Log.e("Database operation","One Row Inserted");

    }
    public Cursor getInformation(SQLiteDatabase db)
    {   Cursor cu;
        String[] proj={UserContact.NewUserInfo.USER_NAME,UserContact.NewUserInfo.USER_MOB,UserContact.NewUserInfo.USER_EMAIL};
        cu=db.query(UserContact.NewUserInfo.TABLE_NAME,proj,null,null,null,null,null);
        Log.e("Database operation",cu.toString());
        return cu;
    }
    public Cursor getContact(String username,SQLiteDatabase sqd)
    {
        String[] proj={UserContact.NewUserInfo.USER_MOB,UserContact.NewUserInfo.USER_EMAIL};
        String selection=UserContact.NewUserInfo.USER_NAME+" Like ? ";
        String[] sel_args={username};
        Cursor cu=sqd.query(UserContact.NewUserInfo.TABLE_NAME,proj,selection,sel_args,null,null,null);
        return cu;
    }
    public void deleteInformation(String Username,SQLiteDatabase sqd)
    {
        String selection=UserContact.NewUserInfo.USER_NAME+" Like ? ";
        String[] selection_args={Username};
        sqd.delete(UserContact.NewUserInfo.TABLE_NAME,selection,selection_args);
    }

    public int updateInformation(String old_name,String new_name,String new_mobile,String new_email,SQLiteDatabase sqld)
    {
        ContentValues cv=new ContentValues();
        cv.put(UserContact.NewUserInfo.USER_NAME,new_name);
        cv.put(UserContact.NewUserInfo.USER_MOB,new_mobile);
        cv.put(UserContact.NewUserInfo.USER_EMAIL,new_email);
        String selection=UserContact.NewUserInfo.USER_NAME+" Like ? ";
        String[] select_args={old_name};
        int count=sqld.update(UserContact.NewUserInfo.TABLE_NAME,cv,selection,select_args);
        return count;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.e("Table created","Table is created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      //  db.execSQL(CREATE_QUERY);
       // Log.e("Table created","Table is created");
    }
}
