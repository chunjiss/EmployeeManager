package com.maithihao.qlnv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MAITHIHAO_ActivitiAdd extends AppCompatActivity {
    private EditText tvTen, tvQue, tvGioiTinh, tvLuong, tvChucVu;
    Button btnAdd;
    DataBase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maithihao_activiti_add);
        dataBase = new DataBase(this);
        tvTen = findViewById(R.id.edt_ten);
        tvQue = findViewById(R.id.edt_que);
        tvGioiTinh = findViewById(R.id.edt_gioitinh);
        tvLuong = findViewById(R.id.edt_luong);
        tvChucVu = findViewById(R.id.edt_chucvu);
        btnAdd = findViewById(R.id.btn_add);


        if (getIntent().getBooleanExtra("edit", false)) {
            btnAdd.setText("Sửa");
            NhanVien nhanVien = dataBase.getNhanVien(getIntent().getStringExtra("id"));
            tvTen.setText(nhanVien.getTen());
            tvQue.setText(nhanVien.getQue());
            tvGioiTinh.setText(nhanVien.getGioitinh());
            tvChucVu.setText(nhanVien.getChucvu());
            tvLuong.setText(nhanVien.getLuong());
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setTen(tvTen.getText().toString());
                nhanVien.setQue(tvQue.getText().toString());
                nhanVien.setGioitinh(tvGioiTinh.getText().toString());
                nhanVien.setChucvu(tvChucVu.getText().toString());
                nhanVien.setLuong(tvLuong.getText().toString());
                if (getIntent().getBooleanExtra("edit", false)) {
                    nhanVien.setId(getIntent().getStringExtra("id"));
                    dataBase.updateSv(nhanVien);
                } else {
                    dataBase.insertSv(nhanVien);
                }
                setResult(Activity.RESULT_OK);
                finish();
            }
        });
    }
}