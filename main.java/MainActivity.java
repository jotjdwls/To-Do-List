package com.cookandroid.a10week;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnSite, btnName, btnMajor, btnPlan, btnMusic, btnMbti, btnCar, btnCalculator, btnReservation;
    LinearLayout baseLayout;
    ImageView image;
    Switch switchShow;
    TextView tv2, tv_name, tv_major, tv_site, tv_mbti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("PROJECT");

        tv_name = (TextView) findViewById(R.id.text_name);
        tv_major = (TextView) findViewById(R.id.text_major);
        tv2 = (TextView) findViewById(R.id.text2);
        tv_site = (TextView) findViewById(R.id.text_site);
        btnName = (Button) findViewById(R.id.btnName);
        btnMajor = (Button) findViewById(R.id.btnMajor);
        btnSite = (Button) findViewById(R.id.btnSite);
        switchShow = (Switch) findViewById(R.id.switch1);
        image = (ImageView) findViewById(R.id.img);
        btnPlan = (Button) findViewById(R.id.btnNewActivity_plan);
        btnMusic = (Button) findViewById(R.id.btnNewActivity_music);
        btnCar = (Button) findViewById(R.id.btnNewActivity_car);
        btnCalculator = (Button) findViewById(R.id.btnNewActivity_calc);
        btnReservation = (Button) findViewById(R.id.btnNewActivity_reser);
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        btnMbti = (Button) findViewById(R.id.btnMbti);
        tv_mbti = (TextView) findViewById(R.id.text_mbti);

        btnName.setVisibility(View.GONE);
        btnMajor.setVisibility(View.GONE);
        btnSite.setVisibility(View.GONE);
        tv_name.setVisibility(View.GONE);
        tv_major.setVisibility(View.GONE);
        btnMbti.setVisibility(View.GONE);
        tv_site.setVisibility(View.GONE);
        tv2.setVisibility(View.GONE);
        tv_mbti.setVisibility(View.GONE);
        image.setVisibility(View.GONE);

        switchShow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (switchShow.isChecked() == true) {
                    btnName.setVisibility(View.VISIBLE);
                    btnMajor.setVisibility(View.VISIBLE);
                    btnSite.setVisibility(View.VISIBLE);
                    tv_name.setVisibility(View.VISIBLE);
                    tv_major.setVisibility(View.VISIBLE);
                    tv_site.setVisibility(View.VISIBLE);
                    btnMbti.setVisibility(View.VISIBLE);
                    tv_mbti.setVisibility(View.VISIBLE);
                    tv2.setVisibility(View.GONE);
                    image.setVisibility(View.VISIBLE);
                } else {
                    btnName.setVisibility(View.GONE);
                    btnMajor.setVisibility(View.GONE);
                    btnSite.setVisibility(View.GONE);
                    tv_name.setVisibility(View.GONE);
                    tv_major.setVisibility(View.GONE);
                    tv_site.setVisibility(View.GONE);
                    tv2.setVisibility(View.VISIBLE);
                    btnMbti.setVisibility(View.GONE);
                    tv_mbti.setVisibility(View.GONE);
                    image.setVisibility(View.GONE);
                    tv2.setText("정보를 보시려면 스위치를 켜시고,\n취미를 보려면 취미 서랍을 여세요.");
                }
            }
        });

        btnName.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_name.setText("  : 조성진 입니다.");
            }
        });

        btnMajor.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_major.setText("  : 한림대학교 빅데이터학과 19학번");
            }
        });

        btnMbti.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_mbti.setText("  : ISFJ 입니다.");
            }
        });

        btnPlan.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), secondActivity.class);
                startActivity(intent);
            }
        });

        btnMusic.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), thirdActivity.class);
                startActivity(intent);
            }
        });

        btnCar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), fourthActivity.class);
                startActivity(intent);
            }
        });

        btnCalculator.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), fifthActivity.class);
                startActivity(intent);
            }
        });

        btnReservation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), sixthActivity.class);
                startActivity(intent);
            }
        });

        registerForContextMenu(btnSite);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mInflater = getMenuInflater();

        if (v == btnSite) {
            menu.setHeaderTitle("원하는 사이트를 고르세요");
            mInflater.inflate(R.menu.menu2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Intent mIntent;
        switch (item.getItemId()) {
            case R.id.itemSite1: //smartlead
                mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://smartlead.hallym.ac.kr/login.php"));
                startActivity(mIntent);
                return true;

            case R.id.itemSite2: //youtube
                mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.youtube.com/"));
                startActivity(mIntent);
                return true;

            case R.id.itemSite3: //google
                mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.kr/"));
                startActivity(mIntent);
                return true;

            case R.id.itemSite4: //google
                mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.store.musinsa.com/app/?menu_id=113"));
                startActivity(mIntent);
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRich:
                image.setImageResource(R.drawable.rich);
                return true;

            case R.id.itemMango:
                image.setImageResource(R.drawable.mango);
                return true;

            case R.id.subNuri1:
                image.setImageResource(R.drawable.nuri1);
                return true;

            case R.id.subNuri2:
                image.setImageResource(R.drawable.nuri2);
                return true;

            case R.id.subNuri3:
                image.setImageResource(R.drawable.nuri3);
                return true;
        }
        return false;
    }

}
