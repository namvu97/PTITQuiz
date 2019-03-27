package com.example.ptitquiz.MyAppPTITQuiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.ptitquiz.Adapter.HinhAnhAdapter;
import com.example.ptitquiz.Model.image;
import com.example.ptitquiz.R;

import java.util.ArrayList;

public class homeActivity extends AppCompatActivity {
    GridView gvHinhAnh;
    ArrayList<image> arrayImage;
    HinhAnhAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Anhxa();
        adapter = new HinhAnhAdapter(this,R.layout.line_image,arrayImage);
        gvHinhAnh.setAdapter(adapter);
        Intent receive = getIntent();
        final String message = receive.getStringExtra("Username");
        gvHinhAnh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(arrayImage.get(position).getTen().equals("Mạng máy tính")){
                    Intent intent = new Intent(homeActivity.this, quiz_test.class);
                    intent.putExtra("truyendulieu","Mạng máy tính");
                    intent.putExtra("Username",message);
                    startActivity(intent);
                }
                if(arrayImage.get(position).getTen().equals("Lập trình web")){
                    Intent intent = new Intent(homeActivity.this, quiz_test.class);
                    intent.putExtra("truyendulieu","Lập trình web");
                    intent.putExtra("Username",message);
                    startActivity(intent);
                }
                if(arrayImage.get(position).getTen().equals("An toàn bảo mật")){
                    Intent intent = new Intent(homeActivity.this, quiz_test.class);
                    intent.putExtra("truyendulieu","An toàn bảo mật");
                    intent.putExtra("Username",message);
                    startActivity(intent);
                }
                if(arrayImage.get(position).getTen().equals("Xác suất thống kê")){
                    Intent intent = new Intent(homeActivity.this, quiz_test.class);
                    intent.putExtra("truyendulieu","Xác suất thống kê");
                    intent.putExtra("Username",message);
                    startActivity(intent);
                }
                if(arrayImage.get(position).getTen().equals("Hệ điều hành Win/Unix/Linux")){
                    Intent intent = new Intent(homeActivity.this, quiz_test.class);
                    intent.putExtra("truyendulieu","Hệ điều hành Win/Unix/Linux");
                    intent.putExtra("Username",message);
                    startActivity(intent);
                }
                if(arrayImage.get(position).getTen().equals("Quản lý dự án phần mềm")){
                    Intent intent = new Intent(homeActivity.this, quiz_test.class);
                    intent.putExtra("truyendulieu","Quản lý dự án phần mềm");
                    intent.putExtra("Username",message);
                    startActivity(intent);
                }
            }
        });
    }

    private void Anhxa() {
        gvHinhAnh = (GridView) findViewById(R.id.gridviewHinhAnh);
        arrayImage = new ArrayList<>();
        arrayImage.add(new image("Xác suất thống kê", R.drawable.xstk));
        arrayImage.add(new image("An toàn bảo mật", R.drawable.atbm));
        arrayImage.add(new image("Lập trình web", R.drawable.ltw));
        arrayImage.add(new image("Mạng máy tính", R.drawable.mmt));
        arrayImage.add(new image("Hệ điều hành Win/Unix/Linux", R.drawable.wul));
        arrayImage.add(new image("Quản lý dự án phần mềm", R.drawable.qldapm));
    }

    public void Logout(View view) {
        Intent intent = new Intent(homeActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
