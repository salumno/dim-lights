package com.example.salumno.dimlights;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class GameView extends SurfaceView {

    private Bitmap bitmap;

    private SurfaceHolder holder;

    public GameView(Context context) {
        super(context);
        holder = getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Canvas canvas = holder.lockCanvas(null);
                drawer(canvas);
                holder.unlockCanvasAndPost(canvas);

            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_toolbar_arrow);
    }

    protected void drawer(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(bitmap, 10, 10, null);
    }
}
