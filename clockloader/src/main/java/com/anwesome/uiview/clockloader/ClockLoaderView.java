package com.anwesome.uiview.clockloader;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by anweshmishra on 01/12/16.
 */
public class ClockLoaderView extends View {
    private Clock clock = new Clock();
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public ClockLoaderView(Context context) {
        super(context);
    }
    public void onDraw(Canvas canvas) {
        canvas.drawColor(LibConstants.OPAQUE_COLOR);
        clock.draw(canvas,paint);
        clock.move();
        try {
            Thread.sleep(LibConstants.DELAY);
            invalidate();
        }
        catch (Exception ex) {

        }
    }
}
