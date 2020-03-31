package com.example.autoriz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class writeRead extends AppCompatActivity {

    private Button read;
    private Button write;
    private TextView txt_show;
    private EditText txt_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_read);

        read = (Button)findViewById(R.id.readBt);
        write = (Button)findViewById(R.id.writeBt);
        txt_edit = (EditText)findViewById(R.id.editText);
        txt_show = (TextView)findViewById(R.id.textV);
        buttonWR();
    }

    public void buttonWR () {

        read.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       readTxt();
                    }
                }
        );
        write.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        writeTxt();
                    }
                }
        );
    }
//чтение текса из файла
    public void readTxt () {
        try {
            InputStream fileInput = openFileInput("example.txt");
            InputStreamReader reader = new InputStreamReader(fileInput);
            BufferedReader buffer = new BufferedReader(reader);
            StringBuffer strBuffer = new StringBuffer();
            String lines;
            while ((lines = buffer.readLine()) != null) //цикл
            {
            strBuffer.append(lines).append("\n");
            }
            txt_show.setText(strBuffer);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    //запись текста в файл
    public void writeTxt () {
        String mytxt = txt_edit.getText().toString();
        try {
                FileOutputStream fileOutputOn = openFileOutput("example.txt", MODE_PRIVATE);
                fileOutputOn.write(mytxt.getBytes());
                fileOutputOn.close();
                txt_edit.setText("");
            Toast.makeText(writeRead.this,"Текст сохранен", Toast.LENGTH_LONG).show();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
