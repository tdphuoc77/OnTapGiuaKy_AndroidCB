package com.example.ontapgiuaky;

import android.widget.ImageView;
import android.widget.TextView;

public class ItemChar {
    private int img;
    private String tvName;
    private double tvPrice;
    private String tvMoTa;

    @Override
    public String toString() {
        return "ItemChar{" +
                "img=" + img +
                ", tvName='" + tvName + '\'' +
                ", tvPrice=" + tvPrice +
                ", tvMoTa='" + tvMoTa + '\'' +
                '}';
    }

    public ItemChar(int img, String tvName, double tvPrice, String tvMoTa) {
        this.img = img;
        this.tvName = tvName;
        this.tvPrice = tvPrice;
        this.tvMoTa = tvMoTa;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public double getTvPrice() {
        return tvPrice;
    }

    public void setTvPrice(double tvPrice) {
        this.tvPrice = tvPrice;
    }

    public String getTvMoTa() {
        return tvMoTa;
    }

    public void setTvMoTa(String tvMoTa) {
        this.tvMoTa = tvMoTa;
    }
}
