package com.example.excilys.exercice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by excilys on 05/04/16.
 */
public class ParlezVousView extends SurfaceView
{

    Paint paint = new Paint();
    private List<Circle> circleList;

    Circle tmp;
    Boolean dragTmp;

    public ParlezVousView(Context context, AttributeSet attrs) {
        super(context, attrs);
        circleList = new LinkedList<>();
        dragTmp =false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.MAGENTA);

        for (Circle circle: circleList) {
            canvas.drawCircle(circle.getX(), circle.getY(), circle.getRadius(), paint);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                tmp = new Circle(0,0);
                tmp.setX(event.getX());
                tmp.setY(event.getY());

                dragTmp=false;

                for (Circle circle: circleList) {
                    if (circle.isInside(tmp)) {
                        tmp = circle;
                        dragTmp = true;

                    }
                }

                if (!dragTmp)  circleList.add(tmp);
                postInvalidate();
                break;

            case MotionEvent.ACTION_MOVE:
                tmp.setX(event.getX());
                tmp.setY(event.getY());
                postInvalidate();
                break;

        }

        return true;
    }

}
