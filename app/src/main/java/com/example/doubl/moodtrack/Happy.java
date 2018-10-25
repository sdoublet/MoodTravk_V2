package com.example.doubl.moodtrack;

import android.graphics.drawable.Drawable;


public class Happy {
    private Drawable smiley;
    private Drawable background1;

    public Happy(Drawable smiley, Drawable background1) {
        this.smiley = smiley;
        this.background1 = background1;
    }

    public Drawable getSmiley() {
        return smiley;
    }

    public void setSmiley(Drawable smiley) {
        this.smiley = smiley;
    }

    public Drawable getBackground1() {
        return background1;
    }

    public void setBackground1(Drawable background1) {
        this.background1 = background1;
    }
}
