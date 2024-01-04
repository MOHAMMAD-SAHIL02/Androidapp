package com.example.text2speach;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    Button b1;
    TextToSpeech ts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editText);
        b1=findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Translated Sucessfully.", Toast.LENGTH_SHORT).show();

                ts=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        ts.setLanguage(Locale.ENGLISH);
                        ts.setSpeechRate(0.3f);
                        ts.speak(e1.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);

                    }
                });
            }
        });

    }
}