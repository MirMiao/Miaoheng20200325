package com.bw.miaoheng20200325;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class MainActivity extends AppCompatActivity {

    private SimpleDraweeView simpleDraweeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleDraweeView = findViewById(R.id.sim);
      /* ImageView iv_head = findViewById(R.id.iv_head);

        Glide.with(this).load(headPic)
                .circleCrop()
                .into(iv_head);*/
        String headPic = getIntent().getStringExtra("headPic");
        Uri parse = Uri.parse(headPic);
        ImageRequest build = ImageRequestBuilder.newBuilderWithSource(parse)
                .setProgressiveRenderingEnabled(true).build();//设置渐进渲染已开启
        AbstractDraweeController build1 = Fresco.newDraweeControllerBuilder()
                .setImageRequest(build)
                .build();
        simpleDraweeView.setController(build1);
    }
}
