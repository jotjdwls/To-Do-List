package com.cookandroid.a10week;

import android.app.Activity;

import androidx.annotation.Nullable;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class fifthActivity extends Activity {
    Button btn1, btn2, btn3, btn4, btnReturn;
    TextView tv;
    EditText edit1, edit2;
    Integer bunja, bunmo;
    String tempStr1, tempStr2;

    public class Cal {
        int num1, num2, result;

        Cal(int num1, int num2) { //생성자
            this.num1 = num1;
            this.num2 = num2;
        }

        void addCal() {
            result = num1 + num2;
        }

        void subCal() {
            result = num1 - num2;
        }

        void mulCal() {
            result = num1 * num2;
        }

        void divCal() {
            result = num1 / num2;
        }

        int getResult() {
            return result;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.fifth);

        btn1 = (Button) findViewById(R.id.addBtn);
        btn2 = (Button) findViewById(R.id.subBtn);
        btn3 = (Button) findViewById(R.id.mulBtn);
        btn4 = (Button) findViewById(R.id.divBtn);
        btnReturn = (Button) findViewById(R.id.btnReturn);
        tv = (TextView) findViewById(R.id.resultTv);
        edit1 = (EditText) findViewById(R.id.firstNumEdit);
        edit2 = (EditText) findViewById(R.id.secondNumEdit);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tempStr1 = edit1.getText().toString();
                tempStr2 = edit2.getText().toString();
                bunja = Integer.parseInt(tempStr1);
                bunmo = Integer.parseInt(tempStr2);

                Cal calculate = new Cal(bunja, bunmo);
                calculate.addCal();
                tv.setText("두 수의 합: " + calculate.getResult());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tempStr1 = edit1.getText().toString();
                tempStr2 = edit2.getText().toString();
                bunja = Integer.parseInt(tempStr1);
                bunmo = Integer.parseInt(tempStr2);

                Cal calculate = new Cal(bunja, bunmo);
                calculate.subCal();
                tv.setText("두 수의 차: " + calculate.getResult());
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tempStr1 = edit1.getText().toString();
                tempStr2 = edit2.getText().toString();
                bunja = Integer.parseInt(tempStr1);
                bunmo = Integer.parseInt(tempStr2);

                Cal calculate = new Cal(bunja, bunmo);
                calculate.mulCal();
                tv.setText("두 수의 곱: " + calculate.getResult());
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tempStr1 = edit1.getText().toString();
                tempStr2 = edit2.getText().toString();
                bunja = Integer.parseInt(tempStr1);
                bunmo = Integer.parseInt(tempStr2);

                Cal calculate = new Cal(bunja, bunmo);
                if (bunmo == 0) {
                    tv.setText("불능(분모=0)");
                } else {
                    calculate.divCal();
                    tv.setText("두 수의 나눗셈: " + calculate.getResult());
                }
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}

