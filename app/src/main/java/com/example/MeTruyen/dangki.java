package com.example.MeTruyen;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class dangki extends AppCompatActivity {
    private EditText Email, Password;
    private Button HoanThanh;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangki);
        mAuth = FirebaseAuth.getInstance();
        Email = findViewById(R.id.DangKiEmail);
        Password = findViewById(R.id.MatKhau);
        progressDialog = new ProgressDialog(this);
        HoanThanh = findViewById(R.id.HoanThanh);
        HoanThanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpUser(Email.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void signUpUser(String email, String password) {
        progressDialog.show();
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()) {
                                Toast.makeText(dangki.this, "Authentication successed.",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(dangki.this, home.class);
                                startActivity(intent);
                                finishAffinity();
                            } else {
                                Toast.makeText(dangki.this, "Sign up failed: " + task.getException(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
    }
}