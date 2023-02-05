package com.app.box;

import static com.app.box.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class boxSave extends AppCompatActivity {

    private EditText et_0;
    private EditText et_1;
    private EditText et_2;
    private  EditText et_3;
    private  EditText et_4;
    private  EditText et_5; // empty
    private  EditText et_6; // empty
    private  EditText et_7; // empty

    private TextView tv_result;
    private  Button btn_save;
    private  Button btn_delete;
    private static String strResult;
    private String code;


    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference conditionRef = mRootRef.child("CODE");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_box_save);

        et_0 = findViewById(id.et_0);
        et_1 = findViewById(id.et_1);
        et_2 = findViewById(id.et_2);
        et_3 = findViewById(id.et_3);
        et_4 = findViewById(id.et_4);
        et_5 = findViewById(id.et_5);
        et_6 = findViewById(id.et_6);
        et_7 = findViewById(id.et_7);
        tv_result = findViewById(id.tv_result);
        btn_save = findViewById(id.btn_back);
        btn_delete = findViewById(id.btn_delete);


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String data1 = et_1.getText().toString();
                    String data2 = et_2.getText().toString();
                    String data3 = et_3.getText().toString();
                    String data4 = et_4.getText().toString();

                    int result1 = Integer.parseInt(data1);
                    int result2 = Integer.parseInt(data2);
                    int result3 = Integer.parseInt(data3);
                    int result4 = Integer.parseInt(data4);

                    if (result1 == 0){
                        int int1 = result2 * result4 + result3;
                        String str1 = String.valueOf(int1);
                        strResult = str1;
                    }else if(result2 == 0){
                        int int2 = result1 * result4 + result3;
                        String str2 = String.valueOf(int2);
                        strResult = str2;
                    }else if(result3 == 0){
                        int int3 = result1 * result2 * result4;
                        String str3 = String.valueOf(int3);
                        strResult = str3;
                    }else if(result4 == 0){
                        int int4 = result1 * result2 + result3;
                        String str4 = String.valueOf(int4);
                        strResult = str4;
                    }else if(true){
                        int int5 = result1 * result2;
                        int int6 = int5 + result3;
                        int int7 = int6 * result4;
                        String str5 = String.valueOf(int7);
                        strResult = str5;
                    }
                    tv_result.setText("총 수량 : "+strResult);
                    code = et_0.getText().toString();


                    if(et_0.getText().toString().equals(null) || code.equals("")){
                        Toast.makeText(boxSave.this, "데이터를 저장하려면 코드 또는 품명은 필수 값입니다.", Toast.LENGTH_SHORT).show();
                    }else{
                    conditionRef.child(code).child("코드").setValue(et_0.getText().toString());
                    conditionRef.child(code).child("박스 수량").setValue(et_1.getText().toString());
                    conditionRef.child(code).child("박스 개입수").setValue(et_2.getText().toString());
                    conditionRef.child(code).child("박스 잔량").setValue(et_3.getText().toString());
                    conditionRef.child(code).child("파렛트 수량").setValue(et_4.getText().toString());
                    conditionRef.child(code).child("empty1").setValue(et_5.getText().toString());
                    conditionRef.child(code).child("empty2").setValue(et_6.getText().toString());
                    conditionRef.child(code).child("empty3").setValue(et_7.getText().toString());
                    }
                }catch (Exception e){

                }


            }
        });


        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_0.setText("코드 또는 품명");
                et_1.setText("0");
                et_2.setText("0");
                et_3.setText("0");
                et_4.setText("0");
                tv_result.setText("결과");
            }
        });

    }
}