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

public class FloorDMapActivity extends AppCompatActivity {


    TextView n1,n2,n3,n4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_dmap);


        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("D");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        n1 = (TextView) findViewById(R.id.n_2);
        n2 = (TextView) findViewById(R.id.n_1);
        n3 = (TextView) findViewById(R.id.n_3);
        n4 = (TextView) findViewById(R.id.n_4);


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

            if(singleUser.get("stoleID").equals("D1")){
                n1.setText(singleUser.get("stoleID")+"\n"+singleUser.get("stoleName").toString());
                if(isAvailable(singleUser.get("isAvailable").toString())){
                    n1.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else{
                    n1.setBackgroundColor(Color.parseColor("#FF0000"));
                }
            }
            else if(singleUser.get("stoleID").equals("D2")){
                n2.setText(singleUser.get("stoleID")+"\n"+singleUser.get("stoleName").toString());
                if(isAvailable(singleUser.get("isAvailable").toString())){
                    n2.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else{
                    n2.setBackgroundColor(Color.parseColor("#FF0000"));
                }
            }
            else if(singleUser.get("stoleID").equals("D3")){
                n3.setText(singleUser.get("stoleID")+"\n"+singleUser.get("stoleName").toString());
                if(isAvailable(singleUser.get("isAvailable").toString())){
                    n3.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else{
                    n3.setBackgroundColor(Color.parseColor("#FF0000"));
                }
            }
            else if(singleUser.get("stoleID").equals("D4")){
                n4.setText(singleUser.get("stoleID")+"\n"+singleUser.get("stoleName").toString());
                if(isAvailable(singleUser.get("isAvailable").toString())){
                    n4.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else{
                    n4.setBackgroundColor(Color.parseColor("#FF0000"));
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
