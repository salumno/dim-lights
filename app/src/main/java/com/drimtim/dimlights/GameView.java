package com.drimtim.dimlights;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by avispa on 27/11/2016.
 */

class GameView extends View {
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Paint active, inactive;
    private Context context;
    private final GestureDetector detector;
    private Field field;
    private final int countOfCells = 5;
    private int squareLength;
    private int margin;

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.field = new Field();
        active = new Paint();
        active.setAntiAlias(true);
        active.setDither(true);
        active.setColor(Color.RED);
        active.setStrokeWidth(8);
        active.setStyle(Paint.Style.FILL);
        inactive = new Paint();
        inactive.setAntiAlias(true);
        inactive.setDither(true);
        inactive.setColor(Color.DKGRAY);
        inactive.setStrokeWidth(5f);
        inactive.setStyle(Paint.Style.FILL);

//        mBitmap = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);
//        mCanvas = new Canvas(mBitmap);
//        mBitmapPaint = new Paint(Paint.DITHER_FLAG);
        this.detector = new GestureDetector(context, new MyGestureListener());
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.save();
//        canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
//        canvas.restore();
//        canvas.drawColor(Color.WHITE);
        this.squareLength = canvas.getWidth() / 5;
        this.margin = (canvas.getHeight() - canvas.getWidth()) / 2;
        int left = 0, top = margin, bottom = top + squareLength, right = squareLength;
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (field.checkCell(j,i)) canvas.drawRect(left, top, right, bottom, active);
                else canvas.drawRect(left, top, right, bottom, inactive);
                left += squareLength;
                right += squareLength;
            }
            left = 0;
            right = squareLength;
            top += squareLength;
            bottom += squareLength;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        return true;
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            if (e.getY() < margin || e.getY() > margin + 5*squareLength) return true;
            int x = (int) e.getX() / squareLength;
            int y = (int) (e.getY() - margin) / squareLength;
            if (x >= 0 && x < 5 && y >= 0 && y < 5) field.click(x,y);
            invalidate();
            return true;
        }
    }
}


