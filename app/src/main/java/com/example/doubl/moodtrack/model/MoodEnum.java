package com.example.doubl.moodtrack.model;

import com.example.doubl.moodtrack.R;

public enum MoodEnum {
    DISAPPOINTED(R.drawable.smiley_disappointed, R.color.faded_red),
    HAPPY (R.drawable.smiley_happy, R.color.light_sage),
    SUPPER_HAPPY (R.drawable.smiley_super_happy, R.color.banana_yellow),
    NORMAL (R.drawable.smiley_normal, R.color.cornflower_blue_65),
    SAD (R.drawable.smiley_sad, R.color.warm_grey);



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