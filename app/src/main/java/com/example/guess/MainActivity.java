package com.example.guess;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int guess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.tvInfo);
        etInput = findViewById(R.id.etInput);
        bControl = (Button) findViewById(R.id.bControl);


        bControl.setOnClickListener(this);
        guess = new Random().nextInt(200) + 1;
    }
    @Override
    public void onClick(View view) {
        int user_guess = Integer.parseInt(etInput.getText().toString());
        tvInfo.setText("" + guess + "," + user_guess);
        if (user_guess == guess) {
            tvInfo.setText("Ничего себе! Правильно!");
            guess = new Random().nextInt(200) + 1;
        } else if (user_guess < 1 || user_guess > 200) {
            tvInfo.setText("Проверьте введенные значения");
        } else if (user_guess < guess) {
            tvInfo.setText("Слишком мало!");
        } else if (user_guess > guess) {
            tvInfo.setText("Слишком много!");
        }
        etInput.setText("");
    }
}