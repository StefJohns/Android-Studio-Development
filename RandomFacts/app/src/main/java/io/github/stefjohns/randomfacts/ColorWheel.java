package io.github.stefjohns.randomfacts;

import android.graphics.Color;

import java.util.Random;

public class ColorWheel {
    // Fields or Member Variables
    String[] colors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7", // light gray
            "#965264", // soft rose
            "#1b685b" // turquoise
    };

    // Methods
    public Integer getColor() {
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(colors.length);
        int colorAsInt = Color.parseColor(colors[randomNumber]);
        return colorAsInt;
    };
}
