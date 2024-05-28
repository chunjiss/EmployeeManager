package com.maithihao.qlnv;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;

public class MAITHIHAO_Activity extends AppCompatActivity {
    RecyclerView rcvNhanVien;
    EditText editSearch;
    NhanVienAdapter adapter;
    ArrayList<NhanVien> list = new ArrayList<>();
    DataBase dataBase;
    ActivityResultLauncher<Intent> mGetContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataBase = new DataBase(this);
        rcvNhanVien = findViewById(R.id.rcv_nhanvien);
        editSearch = findViewById(R.id.edt_search);
        dataBase.createTable();
        mGetContent = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {

                        }
                        list = dataBase.getAllNhanVien();
                        adapter.notifyData(list);
                    }
                });
        list = dataBase.getAllNhanVien();
        adapter = new NhanVienAdapter(list, this, mGetContent);
        rcvNhanVien.setAdapter(adapter);


        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                list = dataBase.getAllNhanVien(charSequence.toString());
                adapter = new NhanVienAdapter( list,MAITHIHAO_Activity.this, mGetContent);
                rcvNhanVien.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add){
            mGetContent.launch(new Intent(MAITHIHAO_Activity.this, MAITHIHAO_ActivitiAdd.class));
        }
        return true;
    }
}