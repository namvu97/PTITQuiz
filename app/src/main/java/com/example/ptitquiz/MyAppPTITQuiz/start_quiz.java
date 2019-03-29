package com.example.ptitquiz.MyAppPTITQuiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ptitquiz.R;

public class start_quiz extends AppCompatActivity {
    Button btnPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);
        btnPlay = findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent receive = getIntent();
                Intent intent = new Intent(start_quiz.this, quiz_test.class);
                intent.putExtra("Username", receive.getStringExtra("Username"));
                intent.putExtra("truyendulieu", receive.getStringExtra("truyendulieu"));
                startActivity(intent);
            }
        });
    }
}
