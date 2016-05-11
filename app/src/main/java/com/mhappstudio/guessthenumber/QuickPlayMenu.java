package com.mhappstudio.guessthenumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class QuickPlayMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_play_menu);

        findViewById(R.id.zero_to_ten_game_btn).setOnClickListener(ZeroTo10);
        findViewById(R.id.zero_to_hundred_game_btn).setOnClickListener(ZeroTo100);
        findViewById(R.id.zero_to_thousand_game_btn).setOnClickListener(ZeroTo1000);
    }

    View.OnClickListener ZeroTo10 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ZeroToTen();
        }
    };

    View.OnClickListener ZeroTo100 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ZeroToHundred();
        }
    };

    View.OnClickListener ZeroTo1000 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ZeroToThousand();
        }
    };

    private void ZeroToTen(){
        Intent start = new Intent(this, MainGame.class);
        start.putExtra("maximum", 10);
        start.putExtra("minimum", 0);
        startActivity(start);
    }

    private void ZeroToHundred(){
        Intent startGame = new Intent(this, MainGame.class);
        startGame.putExtra("maximum", 100);
        startGame.putExtra("minimum", 0);
        startActivity(startGame);
    }

    private void ZeroToThousand(){
        Intent startGame = new Intent(this, MainGame.class);
        startGame.putExtra("maximum", 1000);
        startGame.putExtra("minimum", 0);
        startActivity(startGame);
    }
}
