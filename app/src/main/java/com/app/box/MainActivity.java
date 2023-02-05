package com.app.box;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_list_move;
    Button btn_save_move;
    Button btn_listboard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_save_move = findViewById(R.id.btn_save_move);
        btn_list_move = findViewById(R.id.btn_list_move);
        btn_listboard = findViewById(R.id.btn_listboard);


        btn_list_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, boxList.class);
            startActivity(intent);
            }
        });


        btn_save_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, boxSave.class);
                startActivity(intent);
            }
        });

        btn_listboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, listboard.class);
                startActivity(intent);
            }
        });
    }
}