package com.example.MeTruyen;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CreateStoryFinal extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 100;
    private ImageButton Back;
    private TextView viewTieuDeTruyen, viewMoTaTruyen, viewTheLoai, viewTenPhanTruyen, viewNoiDung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_story_final);
        Back = findViewById(R.id.Back);
        viewTieuDeTruyen = findViewById(R.id.viewTieuDeTruyen);
        viewMoTaTruyen = findViewById(R.id.viewMoTaTruyen);
        viewTheLoai = findViewById(R.id.viewTheLoai);
        viewTenPhanTruyen = findViewById(R.id.viewTenPhanTruyen);
        viewNoiDung = findViewById(R.id.viewNoiDung);

        BottomNavigationView bottomNavigationView = findViewById(R.id.Bottom_Navigation);
        bottomNavigationView.setSelectedItemId(R.id.pen);
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
            public void onClick(View view) {
                String DataReceivedTieuDeTruyen = viewTieuDeTruyen.getText().toString().trim();
                String DataReceivedMoTaTruyen = viewMoTaTruyen.getText().toString().trim();
                String DataReceivedTheLoai = viewTheLoai.getText().toString().trim();
                String DataReceivedTenPhanTruyen = viewTenPhanTruyen.getText().toString().trim();
                String DataReceivedNoiDung = viewNoiDung.getText().toString().trim();
                openBack(DataReceivedTieuDeTruyen, DataReceivedMoTaTruyen, DataReceivedTheLoai, DataReceivedTenPhanTruyen, DataReceivedNoiDung);
            }
        });

        String DataReceivedTieuDeTruyen = getIntent().getStringExtra("data_TieuDeTruyen");
        viewTieuDeTruyen.setText(DataReceivedTieuDeTruyen);

        String DataReceivedMoTaTruyen = getIntent().getStringExtra("data_MoTaTruyen");
        viewMoTaTruyen.setText(DataReceivedMoTaTruyen);

        String DataReceivedTheLoai = getIntent().getStringExtra("data_TheLoai");
        viewTheLoai.setText(DataReceivedTheLoai);

        String DataReceivedTenPhanTruyen = getIntent().getStringExtra("data_TenPhanTruyen");
        viewTenPhanTruyen.setText(DataReceivedTenPhanTruyen);

        String DataReceivedNoiDung = getIntent().getStringExtra("data_NoiDung");
        viewNoiDung.setText(DataReceivedNoiDung);
    }

    public void openBack(String DataReceivedTieuDeTruyen,String DataReceivedMoTaTruyen, String DataReceivedTheLoai, String DataReceivedTenPhanTruyen, String DataReceivedNoiDung){
        Intent intent = new Intent(CreateStoryFinal.this, CreateStory.class);
        intent.putExtra("dataReceived_TieuDeTruyen", DataReceivedTieuDeTruyen);
        intent.putExtra("dataReceived_MoTaTruyen", DataReceivedMoTaTruyen);
        intent.putExtra("dataReceived_TheLoai", DataReceivedTheLoai);
        intent.putExtra("dataReceived_TenPhanTruyen", DataReceivedTenPhanTruyen);
        intent.putExtra("dataReceived_NoiDung", DataReceivedNoiDung);
        setResult(RESULT_OK, intent);
        finish();
    }
}