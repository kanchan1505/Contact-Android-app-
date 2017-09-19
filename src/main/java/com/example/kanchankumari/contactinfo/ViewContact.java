package com.example.kanchankumari.contactinfo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class ViewContact extends AppCompatActivity {
    ListView l;
    SQLiteDatabase sld;
    UserDbHelper udh;
    Cursor cu;
    ListDataAdapter lda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact);
        l=(ListView)findViewById(R.id.listView);
        udh=new UserDbHelper(getApplicationContext());
        sld=udh.getReadableDatabase();
        cu=udh.getInformation(sld);
      //  lda=new ListDataAdapter(getApplicationContext(),R.layout.custom_lay);
        lda=new ListDataAdapter(getApplicationContext(),R.layout.custom_lay,this);
        if(cu.moveToFirst())
        {
            do{
                String name,mob,email;
                name=cu.getString(0);
                mob=cu.getString(1);
                email=cu.getString(2);

                Log.e("View all data",name+" , "+mob+" , "+email);
                DataProvider dlp=new DataProvider(name,mob,email);
                lda.add(dlp);
            }while(cu.moveToNext());

        }
        l.setAdapter(lda);
        
    }


}
