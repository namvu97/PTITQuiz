package com.example.ptitquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class result extends AppCompatActivity {
    TextView edtCa,edtPoint,edtRank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        anhxa();
        Intent intent = getIntent();
        String total = intent.getStringExtra("Tổng");
        String Ca = intent.getStringExtra("Đúng");
        String sco = intent.getStringExtra("Số điểm");
        edtCa.setText(Ca);
        edtPoint.setText(sco);
    }

    private void anhxa() {
        edtCa = findViewById(R.id.edtCa);
        edtPoint = findViewById(R.id.edtPoint);
        edtRank = findViewById(R.id.edtRank);
    }
}
