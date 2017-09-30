package com.example.pushpika.ucsc_cf;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.Map;

import static com.example.pushpika.ucsc_cf.MainActivity.myRef;

public class FloorCMapActivity extends AppCompatActivity {


    TextView n1,n2,n3,n4,n5,n6,n7,n8,n9,n10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_cmap);


        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("C");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        n1 = (TextView) findViewById(R.id.n_9);
        n2 = (TextView) findViewById(R.id.n_7);
        n3 = (TextView) findViewById(R.id.n_5);
        n4 = (TextView) findViewById(R.id.n_3);
        n5 = (TextView) findViewById(R.id.n_1);
        n6 = (TextView) findViewById(R.id.n_2);
        n7 = (TextView) findViewById(R.id.n_4);
        n8 = (TextView) findViewById(R.id.n_6);
        n9 = (TextView) findViewById(R.id.n_8);
        n10 = (TextView) findViewById(R.id.n_10);

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

    public void collectCompanyData(List<Object> stoles)  {


        //iterate through each user, ignoring their UID

        for (Object entry : stoles){

            //Get user map
            Map singleUser = (Map) entry;
            //Get phone field and append to list

            //singleUser.get("floor").toString().equals("W002"))

            //singleUser.get("isAvailable").toString()

            if(singleUser.get("stoleID").equals("C1")){
                n1.setText(singleUser.get("stoleID")+"\n"+singleUser.get("stoleName").toString());
                if(isAvailable(singleUser.get("isAvailable").toString())){
                    n1.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else{
                    n1.setBackgroundColor(Color.parseColor("#FF0000"));
                }
            }
            else if(singleUser.get("stoleID").equals("C2")){
                n2.setText(singleUser.get("stoleID")+"\n"+singleUser.get("stoleName").toString());
                if(isAvailable(singleUser.get("isAvailable").toString())){
                    n2.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else{
                    n2.setBackgroundColor(Color.parseColor("#FF0000"));
                }
            }
            else if(singleUser.get("stoleID").equals("C3")){
                n3.setText(singleUser.get("stoleID")+"\n"+singleUser.get("stoleName").toString());
                if(isAvailable(singleUser.get("isAvailable").toString())){
                    n3.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else{
                    n3.setBackgroundColor(Color.parseColor("#FF0000"));
                }
            }
            else if(singleUser.get("stoleID").equals("C4")){
                n4.setText(singleUser.get("stoleID")+"\n"+singleUser.get("stoleName").toString());
                if(isAvailable(singleUser.get("isAvailable").toString())){
                    n4.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else{
                    n4.setBackgroundColor(Color.parseColor("#FF0000"));
                }
            }
            else if(singleUser.get("stoleID").equals("C5")){
                n5.setText(singleUser.get("stoleID")+"\n"+singleUser.get("stoleName").toString());
                if(isAvailable(singleUser.get("isAvailable").toString())){
                    n5.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else{
                    n5.setBackgroundColor(Color.parseColor("#FF0000"));
                }
            }
            else if(singleUser.get("stoleID").equals("C6")){
                n6.setText(singleUser.get("stoleID")+"\n"+singleUser.get("stoleName").toString());
                if(isAvailable(singleUser.get("isAvailable").toString())){
                    n6.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else{
                    n6.setBackgroundColor(Color.parseColor("#FF0000"));
                }
            }
            else if(singleUser.get("stoleID").equals("C7")){
                n7.setText(singleUser.get("stoleID")+"\n"+singleUser.get("stoleName").toString());
                if(isAvailable(singleUser.get("isAvailable").toString())){
                    n7.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else{
                    n7.setBackgroundColor(Color.parseColor("#FF0000"));
                }
            }
            else if(singleUser.get("stoleID").equals("C8")){
                n8.setText(singleUser.get("stoleID")+"\n"+singleUser.get("stoleName").toString());
                if(isAvailable(singleUser.get("isAvailable").toString())){
                    n8.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else{
                    n8.setBackgroundColor(Color.parseColor("#FF0000"));
                }
            }
            else if(singleUser.get("stoleID").equals("C9")){
                n9.setText(singleUser.get("stoleID")+"\n"+singleUser.get("stoleName").toString());
                if(isAvailable(singleUser.get("isAvailable").toString())){
                    n9.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else{
                    n9.setBackgroundColor(Color.parseColor("#FF0000"));
                }
            }
            else if(singleUser.get("stoleID").equals("C10")){
                n10.setText(singleUser.get("stoleID")+"\n"+singleUser.get("stoleName").toString());
                if(isAvailable(singleUser.get("isAvailable").toString())){
                    n10.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else{
                    n10.setBackgroundColor(Color.parseColor("#FF0000"));
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
