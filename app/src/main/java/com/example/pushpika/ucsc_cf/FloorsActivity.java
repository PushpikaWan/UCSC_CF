package com.example.pushpika.ucsc_cf;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class FloorsActivity extends AppCompatActivity {

    static final String[] FLOORS = new String[]{"W002","E02","Mini Audi"};
    static final String[] FLOORSDESC = new String[]{"at MainBuilding","at .......","there sdsdfsdfsd"};
    ListView simpleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floors);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Locations");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        simpleList = (ListView) findViewById(R.id.list);
        FloorListAdapter customAdapter = new FloorListAdapter(getApplicationContext(), FLOORS, FLOORSDESC);
        simpleList.setAdapter(customAdapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             //Log.d("Item clicked at","pos"+position);
                if (position == 0){
                    Intent intent = new Intent(FloorsActivity.this,Floor1Activity.class);
                    startActivity(intent);
                }
            }
        });
    }



}