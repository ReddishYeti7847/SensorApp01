package com.example.user.sensorapp01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CanvasView extends View {
    private Paint paint;
    private float posX, posY;

    public CanvasView(Context con, AttributeSet as){
        super(con, as);

        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawColor(Color.BLACK);

        float cx = canvas.getWidth() / 2;
        float cy = canvas.getHeight() / 2;

        paint.setColor(Color.CYAN);
        canvas.drawCircle(cx + posX, cy + posY, 50, paint);
    }

    public void setPos(float x, float y){
        posX = x * -20;
        posY = y * 20;

        invalidate();   //再描画
    }
}
