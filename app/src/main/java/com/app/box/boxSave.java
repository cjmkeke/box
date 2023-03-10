package com.app.box;

import static com.app.box.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class boxSave extends AppCompatActivity {

    private EditText et_0;
    private EditText et_1;
    private EditText et_2;
    private EditText et_3;
    private EditText et_4;
    private EditText et_5; // empty
    private EditText et_6; // empty
    private EditText et_7; // empty

    private TextView tv_result;
    private Button btn_save;
    private Button btn_delete;
    private Button btn_camera;
    private Button btn_gallery;
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
        btn_camera = findViewById(id.btn_camera);
        btn_gallery = findViewById(id.btn_gallery);


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

                    if (result1 == 0) {
                        int int1 = result2 * result4 + result3;
                        String str1 = String.valueOf(int1);
                        strResult = str1;
                    } else if (result2 == 0) {
                        int int2 = result1 * result4 + result3;
                        String str2 = String.valueOf(int2);
                        strResult = str2;
                    } else if (result3 == 0) {
                        int int3 = result1 * result2 * result4;
                        String str3 = String.valueOf(int3);
                        strResult = str3;
                    } else if (result4 == 0) {
                        int int4 = result1 * result2 + result3;
                        String str4 = String.valueOf(int4);
                        strResult = str4;
                    } else if (true) {
                        int int5 = result1 * result2;
                        int int6 = int5 + result3;
                        int int7 = int6 * result4;
                        String str5 = String.valueOf(int7);
                        strResult = str5;
                    }
                    tv_result.setText("??? ?????? : " + strResult+" EA");
                    code = et_0.getText().toString();


                    if (et_0.getText().toString().equals(null) || code.equals("")) {
                        Toast.makeText(boxSave.this, "???????????? ??????????????? ?????? ?????? ????????? ?????? ????????????. ????????? ????????? ????????????.", Toast.LENGTH_SHORT).show();
                    } else {
                        conditionRef.child(code).child("??????").setValue(et_0.getText().toString());
                        conditionRef.child(code).child("?????? ??????").setValue(et_1.getText().toString());
                        conditionRef.child(code).child("?????? ?????????").setValue(et_2.getText().toString());
                        conditionRef.child(code).child("?????? ??????").setValue(et_3.getText().toString());
                        conditionRef.child(code).child("????????? ??????").setValue(et_4.getText().toString());
                        conditionRef.child(code).child("empty1").setValue(et_5.getText().toString());
                        conditionRef.child(code).child("empty2").setValue(et_6.getText().toString());
                        conditionRef.child(code).child("empty3").setValue(et_7.getText().toString());
                        Toast.makeText(boxSave.this, "DB ??????"+" ?????? : "+ code, Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {

                }


            }
        });


        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_0.setText(et_0.getHint());
                et_1.setText("0");
                et_2.setText("0");
                et_3.setText("0");
                et_4.setText("0");
                et_5.setText("0");
                et_6.setText("0");
                et_7.setText("0");
                tv_result.setText("??????");
                Toast.makeText(boxSave.this, "????????? ???????????? ?????? ????????????.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//            Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//            if (intentCamera.resolveActivity(getPackageManager()) != null){
//                startActivityForResult(intentCamera, REQUEST_IMAGE_CODE);
//
//            }
            }
        });


    }
}