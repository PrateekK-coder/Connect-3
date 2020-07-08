package com.example.tictactoever3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningpositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    int activegame = 0;
    boolean gameActive = true;
    Button playagain;
    TextView winnerTextView;

    //0 is yellow and 1 is red and 2 is empty
    @SuppressLint("SetTextI18n")
    public void dropin(View view) {


        ImageView counter = (ImageView) view;

        int tappedcounter = Integer.parseInt(counter.getTag().toString());
        if (gamestate[tappedcounter] == 2 && gameActive) {

            gamestate[tappedcounter] = activegame;
            counter.setTranslationY(-1500);
            if (activegame == 0) {
                counter.setImageResource(R.drawable.yellow);
                activegame = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activegame = 0;
            }

            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

            for (int[] winningposition : winningpositions) {
                if (gamestate[winningposition[0]] == gamestate[winningposition[1]] && gamestate[winningposition[1]] == gamestate[winningposition[2]] && gamestate[winningposition[0]] != 2) {
                    gameActive = false;
                    String winner;
                    if (activegame == 1) {
                        winner = "yellow ";
                    } else {
                        winner = "red ";
                    }



                    winnerTextView.setText(winner + " has won");
                    playagain.setVisibility(View.VISIBLE);
                    winnerTextView.setVisibility((View.VISIBLE));


                }
            }


            if ((gamestate[0] != 2) && (gamestate[1] != 2) && (gamestate[2] != 2) && (gamestate[3] != 2) && (gamestate[4] != 2) && (gamestate[5] != 2) && (gamestate[6] != 2) && (gamestate[7] != 2) && (gamestate[8] != 2)) {
                gameActive = false;
                playagain.setVisibility(View.VISIBLE);
                winnerTextView.setVisibility((View.VISIBLE));
                winnerTextView.setText(" Its a Tie ");

            }

        }

    }

    public void Playagain(View view) {

        Log.i("play Again", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Button playagain = (Button) findViewById(R.id.PlayAgain);
        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);

        playagain.setVisibility(View.INVISIBLE);
        winnerTextView.setVisibility((View.INVISIBLE));

        Log.i("andar","before");

        GridLayout gridlayout = findViewById(R.id.gridLayout);
        Log.i("andar","after");

        for (int i = 0; i < gridlayout.getChildCount(); i++) {

            ImageView counter = (ImageView) gridlayout.getChildAt(i);
            counter.setImageDrawable(null);

        }

        for (int i = 0; i < gamestate.length; i++) {
            gamestate[i] = 2;
        }

        activegame = 0;
        gameActive = true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playagain = (Button) findViewById(R.id.PlayAgain);
        winnerTextView = (TextView) findViewById(R.id.winnerTextView);
    }
}
