package com.example.kanchankumari.contactinfo;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kanchan kumari on 6/6/2016.
 */
public class ListDataAdapter extends ArrayAdapter{

   private  final Activity context;
    //Context context;
    List list=new ArrayList();
    public ListDataAdapter(Context context, int resource, Activity context1) {
        super(context, resource);
        this.context = context1;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
      //  Log.e("list detail", list.+"");
    }
    public int getCount()
    {
        return list.size();
    }
    public Object getItem(int pos)
    {
        return list.get(pos);
    }
    static class LayoutHandler
    {
        TextView NAME, MOB, EMAIL;
    }
        public View getView(int pos,View cv,ViewGroup parent)
        {
            View row=cv;
            LayoutHandler lh;
            if(row==null)
            {     LayoutInflater lif=context.getLayoutInflater();
               // LayoutInflater lif=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //LayoutInflater lif=(LayoutInflater)this.get.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row=lif.inflate(R.layout.custom_lay,parent,false);
                lh=new LayoutHandler();
                lh.NAME=(TextView)row.findViewById(R.id.name);
                lh.MOB=(TextView)row.findViewById(R.id.mob);
                lh.EMAIL=(TextView)row.findViewById(R.id.email);
                row.setTag(lh);

            }
            else
            {
                lh=(LayoutHandler)row.getTag();
            }
            DataProvider dpl=(DataProvider)this.getItem(pos);
           // Log.e("Data provider", dpl.getName().toString() + "," + dpl.getMob().toString() + "," + dpl.getEmail().toString());
            lh.NAME.setText(dpl.getName().toString());
            lh.MOB.setText(dpl.getMob().toString());
            lh.EMAIL.setText(dpl.getEmail().toString());
            return row;
        };
    }

