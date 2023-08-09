package com.example.dalsi;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CenterActivity extends AppCompatActivity {
    Button btn1;
    EditText edit1, edit2;

    // 파이어베이스 데이터베이스 연동
    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    //DatabaseReference는 데이터베이스의 특정 위치로 연결하는 거라고 생각하면 된다.
    //현재 연결은 데이터베이스에만 딱 연결해놓고
    //키값(테이블 또는 속성)의 위치 까지는 들어가지는 않은 모습이다.
    private DatabaseReference databaseReference = database.getReference();


    //값을 파이어베이스 Realtime database로 넘기는 함수
    public void addDB(String email, String content) {

        //DB.java에서 선언했던 함수.
        DB DB = new DB(email,content);

        //child는 해당 키 위치로 이동하는 함수입니다.
        //키가 없는데 "zoo"와 name같이 값을 지정한 경우 자동으로 생성합니다.
        databaseReference.child("service").child(email).setValue(DB);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);

        btn1 = findViewById(R.id.btn1); //버튼 아이디 연결
        edit1 = findViewById(R.id.edit1); //이메일 이름 적는 곳
        edit2 = findViewById(R.id.edit2); //문의 내용 종류 적는 곳

        //버튼 누르면 값을 저장
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edit1.getText().toString();
                String content = edit2.getText().toString();

                addDB(email, content);

                // 화면 전환
                Intent intent = new Intent(CenterActivity.this, CompleteActivity.class);
                startActivity(intent);
            }
        });



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 뒤로가기 버튼 활성화
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    // 뒤로가기 버튼 동작 처리
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // activity_main2.xml로 이동
            Intent intent = new Intent(this, UserActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




}