package com.example.buddh.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.io.IOException;
import java.io.InputStream;

public class Main3Activity extends AppCompatActivity {
    Button b_read;
    TextView tv_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        b_read = (Button) findViewById(R.id.b_read);

        tv_text = (TextView) findViewById(R.id.tv_text);

        b_read.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String text = "";
                try{
                    InputStream is = getAssets().open("text.txt");
                    int size = is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    text = new String(buffer);

                } catch(IOException ex){
                    ex.printStackTrace();
                }
                tv_text.setText(text);
            }
        });
    }
}
