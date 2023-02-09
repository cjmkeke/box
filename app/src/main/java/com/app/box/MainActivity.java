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

public class MainActivity extends AppCompatActivity {

    Button btm_listview;
    Button btn_save_move;
    Button btn_data_delete;
    Button btn_listboard;
    DatabaseReference db = FirebaseDatabase.getInstance().getReference();
    DatabaseReference conditionRef = db.child("userid1");
    EditText et_id;
    EditText et_pw;
//    TextView tvview1;
//    TextView tvview2;
//    TextView tv_view_db1;
//    TextView tv_view_db2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btm_listview = findViewById(R.id.btm_listview);
        btn_data_delete = findViewById(R.id.btn_data_delete);
        btn_save_move = findViewById(R.id.btn_save_move);
        btn_listboard = findViewById(R.id.btn_listboard);
        et_id = findViewById(R.id.et_id);
        et_pw = findViewById(R.id.et_pw);
//        tvview1 = findViewById(R.id.tvview1);
//        tvview2 = findViewById(R.id.tvview2);
//        tv_view_db1 = findViewById(R.id.tv_view_db1);
//        tv_view_db2 = findViewById(R.id.tv_view_db2);


        btn_data_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = et_id.getText().toString();
                String pw = et_pw.getText().toString();
//                id와 pw가 맞는지 확인
//                tvview1.setText("입력 id: "+id);
//                tvview2.setText("입력 password: "+pw);

                conditionRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String dataId = snapshot.child("id").getValue(String.class);
                        String dataPw = snapshot.child("pw").getValue(String.class);
                        // id 와 pw가 맞는지 확인
//                        tv_view_db1.setText("db저장된 id : "+dataId);
//                        tv_view_db2.setText("db저장된 pw : "+dataPw);
                        if (pw.equals(dataPw) && id.equals(dataId)){
                            Toast.makeText(MainActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this , dataDelete.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivity.this, "아이디 또는 비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                        }




                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });



//            Intent intent = new Intent(MainActivity.this, dataDelete.class);
//            startActivity(intent);
            }
        });


        btm_listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, listview.class);
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
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,listboard.class);
                startActivity(intent);
            }
        });

    }
}