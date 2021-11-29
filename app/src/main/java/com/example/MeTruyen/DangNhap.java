package com.example.MeTruyen;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DangNhap extends AppCompatActivity {
    private EditText Email, Password;
    private Button DangNhap;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
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
        progressDialog.show();
        mAuth.signInWithEmailAndPassword(StrEmail, StrPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(DangNhap.this, "Authentication successed.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(DangNhap.this, home.class);
                            startActivity(intent);
                            finishAffinity();
                        } else {
                            Toast.makeText(DangNhap.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}