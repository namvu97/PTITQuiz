package com.example.ptitquiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class quiz_test extends AppCompatActivity {
    TextView txtQuestion,txtTime,txtPoint;
    Button btnAnswer1,btnAnswer2,btnAnswer3,btnAnswer4;
    DatabaseReference reference;
    int index = 1, ca = 0, wa = 0,score=0;
    CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_test);
        Anhxa();
        QuestionQuiz();
        UpdateCountDown(60);
    }

    private void QuestionQuiz() {
        if(index>=10){
            Intent intent = new Intent(quiz_test.this, result.class);
            intent.putExtra("Tổng",String.valueOf(index));
            intent.putExtra("Đúng",String.valueOf(ca));
            intent.putExtra("Số điểm",String.valueOf(score));
            startActivity(intent);
        }else{
            Intent intent = getIntent();
            String message = intent.getStringExtra("truyendulieu");
            if(message.equals("Mạng máy tính")) reference = FirebaseDatabase.getInstance().getReference().child("Mmt").child(String.valueOf(index));
            if(message.equals("Lập trình web")) reference = FirebaseDatabase.getInstance().getReference().child("Ltw").child(String.valueOf(index));
            if(message.equals("An toàn bảo mật")) reference = FirebaseDatabase.getInstance().getReference().child("Atbm").child(String.valueOf(index));
            if(message.equals("Xác suất thống kê")) reference = FirebaseDatabase.getInstance().getReference().child("Xstk").child(String.valueOf(index));
            if(message.equals("Hệ điều hành Win/Unix/Linux")) reference = FirebaseDatabase.getInstance().getReference().child("Wul").child(String.valueOf(index));
            if(message.equals("Quản lý dự án phần mềm")) reference = FirebaseDatabase.getInstance().getReference().child("Qldapm").child(String.valueOf(index));
            index++;
            txtPoint.setText(String.valueOf(score));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final Question question = dataSnapshot.getValue(Question.class);
                    txtQuestion.setText(question.getQuestion());
                    btnAnswer1.setText(question.getAns1());
                    btnAnswer2.setText(question.getAns2());
                    btnAnswer3.setText(question.getAns3());
                    btnAnswer4.setText(question.getAns4());
                    btnAnswer1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(btnAnswer1.getText().toString().equals(question.getAnswer())){
                                btnAnswer1.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        ca++;
                                        btnAnswer1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        score+=10;
                                        QuestionQuiz();
                                    }
                                },1500);
                            }
                            else{
                                wa++;
                                if(score>0) score-=5;
                                btnAnswer1.setBackgroundColor(Color.RED);
                                if(btnAnswer2.getText().toString().equals(question.getAnswer())){
                                    btnAnswer2.setBackgroundColor(Color.GREEN);
                                }else if(btnAnswer3.getText().toString().equals(question.getAnswer())){
                                    btnAnswer3.setBackgroundColor(Color.GREEN);
                                }else if(btnAnswer4.getText().toString().equals(question.getAnswer())){
                                    btnAnswer4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        btnAnswer1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btnAnswer2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btnAnswer3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btnAnswer4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        QuestionQuiz();
                                    }
                                },1500);
                            }
                        }
                    });
                    btnAnswer2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(btnAnswer2.getText().toString().equals(question.getAnswer())){
                                btnAnswer2.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        ca++;
                                        score+=10;
                                        btnAnswer2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        QuestionQuiz();
                                    }
                                },1500);
                            }
                            else{
                                wa++;
                                if(score>0) score-=5;
                                btnAnswer2.setBackgroundColor(Color.RED);
                                if(btnAnswer1.getText().toString().equals(question.getAnswer())){
                                    btnAnswer1.setBackgroundColor(Color.GREEN);
                                }else if(btnAnswer3.getText().toString().equals(question.getAnswer())){
                                    btnAnswer3.setBackgroundColor(Color.GREEN);
                                }else if(btnAnswer4.getText().toString().equals(question.getAnswer())){
                                    btnAnswer4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        btnAnswer1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btnAnswer2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btnAnswer3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btnAnswer4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        QuestionQuiz();
                                    }
                                },1500);
                            }
                        }
                    });
                    btnAnswer3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(btnAnswer3.getText().toString().equals(question.getAnswer())){
                                btnAnswer3.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        ca++;
                                        score+=10;
                                        btnAnswer3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        QuestionQuiz();
                                    }
                                },1500);
                            }
                            else{
                                wa++;
                                if(score>0) score-=5;
                                btnAnswer3.setBackgroundColor(Color.RED);
                                if(btnAnswer2.getText().toString().equals(question.getAnswer())){
                                    btnAnswer2.setBackgroundColor(Color.GREEN);
                                }else if(btnAnswer1.getText().toString().equals(question.getAnswer())){
                                    btnAnswer1.setBackgroundColor(Color.GREEN);
                                }else if(btnAnswer4.getText().toString().equals(question.getAnswer())){
                                    btnAnswer4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        btnAnswer1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btnAnswer2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btnAnswer3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btnAnswer4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        QuestionQuiz();
                                    }
                                },1500);
                            }
                        }
                    });
                    btnAnswer4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(btnAnswer4.getText().toString().equals(question.getAnswer())){
                                btnAnswer4.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        ca++;
                                        score+=10;
                                        btnAnswer4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        QuestionQuiz();
                                    }
                                },1500);
                            }
                            else{
                                wa++;
                                if(score>0) score-=5;
                                btnAnswer4.setBackgroundColor(Color.RED);
                                if(btnAnswer2.getText().toString().equals(question.getAnswer())){
                                    btnAnswer2.setBackgroundColor(Color.GREEN);
                                }else if(btnAnswer3.getText().toString().equals(question.getAnswer())){
                                    btnAnswer3.setBackgroundColor(Color.GREEN);
                                }else if(btnAnswer1.getText().toString().equals(question.getAnswer())){
                                    btnAnswer1.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        btnAnswer1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btnAnswer2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btnAnswer3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btnAnswer4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        QuestionQuiz();
                                    }
                                },1500);
                            }
                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }


    }


    private void Anhxa() {
        txtQuestion = findViewById(R.id.txtQuestion);
        txtTime = findViewById(R.id.txtTime);
        txtPoint = findViewById(R.id.txtPoint);
        btnAnswer1 = findViewById(R.id.btnAnswer1);
        btnAnswer2 = findViewById(R.id.btnAnswer2);
        btnAnswer3 = findViewById(R.id.btnAnswer3);
        btnAnswer4 = findViewById(R.id.btnAnswer4);
    }

    public void UpdateCountDown(final int timeLeft){
        new CountDownTimer(timeLeft*1000+1000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                int minute = (int) (millisUntilFinished / 1000) /60;
                int seconds = (int) (millisUntilFinished / 1000) %60;
                txtTime.setText(String.format("%02d:%02d",minute,seconds));
            }

            @Override
            public void onFinish() {
                txtTime.setText("Hết giờ!");
                Intent intent = new Intent(quiz_test.this,time_up.class);
                intent.putExtra("Tổng",String.valueOf(index));
                intent.putExtra("Đúng",String.valueOf(ca));
                intent.putExtra("Số điểm",String.valueOf(score));
                startActivity(intent);
            }
        }.start();
    }
}
