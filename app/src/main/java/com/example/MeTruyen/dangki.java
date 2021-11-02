package com.example.MeTruyen;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class dangki extends AppCompatActivity {
    private Button HoanThanh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangki);
        HoanThanh = (Button) findViewById(R.id.HoanThanh);
        HoanThanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHoanThanh();
            }
        });
    }
    public void openHoanThanh(){
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
}