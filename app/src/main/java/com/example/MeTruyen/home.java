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
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home extends AppCompatActivity {
    private Button Search;
    private ImageButton Truyen1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Search = findViewById(R.id.Search);
        Truyen1 = findViewById(R.id.Truyen1);

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
                    //case R.id.light:

                    //Nut tai khoan
                    case R.id.acc:
                        startActivity(new Intent(getApplicationContext(),Account.class));
                        overridePendingTransition(0,0);
                        return true;

                    //Nut cai dat
                    //case R.id.set:
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
                openTruyen1();
            }
        });
    }
    // Mo tim kiem
    public void openSearch(){
        Intent intent = new Intent(this, timkiem.class);
        startActivity(intent);
    }
    // Doc truyen
    public void openTruyen1(){
        Intent intent = new Intent(this, ReadStory.class);
        startActivity(intent);
    }
}