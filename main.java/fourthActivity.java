package com.cookandroid.a10week;

import android.app.Activity;

import androidx.annotation.Nullable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class fourthActivity extends Activity {
    Button makeCarBtn, speedUpBtn, speedDownBtn, btnReturn;
    EditText color, speed;
    TextView output;
    String tempStr, colorCar, speedCar;
    int speedInt;
    Car myCar;

    public class Car {
        String color;
        int speed = 0;

        Car(String color, int speed) {
            this.color = color;
            this.speed = speed;
        }

        void upSpeed(int value) {
            if (speed + value >= 200)
                speed = 200;
            else
                speed = speed + value;
        }

        void downSpeed(int value) {
            if (speed - value <= 0)
                speed = 0;
            else
                speed = speed - value;
        }

        int getSpeed() {
            return speed;
        }

        String getColor() {
            return color;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.fourth);

        speedUpBtn = (Button) findViewById(R.id.button1);
        speedDownBtn = (Button) findViewById(R.id.button2);
        makeCarBtn = (Button) findViewById(R.id.buttonCar);
        btnReturn = (Button) findViewById(R.id.btnReturn);
        output = (TextView) findViewById(R.id.textView1);
        speed = (EditText) findViewById(R.id.editText1);
        color = (EditText) findViewById(R.id.editText2);

        //생성자가 없을 때 사용하는 방법
        //myCar1.color = "Red";
        //myCar1.speed = 0;

        makeCarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorCar = speed.getText().toString();
                speedCar = color.getText().toString();
                speedInt = Integer.parseInt(speedCar);
                myCar = new Car(colorCar, 0);
                output.setText("객체가 생성되었습니다.");
            }
        });

        speedUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCar.upSpeed(speedInt);
                int var = myCar.getSpeed();
                tempStr = Integer.toString(var);
                output.setText("자동차의 속도는 [" + tempStr + "]이고 \n자동차의 색상은 [" +
                        myCar.getColor() + "]입니다.");
            }
        });

        speedDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCar.downSpeed(speedInt);
                int var = myCar.getSpeed();
                tempStr = Integer.toString(var);
                output.setText("자동차의 속도는 [" + tempStr + "]이고 \n자동차의 색상은 [" +
                        myCar.getColor() + "]입니다.");
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}

