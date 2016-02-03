package com.example.demo.basicui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView greeting;
    SeekBar opacityController;
    Switch textSwitch;
    String altText;
    String orgText;
    Boolean textState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orgText="Hello Tulsa Tech!";
        altText="Thanks for looking!";
        textState=true;

        opacityController = (SeekBar)findViewById(R.id.opacityBar);
        opacityController.setProgress(255);

        greeting= (TextView)findViewById(R.id.greetingText);
        textSwitch = (Switch) findViewById(R.id.textSwitch);

        opacityController.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        greeting.setAlpha(progress / 255f);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );


        textSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textState){
                    greeting.setText(altText);
                    textState=false;
                }else{
                    greeting.setText(orgText);
                    textState=true;
                }
            }
        });
    }
}
