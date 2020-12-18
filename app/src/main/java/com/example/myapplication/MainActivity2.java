package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    class Data {
        int photo;
    }

    public class MyAdapter extends BaseAdapter {
        private MainActivity2.Data[] data;
        private int view;

        public MyAdapter(MainActivity2.Data[] data, int view) {
            this.data = data;
            this.view = view;
        }

        public int getCount() {
            return data.length;
        }

        public Object getItem(int position) {
            return data[position];
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(view, parent, false);
            ImageView imageView = convertView.findViewById(R.id.imageView);
            imageView.setImageResource(data[position].photo);
            return convertView;
        }
    }

    private Button btn_photo, btn_setting, btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_home = findViewById(R.id.btn_home);
        btn_photo = findViewById(R.id.btn_photo);
        btn_setting = findViewById(R.id.btn_setting);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity2.this, MainActivity.class), 1);
                finish();
            }
        });
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity2.this, MainActivity3.class), 3);
                finish();
            }
        });


        int[] PhotoIdArray = new int[]{R.drawable.sula,R.drawable.girl,R.drawable.peko};
        Data[] PhotoData = new Data[PhotoIdArray.length];
        for (int i = 0; i < PhotoData.length; i++) {
            PhotoData[i] = new Data();
            PhotoData[i].photo = PhotoIdArray[i];

            MyAdapter PhotoAdapter = new MyAdapter(PhotoData, R.layout.photo);

            GridView gridview = findViewById(R.id.gridview);
            gridview.setAdapter(PhotoAdapter);
            gridview.setNumColumns(1);
        }
    }
}