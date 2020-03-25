package com.bw.miaoheng20200325;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv_head = findViewById(R.id.iv_head);
        String headPic = getIntent().getStringExtra("headPic");
        Glide.with(this).load(headPic)
                .circleCrop()
                .into(iv_head);
    }
}
