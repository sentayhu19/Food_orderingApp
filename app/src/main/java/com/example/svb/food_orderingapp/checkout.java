package com.example.svb.food_orderingapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class checkout extends Activity {
    TextView listView, priceView;
    String list_choice;
    Button ch;
    Double price;
    EditText em;
    EditText name;
    TextView card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        listView =(TextView)findViewById(R.id.listView);
        priceView=(TextView)findViewById(R.id.priceView);
        ch=(Button)findViewById(R.id.ch);
        em=(EditText)findViewById(R.id.email1);
        name=(EditText)findViewById(R.id.name1);
        card=(TextView)findViewById(R.id.card1);
        //
        Bundle bundle = getIntent().getExtras();
        //
        ch.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      if (em.getText().toString().equals("") || name.getText().toString().equals("") || card.getText().toString().equals("") || isEmailValid(em.getText().toString())) {

                                          showmessage ();
                                      }
                                      else {

                                          openActivity2();
                                      }

                                  }
                              }

        );


       try{
            list_choice = bundle.getString("choices");
            price = bundle.getDouble("price");
            listView.setText(list_choice);
            priceView.setText(price.toString() + "  Ethiopian birr \n");

        }catch (Exception e)
        {
            System.out.println("++++++++++  Error ++++++++++++ " + e.getMessage());
          list_choice=e.getMessage();
            listView.setText(list_choice);

        }
    }
    public void openActivity2() {
        Toast.makeText(this, "Your orders will be right away!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void showmessage ()
    {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 400 milliseconds
        v.vibrate(400);
        Toast.makeText(this, "Empty, Please enter valid inputs!", Toast.LENGTH_SHORT).show();
    }
    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}