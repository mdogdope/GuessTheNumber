package com.mhappstudio.guessthenumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.startapp.android.publish.StartAppAd;
import com.startapp.android.publish.StartAppSDK;

public class GameOver extends AppCompatActivity {

    int max;
    int min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        TextView rangeTextView = (TextView)findViewById(R.id.game_rang_text_view);
        TextView scoreTextView = (TextView)findViewById(R.id.guess_count_text_view);
        Intent data = getIntent();

        min = data.getIntExtra("min", 0);
        max = data.getIntExtra("max", 0);
        int score = data.getIntExtra("score", 0);

        rangeTextView.setText(min + " - " + max);
        scoreTextView.setText("It took you:\n" + score + " guesses");

        findViewById(R.id.menu_btn).setOnClickListener(menubtn);
        findViewById(R.id.play_again_btn).setOnClickListener(playagainbtn);
    }

    View.OnClickListener menubtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            menuBtnClick();
        }
    };
    View.OnClickListener playagainbtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            playAgainBtnClick();
        }
    };

    private void menuBtnClick(){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }

    private void playAgainBtnClick(){
        Intent intent = new Intent(this, MainGame.class);
        intent.putExtra("maximum", max);
        intent.putExtra("minimum", min);
        startActivity(intent);
    }
}
