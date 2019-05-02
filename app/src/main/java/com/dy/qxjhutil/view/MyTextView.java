package com.dy.qxjhutil.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by Dy on 2019/5/1 22
 *
 * @author Dy
 */
public class MyTextView extends android.support.v7.widget.AppCompatTextView {

    public MyTextView(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("kttext.ttf", context);
        setTypeface(customFont);
//        TextPaint textPaint = this.getPaint();
//        textPaint.setFakeBoldText(true);
    }

}
