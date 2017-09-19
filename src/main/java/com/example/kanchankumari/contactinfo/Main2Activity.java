package com.example.kanchankumari.contactinfo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText e1,e2,e3;
    SQLiteDatabase sld;
    Context con=this;
    UserDbHelper udh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
    }

    public void save(View v)
    {
      String name=e1.getText().toString();
        String mob=e2.getText().toString();
        String email=e3.getText().toString();
        udh=new UserDbHelper(con);
        sld=udh.getWritableDatabase();
        udh.addInformation(name,mob,email,sld);
        Toast.makeText(getBaseContext(),"Contact Inserted",Toast.LENGTH_LONG).show();
        udh.close();
    }
}
