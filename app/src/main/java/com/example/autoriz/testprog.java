package com.example.autoriz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class testprog extends AppCompatActivity
{
            private TextView textView;
            public String res;
            private Switch switchHotProperty;
            private SeekBar heightTable;
            final Pet cat = new Pet("Kitana");


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testprog);

        textView = (TextView)findViewById(R.id.textik);
        switchHotProperty = (Switch)findViewById(R.id.warmButton);
        heightTable = (SeekBar)findViewById(R.id.hightTable);

        heightTable.setOnSeekBarChangeListener(
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    cat.age = heightTable.getProgress();
                    Gson gson = new Gson();
                    textView.setText(gson.toJson(cat));
                }
            }
        );


        switchHotProperty.setOnCheckedChangeListener(
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switchHotPropertyChecked();
                }
            }
        );
    }


    void switchHotPropertyChecked ()
    {
        cat.hot = switchHotProperty.isChecked();
        Gson gson = new Gson();
        String json = gson.toJson(cat);
        textView.setText(json);
        String toastMessage;
        if (cat.hot)
        {
            toastMessage = "Подогрев включен";
        }
        else
        {
            toastMessage = "Подогрев выключен";
        }
        Toast.makeText(testprog.this, toastMessage, Toast.LENGTH_SHORT).show();
    }
}



