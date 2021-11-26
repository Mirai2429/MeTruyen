package com.example.MeTruyen;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.support.account.AccountAuthManager;
import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.account.service.AccountAuthService;
import com.huawei.hms.support.hwid.HuaweiIdAuthManager;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.result.HuaweiIdAuthResult;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;
import com.squareup.picasso.Picasso;

public class Account extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MeTruyen";
    public static final int DEFINED_CODE = 222;
    private static final int REQUEST_CODE_SCAN = 0X01;
    private AccountAuthService mAuthManager;
    private AccountAuthParams mAuthParam;
    ImageView imgViewPhoto;
    TextView txtViewUid;
    TextView txtViewNickName;
    TextView txtViewEmail;
    TextView txtViewPhone;
    Button btnSignOut;
    Button btnUpdateName;
    Button btnScan;
    Button btnQRCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        initView();
        showUserInfo();
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

        btnScan = findViewById(R.id.btnScan);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newViewBtnClick();
            }
        });

        btnQRCode = findViewById(R.id.btnQRCode);
        btnQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account.this, QRCode.class);
                startActivity(intent);
            }
        });
    }
    private void initView() {
        btnSignOut = findViewById(R.id.btn_Signout);
        btnSignOut.setOnClickListener(this);
        imgViewPhoto = findViewById(R.id.imgView_photo);
        imgViewPhoto.setOnClickListener(this);
        txtViewUid = findViewById(R.id.txtView_uid);
        txtViewNickName = findViewById(R.id.txtView_NickName);
        txtViewEmail = findViewById(R.id.txtView_email);
        txtViewPhone = findViewById(R.id.txtView_phone);
        btnUpdateName = findViewById(R.id.btn_update_name);
        btnUpdateName.setOnClickListener(this);
    }

    private void showUserInfo() {

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Signout:
                    signOut();
                    startActivity(new Intent(Account.this, login.class));
                    break;

            //case R.id.imgView_photo:
            //    break;

            //case R.id.btn_update_name:
            //    break;
        }
    }

    private void signOut() {
        Task<Void> signOutTask = mAuthManager.signOut();
        signOutTask.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.i(TAG, "signOut Success");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(Exception e) {
                Log.i(TAG, "signOut fail");
            }
        });
    }


    //Scan kit
    public void newViewBtnClick() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.requestPermissions(
                    new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE},
                    DEFINED_CODE);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (permissions == null || grantResults == null || grantResults.length < 2 || grantResults[0] != PackageManager.PERMISSION_GRANTED || grantResults[1] != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        if (requestCode == DEFINED_CODE) {
            // start your activity for scanning barcode
            this.startActivityForResult(new Intent(this, DefinedActivity.class), REQUEST_CODE_SCAN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // receive result after your activity finished scanning
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK || data == null) {
            return;
        }
        if (requestCode == REQUEST_CODE_SCAN) {
            HmsScan hmsScan = data.getParcelableExtra(DefinedActivity.SCAN_RESULT);
            if (hmsScan != null && !TextUtils.isEmpty(hmsScan.getOriginalValue())) {
                Toast.makeText(Account.this, hmsScan.getOriginalValue(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}