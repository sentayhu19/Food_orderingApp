package com.example.svb.food_orderingapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends Activity {
    TabHost host;
    //for location
    Button launch;
    Intent intent = null;
    Intent chooser = null;
    Button button1;
    Button ch1;
    Button c1,c2,c3,c4,c5;
    String choice = "";
    Double price = 0.00;
    int pizzzacount;
    int spacount;
    int roastccount;
    int fishsandcount;
    int shacount;
TextView textView;
TextView g;
    Button em;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//email
em=(Button)findViewById(R.id.em);
        em.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           openActivity2();
                                       }
                                   }

        );



        //
        //end here the animation +++++++++++++++++++
        ch1=(Button)findViewById(R.id.ch);
        c1 = (Button) findViewById(R.id.c1);
        c2 = (Button) findViewById(R.id.c2);
        c3 = (Button) findViewById(R.id.c3);
        c4 = (Button) findViewById(R.id.c4);
        c5 = (Button) findViewById(R.id.c5);

            host=(TabHost)
            findViewById(R.id.tabHost);
            host.setup();
            TabHost.TabSpec spec = host.newTabSpec("Tab One");
            button1=(Button)

            findViewById(R.id.callbtn);
            g=(TextView)

            findViewById(R.id.greet);

            button1.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick (View v){
                //String number = edittx.getText().toString();
                Intent cnint = new Intent(Intent.ACTION_DIAL);
                cnint.setData(Uri.parse("tel:" + 994));
                startActivity(cnint);

            }
            }

            );
            //cal
            Calendar c = Calendar.getInstance();
            int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
            if(timeOfDay>=0&&timeOfDay<12)

            {
                Toast.makeText(this, "Good Morning", Toast.LENGTH_SHORT).show();
                g.setText("Good Morining");
            }

            else if(timeOfDay>=12&&timeOfDay<16)

            {
                Toast.makeText(this, "Good Afternoon", Toast.LENGTH_SHORT).show();
                g.setText("Good Afternoon");
            }

            else if(timeOfDay>=16&&timeOfDay<21)

            {
                Toast.makeText(this, "Good Evening", Toast.LENGTH_SHORT).show();
                g.setText("Good Evening");
            }

            else if(timeOfDay>=21&&timeOfDay<24)

            {
                Toast.makeText(this, "Good Night", Toast.LENGTH_SHORT).show();
                g.setText("Good Night");
            }
            //cal
            spec.setContent(R.id.tab1);
            spec.setIndicator("Home");
            host.addTab(spec);


            spec=host.newTabSpec("Tab Two");
            spec.setContent(R.id.tab2);
            spec.setIndicator("Orders");
            host.addTab(spec);
            spec=host.newTabSpec("Tab Three");
            spec.setContent(R.id.tab3);
            spec.setIndicator("Location");
            host.addTab(spec);

            spec=host.newTabSpec("Tab Three");
            spec.setContent(R.id.tab4);
            spec.setIndicator("About");
            host.addTab(spec);
            //location
            launch=(Button)

            findViewById(R.id.launching);

            launch.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                intent = new Intent(intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:8.999438,38.807811"));
                chooser = Intent.createChooser(intent, "launch");
                startActivity(chooser);

            }
            }

            );
            //location

        }

    public void add_to_list(View view) {
        if (view == findViewById(R.id.c1)) {
pizzzacount+=1;
            if (pizzzacount>1)
            {

            }
            choice = choice+"(" +pizzzacount+ ") Pizza" + "\n";
            price = price + 250;
       } else if (view == findViewById(R.id.c2)) {
spacount+=1;
            choice = choice+"(" + spacount+") Spaghetti" + "\n";
            price = price + 100;
        } else if (view == findViewById(R.id.c3)) {
roastccount+=1;
            choice = choice+"("+roastccount + ") Roast Chicken" + "\n";
            price = price + 350;
        }
        else if (view == findViewById(R.id.c4)) {
fishsandcount+=1;
            choice = choice +"("+fishsandcount+") Fish Sandwitch" + "\n";
            price = price + 90;
        }
        else if (view == findViewById(R.id.c5)) {
            shacount+=1;
            choice = choice +"("+shacount+ ")Shwarma" + "\n";
            price = price + 150;
        }
    }
    public void placeOrder(View view){
        Intent i = new Intent(MainActivity.this, checkout.class);
        Bundle bundle = new Bundle();
        bundle.putString("choices",choice);
        bundle.putDouble("price",price);
        i.putExtras(bundle);
        startActivity(i);
    }
    public void openActivity2() {
        Intent intent = new Intent(this, web1.class);
        startActivity(intent);

    }
    }

