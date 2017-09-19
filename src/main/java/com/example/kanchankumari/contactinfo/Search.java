package com.example.kanchankumari.contactinfo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Search extends AppCompatActivity {
    EditText D_m,D_em;
    EditText s_n;
    UserDbHelper udh;
    SQLiteDatabase sld;
    String search_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        D_m=(EditText)findViewById(R.id.ed2);
        D_em=(EditText)findViewById(R.id.ed3);
        s_n=(EditText)findViewById(R.id.ed1);
        D_m.setVisibility(View.INVISIBLE);
        D_em.setVisibility(View.INVISIBLE);

    }
    public void searchContact(View v)
    {
        search_name=s_n.getText().toString();
        udh=new UserDbHelper(getApplicationContext());
        sld=udh.getReadableDatabase();
        Cursor cu=udh.getContact(search_name,sld);
        if(cu.moveToFirst())
        {
            String MOB=cu.getString(0);
            String Email=cu.getString(1);
            Log.e("Search Data", "Mob " + MOB + " Email  " + Email);
            D_m.setText(MOB);
            D_em.setText(Email);
            D_m.setVisibility(View.VISIBLE);
            D_em.setVisibility(View.VISIBLE);
        }
    }
}
