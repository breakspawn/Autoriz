package com.example.autoriz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class Empty2 extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {
    private TextView txt;    //текст определение вывод
    private GestureDetectorCompat gd; //определение нажатия тап
    private AutoCompleteTextView txt_view;  //название автокомплита
    private String [] cars = new String[] { //массив слов для автозаполнения
            "Audi",
            "Saab",
            "Ford",
            "Bmw",
            "WV",
            "Lada-gavno",
            "Dodge"
    };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_emp2);
        txt = (TextView)findViewById(R.id.field);
        gd = new GestureDetectorCompat(this, this); //определение тап на дисплей
        gd.setOnDoubleTapListener(this);
        txt_view = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);

        ArrayAdapter adapt = new ArrayAdapter(this, android.R.layout.select_dialog_item, cars); //адаптер для считывания и вывода
        txt_view.setThreshold(1);  //
        txt_view.setAdapter(adapt); //вывод автокомплита через адаптер

    }

    @Override   //запуск gd определения жестов
    public boolean onTouchEvent(MotionEvent event) {
        gd.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        txt.setText("tapconfirmed");  //просто тап
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        txt.setText("doubletap");  //двойной тап
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        txt.setText("OnlongPress");
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        txt.setText("down"); //палец прислонен
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        txt.setText("up");
        return false; //палец поднят
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }


    @SuppressLint("SetTextI10n")
    @Override
    public void onLongPress(MotionEvent e) {
        txt.setText("OnlongPress"); //длинное нажатие

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
