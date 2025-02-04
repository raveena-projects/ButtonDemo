package com.example.buttondemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button simpleButton;
    private ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        simpleButton = findViewById(R.id.btn);
        simpleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Button","Button clicked");
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        imageButton = findViewById(R.id.imgBtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Button","Image Button clicked");
            }
        });
    }
    public  void checkboxOnclickHandler(View view){
        CheckBox checkBox = (CheckBox) view;
        if(checkBox.isChecked()){
            Log.d("Checkbox selected", (String) checkBox.getText());
            String text = (String) checkBox.getText();
            if(text.equalsIgnoreCase("Project")){
                Log.d("Project tag", "Project checkbox selected");
            }
        }
    }
    public void radioButtonOnClickHandler(View view){
        RadioButton radioButton = (RadioButton) view;
        if(radioButton.isChecked()){
            Log.d("radioButton selected", (String) radioButton.getText());
        }
    }
}