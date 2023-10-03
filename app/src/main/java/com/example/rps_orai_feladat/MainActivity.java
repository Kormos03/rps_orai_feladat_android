package com.example.rps_orai_feladat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
private ImageView imageView1;
private TextView textViewHuman;
private TextView textViewComputer;
private ImageView imageView2;
private Button buttonko;
private Button buttonpapir;
private Button buttonollo;
public int eredmeny;
public int win;
public int loose;
public int tipp;
private AlertDialog.Builder alertDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        buttonko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView1.setImageResource(R.drawable.rock);
                tipp = 0;
                computer();
                ellenorzes();
            }
        });
        buttonpapir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView1.setImageResource(R.drawable.paper);
                tipp = 1;
                computer();
                ellenorzes();
            }
        });
        buttonollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView1.setImageResource(R.drawable.scissors);
                tipp = 2;
                computer();
                ellenorzes();

            }
        });
    }
    public void init()
    {
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        textViewComputer = findViewById(R.id.textViewComputer);
        textViewHuman = findViewById(R.id.textViewHuman);
        buttonko = findViewById(R.id.buttonko);
        buttonpapir = findViewById(R.id.buttonpapir);
        buttonollo = findViewById(R.id.buttonollo);
        alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Vesztettél!").setMessage("Restart?").setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Reset();
                    }
                })
                .setCancelable(false)
                .create();
    }
    public void computer()
    {
        Random random = new Random();
        int rnd = random.nextInt(3);
        switch (rnd)
        {
            case 0:
                imageView2.setImageResource(R.drawable.rock);
                eredmeny = 0;
                break;
            case 1:
                imageView2.setImageResource(R.drawable.paper);
                eredmeny = 1;
                break;
            case 2:
                imageView2.setImageResource(R.drawable.scissors);
                eredmeny = 2;
                break;

        }
    }
    public void ellenorzes()
    {

        if(eredmeny == tipp)
        {
            win++;
            textViewHuman.setText("Ember: " + win);
        }
        else
        {
            loose++;
            textViewComputer.setText("Computer: " + loose);
        }
        if (loose == 3)
        {
            alertDialog.setTitle("Vesztettél!").create().show();
        } else if (win == 3)
        {
            alertDialog.setTitle("Győzelem!").create().show();
        }
    }
    public void Reset()
    {
        imageView1.setImageResource(R.drawable.rock);
        imageView2.setImageResource(R.drawable.rock);
        win = 0;
        textViewHuman.setText("Ember: 0");
        loose = 0;
        textViewComputer.setText("Computer: 0");
        tipp = 0;
    }
}