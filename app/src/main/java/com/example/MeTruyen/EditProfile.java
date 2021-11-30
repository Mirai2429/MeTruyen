package com.example.MeTruyen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class EditProfile extends AppCompatActivity {
    private static final String TAG = "MeTruyen";
    private ImageView Back;
    private EditText EditName;
    private Button CapNhat;
    private ImageView Avatar;
    private Uri mUri;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Back = findViewById(R.id.Back);
        Avatar = findViewById(R.id.Avatar);
        EditName = findViewById(R.id.EditName);
        CapNhat = findViewById(R.id.CapNhat);
        progressDialog = new ProgressDialog(this);
        setUserInfo();
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

        CapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateProfile();
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfile.this, Account.class);
                startActivity(intent);
            }
        });
    }

    private void setUserInfo(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            EditName.setText(user.getDisplayName());
            Glide.with(this).load(user.getPhotoUrl()).error(R.drawable.acc).into(Avatar);
        }
    }

    private void updateProfile(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        progressDialog.show();
        String UpdateName = EditName.getText().toString().trim();
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(UpdateName)
                .setPhotoUri(mUri)
                .build();

        user.updateProfile(profileUpdates)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(EditProfile.this, "Update profile successed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}