package com.example.kanchankumari.contactinfo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    EditText sn,mb,el;
    String sname;
    SQLiteDatabase sld,sqld;
    UserDbHelper udh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        sn=(EditText)findViewById(R.id.tx1);
        mb=(EditText)findViewById(R.id.tx2);
        el=(EditText)findViewById(R.id.tx3);
        mb.setVisibility(View.INVISIBLE);
        el.setVisibility(View.INVISIBLE);

    }
    public void searchUp(View v)
    {
        sname=sn.getText().toString();
        udh=new UserDbHelper(getApplicationContext());
        sld=udh.getReadableDatabase();
        Cursor cu=udh.getContact(sname,sld);
        if(cu.moveToFirst())
        {
            String MOB=cu.getString(0);
            String Email=cu.getString(1);
            Log.e("Update Data", "Mob " + MOB + " Email  " + Email);
            mb.setText(MOB);
            el.setText(Email);
            mb.setVisibility(View.VISIBLE);
            el.setVisibility(View.VISIBLE);
        }
    }
    public void updateItem(View v)
    {
        udh=new UserDbHelper(getApplicationContext());
        sqld=udh.getWritableDatabase();
        String name,email,mobile;
        name=sn.getText().toString();
        mobile=mb.getText().toString();
        email=el.getText().toString();
        int count=udh.updateInformation(sname,name,mobile,email,sqld);
        Toast.makeText(getApplicationContext(),count+" Contact Updated ",Toast.LENGTH_LONG).show();
        finish();
    }
}
