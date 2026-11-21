package com.example.dice_game;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random rnd = new Random();
    int zarDegisimi1, uretilenZar1, zarDegisimi2, uretilenZar2;
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

        ImageView dice1 = findViewById(R.id.dice1);
        ImageView dice2 = findViewById(R.id.dice2);
        Button zarAt = findViewById(R.id.zarAt);
        Button yeniOyun = findViewById(R.id.yeniOyun);
        TextView txt = findViewById(R.id.txt);

        zarAt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zarAt.setEnabled(false);

                new CountDownTimer(2000, 200){
                    @Override
                    public void onTick(long kalanMs){
                        zarDegisimi1 = rnd.nextInt(7) + 1;
                        zarDegisimi2 = rnd.nextInt(7) + 1;

                        if (zarDegisimi1 == 1){
                            dice1.setImageResource(R.drawable.dice_1);
                        } else if (zarDegisimi1 == 2){
                            dice1.setImageResource(R.drawable.dice_2);
                        } else if (zarDegisimi1 == 3){
                            dice1.setImageResource(R.drawable.dice_3);
                        } else if (zarDegisimi1 == 4){
                            dice1.setImageResource(R.drawable.dice_4);
                        } else if (zarDegisimi1 == 5){
                            dice1.setImageResource(R.drawable.dice_5);
                        } else if (zarDegisimi1 == 6){
                            dice1.setImageResource(R.drawable.dice_6);
                        }

                        if (zarDegisimi2 == 1){
                            dice2.setImageResource(R.drawable.dice_1);
                        } else if (zarDegisimi2 == 2){
                            dice2.setImageResource(R.drawable.dice_2);
                        } else if (zarDegisimi2 == 3){
                            dice2.setImageResource(R.drawable.dice_3);
                        } else if (zarDegisimi2 == 4){
                            dice2.setImageResource(R.drawable.dice_4);
                        } else if (zarDegisimi2 == 5){
                            dice2.setImageResource(R.drawable.dice_5);
                        } else if (zarDegisimi2 == 6){
                            dice2.setImageResource(R.drawable.dice_6);
                        }
                    }

                    public void onFinish(){
                        if (uretilenZar1 == 1){
                            dice1.setImageResource(R.drawable.dice_1);
                        } else if (uretilenZar1 == 2){
                            dice1.setImageResource(R.drawable.dice_2);
                        } else if (uretilenZar1 == 3){
                            dice1.setImageResource(R.drawable.dice_3);
                        } else if (uretilenZar1 == 4){
                            dice1.setImageResource(R.drawable.dice_4);
                        } else if (uretilenZar1 == 5){
                            dice1.setImageResource(R.drawable.dice_5);
                        } else if (uretilenZar1 == 6){
                            dice1.setImageResource(R.drawable.dice_6);
                        }

                        if (uretilenZar2 == 1){
                            dice2.setImageResource(R.drawable.dice_1);
                        } else if (uretilenZar2 == 2){
                            dice2.setImageResource(R.drawable.dice_2);
                        } else if (uretilenZar2 == 3){
                            dice2.setImageResource(R.drawable.dice_3);
                        } else if (uretilenZar2 == 4){
                            dice2.setImageResource(R.drawable.dice_4);
                        } else if (uretilenZar2 == 5){
                            dice2.setImageResource(R.drawable.dice_5);
                        } else if (uretilenZar2 == 6){
                            dice2.setImageResource(R.drawable.dice_6);
                        }

                        if(uretilenZar1 > uretilenZar2){
                            txt.setText("Oyuncu Kazandı.");
                        } else if (uretilenZar1 < uretilenZar2) {
                            txt.setText("Bilgisayar Kazandı.");

                        } else{
                            txt.setText("Berabere");
                        }
                    }
                }.start();

            }
        });

        yeniOyun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uretilenZar1 = rnd.nextInt(7) + 1;
                uretilenZar2 = rnd.nextInt(7) + 1;
                txt.setText("");
                zarAt.setEnabled(true);
            }
        });
    }
}