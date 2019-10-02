package com.example.diceout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import java.io.IOException;
import java.io.InputStream;

public class DieView extends android.support.v7.widget.AppCompatImageView {

    public class Card
    {
        private int type, value;
        private String[] cardType = {"clubs", "spades", "diamonds", "hearts"};
        private String[] cardValue = {"ace", "two", "three", "four","five", "six", "seven", "eight",
                "nine", "ten", "jack",  "queen","king"};

        public Card(int types, int values)
        {
            type = types;
            value = values;
        }

        public String toString()
        {
            String finalCard = cardValue[value] + "_of_" + cardType[type];

            return finalCard;
        }
    }

    private int value,type;
    private Context context;
    Card draw;
    String newcard;
    public DieView(Context context) {
        super(context);
        init(context);
    }

    public DieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setImageResource(R.drawable.red_joker);
        this.context = context;
    }

    public void roll() {
        value = (int) ((Math.random() * 13));
        type = (int) (Math.random()*4);

        draw = new Card(type,value);

        newcard = draw.toString();

        try {
            InputStream stream = context.getAssets().open(newcard+".png");
            Drawable d = Drawable.createFromStream(stream,null);
            setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getValue() {
        return value+1;
    }
}
