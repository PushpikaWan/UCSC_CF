package com.example.pushpika.ucsc_cf;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.Map;

import static com.example.pushpika.ucsc_cf.MainActivity.myRef;

public class Floor1MapActivity extends AppCompatActivity {

    TextView n1,n2,n3,n4,n5,n6,n7,n8,n9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor1_map);


        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("W002");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        n1 = (TextView) findViewById(R.id.n_1);
        n2 = (TextView) findViewById(R.id.n_2);
        n3 = (TextView) findViewById(R.id.n_3);
        n4 = (TextView) findViewById(R.id.n_4);
        n5 = (TextView) findViewById(R.id.n_5);
        n6 = (TextView) findViewById(R.id.n_6);
        n7 = (TextView) findViewById(R.id.n_7);
        n8 = (TextView) findViewById(R.id.n_8);
        n9 = (TextView) findViewById(R.id.n_9);

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                updateMap();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.d("Main activity","child changed");
                updateMap();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void updateMap(){
        myRef.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Get map of users in datasnapshot
                        collectCompanyData((List<Object>) dataSnapshot.getValue());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });
    }

    public void collectCompanyData(List<Object> stoles)  {


        //iterate through each user, ignoring their UID

        for (Object entry : stoles){

            //Get user map
            Map singleUser = (Map) entry;
            //Get phone field and append to list

           //singleUser.get("floor").toString().equals("W002"))

                        //singleUser.get("isAvailable").toString()

            if((long)singleUser.get("stoleNumber")==1){
                n1.setText("1");
                if(isAvailable(singleUser.get("isAvailable").toString())){
                    n1.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else{
                    n1.setBackgroundColor(Color.parseColor("#FF0000"));
                }
            }
            else if((long)singleUser.get("stoleNumber")==2){
                n2.setText("2");
                if(isAvailable(singleUser.get("isAvailable").toString())){
                    n2.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else{
                    n2.setBackgroundColor(Color.parseColor("#FF0000"));
                }
            }
            else if((long)singleUser.get("stoleNumber")==3){
                n3.setText("3");
                if(isAvailable(singleUser.get("isAvailable").toString())){
                    n3.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else{
                    n3.setBackgroundColor(Color.parseColor("#FF0000"));
                }

            }
            else if((long)singleUser.get("stoleNumber")==4){
                n4.setText("4");
                if(isAvailable(singleUser.get("isAvailable").toString())){
                    n4.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else{
                    n4.setBackgroundColor(Color.parseColor("#FF0000"));
                }

            }
            else if((long)singleUser.get("stoleNumber")==5){
                n6.setText("5");
                if(isAvailable(singleUser.get("isAvailable").toString())){
                    n6.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else{
                    n6.setBackgroundColor(Color.parseColor("#FF0000"));
                }

            }
            else if((long)singleUser.get("stoleNumber")==6){
                n7.setText("6");
                if(isAvailable(singleUser.get("isAvailable").toString())){
                    n7.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else{
                    n7.setBackgroundColor(Color.parseColor("#FF0000"));
                }

            }
            else if((long)singleUser.get("stoleNumber")==7){
                n9.setText("7");
                if(isAvailable(singleUser.get("isAvailable").toString())){
                    n9.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else{
                    n9.setBackgroundColor(Color.parseColor("#FF0000"));
                }

            }

            else{

            }

        }
    }

    public boolean isAvailable(String state){
        if(state.equals("Available")){
            return true;
        }
        return false;
    }


}
