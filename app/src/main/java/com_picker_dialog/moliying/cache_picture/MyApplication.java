package com_picker_dialog.moliying.cache_picture;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * Created by Administrator on 2016/8/8.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //使用默认的配置参数并加载
        ImageLoaderConfiguration configuration=ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(configuration);
        //自定义配置参数并加载————使用ImageLoaderConfiguration.Builder构建
//        ImageLoaderConfiguration.Builder builder=new ImageLoaderConfiguration.Builder(this);
//        File cacheDir = StorageUtils.getCacheDirectory(this);
//        builder.memoryCacheExtraOptions(480, 800);
//        builder.diskCacheExtraOptions(480, 800, null);
//        builder.threadPoolSize(3);
//        builder.threadPriority(Thread.NORM_PRIORITY - 2);
//        builder.memoryCache(new LruMemoryCache(2 * 1024 * 1024));
//        builder.memoryCacheSize(2 * 1024 * 1024);
//        builder.diskCache(new UnlimitedDiskCache(cacheDir));
//        builder.diskCacheSize(50 * 1024 * 1024);
//        builder.diskCacheFileCount(100);
//        builder.writeDebugLogs();
//        ImageLoaderConfiguration configuration=builder.build();
//        ImageLoader.getInstance().init(configuration);






        Fresco.initialize(this);
    }
}
