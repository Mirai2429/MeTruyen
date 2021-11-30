package com.example.MeTruyen;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 100;
    private Button Search;
    private ImageButton Truyen1, Truyen2, Truyen3, Truyen4, Truyen5, Truyen6, Truyen7, Truyen8, Truyen9;
    private TextView TenTruyen1, TenTruyen2, TenTruyen3, TenTruyen4, TenTruyen5, TenTruyen6, TenTruyen7, TenTruyen8, TenTruyen9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Search = findViewById(R.id.Search);
        Truyen1 = findViewById(R.id.Truyen1);
        Truyen2 = findViewById(R.id.Truyen2);
        Truyen3 = findViewById(R.id.Truyen3);
        Truyen4 = findViewById(R.id.Truyen4);
        Truyen5 = findViewById(R.id.Truyen5);
        Truyen6 = findViewById(R.id.Truyen6);
        Truyen7 = findViewById(R.id.Truyen7);
        Truyen8 = findViewById(R.id.Truyen8);
        Truyen9 = findViewById(R.id.Truyen9);

        TenTruyen1 = findViewById(R.id.TenTruyen1);
        TenTruyen2 = findViewById(R.id.TenTruyen2);
        TenTruyen3 = findViewById(R.id.TenTruyen3);
        TenTruyen4 = findViewById(R.id.TenTruyen4);
        TenTruyen5 = findViewById(R.id.TenTruyen5);
        TenTruyen6 = findViewById(R.id.TenTruyen6);
        TenTruyen7 = findViewById(R.id.TenTruyen7);
        TenTruyen8 = findViewById(R.id.TenTruyen8);
        TenTruyen9 = findViewById(R.id.TenTruyen9);

        BottomNavigationView bottomNavigationView = findViewById(R.id.Bottom_Navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    // Nut home
                    case R.id.home:
                        return true;

                    // Nut tao truyen moi
                    case R.id.pen:
                        startActivity(new Intent(getApplicationContext(),CreateStory.class));
                        overridePendingTransition(0,0);
                        return true;

                    //Nut chinh sua truyen
                    case R.id.light:
                        startActivity(new Intent(getApplicationContext(),MyStory.class));
                        overridePendingTransition(0,0);
                        return true;

                    //Nut tai khoan
                    case R.id.acc:
                        startActivity(new Intent(getApplicationContext(),Account.class));
                        overridePendingTransition(0,0);
                        return true;

                    //Nut cai dat
                    case R.id.set:
                        startActivity(new Intent(getApplicationContext(),Setting.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSearch();
            }
        });

        Truyen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenTruyen1 = TenTruyen1.getText().toString().trim();
                openTruyen1(tenTruyen1);
            }
        });

        Truyen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenTruyen2 = TenTruyen2.getText().toString().trim();
                openTruyen2(tenTruyen2);
            }
        });
    }


    public void openSearch(){
        Intent intent = new Intent(this, timkiem.class);
        startActivity(intent);
    }

    public void openTruyen1(String tenTruyen1){
        Intent intent = new Intent(this, ReadStory.class);
        intent.putExtra("data_TenTruyen1", tenTruyen1);
        startActivityForResult(intent, MY_REQUEST_CODE);
    }

    public void openTruyen2(String tenTruyen2){
        Intent intent = new Intent(this, ReadStory2.class);
        intent.putExtra("data_TenTruyen2", tenTruyen2);
        startActivityForResult(intent, MY_REQUEST_CODE);
    }
}