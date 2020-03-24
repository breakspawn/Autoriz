package com.example.autoriz;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Empty extends AppCompatActivity {

   private ListView list;
   private String[] names = new String[] {"John", "Alex", "Max", "Bob"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        list = (ListView) findViewById(R.id.activ);
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, R.layout.support_simple_spinner_dropdown_item, names);
        list.setAdapter(adapter);

        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View v, int i, long l) {
                        String id = Long.toString(list.getItemIdAtPosition(i));
                        String name = (String) list.getItemAtPosition(i);

                        Toast.makeText(Empty.this, "В списке: " + Integer.toString(i+1) + "\n ID элемента: " + id + "\n Имя: " + name,
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        );
    }

}
//володя хуй  пися