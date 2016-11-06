package com.abilash.databinding;

/**
 * Created by Abilash on 11/6/2016.
 */

public class CardItem {
    private String imageUrl;
    private String tittle;
    private String desc;

    CardItem(String imageUrl, String desc) {
        this.imageUrl = imageUrl;
        this.desc = desc;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
