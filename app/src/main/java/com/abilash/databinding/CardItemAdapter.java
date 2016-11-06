package com.abilash.databinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.abilash.databinding.databinding.CardItemBinding;

import java.util.List;

/**
 * Created by Abilash on 11/6/2016.
 */

public class CardItemAdapter extends RecyclerView.Adapter<CardItemAdapter.BindingHolder> {

    private List<CardItem> mCardItems;
    private Context mContext;


    public CardItemAdapter(List<CardItem> cardItems, Context context) {
        mCardItems = cardItems;
        mContext = context;
    }


    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.card_item, parent, false);
        return new BindingHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        CardItemBinding binding = holder.cardItemBinding;
        binding.setCardVm(new CardViewModel(getItem(position), mContext));

    }

    @Override
    public int getItemCount() {
        return mCardItems.size();
    }

    public CardItem getItem(int position) {
        return mCardItems.get(position);
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private CardItemBinding cardItemBinding;

        BindingHolder(CardItemBinding cardItemBinding) {
            super(cardItemBinding.getRoot());
            this.cardItemBinding = cardItemBinding;
        }
    }
}
