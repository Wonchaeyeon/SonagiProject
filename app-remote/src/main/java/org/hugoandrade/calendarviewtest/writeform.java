package org.hugoandrade.calendarviewtest;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class writeform extends AppCompatActivity {
    private SharedPreferences sp;
    private TextView mDateTextView;
    private Calendar mCalendar;
    public ImageButton ib1;
    private static final int SET_DATE_AND_TIME_REQUEST_CODE = 200;
    private final int GET_GALLERY_IMAGE = 200;
    private ImageView imageview;
    private String mDate;
    private TextView today;

    ImageButton angry, happy, hurt, crying, sleeping, heart;
    ImageButton sunshine,cloud,snow,lightning,light,wind;

    private final static SimpleDateFormat writedateFormat
            = new SimpleDateFormat("MM/dd  EEEE", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writeform);
        Intent intent = getIntent();
        mDate = intent.getStringExtra("date");

        sp = getSharedPreferences("myFile", Activity.MODE_PRIVATE);
        String diary = sp.getString(mDate +"d", "");

        angry = findViewById(R.id.angry);
        happy = findViewById(R.id.happy);
        hurt = findViewById(R.id.hurt);
        crying = findViewById(R.id.crying);
        sleeping = findViewById(R.id.sleeping);
        heart = findViewById(R.id.heart);

        sunshine = findViewById(R.id.sunshine);
        cloud = findViewById(R.id.cloud);
        snow = findViewById(R.id.snow);
        lightning = findViewById(R.id.lightning);
        light = findViewById(R.id.light);
        wind = findViewById(R.id.wind);


        if (diary != "") {
            ((EditText) findViewById(R.id.edit)).setText(diary);
        }


        ImageView backbutton = (ImageView) findViewById(R.id.backb);
        backbutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                onBackPressed();
            }
        });

        imageview = (ImageView) findViewById(R.id.addimg);
        imageview.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_GALLERY_IMAGE);
            }
        });
        imageview = (ImageView) findViewById(R.id.addimg2);
        imageview.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_GALLERY_IMAGE);
            }
        });
        imageview = (ImageView) findViewById(R.id.addimg3);
        imageview.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_GALLERY_IMAGE);
            }
        });
        imageview = (ImageView) findViewById(R.id.addimg4);
        imageview.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_GALLERY_IMAGE);
            }
        });


        ImageView tabb = (ImageView) findViewById(R.id.tabbar);
        tabb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getApplicationContext(), v);
                getMenuInflater().inflate(R.menu.menu1, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.moreimg:
                                Toast.makeText(getApplication(), "사진 불러오기 기능을 준비중입니다.", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.later:
                                Toast.makeText(getApplication(), "편지 기능을 준비중입니다.", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.category:
                                Toast.makeText(getApplication(), "카테고리 기능을 준비중입니다.", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.set:
                                Toast.makeText(getApplication(), "설정 기능을 준비중입니다.", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                        return false;

                    }
                });
                popup.show();
            }
        });
        //기분
        angry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angry.setImageResource(R.drawable.circle);
                happy.setImageResource(R.drawable.happy);
                hurt.setImageResource(R.drawable.hurt);
                crying.setImageResource(R.drawable.crying);
                sleeping.setImageResource(R.drawable.sleeping);
                heart.setImageResource(R.drawable.heart);
            }
        });
        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                happy.setImageResource(R.drawable.circle);
                angry.setImageResource(R.drawable.angry);
                hurt.setImageResource(R.drawable.hurt);
                crying.setImageResource(R.drawable.crying);
                sleeping.setImageResource(R.drawable.sleeping);
                heart.setImageResource(R.drawable.heart);
            }
        });
        hurt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hurt.setImageResource(R.drawable.circle);
                angry.setImageResource(R.drawable.angry);
                happy.setImageResource(R.drawable.happy);
                crying.setImageResource(R.drawable.crying);
                sleeping.setImageResource(R.drawable.sleeping);
                heart.setImageResource(R.drawable.heart);
            }
        });
        crying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crying.setImageResource(R.drawable.circle);
                angry.setImageResource(R.drawable.angry);
                happy.setImageResource(R.drawable.happy);
                hurt.setImageResource(R.drawable.hurt);
                sleeping.setImageResource(R.drawable.sleeping);
                heart.setImageResource(R.drawable.heart);
            }
        });
        sleeping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sleeping.setImageResource(R.drawable.circle);
                angry.setImageResource(R.drawable.angry);
                happy.setImageResource(R.drawable.happy);
                hurt.setImageResource(R.drawable.hurt);
                crying.setImageResource(R.drawable.crying);
                heart.setImageResource(R.drawable.heart);
            }
        });
        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                heart.setImageResource(R.drawable.circle);
                angry.setImageResource(R.drawable.angry);
                happy.setImageResource(R.drawable.happy);
                hurt.setImageResource(R.drawable.hurt);
                crying.setImageResource(R.drawable.crying);
                sleeping.setImageResource(R.drawable.sleeping);
            }
        });

