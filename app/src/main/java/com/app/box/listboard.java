package com.app.box;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class listboard extends AppCompatActivity {

    TextView board_tv_view_0;
    TextView board_tv_view_1;
    TextView board_tv_view_2;
    TextView board_tv_view_3;
    TextView board_tv_view_4;
    TextView board_tv_view_5;
    TextView board_tv_view_6;
    TextView board_tv_view_7;
    EditText et_search;
    Button btn_back;
    Button btn_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listboard);
        DatabaseReference db = FirebaseDatabase.getInstance().getReference();
        DatabaseReference conditionRef = db.child("CODE");

        board_tv_view_0 = findViewById(R.id.board_tv_view_0);
        board_tv_view_1 = findViewById(R.id.board_tv_view_1);
        board_tv_view_2 = findViewById(R.id.board_tv_view_2);
        board_tv_view_3 = findViewById(R.id.board_tv_view_3);
        board_tv_view_4 = findViewById(R.id.board_tv_view_4);
        board_tv_view_5 = findViewById(R.id.board_tv_view_5);
        board_tv_view_6 = findViewById(R.id.board_tv_view_6);
        board_tv_view_7 = findViewById(R.id.board_tv_view_7);
        et_search = findViewById(R.id.et_search);
        btn_back = findViewById(R.id.btn_back);
        btn_search = findViewById(R.id.btn_search);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchText = et_search.getText().toString();

                if (searchText.isEmpty()) {
                    Toast.makeText(listboard.this, "검색창이 비어 있습니다.", Toast.LENGTH_SHORT).show();
                } else {

                    conditionRef.child(searchText).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String str0 = snapshot.child("코드").getValue(String.class);
                            String str1 = snapshot.child("박스 수량").getValue(String.class);
                            String str2 = snapshot.child("박스 개입수").getValue(String.class);
                            String str3 = snapshot.child("박스 잔량").getValue(String.class);
                            String str4 = snapshot.child("파렛트 수량").getValue(String.class);
                            String str5 = snapshot.child("empty1").getValue(String.class);
                            String str6 = snapshot.child("empty2").getValue(String.class);
                            String str7 = snapshot.child("empty3").getValue(String.class);

                            board_tv_view_0.setText(str0);
                            board_tv_view_1.setText(str1);
                            board_tv_view_2.setText(str2);
                            board_tv_view_3.setText(str3);
                            board_tv_view_4.setText(str4);
                            board_tv_view_5.setText(str5);
                            board_tv_view_6.setText(str6);
                            board_tv_view_7.setText(str7);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }

            }
        });


//        // 하나씩 데이터를 불러오는 방법
//        conditionRef.child("코드").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String str = snapshot.getValue(String.class);
//                board_tv_view_0.setText(str);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listboard.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}