package com.example.listviewadu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ListView listSinhVien;
    int id = -1;
    EditText editTen;
    EditText editMasv;
    Button btnThem, btnSua, btnXoa;
    ArrayList<SinhVien> arrSinhVien;
    CustomAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        arrSinhVien = new ArrayList<SinhVien>();
        arrSinhVien.add(new SinhVien(R.mipmap.ic_launcher_round, "Cao Thị Thu Hiền", "1811505310312"));
        arrSinhVien.add(new SinhVien(R.mipmap.ic_launcher_round, "Cao Thị Thu Hiền 1", "1811505310312"));
        arrSinhVien.add(new SinhVien(R.mipmap.ic_launcher_round, "Cao Thị Thu Hiền 2", "1811505310312"));

        myadapter = new CustomAdapter(this, R.layout.item_layout, arrSinhVien);
        listSinhVien.setAdapter(myadapter);
        listSinhVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                id = position;
                editTen.setText(arrSinhVien.get(position).getTenSinhVien());
                editMasv.setText(arrSinhVien.get(position).getMasvSinhVien());
            }
        });
        listSinhVien.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long l) {
                arrSinhVien.remove(position);
                myadapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Đã xóa thành công", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void anhxa(){
        listSinhVien = (ListView) findViewById(R.id.list_sinhvien);
        editTen = (EditText) findViewById(R.id.edit_ten);
        editMasv = (EditText) findViewById(R.id.edit_masv);
        btnThem = (Button) findViewById(R.id.btn_them);
        btnSua = (Button) findViewById(R.id.btn_sua);
        btnXoa = (Button) findViewById(R.id.btn_xoa);
    }
    public void onClick(View view){
        switch (view.getId()){

            case R.id.btn_them:
                Toast.makeText(this, "click vào button thêm", Toast.LENGTH_SHORT ).show();
                String ten = editTen.getText().toString();
                String masv = editMasv.getText().toString();
                SinhVien temp = new SinhVien(R.mipmap.ic_launcher, ten, masv);
                arrSinhVien.add(temp);
                myadapter.notifyDataSetChanged();
                break;

            case R.id.btn_sua:
                String tenDaSua = editTen.getText().toString();
                String masvDaSua = editMasv.getText().toString();
                SinhVien svDaSua = new SinhVien(R.mipmap.ic_launcher, tenDaSua,masvDaSua);
                arrSinhVien.set(id,svDaSua);
                id=-1;
                myadapter.notifyDataSetChanged();
                break;
        }
    }
}