package com.example.autoriz;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private ImageView img;  //назнаение переменных
    private EditText email;
    private EditText pass;
    private Button enter;
    private Button registr;
    private Button  frag;
    private Button auto;
    private Button so;
    private Button wrbt;
    private Button browseButton;
    private Button testButton;
    private ImageView bomzh;
    private MediaPlayer bomzhSound;

    private static final String email_txt = "1";
    private static final String pass_txt  = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login();
    }

    public void login ()
    {


        email = (EditText)findViewById(R.id.Email);   //назаначение id кнопок
    pass = (EditText)findViewById(R.id.Password);
    enter = (Button)findViewById(R.id.Enter);
    registr = (Button)findViewById(R.id.Registr);
    //img = (ImageView)findViewById(R.id.Back);
    frag = (Button)findViewById(R.id.Fragment);
    auto = (Button)findViewById(R.id.empt);
    so = (Button)findViewById(R.id.soundBt);
    wrbt = (Button)findViewById(R.id.writebutton2);
    browseButton = (Button)findViewById(R.id.browserButton);
    testButton = (Button) findViewById(R.id.TestBT);

    bomzh = (ImageView)findViewById(R.id.bomzh);
    bomzhSound = MediaPlayer.create(this,R.raw.murloc);




        bomzh.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bomzhSound.start();
                        Toast.makeText(MainActivity.this, "Вы напугали деда", Toast.LENGTH_SHORT).show();

                    }
                }
        );
                        enter.setOnClickListener(
                                new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View v)
                                    {
                                        if (email_txt.equals(String.valueOf(email.getText())) && pass_txt.equals(String.valueOf(pass.getText()))) {
                                            Intent intent = new Intent("com.example.autoriz.Empty");
                                        startActivity(intent);
                                            Toast.makeText(MainActivity.this, "Верный пароль",
                                                    Toast.LENGTH_LONG
                                            ).show();
                                        }
                                         else
                                        {
                                            Toast.makeText(MainActivity.this, "Неверный пароль",
                                                    Toast.LENGTH_LONG
                                            ).show();
                                        }
                                    }
                               }
                        );
                        registr.setOnClickListener(
                                new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View v)
                                    {
                                        Toast.makeText(MainActivity.this, "Успешная регистрация",
                                                Toast.LENGTH_LONG
                                        ).show();
                                    }

                                }
                        );
            frag.setOnClickListener(
                    new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            Intent intent = new Intent("com.example.autoriz.Frag");
                            startActivity(intent);
                        }
                    }
            );
            auto.setOnClickListener(
                    new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
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
            browseButton.setOnClickListener(
                    new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            Intent intent = new Intent("com.example.autoriz.browser");
                            startActivity(intent);
                        }
                    }
            );
            testButton.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                             Intent intent = new Intent("com.example.autoriz.testprog");
                             startActivity(intent);
                            }

                    }
            );
        }
    }



