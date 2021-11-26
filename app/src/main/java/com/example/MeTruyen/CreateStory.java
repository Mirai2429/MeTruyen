package com.example.MeTruyen;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CreateStory extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 100;
    private Button TiepTheo;
    private EditText editTieuDeTruyen, editMoTaTruyen, editTheLoai, editTenPhanTruyen, editNoiDung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_story);
        TiepTheo = findViewById(R.id.TiepTheo);
        editTieuDeTruyen = findViewById(R.id.editTieuDeTruyen);
        editMoTaTruyen = findViewById(R.id.editMoTaTruyen);
        editTheLoai = findViewById(R.id.editTheLoai);
        editTenPhanTruyen = findViewById(R.id.editTenPhanTruyen);
        editNoiDung = findViewById(R.id.editNoiDung);

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

        TiepTheo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String DataTieuDeTruyen = editTieuDeTruyen.getText().toString().trim();
                String DataMoTaTruyen = editMoTaTruyen.getText().toString().trim();
                String DataTheLoai = editTheLoai.getText().toString().trim();
                String DataTenPhanTruyen = editTenPhanTruyen.getText().toString().trim();
                String DataNoiDung = editNoiDung.getText().toString().trim();
                openTiepTheo(DataTieuDeTruyen, DataMoTaTruyen, DataTheLoai, DataTenPhanTruyen, DataNoiDung);
            }
        });
    }

    private void openTiepTheo(String dataTieuDeTruyen, String dataMoTaTruyen, String dataTheLoai, String dataTenPhanTruyen, String dataNoiDung){
        Intent intent = new Intent(this, CreateStoryFinal.class);
        intent.putExtra("data_TieuDeTruyen", dataTieuDeTruyen);
        intent.putExtra("data_MoTaTruyen", dataMoTaTruyen);
        intent.putExtra("data_TheLoai", dataTheLoai);
        intent.putExtra("data_TenPhanTruyen", dataTenPhanTruyen);
        intent.putExtra("data_NoiDung", dataNoiDung);
        startActivityForResult(intent, MY_REQUEST_CODE);
    }
}