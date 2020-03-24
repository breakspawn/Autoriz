package com.example.autoriz;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Empty extends AppCompatActivity {

   private ListView list;
   private String[] names = new String[] {"John", "Alex", "Max", "Bob"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

       list = (ListView) findViewById(R.id.activ);

        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, R.layout.activ, names);
        list.setAdapter(adapter);

        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View v, int i, long l) {
                        String val = Long.toString(list.getItemIdAtPosition(i));
                        Toast.makeText(Empty.this, "Позиция" + i + ", значение" + val,
                                Toast.LENGTH_LONG
                        ).show();

                    }
                }
        );
    }

}
//володя хуй  пися