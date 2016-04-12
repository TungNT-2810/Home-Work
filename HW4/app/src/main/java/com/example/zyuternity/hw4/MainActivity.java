package com.example.zyuternity.hw4;

import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button showAll, hideAll, redClose, blueClose, greenClose;
    RelativeLayout red, blue, green;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        widgetsValue();
    }

    public void widgetsValue(){
        showAll = (Button) findViewById(R.id.showAll);
        hideAll = (Button) findViewById(R.id.hideAll);
        redClose = (Button) findViewById(R.id.redClose);
        blueClose = (Button) findViewById(R.id.blueClose);
        greenClose = (Button) findViewById(R.id.greenClose);
        red = (RelativeLayout) findViewById(R.id.redLayout);
        blue = (RelativeLayout) findViewById(R.id.blueLayout);
        green = (RelativeLayout) findViewById(R.id.greenLayout);
        showAll.setOnClickListener(this);
        hideAll.setOnClickListener(this);
        redClose.setOnClickListener(this);
        blueClose.setOnClickListener(this);
        greenClose.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.showAll:
                red.setVisibility(View.VISIBLE);
                blue.setVisibility(View.VISIBLE);
                green.setVisibility(View.VISIBLE);
                break;
            case R.id.blueClose:
                blue.setVisibility(View.GONE);
                break;
            case R.id.greenClose:
                green.setVisibility(View.GONE);
                break;
            case R.id.redClose:
                red.setVisibility(View.GONE);
                break;
            case R.id.hideAll:
                blue.setVisibility(View.GONE);
                green.setVisibility(View.GONE);
                red.setVisibility(View.GONE);
                break;
        }
    }
}
