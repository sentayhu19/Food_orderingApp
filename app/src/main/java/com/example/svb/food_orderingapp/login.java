package com.example.svb.food_orderingapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class login extends Activity {
Button buttn;
    EditText username, userpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        login();
    }
        public void login(){
        buttn = (Button)findViewById(R.id.btn_login);
            username=(EditText)findViewById(R.id.foodusername);
            userpass=(EditText)findViewById(R.id.foodpassword);
            buttn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (username.getText().toString().equals("a") && userpass.getText().toString().equals("a")) {
                        openActivity2();
                    } else {
                        Vibrator v1 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 400 milliseconds
                        v1.vibrate(400);
                        Toast.makeText(getApplicationContext(), "Wrong credential", Toast.LENGTH_LONG).show();
                    }

                }
            });

    }

    private void openActivity2() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void openActivity3() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
