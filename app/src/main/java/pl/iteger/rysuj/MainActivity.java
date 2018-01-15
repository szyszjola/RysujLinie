package pl.iteger.rysuj;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    mojWidok widok;
    View.OnTouchListener Nasluchiwacz;
    GestureDetector wykrywaczGestow;
    float downX, downY, upX, upY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.moj_widok);

        widok = findViewById(R.id.mojwidokID);


        wykrywaczGestow = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            public void onLongPress(MotionEvent motionEvent) {
                widok.setNewLine(motionEvent.getX(), motionEvent.getY());
                widok.invalidate();
            }

            public boolean onScroll(MotionEvent e1, MotionEvent e2, float dX, float dY) {
                return false;
            }
        });

        Nasluchiwacz = new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        downX = motionEvent.getX();
                        downY = motionEvent.getY();
                        widok.setDownX(motionEvent.getX());
                        widok.setDownY(motionEvent.getY());
                        widok.invalidate();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        widok.setMoveX(motionEvent.getX());
                        widok.setMoveY(motionEvent.getY());
                        widok.setDownX(downX);
                        widok.setDownY(downY);
                        widok.invalidate();
                        break;
                    case MotionEvent.ACTION_UP:
                        upX = motionEvent.getX();
                        upY = motionEvent.getY();
                        widok.setDownX(downX);
                        widok.setDownY(downY);
                        widok.setUpX(motionEvent.getX());
                        widok.setUpY(motionEvent.getY());
                        widok.invalidate();

                        if (Math.abs(downX - upX) > Math.abs(downY - upY)) {
                            if (upX > downX)
                                Toast.makeText(getApplicationContext(), "Ruszyłeś w prawo!", Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(getApplicationContext(), "Ruszyłeś w lewo!", Toast.LENGTH_SHORT).show();
                        } else {
                            if (upY > downY)
                                Toast.makeText(getApplicationContext(), "Ruszyłeś w dół!", Toast.LENGTH_SHORT).show();// oś y rośnie w dół
                            else
                                Toast.makeText(getApplicationContext(), "Ruszyłeś w góre!!", Toast.LENGTH_SHORT).show();

                        } //foreach() -->  for(Coordinate coordinate :mBlocks) // po każdym elemencie tablicy

                        break;
                }

                return true;
            }
        };

        widok.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent motionEvent) {
                v.onTouchEvent(motionEvent);
                wykrywaczGestow.onTouchEvent(motionEvent);
                Nasluchiwacz.onTouch(v, motionEvent);
                return true;
            }
        });

    }


}
