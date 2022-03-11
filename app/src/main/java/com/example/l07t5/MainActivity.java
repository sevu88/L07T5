package com.example.l07t5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Context context = null;
    EditText inputText;
    EditText fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        inputText = (EditText) findViewById(R.id.editTextInput);
        fileName = (EditText) findViewById(R.id.editTextFile);
    }

    public void readFile(View v) {
        try {
            InputStream ins = context.openFileInput(String.valueOf(fileName.getText()));
            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String s = "";

            while ((s= br.readLine()) != null) {
                inputText.setText(s);
            }
            ins.close();

        }
        catch (IOException e) {
            Log.e("IOException", "Virhe syötteessä");
        }

    }

    public void writeFile(View v) {
        try {
            OutputStreamWriter ows = new OutputStreamWriter(context.openFileOutput("newFile.txt", context.MODE_PRIVATE));
            ows.write(String.valueOf(inputText.getText()));
            ows.close();

        }
        catch (IOException e) {
            Log.e("IOException", "Virhe syötteessä");
        }

    }
}