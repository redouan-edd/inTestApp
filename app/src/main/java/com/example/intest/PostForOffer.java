package com.example.intest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PostForOffer extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String offerid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_for_offer);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("OfferIdNumber");

        sharedPreferences=getSharedPreferences("codes",MODE_PRIVATE);
        editor=sharedPreferences.edit();

        getOfferId();
        offerid=sharedPreferences.getString("idOffer",null);
        int offeridint=Integer.valueOf(offerid);
        offeridint++;offerid=String.valueOf(offeridint);myRef.setValue(offerid);



    }
    public void getOfferId()
    {

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                editor.remove("idOffer").commit();
                editor.putString("idOffer",value);
                editor.apply();

            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });

    }
}