//날씨

        sunshine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sunshine.setImageResource(R.drawable.circle);
                cloud.setImageResource(R.drawable.cloud);
                snow.setImageResource(R.drawable.snow);
                lightning.setImageResource(R.drawable.lightning);
                light.setImageResource(R.drawable.light);
                wind.setImageResource(R.drawable.wind);
            }
        });
        cloud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cloud.setImageResource(R.drawable.circle);
                sunshine.setImageResource(R.drawable.sunshine);
                snow.setImageResource(R.drawable.snow);
                lightning.setImageResource(R.drawable.lightning);
                light.setImageResource(R.drawable.light);
                wind.setImageResource(R.drawable.wind);
            }
        });snow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snow.setImageResource(R.drawable.circle);
                sunshine.setImageResource(R.drawable.sunshine);
                cloud.setImageResource(R.drawable.cloud);
                lightning.setImageResource(R.drawable.lightning);
                light.setImageResource(R.drawable.light);
                wind.setImageResource(R.drawable.wind);
            }
        });lightning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lightning.setImageResource(R.drawable.circle);
                sunshine.setImageResource(R.drawable.sunshine);
                cloud.setImageResource(R.drawable.cloud);
                snow.setImageResource(R.drawable.snow);
                light.setImageResource(R.drawable.light);
                wind.setImageResource(R.drawable.wind);
            }
        });light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                light.setImageResource(R.drawable.circle);
                sunshine.setImageResource(R.drawable.sunshine);
                cloud.setImageResource(R.drawable.cloud);
                snow.setImageResource(R.drawable.snow);
                lightning.setImageResource(R.drawable.lightning);
                wind.setImageResource(R.drawable.wind);
            }
        });wind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wind.setImageResource(R.drawable.circle);
                sunshine.setImageResource(R.drawable.sunshine);
                cloud.setImageResource(R.drawable.cloud);
                snow.setImageResource(R.drawable.snow);
                lightning.setImageResource(R.drawable.lightning);
                light.setImageResource(R.drawable.light);
            }
        });
    }


    //이미지 불러오기
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri selectedImageUri = data.getData();
            imageview.setImageURI(selectedImageUri);

        }
    }

//    public void saveData(View view)
//    {
//        EditText editText = (EditText) findViewById(R.id.edit);
//        String strSaveData = editText.getText().toString();
//
//        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putString(getString(R.string.savedata_private_key), strSaveData);
//        editor.commit();
//
//        TextView textView = (TextView) findViewById(R.id.save_text_view);
//        textView.setText(strSaveData);
//    }


    public void onClick(View v) {
        SharedPreferences.Editor editor = sp.edit();

        EditText editText = (EditText) findViewById(R.id.edit);
        String strSaveData = editText.getText().toString();


        if (v.getId() == R.id.saveBtn) {
            editor.putString("20200706f", "g111");
            editor.putString(mDate +"d", strSaveData);

            editor.commit();
            finish();
        }


    }
}


