package com.abilash.databinding;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Abilash on 11/6/2016.
 */

public class CardViewModel extends BaseObservable {
    private CardItem mCardItem;
    private Context mContext;

    public CardViewModel(CardItem cardItem, Context context) {
        mCardItem = cardItem;
        mContext = context;
    }

    @BindingAdapter({"image"})
    public static void loadImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
    }

    @Bindable
    public String getDesc() {
        return mCardItem.getDesc();
    }

    @Bindable
    public String getImageUrl() {
        return mCardItem.getImageUrl();
    }
}
