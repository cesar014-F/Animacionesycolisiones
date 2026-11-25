package com.example.animacionesycolisiones;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

public class Juego extends View {

    float cx = 360, cy = 300, posx = 325, posy = 1475;
    int r = 30, time = 0, dirx = 1, diry= 1, vel = 7;

    public Juego(Context context) {
        super(context);
    }

    @Override
    protected void onDraw( Canvas canvas) {

        Paint b = new Paint();
        b.setColor(Color.parseColor("#FF6200EE"));
        b.setStrokeWidth(20);

        Rect player = new Rect((int) posx, (int) posy, (int) (posx + 100),(int) (posy +50));


        Paint p = new Paint();
        p.setARGB(255,0,255,0);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(2);

        Rect hbpelota = new Rect(Math.round(cx-50), Math.round(cy+50), Math.round(cx+50), Math.round(cy-50));

        canvas.drawRect(hbpelota, p);
        canvas.drawCircle(cx, cy, r, b);
        canvas.drawRect(player, b);

        
        time = time + 1;
        movimientobola();
        colision();
        golpe(player, hbpelota);
        invalidate();

        super.onDraw(canvas);
    }

    private void movimientobola(){
        cx += dirx*vel;
        cy += diry*vel;
    }

    private void colision(){

        if(cx >= 690) {dirx =-1;}
        if(cx <= 10) {dirx =1;}
        if(cy >= 1550) {diry =-1;}
        if(cy <= 200) {diry =1;}
    }

    private void golpe(Rect player, Rect hbpelota){

        if(player.intersect(hbpelota)){
            diry = -1;

        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            posx = event.getX();
            invalidate();
        }
        return super.onTouchEvent(event);
    }
}
