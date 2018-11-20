package com.example.doubl.moodtrack.model;

import com.example.doubl.moodtrack.R;

public enum MoodEnum {
    SUPPER_HAPPY (R.drawable.smiley_super_happy, R.color.banana_yellow),
    HAPPY (R.drawable.smiley_happy, R.color.light_sage),
    NORMAL (R.drawable.smiley_normal, R.color.cornflower_blue_65),
    DISAPPOINTED(R.drawable.smiley_disappointed, R.color.warm_grey),
    SAD (R.drawable.smiley_sad, R.color.faded_red);



    private int DrawableIcone;
    private int ColorBakground;
    MoodEnum(int Drawableicone, int ColorBakground) {
        this.ColorBakground= ColorBakground;
        this.DrawableIcone = Drawableicone;
    }

    public int getDrawableIcone() {
        return DrawableIcone;
    }

    public int getColorBakground() {
        return ColorBakground;
    }
}

// identifier les valeurs avec des noms