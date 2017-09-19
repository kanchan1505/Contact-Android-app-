package com.example.kanchankumari.contactinfo;

/**
 * Created by kanchan kumari on 6/6/2016.
 */

public class DataProvider {
    private String name,mob,email;
    public DataProvider(String name,String mob,String email)
    {
        this.name=name;
        this.mob=mob;
        this.email=email;

    }


    public String getMob() {
        return mob;
    }

    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }
}
