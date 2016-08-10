package com_picker_dialog.moliying.cache_picture;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    SimpleDraweeView draweeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.imageView);
        draweeView = (SimpleDraweeView) findViewById(R.id.draweeView);
    }
    public void load_pic(View view){
        String imageUrl="http://imgsrc.baidu.com/forum/w%3D580/sign=2184db6dbb12c8fcb4f3f6c5cc0292b4/75146f81800a19d8ef312d4831fa828ba71e46fc.jpg";
        //第一种方式：loadImage加载图片
        ImageSize mImageSize = new ImageSize(100, 100);
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        ImageLoader.getInstance().loadImage(imageUrl,mImageSize,options,new ImageLoadingListener(){
            public void onLoadingStarted(String imageUri,View view){}
            public void onLoadingFailed(String imageUri,View view,FailReason failReason){}
            public void onLoadingComplete(String imageUri,View view,Bitmap loadedImage){imageView.setImageBitmap(loadedImage);}
            public void onLoadingCancelled(String imageUri,View view){}
        });
        //第二种方式：displayImage加载图片
//        DisplayImageOptions options = new DisplayImageOptions.Builder()
//                .showImageOnLoading(R.mipmap.ic_launcher)
//                .showImageOnFail(R.mipmap.ic_launcher)
//                .cacheInMemory(true)
//                .cacheOnDisk(true)
//                .bitmapConfig(Bitmap.Config.RGB_565)
//                .build();
//        ImageLoader.getInstance().displayImage(imageUrl, imageView, options);
    }
    public void load_pic_picasso(View view){
        String imageUrl="http://imgsrc.baidu.com/forum/w%3D580/sign=2184db6dbb12c8fcb4f3f6c5cc0292b4/75146f81800a19d8ef312d4831fa828ba71e46fc.jpg";
        Picasso.with(this)
                .load(imageUrl)
                .into(imageView);
    }
    public void load_pic_glide(View view){
        String imageUrl="http://imgsrc.baidu.com/forum/w%3D580/sign=2184db6dbb12c8fcb4f3f6c5cc0292b4/75146f81800a19d8ef312d4831fa828ba71e46fc.jpg";
        Glide.with(this)
                .load(imageUrl)
                .into(imageView);
    }
    public void load_pic_fresco(View view){
        String imageUrl="http://imgsrc.baidu.com/forum/w%3D580/sign=2184db6dbb12c8fcb4f3f6c5cc0292b4/75146f81800a19d8ef312d4831fa828ba71e46fc.jpg";
        draweeView.setImageURI(Uri.parse(imageUrl));
    }
}
