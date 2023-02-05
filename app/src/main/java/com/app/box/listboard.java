package com.app.box;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

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
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listboard);

        DatabaseReference db = FirebaseDatabase.getInstance().getReference();
        DatabaseReference conditionRef = db.child("CODE").child("x00");

        board_tv_view_0 = findViewById(R.id.board_tv_view_0);
        board_tv_view_1 = findViewById(R.id.board_tv_view_1);
        board_tv_view_2 = findViewById(R.id.board_tv_view_2);
        board_tv_view_3 = findViewById(R.id.board_tv_view_3);
        board_tv_view_4 = findViewById(R.id.board_tv_view_4);
        board_tv_view_5 = findViewById(R.id.board_tv_view_5);
        board_tv_view_6 = findViewById(R.id.board_tv_view_6);
        board_tv_view_7 = findViewById(R.id.board_tv_view_7);
        btn_back = findViewById(R.id.btn_back);


        conditionRef.child("코드").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String str = snapshot.getValue(String.class);
                board_tv_view_0.setText(str);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}