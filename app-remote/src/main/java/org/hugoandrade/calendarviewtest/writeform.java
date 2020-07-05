package org.hugoandrade.calendarviewtest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class writeform extends AppCompatActivity {

    private final int GET_GALLERY_IMAGE = 200;
    private ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writeform);


        ImageView backbutton = (ImageView) findViewById(R.id.backb);
        backbutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                onBackPressed();
            }
        });

        imageview= (ImageView) findViewById(R.id.addimg);
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




    }

    //이미지 불러오기
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri selectedImageUri = data.getData();
            imageview.setImageURI(selectedImageUri);

        }
    }

    public void saveData(View view)
    {
        EditText editText = (EditText) findViewById(R.id.edit);
        String strSaveData = editText.getText().toString();

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.savedata_private_key), strSaveData);
        editor.commit();

        TextView textView = (TextView) findViewById(R.id.save_text_view);
        textView.setText(strSaveData);
    }


}
