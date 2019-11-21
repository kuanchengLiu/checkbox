package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> list; // 用來設定商品項目
    ListView listview;
    List<Boolean> listShow;    // 這個用來記錄哪幾個 item 是被打勾的
    int total = 0; // 用來記錄你總共花多少錢
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.ListView);
        listShow = new ArrayList<Boolean>();

        list = new ArrayList<String>();

        list.add("熟x紅茶  50元");
        listShow.add(false);

        list.add("熟x冷露  50元");
        listShow.add(false);

        list.add("春x綠茶  50元");
        listShow.add(false);

        list.add("春x冰茶  50元");
        listShow.add(false);

        list.add("白x歐雷  50元");
        listShow.add(false);

        list.add("春x紅茶  50元");
        listShow.add(false);

        list.add("春x冷露  50元");
        listShow.add(false);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                CheckedTextView chkItem = v.findViewById(R.id.check);
                chkItem.setChecked(!chkItem.isChecked());

                if (listShow.get(position) == false) {
                    listShow.set(position, true);
                    total += 50;
                } else {
                    listShow.set(position, false);
                    total -= 50;

                }

                listShow.set(position, chkItem.isChecked());

            }
        });


        ListAdepter adapterItem = new ListAdepter(this, list);
        listview.setAdapter(adapterItem);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("是否要給拎北錢")
                        .setMessage("給拎北錢" + total)
                        .setPositiveButton("給拎北錢", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                return;
                            }
                        })
                        .setNeutralButton("我再想想", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                return;
                            }
                        }).show();
            }
        });
    }
}
