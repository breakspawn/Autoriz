package com.example.autoriz;


import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import androidx.appcompat.app.AppCompatActivity;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.io.IOException;

public class dataBase extends AppCompatActivity {

    private SlidrInterface slide1;
    private Button dbButton;
    private TextView textView;

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
        slide1 = Slidr.attach(this);
        dbButton = (Button) findViewById(R.id.dbSelectButton);
        textView = (TextView) findViewById(R.id.dbText);
//
//        mDBHelper = new DatabaseHelper(getApplicationContext());
//
//        try {
//            mDBHelper.updateDataBase();
//        } catch (IOException mIOException) {
//            throw new Error("UnableToUpdateDatabase");
//        }
//
//        try {
//            mDb = mDBHelper.getWritableDatabase();
//        } catch (SQLException mSQLException) {
//            throw mSQLException;
//        }

        //Пропишем обработчик клика кнопки
        dbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(dataBase.this, "database", Toast.LENGTH_SHORT).show();
                DataBaseWorker w = new DataBaseWorker(dataBase.this);
                String result = w.select(w.T_USERS);
                textView.setText(result);
            }
        });
    }
}
