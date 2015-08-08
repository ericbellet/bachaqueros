package com.ati.damlabs.dam_lab_android_2.models;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ati.damlabs.dam_lab_android_2.R;

import java.util.ArrayList;

/**
 * Created by eric on 31/07/15.
 */


/**
 * Created by Juan on 7/19/2015.
 */
public class UserAdapter extends ArrayAdapter<User> {

    Activity _context;
    ArrayList<User> _users;

    public UserAdapter(Activity context, int resourse, ArrayList<User> users) {
        super(context, resourse, users);

        _context = context;
        _users = users;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = _context.getLayoutInflater();
        View item = inflater.inflate(R.layout.component_user_list, null);

        TextView email = (TextView)item.findViewById(R.id.P_email);


        email.setText(_users.get(position).get_email());



        return item;
    }
}
