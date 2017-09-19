package com.example.kanchankumari.contactinfo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Delete extends AppCompatActivity {
    UserDbHelper udh;
    SQLiteDatabase sld,sqld;
    String search_name;
    EditText txt;
    TextView e,m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        txt=(EditText)findViewById(R.id.txt1);
        e=(TextView)findViewById(R.id.em);
        m=(TextView)findViewById(R.id.mo);
        m.setVisibility(View.INVISIBLE);
        e.setVisibility(View.INVISIBLE);

    }
    public void searchIt(View v)
    {
        search_name=txt.getText().toString();
        udh=new UserDbHelper(getApplicationContext());
        sld=udh.getReadableDatabase();
        Cursor cu=udh.getContact(search_name,sld);
        if(cu.moveToFirst())
        {
            String MOB=cu.getString(0);
            String Email=cu.getString(1);
            Log.e("Delete Data", "Mob " + MOB + " Email  " + Email);
            m.setText(MOB);
            e.setText(Email);
            m.setVisibility(View.VISIBLE);
            e.setVisibility(View.VISIBLE);
        }
    }
    public void deleteItem(View v)
    {
        search_name=txt.getText().toString();
        udh=new UserDbHelper(getApplicationContext());
        sqld=udh.getWritableDatabase();
        udh.deleteInformation(search_name,sqld);
        Toast.makeText(getBaseContext()," Contact Deleted " ,Toast.LENGTH_LONG).show();
    }
}
