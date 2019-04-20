package com.dy.qxjhutil.util.image;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.dy.qxjhutil.R;

import java.lang.annotation.Target;


public class ImageLoaderUtil {
    static ImageLoaderUtil instance;

    public ImageLoaderUtil() {
    }

    public static ImageLoaderUtil getInstance() {
        if (null == instance) {
            synchronized (ImageLoaderUtil.class) {
                if (null == instance) {
                    instance = new ImageLoaderUtil();
                }
            }
        }
        return instance;
    }

    /**
     * 普通加载
     *
     * @param context
     * @param url
     * @param imageView
     */
    public void loadImage(Context context, @Nullable String url, @Nullable ImageView imageView) {
        if (imageView == null) {
            LogUtils.e("ImageView 为null");
            return;
        }
        if (!TextUtils.isEmpty(url) && url.length() > 0) {
            RequestOptions options = new RequestOptions()
                    .centerCrop()
//                .placeholder(R.drawable.qmui_icon_notify_error)
                    .error(R.drawable.qmui_icon_notify_error);
            Glide.with(context).load(url).apply(options).into(imageView);
        } else {
            imageView.setImageResource(R.drawable.qmui_icon_notify_error);
        }
    }

    /**
     * 普通加载
     *
     * @param context
     * @param url
     * @param imageView
     */
    public void loadImage(Context context, @Nullable String url, @DrawableRes int error, @Nullable ImageView imageView) {
        if (imageView == null) {
            LogUtils.e("ImageView 为null");
            return;
        }
        if (!TextUtils.isEmpty(url) && url.length() > 0) {
            RequestOptions options = new RequestOptions()
                    .centerCrop()
//                .placeholder(R.drawable.qmui_icon_notify_error)
                    .error(error);
//                    .error(R.drawable.qmui_icon_notify_error);
            Glide.with(context).load(url).apply(options).into(imageView);
        } else {
            imageView.setImageResource(error);
        }
    }

    /**
     * 加载圆形图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public void loadCircleImage(Context context, @Nullable String url, @Nullable ImageView imageView) {
        if (imageView == null) {
            LogUtils.e("ImageView 为null");
            return;
        }
        if (!TextUtils.isEmpty(url) && url.length() > 0) {
            RequestOptions options = new RequestOptions()
                    .circleCrop()
//                .placeholder(R.drawable.qmui_icon_notify_error)
                    .error(R.drawable.qmui_icon_notify_error);
            Glide.with(context).load(url).apply(options).into(imageView);
        } else {
            imageView.setImageResource(R.drawable.qmui_icon_notify_error);
        }
    }

    /**
     * 加载圆角图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public void loadRoundImage(Context context, @Nullable String url, @Nullable ImageView imageView) {
        if (imageView == null) {
            LogUtils.e("ImageView 为null");
            return;
        }
        if (!TextUtils.isEmpty(url) && url.length() > 0) {
            RequestOptions options = RequestOptions
                    .bitmapTransform(new RoundedCorners(20))
//                .placeholder(R.drawable.qmui_icon_notify_error)
                    .error(R.drawable.qmui_icon_notify_error);

            Glide.with(context).load(url).apply(options).into(imageView);
        } else {
            imageView.setImageResource(R.drawable.qmui_icon_notify_error);
        }
    }


    public void loadBitmapImage(Context context, @Nullable String url, Target target) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        if (!TextUtils.isEmpty(url) && url.length() > 0) {
            Glide.with(context)
                    .asBitmap()
                    .load(url)
                    .into((ImageView) target);
        } else {
            ToastUtils.showLong("图片地址为空");
            return;
        }

    }
}