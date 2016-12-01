package com.anwesome.uiview.clockloader;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by anweshmishra on 01/12/16.
 */
public class Clock {
    private int a = 0, b = 0;
    private int mode = 0;
    public void draw(Canvas canvas, Paint paint) {
        int w = canvas.getWidth(), h = canvas.getHeight();
        int radius = w/3;
        if(w>h) {
            radius = h/3;
        }
        paint.setColor(Color.parseColor(LibConstants.CLOCK_COLOR));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(15);
        canvas.drawCircle(w/2,h/2,radius,paint);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        canvas.translate(w/2,h/2);
        int startAngle = a,endAngle = 360-a;
        if(mode == 1) {
            startAngle = 0;
            endAngle = b;
        }
        canvas.drawArc(new RectF(-radius,-radius,radius,radius),startAngle,endAngle,true,paint);
        canvas.restore();
    }
    public void move() {
        switch (mode) {
            case 0:
                a+=LibConstants.SWEEP_SPEED;
                if(a == 360) {
                    mode = 1;
                    b = 0;
                }
                break;
            case 1:
                b+=LibConstants.SWEEP_SPEED;
                if(b == 360) {
                    mode = 0;
                    a = 0;
                }
                break;
            default:
                break;
        }
    }
}
