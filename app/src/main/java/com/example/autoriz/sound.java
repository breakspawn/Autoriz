package com.example.autoriz;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class sound extends AppCompatActivity {
    private ImageView cat;
    private ImageView dog;
    private ImageView golub;
    private MediaPlayer catSound, dogSound, golubSound;
    private SlidrInterface slide;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);

        cat = (ImageView)findViewById(R.id.Cat1);
        dog = (ImageView)findViewById(R.id.Dog);
        golub = (ImageView)findViewById(R.id.Golub1);

        catSound = MediaPlayer.create(this, R.raw.cats);
        dogSound = MediaPlayer.create(this, R.raw.dogs);
        golubSound = MediaPlayer.create(this, R.raw.omae);
        slide = Slidr.attach(this);

        imageClick ();

     }

    public void soundPlay(MediaPlayer mediaPlayer) {
        mediaPlayer.start();

    }


    public void imageClick() {
        cat.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay (catSound);

                    }
                }
        );
        dog.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay (dogSound);


                    }
                }
        );
        golub.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay (golubSound);

                    }
                }
        );
    }

}
