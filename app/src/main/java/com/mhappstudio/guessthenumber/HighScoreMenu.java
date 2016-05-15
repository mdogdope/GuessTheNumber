package com.mhappstudio.guessthenumber;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HighScoreMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score_menu);

        TextView tv1to10 = (TextView)findViewById(R.id.highscore_1_to_10);
        TextView tv1to100 = (TextView)findViewById(R.id.highscore_1_to_100);
        TextView tv1to1000 = (TextView)findViewById(R.id.highscore_1_to_1000);

        SharedPreferences highScorePref = getSharedPreferences("HighScore", Context.MODE_PRIVATE);

        if(highScorePref.contains("10")){
            String highScore = highScorePref.getString("10", "");
            tv1to10.setText(highScore);
        }else{
            tv1to10.setText("-");
        }

        if(highScorePref.contains("100")){
            String highScore = highScorePref.getString("100", "");
            tv1to100.setText(highScore);
        }else{
            tv1to100.setText("-");
        }

        if(highScorePref.contains("1000")){
            String highScore = highScorePref.getString("1000", "");
            tv1to1000.setText(highScore);
        }else{
            tv1to1000.setText("-");
        }
    }
}
