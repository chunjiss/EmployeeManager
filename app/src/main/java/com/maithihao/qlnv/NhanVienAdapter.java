package com.maithihao.qlnv;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NhanVienAdapter extends RecyclerView.Adapter<NhanVienAdapter.ViewHolder> {
    ArrayList<NhanVien> list;
    Context context;
    DataBase dataBase;
    ActivityResultLauncher<Intent> getContent;

    public NhanVienAdapter(ArrayList<NhanVien> list, Context context, ActivityResultLauncher<Intent> getContent) {
        this.list = list;
        this.context = context;
        this.getContent = getContent;
        dataBase = new DataBase(
                context
        );
    }

    @NonNull
    @Override
    public NhanVienAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nhanvien, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NhanVienAdapter.ViewHolder holder, int position) {
        holder.bindData(list.get(position));

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MAITHIHAO_ActivitiAdd.class);
                intent.putExtra("edit", true);
                intent.putExtra("id", list.get(position).getId());
                getContent.launch(intent);
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBase.deletenv(list.get(position).getId());
                list.remove(position);
                notifyItemRemoved(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void notifyData(ArrayList<NhanVien> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvId, tvTen, tvQue, tvGioiTinh, tvLuong, tvChucVu;
        private ImageView edit, delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvTen = itemView.findViewById(R.id.tv_ten);
            tvQue = itemView.findViewById(R.id.tv_que);
            tvGioiTinh = itemView.findViewById(R.id.tv_gioitinh);
            tvLuong = itemView.findViewById(R.id.tv_luong);
            tvChucVu = itemView.findViewById(R.id.tv_chucvu);

            edit = itemView.findViewById(R.id.edit);
            delete = itemView.findViewById(R.id.delete);
        }

        void bindData(NhanVien nhanVien) {
            tvId.setText("Mã nv: " + nhanVien.getId());
            tvTen.setText(nhanVien.getTen());
            tvQue.setText("Quê: " + nhanVien.getQue());
            tvChucVu.setText("Chức vụ: " + nhanVien.getChucvu());
            tvGioiTinh.setText("Giới tính: " + nhanVien.getGioitinh());
            tvLuong.setText("Lương: " + nhanVien.getLuong());
        }

    }
}
