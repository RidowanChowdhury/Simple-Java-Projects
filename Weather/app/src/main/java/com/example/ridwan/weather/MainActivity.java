package com.example.ridwan.weather;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.label;

public class MainActivity extends AppCompatActivity {
   /* static TextView tempView;
    static TextView nameView;
    static TextView humView;
    static TextView setView;
    static TextView riseView;*/
   private RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        /*tempView = (TextView)findViewById(R.id.temp);
        nameView = (TextView)findViewById(R.id.name);
        humView = (TextView)findViewById(R.id.humidity);
        setView = (TextView)findViewById(R.id.ss);
        riseView = (TextView)findViewById(R.id.sr);
        Typeface tf = Typeface.createFromAsset(getAssets(),"spaceage.ttf");
        //Typeface tf = Typeface.createFromFile("main/assets/package/spaceage.ttf");
        tempView.setTypeface(tf);
        nameView.setTypeface(tf);
        humView.setTypeface(tf);
        setView.setTypeface(tf);
        riseView.setTypeface(tf);*/
        DownloadTask task = new DownloadTask();
        task.execute("http://api.openweathermap.org/data/2.5/weather?q=dhaka&appid=5e21a2507bf0685b4d99fd22896e182d");

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

       /* DownloadTask task = new DownloadTask();
        task.execute("http://api.openweathermap.org/data/2.5/weather?q=dhaka&appid=5e21a2507bf0685b4d99fd22896e182d");*/


      /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    protected void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });
    }

    private ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();

            DataObject obj0 = new DataObject("City",
                    DownloadTask.placename);
            results.add(0, obj0);
        DataObject obj1 = new DataObject("Temparature",
                DownloadTask.tr);
        results.add(1, obj1);
        DataObject obj2 = new DataObject("Humidity",
                DownloadTask.hum);
        results.add(2, obj2);
        DataObject obj3 = new DataObject("Sunset",
                DownloadTask.setTime);
        results.add(3, obj3);
        DataObject obj4 = new DataObject("Sunrise",
                DownloadTask.riseTime);
        results.add(4, obj4);


        return results;
    }
}
