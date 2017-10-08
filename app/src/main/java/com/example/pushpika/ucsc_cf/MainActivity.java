package com.example.pushpika.ucsc_cf;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardLoadingAdapter adapter;
    private List<CompanyCard> albumList;
    public static DatabaseReference myRef,userRef;
    public static String userEmailAddress;
    public static boolean isAdmin = false;
    public boolean isCompanySpecific = false;
    public String enableCompanies ="ALL";
    private FloatingActionButton floatingActionButton;

    // Creating Progress dialog.
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        albumList = new ArrayList<>();
        adapter = new CardLoadingAdapter(this, albumList);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.float_button);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        //firebase init
        myRef = FirebaseDatabase.getInstance().getReference().child("Stoles");
        userRef = FirebaseDatabase.getInstance().getReference().child("Users");

        setEmailAddress();

    }

    private void setEmailAddress(){

        SharedPreferences settings = getSharedPreferences("prefs", 0);
        boolean firstRun = settings.getBoolean("firstRun", true);

        //final Intent intent = new Intent(this, LoginActivity.class);

        userEmailAddress = settings.getString("Email_Address","no");

        if (firstRun) {
            // here run your first-time instructions, for example :
            Intent intent = new Intent(this,EmailAddressEntryActivity.class);
            startActivity(intent);
            finish();

        }
        else{
            setAdminList();
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapter);


            myRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    Log.d("Main activity","child changed");
                    prepareAlbums();
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

            prepareAlbums();
        }

    }
    private void prepareAlbums() {

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

        int[] covers = new int[]{
                R.drawable.default_comp,
                R.drawable.default_comp,
                R.drawable.default_comp
        };


        //iterate through each user, ignoring their UID
        int i = 0; //hard coded value not good
        if(isCompanySpecific){
           companySpecificLoader(stoles);
        }
        else{
            for (Object entry : stoles){

                //Get user map
                Map singleUser = (Map) entry;
                //Get phone field and append to list

                CompanyCard a = new CompanyCard(singleUser.get("stoleName").toString(),
                        singleUser.get("isAvailable").toString(),
                        singleUser.get("authEmails").toString(),
                        (long)singleUser.get("stoleNumber"),
                        singleUser.get("stoleID").toString(),
                        i,
                        singleUser.get("floor").toString(),
                        covers[0]);

                if (MainActivity.userEmailAddress.equals(singleUser.get("authEmails").toString())){
                    isCompanySpecific = true;
                    enableCompanies =singleUser.get("stoleName").toString();
                }
                if( albumList.size() > i && albumList.get(i).getStoleID().equals(singleUser.get("stoleID").toString())){
                    albumList.get(i).setIsAvailable( singleUser.get("isAvailable").toString());
                }
                else{
                    albumList.add(a);
                }

                i++;
            }
            if(isCompanySpecific){
                albumList.clear();
                companySpecificLoader(stoles);
            }
            else{
                floatingActionButton.setVisibility(View.VISIBLE);
                progressDialog.dismiss();
            }
        }

        adapter.notifyDataSetChanged();
    }

    private void companySpecificLoader(List <Object> stoles){

        int[] covers = new int[]{
                R.drawable.default_comp,
                R.drawable.default_comp,
                R.drawable.default_comp
        };
        int i = 0;
        for (Object entry : stoles){

            //Get user map
            Map singleUser = (Map) entry;
            //Get phone field and append to list

            CompanyCard a = new CompanyCard(singleUser.get("stoleName").toString(),
                    singleUser.get("isAvailable").toString(),
                    singleUser.get("authEmails").toString(),
                    (long)singleUser.get("stoleNumber"),
                    singleUser.get("stoleID").toString(),
                    i,
                    singleUser.get("floor").toString(),
                    covers[0]);

            if (singleUser.get("stoleName").toString().equals(enableCompanies)){

                if( albumList.size() > i && albumList.get(i).getStoleID().equals(singleUser.get("stoleID").toString())){
                    albumList.get(i).setIsAvailable( singleUser.get("isAvailable").toString());
                }
                else{
                    albumList.add(a);
                }

                i++;
            }
        }
        progressDialog.dismiss();
    }

    private void setAdminList(){

        userRef.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Get map of users in datasnapshot
                        List<Object> users= (List<Object>) dataSnapshot.getValue();

                        for (Object entry : users){

                            //Get user map
                            Map singleUser = (Map) entry;
                            //Get phone field and append to list

                            if (singleUser.get("email").toString().equals(userEmailAddress)){
                                isAdmin = true;
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });

    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public void goFloors(View view){
        Intent intent = new Intent(MainActivity.this,FloorsActivity.class);
        startActivity(intent);
    }

}
