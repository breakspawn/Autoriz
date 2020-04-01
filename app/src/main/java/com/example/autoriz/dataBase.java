package com.example.autoriz;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class dataBase extends AppCompatActivity
{

    private SlidrInterface slide1;
    private Button dbButton;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
        slide1 = Slidr.attach(this);
        dbButton = (Button)findViewById(R.id.dbSelectButton);


        dbButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                    }
                }
        );
    }

}