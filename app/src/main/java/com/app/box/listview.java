package com.app.box;

import static com.app.box.R.layout.text_lay;
import static com.app.box.R.layout.vecyclerview_layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class listview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        RecyclerView recyclerView = findViewById(R.id.recyclerview_list);

        listViewAdapter Adapter = new listViewAdapter(new listViewAdapter.OnClickListView() {
            @Override
            public void OnClickedListView(datacode model) {

            }
        });
        recyclerView.setAdapter(Adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    private static class listViewAdapter extends RecyclerView.Adapter<listViewAdapter.listViewHolder> {
        interface OnClickListView {
            void OnClickedListView(datacode model);
        }

        private OnClickListView mListener;

        private List<datacode> mItems = new ArrayList<>();

        public listViewAdapter() {
        }

        public listViewAdapter(OnClickListView listener) {
            mListener = listener;
        }

        public void setItems(List<datacode> items) {
            this.mItems = items;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public listViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(vecyclerview_layout, parent, false);
            final listViewHolder viewHolder = new listViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        final datacode item = mItems.get(viewHolder.getAdapterPosition());
                        mListener.OnClickedListView(item);
                    }
                }
            });
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull listViewHolder holder, int position) {
            datacode item = mItems.get(position);
            // TODO : 데이터를 뷰홀더에 표시하시오
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        public static class listViewHolder extends RecyclerView.ViewHolder {
            // TODO : 뷰홀더 완성하시오

            public listViewHolder(@NonNull View itemView) {
                super(itemView);
                // TODO : 뷰홀더 완성하시오
            }
        }
    }

}