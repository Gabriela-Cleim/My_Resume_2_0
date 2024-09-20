package com.example.mycv;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

public class Typewriter extends androidx.appcompat.widget.AppCompatTextView {

    private CharSequence text;
    private int index;
    private long delay = 100;

    public Typewriter(Context context) {
        super(context);
    }

    public Typewriter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            setText(text.subSequence(0, index++));

            if(index <= text.length()){
                handler.postDelayed(runnable, delay);
            }
        }
    };

    public void animateText(CharSequence mtext){
        text = mtext;
        index = 0;
        setText("");
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, delay);
    }
    public void setCharacterDelay(long d){
        delay = d;
    }
}
