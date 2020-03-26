package com.example.autoriz;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Empty extends AppCompatActivity {

    private SeekBar seek; //ползунок
    private ListView list; //текст
    private String[] names = new String[] {"John", "Alex", "Max", "Bob"}; //массив имен для текста

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        list = (ListView) findViewById(R.id.activ);
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, R.layout.activ, names); //назночение массива для тектса
        list.setAdapter(adapter);
        seek = (SeekBar)findViewById(R.id.seekBar); //ползунок переменная seek

        
        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View v, int i, long l) { //считывание кнопок
                        String id = Long.toString(list.getItemIdAtPosition(i)); //превод символов в строку
                        String name = (String) list.getItemAtPosition(i); //позиции для строк

                        //вывод в тост
                        Toast.makeText(Empty.this, "В списке: " + Integer.toString(i+1) + "\n ID элемента: " + id + "\n Имя: " + name
                                        + ", прогресс" + seek.getProgress(), //считывание положения ползунка SeekBar
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        );
    }

}
