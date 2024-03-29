package com.example.MeTruyen;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
public class QRCode extends AppCompatActivity {
    EditText EditText;
    Button Tao;
    ImageButton Back;
    ImageView QRCodeImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        EditText = findViewById(R.id.EditText);
        Tao = findViewById(R.id.Tao);
        Back = findViewById(R.id.Back);
        QRCodeImage = findViewById(R.id.QRCodeImage);
        Tao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {
                    BitMatrix bitMatrix = multiFormatWriter.encode(EditText.getText().toString(), BarcodeFormat.QR_CODE, 500, 500);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    QRCodeImage.setImageBitmap(bitmap);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QRCode.this, Account.class);
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.Bottom_Navigation);
        bottomNavigationView.setSelectedItemId(R.id.acc);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    // Nut home
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),home.class));
                        overridePendingTransition(0,0);
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
    }
}