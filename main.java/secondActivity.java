package com.cookandroid.a10week;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class secondActivity extends AppCompatActivity {
    TextView tv, tv_date, tv_year, tv_month, tv_day;
    EditText et1, et2, et3, et4, et5, et6, et7, et_year, et_month, et_day;
    Button bt1, bt2, bt3, bt4, bt5, btBack, btSave, btReset;
    CheckBox ck1, ck2, ck3, ck4, ck5, ck6, ck7;
    LinearLayout base1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.second);
        setTitle("Scheduler");

        tv = (TextView) findViewById(R.id.tv);
        tv_date = (TextView) findViewById(R.id.text_date);
        tv_year = (TextView) findViewById(R.id.text_year);
        tv_month = (TextView) findViewById(R.id.text_month);
        tv_day = (TextView) findViewById(R.id.text_day);
        bt1 = (Button) findViewById(R.id.btn1);
        bt2 = (Button) findViewById(R.id.btn2);
        bt3 = (Button) findViewById(R.id.btn3);
        bt4 = (Button) findViewById(R.id.btn4);
        bt5 = (Button) findViewById(R.id.btn5);
        btBack = (Button) findViewById(R.id.btnBack);
        btSave = (Button) findViewById(R.id.btnSave);
        btReset = (Button) findViewById(R.id.btnReset);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);
        et6 = (EditText) findViewById(R.id.et6);
        et7 = (EditText) findViewById(R.id.et7);
        et_year = (EditText) findViewById(R.id.edit_year);
        et_month = (EditText) findViewById(R.id.edit_month);
        et_day = (EditText) findViewById(R.id.edit_day);
        ck1 = (CheckBox) findViewById(R.id.check1);
        ck2 = (CheckBox) findViewById(R.id.check2);
        ck3 = (CheckBox) findViewById(R.id.check3);
        ck4 = (CheckBox) findViewById(R.id.check4);
        ck5 = (CheckBox) findViewById(R.id.check5);
        ck6 = (CheckBox) findViewById(R.id.check6);
        ck7 = (CheckBox) findViewById(R.id.check7);
        base1 = (LinearLayout) findViewById(R.id.base1);

        bt2.setVisibility(View.GONE);
        bt3.setVisibility(View.GONE);
        bt4.setVisibility(View.GONE);
        bt5.setVisibility(View.GONE);
        et4.setVisibility(View.GONE);
        et5.setVisibility(View.GONE);
        et6.setVisibility(View.GONE);
        et7.setVisibility(View.GONE);
        ck4.setVisibility(View.GONE);
        ck5.setVisibility(View.GONE);
        ck6.setVisibility(View.GONE);
        ck7.setVisibility(View.GONE);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt1.setVisibility(View.GONE);
                bt2.setVisibility(View.VISIBLE);
                et4.setVisibility(View.VISIBLE);
                ck4.setVisibility(View.VISIBLE);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt2.setVisibility(View.GONE);
                bt3.setVisibility(View.VISIBLE);
                et5.setVisibility(View.VISIBLE);
                ck5.setVisibility(View.VISIBLE);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt3.setVisibility(View.GONE);
                bt4.setVisibility(View.VISIBLE);
                et6.setVisibility(View.VISIBLE);
                ck6.setVisibility(View.VISIBLE);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt4.setVisibility(View.GONE);
                bt5.setVisibility(View.VISIBLE);
                et7.setVisibility(View.VISIBLE);
                ck7.setVisibility(View.VISIBLE);
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "더 이상 추가할 수 없습니다!", Toast.LENGTH_LONG).show();
            }
        });

        btReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
                et5.setText("");
                et6.setText("");
                et7.setText("");
                et_year.setText("");
                et_month.setText("");
                et_day.setText("");
                et4.setVisibility(View.GONE);
                et5.setVisibility(View.GONE);
                et6.setVisibility(View.GONE);
                et7.setVisibility(View.GONE);
                ck4.setVisibility(View.GONE);
                ck5.setVisibility(View.GONE);
                ck6.setVisibility(View.GONE);
                ck7.setVisibility(View.GONE);
                bt1.setVisibility(View.VISIBLE);
                bt2.setVisibility(View.GONE);
                bt3.setVisibility(View.GONE);
                bt4.setVisibility(View.GONE);
                bt5.setVisibility(View.GONE);
                ck1.setChecked(false);
                ck2.setChecked(false);
                ck3.setChecked(false);
                ck4.setChecked(false);
                ck5.setChecked(false);
                ck6.setChecked(false);
                ck7.setChecked(false);
            }
        });

        btSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    String title_date = et_year.getText().toString() + "_" + et_month.getText().toString() + "_" + et_day.getText().toString();
                    FileOutputStream outFs = openFileOutput(title_date + "_WhatIDid.txt", Context.MODE_PRIVATE);

                    String date = "[오늘의 날짜: " + title_date + "] \n\n" + "[내가 한 일] \n";
                    outFs.write(date.getBytes());

                    if (ck1.isChecked() == true) {
                        String str1 = et1.getText().toString() + "\n";
                        outFs.write(str1.getBytes());
                    }
                    if (ck2.isChecked() == true) {
                        String str2 = et2.getText().toString() + "\n";
                        outFs.write(str2.getBytes());
                    }
                    if (ck3.isChecked() == true) {
                        String str3 = et3.getText().toString() + "\n";
                        outFs.write(str3.getBytes());
                    }
                    if (ck4.isChecked() == true) {
                        String str4 = et4.getText().toString() + "\n";
                        outFs.write(str4.getBytes());
                    }
                    if (ck5.isChecked() == true) {
                        String str5 = et5.getText().toString() + "\n";
                        outFs.write(str5.getBytes());
                    }
                    if (ck6.isChecked() == true) {
                        String str6 = et6.getText().toString() + "\n";
                        outFs.write(str6.getBytes());
                    }
                    if (ck7.isChecked() == true) {
                        String str7 = et7.getText().toString() + "\n";
                        outFs.write(str7.getBytes());
                    }

                    outFs.close();
                    Toast.makeText(getApplicationContext(), "파일이 생성 되었습니다.", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                }
            }
        });


        btBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0, 1, 0, "테마변경(GREEN)");
        menu.add(0, 2, 0, "테마변경(ORANGE)");
        menu.add(0, 3, 0, "테마변경(GRAY)");
        menu.add(0, 4, 0, "테마변경(ORIGINAL)");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1: //배경-연두색, 글씨-카키색, 버튼-카키색
                base1.setBackgroundColor(Color.rgb(0xE4, 0xF7, 0xBA));
                bt1.setBackgroundColor(Color.rgb(0x1E, 0x3C, 0x00));
                bt2.setBackgroundColor(Color.rgb(0x1E, 0x3C, 0x00));
                bt3.setBackgroundColor(Color.rgb(0x1E, 0x3C, 0x00));
                bt4.setBackgroundColor(Color.rgb(0x1E, 0x3C, 0x00));
                bt5.setBackgroundColor(Color.rgb(0x1E, 0x3C, 0x00));
                btReset.setBackgroundColor(Color.rgb(0x1E, 0x3C, 0x00));
                btSave.setBackgroundColor(Color.rgb(0x1E, 0x3C, 0x00));
                btBack.setBackgroundColor(Color.rgb(0x1E, 0x3C, 0x00));
                tv.setTextColor(Color.rgb(0x1E, 0x3C, 0x00));
                tv_date.setTextColor(Color.rgb(0x1E, 0x3C, 0x00));
                tv_year.setTextColor(Color.rgb(0x1E, 0x3C, 0x00));
                tv_month.setTextColor(Color.rgb(0x1E, 0x3C, 0x00));
                tv_day.setTextColor(Color.rgb(0x1E, 0x3C, 0x00));
                return true;

            case 2: //배경-주황색, 글씨-버건디색, 버튼-버건디색
                base1.setBackgroundColor(Color.rgb(0xFF, 0xCF, 0x9F));
                bt1.setBackgroundColor(Color.rgb(0x6C, 0x00, 0x00));
                bt2.setBackgroundColor(Color.rgb(0x6C, 0x00, 0x00));
                bt3.setBackgroundColor(Color.rgb(0x6C, 0x00, 0x00));
                bt4.setBackgroundColor(Color.rgb(0x6C, 0x00, 0x00));
                bt5.setBackgroundColor(Color.rgb(0x6C, 0x00, 0x00));
                btReset.setBackgroundColor(Color.rgb(0x6C, 0x00, 0x00));
                btSave.setBackgroundColor(Color.rgb(0x6C, 0x00, 0x00));
                btBack.setBackgroundColor(Color.rgb(0x6C, 0x00, 0x00));
                tv.setTextColor(Color.rgb(0x6C, 0x00, 0x00));
                tv_date.setTextColor(Color.rgb(0x6C, 0x00, 0x00));
                tv_year.setTextColor(Color.rgb(0x6C, 0x00, 0x00));
                tv_month.setTextColor(Color.rgb(0x6C, 0x00, 0x00));
                tv_day.setTextColor(Color.rgb(0x6C, 0x00, 0x00));
                return true;

            case 3: //배경-회색, 글씨-검정색, 버튼-검정색
                base1.setBackgroundColor(Color.rgb(0xD8, 0xD8, 0xD8));
                bt1.setBackgroundColor(Color.BLACK);
                bt2.setBackgroundColor(Color.BLACK);
                bt3.setBackgroundColor(Color.BLACK);
                bt4.setBackgroundColor(Color.BLACK);
                bt5.setBackgroundColor(Color.BLACK);
                btReset.setBackgroundColor(Color.BLACK);
                btSave.setBackgroundColor(Color.BLACK);
                btBack.setBackgroundColor(Color.BLACK);
                tv.setTextColor(Color.BLACK);
                tv_date.setTextColor(Color.BLACK);
                tv_year.setTextColor(Color.BLACK);
                tv_month.setTextColor(Color.BLACK);
                tv_day.setTextColor(Color.BLACK);
                return true;

            case 4: //배경-흰색, 글씨-파랑색, 버튼-보라색
                base1.setBackgroundColor(Color.rgb(0xFF, 0xFF, 0xFF));
                bt1.setBackgroundColor(Color.rgb(0x62, 0x00, 0xEE));
                bt2.setBackgroundColor(Color.rgb(0x62, 0x00, 0xEE));
                bt3.setBackgroundColor(Color.rgb(0x62, 0x00, 0xEE));
                bt4.setBackgroundColor(Color.rgb(0x62, 0x00, 0xEE));
                bt5.setBackgroundColor(Color.rgb(0x62, 0x00, 0xEE));
                btReset.setBackgroundColor(Color.rgb(0x62, 0x00, 0xEE));
                btSave.setBackgroundColor(Color.rgb(0x62, 0x00, 0xEE));
                btBack.setBackgroundColor(Color.rgb(0x62, 0x00, 0xEE));
                tv.setTextColor(Color.BLUE);
                tv_date.setTextColor(Color.BLUE);
                tv_year.setTextColor(Color.BLUE);
                tv_month.setTextColor(Color.BLUE);
                tv_day.setTextColor(Color.BLUE);
                return true;
        }
        return false;
    }
}
