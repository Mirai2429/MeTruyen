package com.example.MeTruyen;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AddTruyen extends AppCompatActivity {
    private ImageButton Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_truyen);
        Back = findViewById(R.id.Back);
        BottomNavigationView bottomNavigationView = findViewById(R.id.Bottom_Navigation);
        bottomNavigationView.setSelectedItemId(R.id.light);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),home.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.pen:
                        startActivity(new Intent(getApplicationContext(),CreateStory.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.light:
                        startActivity(new Intent(getApplicationContext(),MyStory.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.acc:
                        startActivity(new Intent(getApplicationContext(),Account.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.set:
                        startActivity(new Intent(getApplicationContext(),Setting.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddTruyen.this, MyStory.class);
                startActivity(intent);
            }
        });
    }
}