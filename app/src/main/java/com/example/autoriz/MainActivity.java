package com.example.autoriz;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView img;  //назнаение переменных
    private EditText email;
    private EditText pass;
    private Button enter;
    private Button registr;
    private Button  frag;
    private Button auto;
    private Button so;
    private Button wrbt;

    private static final String email_txt = "1";
    private static final String pass_txt  = "1";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login();

    }








        public void login () {
    email = (EditText)findViewById(R.id.Email);   //назаначение id кнопок
    pass = (EditText)findViewById(R.id.Password);
    enter = (Button)findViewById(R.id.Enter);
    registr = (Button)findViewById(R.id.Registr);
    //img = (ImageView)findViewById(R.id.Back);
    frag = (Button)findViewById(R.id.Fragment);
    auto = (Button)findViewById(R.id.empt2);
    so = (Button)findViewById(R.id.soundbutton);
    wrbt = (Button)findViewById(R.id.writebutton2);
    

                        enter.setOnClickListener(
                                new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        if (email_txt.equals(String.valueOf(email.getText())) && pass_txt.equals(String.valueOf(pass.getText()))) {
                                            Intent intent = new Intent("com.example.autoriz.Empty");
                                        startActivity(intent);
                                            Toast.makeText(MainActivity.this, "Верный пароль",
                                                    Toast.LENGTH_LONG
                                            ).show();
                                        }

                                         else {
                                            Toast.makeText(MainActivity.this, "Неверный пароль",
                                                    Toast.LENGTH_LONG
                                            ).show();
                                        }
                                    }
                               }
                        );
                        registr.setOnClickListener(
                                new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(MainActivity.this, "Успешная регистрация",
                                                Toast.LENGTH_LONG
                                        ).show();
                                    }

                                }
                        );

            frag.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent("com.example.autoriz.Frag");
                            startActivity(intent);
                        }
                    }
            );

            auto.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent("com.example.autoriz.Empty2");
                            startActivity(intent);
                        }
                    }
            );

            so.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent("com.example.autoriz.sound");
                            startActivity(intent);
                        }
                    }
            );
            wrbt.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent("com.example.autoriz.writeRead");
                            startActivity(intent);
                        }
                    }
            );


        }


    }



