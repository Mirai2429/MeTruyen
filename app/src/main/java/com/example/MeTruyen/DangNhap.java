package com.example.MeTruyen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DangNhap extends AppCompatActivity {
    private static final String TAG = "MeTruyen";
    private EditText Email, Password;
    private Button DangNhap;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        mAuth = FirebaseAuth.getInstance();
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.MatKhau);
        DangNhap = findViewById(R.id.DangNhap);
        DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickDangNhap();
            }
        });
    }

    public void onClickDangNhap(){
        String StrEmail = Email.getText().toString().trim();
        String StrPassword = Password.getText().toString().trim();
        mAuth.createUserWithEmailAndPassword(StrEmail, StrPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(DangNhap.this, "Authentication successed.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(DangNhap.this, home.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(DangNhap.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}