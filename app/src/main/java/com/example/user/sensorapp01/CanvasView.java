package com.example.user.sensorapp01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CanvasView extends View {
    private Paint paint;
    private float posX, posY;   //位置
    private float preXV, preYV; //一つ前の速度

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

    public void setPos(float ax, float ay){
        float dt = 4.0f;
        ax = ax * -1;

        //時間を進める処理
        posX = preXV * dt + ax * dt * dt / 2;
        preXV += ax * dt;

        posY = preYV * dt + ay * dt * dt / 2;;
        preYV += ay * dt;

        invalidate();   //再描画
    }
}
