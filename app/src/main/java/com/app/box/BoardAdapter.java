package com.app.box;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardViewHolder> {
    // 해당 어댑터의 ViewHolder를 상속받는다.
    private List<datacode> datas;

    public BoardAdapter(List<datacode> datas) {
        this.datas = datas;
    }

    @Override
    public BoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // ViewHodler 객체를 생성 후 리턴한다.
        return new BoardViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BoardViewHolder holder, int position) {
        // ViewHolder 가 재활용 될 때 사용되는 메소드
        datacode data = datas.get(position);
        holder.title.setText(data.getEt_1());
    }

    @Override
    public int getItemCount() {
        return datas.size(); // 전체 데이터의 개수 조회
    }

    // 아이템 뷰를 저장하는 클래스
    public class BoardViewHolder extends RecyclerView.ViewHolder {
        // ViewHolder 에 필요한 데이터들을 적음.
        private TextView title;

        public BoardViewHolder(@NonNull View itemView) {
            super(itemView);
            // 아이템 뷰에 필요한 View
            title = itemView.findViewById(R.id.tv_code);
        }
    }
}
