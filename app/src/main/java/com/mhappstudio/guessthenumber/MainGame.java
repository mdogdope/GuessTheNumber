package com.mhappstudio.guessthenumber;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Random;

public class MainGame extends AppCompatActivity {

    InterstitialAd mInterstitialAd = new InterstitialAd(this);

    String inputFieldView1 = "";
    int randomNum;
    int guessCounter = 1;
    boolean highScoreGood = false;
    int max, min, guess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        mInterstitialAd.setAdUnitId("ca-app-pub-7283483668136736/3475367203");

        requestNewInterstitial();

        //Log.i("TAG", "It worked");

        ImageButton btnSubmit = (ImageButton) findViewById(R.id.key_pad_enter);
        btnSubmit.setEnabled(false);

        TextView guessnumTextView = (TextView)findViewById(R.id.guess_counter);
        guessnumTextView.setText("Guess #" + guessCounter);

        Intent bounds = getIntent();
        max = bounds.getIntExtra("maximum", 0);
        min = bounds.getIntExtra("minimum", 0);

        //Log.i("Minimum value", String.valueOf(min));
        //Log.i("Maximum value", String.valueOf(max));

        if (min == 0){
            if (max == 10 || max == 100 || max == 1000){
                highScoreGood = true;
            }
        }

        Random rand = new Random();
        randomNum = rand.nextInt((max - min) +1) + min;

        findViewById(R.id.key_pad_0).setOnClickListener(keypad0);
        findViewById(R.id.key_pad_1).setOnClickListener(keypad1);
        findViewById(R.id.key_pad_2).setOnClickListener(keypad2);
        findViewById(R.id.key_pad_3).setOnClickListener(keypad3);
        findViewById(R.id.key_pad_4).setOnClickListener(keypad4);
        findViewById(R.id.key_pad_5).setOnClickListener(keypad5);
        findViewById(R.id.key_pad_6).setOnClickListener(keypad6);
        findViewById(R.id.key_pad_7).setOnClickListener(keypad7);
        findViewById(R.id.key_pad_8).setOnClickListener(keypad8);
        findViewById(R.id.key_pad_9).setOnClickListener(keypad9);
        findViewById(R.id.key_pad_clear).setOnClickListener(keypadclear);
        findViewById(R.id.key_pad_enter).setOnClickListener(keypadenter);
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("ACC147BB43B7A9B94CF4AF24C53CD80D")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    //Keypad Click Listeners===========[[
    View.OnClickListener keypad0 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            keypad(0);
        }
    };

    View.OnClickListener keypad1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            keypad(1);
        }
    };

    View.OnClickListener keypad2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            keypad(2);
        }
    };

    View.OnClickListener keypad3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            keypad(3);
        }
    };

    View.OnClickListener keypad4 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            keypad(4);
        }
    };

    View.OnClickListener keypad5 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            keypad(5);
        }
    };

    View.OnClickListener keypad6 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            keypad(6);
        }
    };

    View.OnClickListener keypad7 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            keypad(7);
        }
    };

    View.OnClickListener keypad8 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            keypad(8);
        }
    };

    View.OnClickListener keypad9 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            keypad(9);
        }
    };

    View.OnClickListener keypadclear =  new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            clearText();
        }
    };

    View.OnClickListener keypadenter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            enter();
        }
    };
    //Keypad Click Listeners===========]]

    private void keypad(int num){
        ImageButton btnSubmit = (ImageButton) findViewById(R.id.key_pad_enter);
        btnSubmit.setEnabled(true);

        String strNum = String.valueOf(num);
                TextView text1 = (TextView)findViewById(R.id.current_guess);
                inputFieldView1 = inputFieldView1 + strNum;
                text1.setText(inputFieldView1);

    }

    private void clearText(){
        TextView text2 = (TextView)findViewById(R.id.current_guess);
        text2.setText("");
        inputFieldView1 = "";

        ImageButton btnSubmit = (ImageButton) findViewById(R.id.key_pad_enter);
        btnSubmit.setEnabled(false);
    }

    private void enter(){
        guess = Integer.parseInt(inputFieldView1);

        if (guess == randomNum){
            displayAd();
        }else if (guess > randomNum){
            indicatorDisplay("Too High");
            ++guessCounter;
            guessCounterDisplay();
        }else if(guess < randomNum){
            indicatorDisplay("Too Low");
            ++guessCounter;
            guessCounterDisplay();
        }

        ImageButton btnSubmit = (ImageButton) findViewById(R.id.key_pad_enter);
        btnSubmit.setEnabled(false);

        clearText();
    }

    private void guessCounterDisplay(){
        TextView counter = (TextView)findViewById(R.id.guess_counter);
        counter.setText("Guess #" + guessCounter);
    }

    private void indicatorDisplay(String indicatorType){
        TextView indicator = (TextView)findViewById(R.id.indicator);
        indicator.setText(indicatorType);
    }
    private void keepHighScore(int score){
        SharedPreferences highScorePrefs = this.getSharedPreferences("HighScore", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = highScorePrefs.edit();
        if(max == 10){
            if(highScorePrefs.contains("10")) {
                String highScore = highScorePrefs.getString("10", "");
                int highScoreInt = Integer.parseInt(highScore);
                if(highScoreInt > score) {
                    String maxStr = String.valueOf(max),
                            scoreStr = String.valueOf(score);

                    editor.putString(maxStr, scoreStr).commit();
                }
            }else{
                String maxStr = String.valueOf(max),
                        scoreStr = String.valueOf(score);

                editor.putString(maxStr, scoreStr).commit();
            }
        }else if(max == 100){
            if(highScorePrefs.contains("100")) {
                String highScore = highScorePrefs.getString("100", "");
                int highScoreInt = Integer.parseInt(highScore);
                if(highScoreInt > score) {
                    String maxStr = String.valueOf(max),
                            scoreStr = String.valueOf(score);

                    editor.putString(maxStr, scoreStr).commit();
                }
            }else {
                String maxStr = String.valueOf(max),
                        scoreStr = String.valueOf(score);

                editor.putString(maxStr, scoreStr).commit();
            }
        }else if(max == 1000){
            if(highScorePrefs.contains("1000")) {
                String highScore = highScorePrefs.getString("1000", "");
                int highScoreInt = Integer.parseInt(highScore);
                if(highScoreInt > score) {
                    String maxStr = String.valueOf(max),
                            scoreStr = String.valueOf(score);

                    editor.putString(maxStr, scoreStr).commit();
                }
            }else{
                String maxStr = String.valueOf(max),
                        scoreStr = String.valueOf(score);

                editor.putString(maxStr, scoreStr).commit();
            }
        }
    }

    private void displayAd(){
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }else{
            continueGame();
        }

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                continueGame();
            }
        });
    }

    private void continueGame(){

        Intent gameover = new Intent(this, GameOver.class);
        if (highScoreGood){
            keepHighScore(guessCounter);
        }
        gameover.putExtra("score", guessCounter);
        gameover.putExtra("max", max);
        gameover.putExtra("min", min);
        startActivity(gameover);
    }
}
