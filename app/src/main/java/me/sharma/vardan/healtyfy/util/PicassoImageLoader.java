package me.sharma.vardan.healtyfy.util;

import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import static me.sharma.vardan.healtyfy.core.HealthyApp.getContext;


public class PicassoImageLoader implements ImageLoader {

    @Override
    public void show(String url, ImageView imageView) {
        if (TextUtils.isEmpty(url)) url = "notavail";
        Picasso.with(getContext()).load(url)
//                .error(R.drawable.ic_placeholder)
                .into(imageView);
    }

    @Override
    public void show(List<String> urls, ImageView imageView) {
        String url = "notavail";
        if (urls != null && urls.size() > 0 && !TextUtils.isEmpty(urls.get(0))) {
            url = urls.get(0);
        }
        show(url, imageView);
    }
}
