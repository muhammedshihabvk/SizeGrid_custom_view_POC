package com.shabs.sizegridpoc;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomTextView extends View {

    private int dividerColor;
    private Paint paint;
    private int lineSize;

    public CustomTextView(Context context) {
        super(context);
        init(null);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }


    private void init(@Nullable AttributeSet set) {

        if (set == null)
            return;
        TypedArray typedArray = getContext().obtainStyledAttributes(set, R.styleable.CustomTextView);

        dividerColor = typedArray.getColor(R.styleable.CustomTextView_set_line_color, Color.BLACK);
        lineSize = typedArray.getInteger(R.styleable.CustomTextView_set_line_width,3);

        paint = new Paint();
        paint.setColor(dividerColor);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(Float.parseFloat(String.valueOf(lineSize)));

        typedArray.recycle();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0, getHeight(), getWidth(), 0, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
    }
}
