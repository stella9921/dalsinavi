package com.example.dalsi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SearchViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchview);

        ImageButton backButton = findViewById(R.id.backButton);
        ListView listViewResults = findViewById(R.id.listViewResults);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // 가상의 데이터
        ArrayList<String> resultList = new ArrayList<>();
        resultList.add("Item 1");
        resultList.add("Item 2");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, resultList);
        listViewResults.setAdapter(adapter);

        listViewResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = resultList.get(position);
                if (selectedItem.equals("Item 1")) {
                    // www.naver.com 링크 열기
                    openWebView("https://www.naver.com");
                }
                // 다른 항목에 대한 처리도 추가 가능
            }
        });
    }

    private void openWebView(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}