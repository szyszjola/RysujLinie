package pl.iteger.rysuj;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jolanta.szyszkiewicz on 2017.11.08.
 */

public class mojWidok extends View {

    Paint pedzel = new Paint();
    Paint pedzel_up = new Paint();
    Paint pedzel_move = new Paint();
    Paint pedzel_new = new Paint();
    float touch_x;
    float touch_y;
    float touch_up_x;
    float touch_up_y;
    float touch_move_x;
    float touch_move_y;
    float touch_new_x;
    float touch_new_y;


    public void setDownX(float x) {
        touch_x = x;
    }

    public void setDownY(float y) {
        touch_y = y;
    }

    public void setMoveX(float x) {
        touch_move_x = x;
    }

    public void setMoveY(float y) {
        touch_move_y = y;
    }

    public void setUpX(float x) {
        touch_up_x = x;
    }

    public void setUpY(float y) {
        touch_up_y = y;
    }

    public void setNewLine(float x, float y) {
        touch_new_x = x;
        touch_new_y = y;
    }

    public mojWidok(Context context) {
        super(context);
        WlasciwosciPedzla(context);
    }

    public mojWidok(Context context, AttributeSet attrs) {
        super(context, attrs);

        WlasciwosciPedzla(context);
    }

    public mojWidok(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        WlasciwosciPedzla(context);
    }

    public void WlasciwosciPedzla(Context context)
    {
        pedzel.setColor(Color.MAGENTA);
        pedzel.setStrokeWidth(2);
        pedzel.setAntiAlias(true);
        pedzel.setTextSize(25);
        pedzel_up.setColor(Color.BLUE);
        pedzel_up.setStrokeWidth(4);
        pedzel_move.setColor(Color.GREEN);
        pedzel_move.setStrokeWidth(3);
        pedzel_new.setColor((Color.YELLOW));
        pedzel_new.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.TRANSPARENT);
//        canvas.drawLine(5, 5, touch_x, touch_y, pedzel);
      //  canvas.drawLine(touch_x, touch_y, touch_up_x, touch_up_y, pedzel_up);
       canvas.drawLine(touch_x, touch_y, touch_move_x, touch_move_y, pedzel_move);
        canvas.drawCircle(touch_new_x, touch_new_y, 20, pedzel_new);
    }



}
