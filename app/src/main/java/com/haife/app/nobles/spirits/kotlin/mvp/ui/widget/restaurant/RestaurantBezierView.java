package com.haife.app.nobles.spirits.kotlin.mvp.ui.widget.restaurant;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/25$
 * TODO:
 */
public class RestaurantBezierView extends View {
    private Point controlPoint = new Point(200, 200);

    public RestaurantBezierView(@NonNull Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
    }

    public RestaurantBezierView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.WHITE);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);

    }


    @Override
    public void onDraw(Canvas c) {
        super.onDraw(c);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(1);
        Path path = new Path();
        path.quadTo(getMeasuredWidth() / 2, getMeasuredHeight(), getMeasuredWidth(), 0);
        c.drawPath(path, paint);
    }
}
