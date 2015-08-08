package com.ati.damlabs.dam_lab_android_2.models;

import android.content.Context;

import com.ati.damlabs.dam_lab_android_2.libs.UsersLocalDB;

import java.io.Serializable;



/**
 * Created by Juan on 7/19/2015.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 2L;


    private String _email;


    public User(String _email){

        this._email = _email;

    }

    //GETTERS



    public String get_email() {
        return _email;
    }



    //SETTERS



    public void set_email(String email) {
        this._email = email;
    }



    //LOCAL DB OPERATIONS

    public void createUser(Context context){
        UsersLocalDB helper = new UsersLocalDB(context);

        helper.write();
        helper.createUser(this);
        helper.close();
    }


}
