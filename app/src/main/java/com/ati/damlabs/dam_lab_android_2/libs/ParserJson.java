package com.ati.damlabs.dam_lab_android_2.libs;

import android.content.Context;
import android.util.Log;

import com.ati.damlabs.dam_lab_android_2.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Juan on 7/19/2015.
 */
public class ParserJson {

    public static ArrayList<User> parseUsers(String bodyData, Context context) {
        ArrayList<User> users = new ArrayList<>();

        try {

            JSONArray jsonArray = new JSONArray(bodyData);

            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);

                User user = new User(json.getString("email"));
                user.createUser(context);
                users.add(user);

            }

        } catch (JSONException e) {
            users = null;
            Log.i("Error", "Algo salio mal =============> " + e.getMessage());
        }

        return users;
    }

}
