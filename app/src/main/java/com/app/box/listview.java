package com.app.box;

import static com.app.box.R.layout.recyclerview_layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class listview extends AppCompatActivity {
    //추가
    private RecyclerView mPostRecyclerView;
    private BoardAdapter mAdpater;
    private ArrayList<datacode> mDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference conditionRef = mRootRef.child("userid1").child("id");

        mPostRecyclerView = findViewById(R.id.recyclerview_list);

        conditionRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // 파이어베이스 데이터베이스의 데이터를 받아오는 곳
//                mDatas.clear(); // 기존 배열리스트가 존재하지 않게 초기화
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { //반복문으로 데이터 리스트를 추출
                    datacode user = snapshot.getValue(datacode.class); // User 객체에 데이터 담는다
                    mDatas.add(user); // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                }
                mAdpater.notifyDataSetChanged(); // 리스트 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // db를 가져오던 중 에러 발생 시
                Log.e("MainActivity", String.valueOf(error.toException())); // 에러문 출력
            }
        });
    }
}