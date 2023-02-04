package com.app.box;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class boxSave extends AppCompatActivity {

    private EditText et_0;
    private EditText et_1;
    private EditText et_2;
    private  EditText et_3;
    private  EditText et_4;
    private TextView tv_result;
    private  Button btn_save;
    private  Button btn_delete;
    private static String strResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box_save);

        et_0 = findViewById(R.id.et_0);
        et_1 = findViewById(R.id.et_1);
        et_2 = findViewById(R.id.et_2);
        et_3 = findViewById(R.id.et_3);
        et_4 = findViewById(R.id.et_4);
        tv_result = findViewById(R.id.tv_result);
        btn_save = findViewById(R.id.btn_save);
        btn_delete = findViewById(R.id.btn_delete);


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