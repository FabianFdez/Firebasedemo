package com.abc.firebase_demo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference dbref = FirebaseDatabase.getInstance().getReference("user2");

        Map<String, String> values = new HashMap<>();
        values.put("name", "Pepito");
        values.put("id", "524567852");


        dbref.push();
        dbref.setValue(values, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(
                    @Nullable DatabaseError databaseError,
                    @NonNull DatabaseReference databaseReference) {
                if (databaseError == null) {
                    Log.i("Info", "Guardado con exitosamente");
                } else {
                    Log.i("Info", "Falló al guardarse los datos");
                }
            }
        });

    }
}
