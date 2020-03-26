package com.example.autoriz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;


import com.example.autoriz.Blank1;
import com.example.autoriz.Blank2;


public class Frag extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_fragment);
    }
        public void Change (View view) {
            Fragment fragment = null;
            switch (view.getId()) {
                case R.id.button4:
                    fragment = new Blank1();
                    break;
                case R.id.button5:
                    fragment = new Blank2();
                    break;
            }
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentos, fragment);
            ft.commit();
            }
        }

