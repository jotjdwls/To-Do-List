package com.cookandroid.a10week;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class thirdActivity extends AppCompatActivity {
    Button btnStart1, btnStop1, btnStart2, btnStop2, btnStart3, btnStop3, btnBack, btnReserch, btnSave;
    Switch sc;
    ImageView img;
    TextView tv1, tv2, tv3, tv4;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.third);
        setTitle("Music");

        final MediaPlayer lovesickgirl, oldsong, starofthenightsky;
        lovesickgirl = MediaPlayer.create(this, R.raw.lovesickgirls);
        oldsong = MediaPlayer.create(this, R.raw.oldsong);
        starofthenightsky = MediaPlayer.create(this, R.raw.starofthenightsky);

        et = (EditText) findViewById(R.id.link);
        sc = (Switch) findViewById(R.id.switch1);
        btnStart1 = (Button) findViewById(R.id.btnStart1);
        btnStop1 = (Button) findViewById(R.id.btnStop1);
        btnSave = (Button) findViewById(R.id.save);
        btnStart2 = (Button) findViewById(R.id.btnStart2);
        btnStop2 = (Button) findViewById(R.id.btnStop2);
        btnStart3 = (Button) findViewById(R.id.btnStart3);
        btnStop3 = (Button) findViewById(R.id.btnStop3);
        btnBack = (Button) findViewById(R.id.back);
        btnReserch = (Button) findViewById(R.id.reserch);
        tv1 = (TextView) findViewById(R.id.singer);
        tv2 = (TextView) findViewById(R.id.title);
        tv3 = (TextView) findViewById(R.id.date);
        tv4 = (TextView) findViewById(R.id.idontwantit);
        img = (ImageView) findViewById(R.id.img);

        btnStart1.setVisibility(View.GONE);
        btnStop1.setVisibility(View.GONE);
        btnStart2.setVisibility(View.GONE);
        btnStop2.setVisibility(View.GONE);
        btnStart3.setVisibility(View.GONE);
        btnStop3.setVisibility(View.GONE);
        btnSave.setVisibility(View.GONE);
        btnReserch.setVisibility(View.GONE);
        et.setVisibility(View.GONE);
        tv1.setVisibility(View.GONE);
        tv2.setVisibility(View.GONE);
        tv3.setVisibility(View.GONE);
        tv4.setVisibility(View.GONE);
        img.setVisibility(View.GONE);

        sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sc.isChecked() == true) {
                    btnStart1.setVisibility(View.VISIBLE);
                    btnStop1.setVisibility(View.VISIBLE);
                    btnStart2.setVisibility(View.VISIBLE);
                    btnStop2.setVisibility(View.VISIBLE);
                    btnStart3.setVisibility(View.VISIBLE);
                    btnStop3.setVisibility(View.VISIBLE);
                    btnReserch.setVisibility(View.VISIBLE);
                    tv4.setVisibility(View.VISIBLE);
                    et.setVisibility(View.VISIBLE);
                } else {
                    btnStart1.setVisibility(View.GONE);
                    btnStop1.setVisibility(View.GONE);
                    btnStart2.setVisibility(View.GONE);
                    btnStop2.setVisibility(View.GONE);
                    btnStart3.setVisibility(View.GONE);
                    btnSave.setVisibility(View.GONE);
                    btnStop3.setVisibility(View.GONE);
                    btnReserch.setVisibility(View.GONE);
                    tv1.setVisibility(View.GONE);
                    tv2.setVisibility(View.GONE);
                    tv3.setVisibility(View.GONE);
                    img.setVisibility(View.GONE);
                    tv4.setVisibility(View.GONE);
                    et.setVisibility(View.GONE);
                }
            }
        });


        btnStart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lovesickgirl.start();
                tv1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.VISIBLE);
                tv3.setVisibility(View.VISIBLE);
                img.setVisibility(View.VISIBLE);
                btnSave.setVisibility(View.VISIBLE);
                img.setImageResource(R.drawable.lovesickgrils);
                tv1.setText("가수: 블랙핑크");
                tv2.setText("제목: LoveSick Girls");
                tv3.setText("발매일: 2020-10-02");

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            String title = "첫번째_음악_정보";
                            FileOutputStream outFs = openFileOutput(title + ".txt", Context.MODE_PRIVATE);

                            String text = "[" + title + "]\n\n" + tv1.getText().toString() + "\n" +
                                    tv2.getText().toString() + "\n" + tv3.getText().toString();
                            outFs.write(text.getBytes());

                            outFs.close();
                            Toast.makeText(getApplicationContext(), "파일이 생성 되었습니다.", Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                        }
                    }
                });
            }
        });

        btnStop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lovesickgirl.pause();
                tv1.setVisibility(View.GONE);
                tv2.setVisibility(View.GONE);
                tv3.setVisibility(View.GONE);
                img.setVisibility(View.GONE);
                btnSave.setVisibility(View.GONE);
            }
        });

        btnStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oldsong.start();
                tv1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.VISIBLE);
                tv3.setVisibility(View.VISIBLE);
                img.setVisibility(View.VISIBLE);
                btnSave.setVisibility(View.VISIBLE);
                img.setImageResource(R.drawable.oldsong);
                tv1.setText("가수: 스탠딩에그");
                tv2.setText("제목: 오래된 노래");
                tv3.setText("발매일: 2020-09-04");


                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            String title = "두번째_음악_정보";
                            FileOutputStream outFs = openFileOutput(title + ".txt", Context.MODE_PRIVATE);

                            String text = "[" + title + "]\n\n" + tv1.getText().toString() + "\n" +
                                    tv2.getText().toString() + "\n" + tv3.getText().toString();
                            outFs.write(text.getBytes());

                            outFs.close();
                            Toast.makeText(getApplicationContext(), "파일이 생성 되었습니다.", Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                        }
                    }
                });
            }
        });

        btnStop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oldsong.pause();
                tv1.setVisibility(View.GONE);
                tv2.setVisibility(View.GONE);
                tv3.setVisibility(View.GONE);
                img.setVisibility(View.GONE);
                btnSave.setVisibility(View.GONE);
            }
        });

        btnStart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starofthenightsky.start();
                tv1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.VISIBLE);
                tv3.setVisibility(View.VISIBLE);
                img.setVisibility(View.VISIBLE);
                btnSave.setVisibility(View.VISIBLE);
                img.setImageResource(R.drawable.starofnightsky);
                tv1.setText("가수: 경서");
                tv2.setText("제목: 밤하늘의 별을(2020)");
                tv3.setText("발매일: 2020-11-14");


                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            String title = "세번째_음악_정보";
                            FileOutputStream outFs = openFileOutput(title + ".txt", Context.MODE_PRIVATE);

                            String text = "[" + title + "]\n\n" + tv1.getText().toString() + "\n" +
                                    tv2.getText().toString() + "\n" + tv3.getText().toString();
                            outFs.write(text.getBytes());

                            outFs.close();
                            Toast.makeText(getApplicationContext(), "파일이 생성 되었습니다.", Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                        }
                    }
                });
            }
        });

        btnStop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starofthenightsky.pause();
                tv1.setVisibility(View.GONE);
                tv2.setVisibility(View.GONE);
                tv3.setVisibility(View.GONE);
                img.setVisibility(View.GONE);
                btnSave.setVisibility(View.GONE);
            }
        });

        btnReserch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String str = et.getText().toString();
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                startActivity(mIntent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}