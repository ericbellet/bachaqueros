package com.ati.damlabs.dam_lab_android_2.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.ati.damlabs.dam_lab_android_2.R;
import com.ati.damlabs.dam_lab_android_2.libs.ParserJson;
import com.ati.damlabs.dam_lab_android_2.libs.UsersRestClient;
import com.ati.damlabs.dam_lab_android_2.models.User;
import com.ati.damlabs.dam_lab_android_2.models.UserAdapter;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import java.util.ArrayList;


public class ListActivity extends ActionBarActivity {

    private ListView usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        usersList = (ListView) findViewById(R.id.userList);

        fillUsersList();
    }

    public void fillUsersList() {

        try {
            UsersRestClient.get("users", null, null, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                    ArrayList<User> users = ParserJson.parseUsers(new String(responseBody), ListActivity.this);

                    UserAdapter adapter = new UserAdapter(ListActivity.this, R.layout.component_user_list, users);

                    usersList.setAdapter(adapter);

                    Toast.makeText(ListActivity.this, "Cargados " + users.size() + " users", Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    Toast.makeText(ListActivity.this, "Error: " + statusCode, Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            Log.i("Error", "Algo salio mal" + e.getMessage());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
