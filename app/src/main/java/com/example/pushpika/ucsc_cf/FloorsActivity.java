package com.example.pushpika.ucsc_cf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class FloorsActivity extends AppCompatActivity {

    static final String[] FLOORS = new String[]{"A","B","C","D"};
    static final String[] FLOORSDESC = new String[]{"Ground Floor","Ground Floor","Second Floor","Second Floor"};
    ListView simpleList;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


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
                    Intent intent = new Intent(FloorsActivity.this,FloorAActivity.class);
                    startActivity(intent);
                }
                else if (position == 1){
                    Intent intent = new Intent(FloorsActivity.this,FloorBActivity.class);
                    startActivity(intent);
                }
                else if (position == 2){
                    Intent intent = new Intent(FloorsActivity.this,FloorCActivity.class);
                    startActivity(intent);
                }
                else if (position == 3){
                    Intent intent = new Intent(FloorsActivity.this,FloorDActivity.class);
                    startActivity(intent);
                }
            }
        });
    }



}