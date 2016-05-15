package com.mhappstudio.guessthenumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class QuickPlayMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_play_menu);

        findViewById(R.id.zero_to_ten_game_btn).setOnClickListener(ZeroTo10);
        findViewById(R.id.zero_to_hundred_game_btn).setOnClickListener(ZeroTo100);
        findViewById(R.id.zero_to_thousand_game_btn).setOnClickListener(ZeroTo1000);

        findViewById(R.id.zero_to_ten_game_btn).setOnTouchListener(ZeroTo10Touch);
        findViewById(R.id.zero_to_hundred_game_btn).setOnTouchListener(ZeroTo100Touch);
        findViewById(R.id.zero_to_thousand_game_btn).setOnTouchListener(ZeroTo1000Touch);
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

    View.OnTouchListener ZeroTo10Touch = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            LinearLayout zeroToTen = (LinearLayout)findViewById(R.id.zero_to_ten_game_btn);
            zeroToTen.setBackgroundResource(R.drawable.menu_btn_shape_pressed);
            return false;
        }
    };
    View.OnTouchListener ZeroTo100Touch = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            LinearLayout zeroToTen = (LinearLayout)findViewById(R.id.zero_to_hundred_game_btn);
            zeroToTen.setBackgroundResource(R.drawable.menu_btn_shape_pressed);
            return false;
        }
    };
    View.OnTouchListener ZeroTo1000Touch = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            LinearLayout zeroToTen = (LinearLayout)findViewById(R.id.zero_to_thousand_game_btn);
            zeroToTen.setBackgroundResource(R.drawable.menu_btn_shape_pressed);
            return false;
        }
    };

    private void ZeroToTen(){
        LinearLayout zeroToTen = (LinearLayout)findViewById(R.id.zero_to_ten_game_btn);
        zeroToTen.setBackgroundResource(R.drawable.menu_btn_shape);

        Intent start = new Intent(this, MainGame.class);
        start.putExtra("maximum", 10);
        start.putExtra("minimum", 0);
        startActivity(start);
    }

    private void ZeroToHundred(){
        LinearLayout zeroToTen = (LinearLayout)findViewById(R.id.zero_to_hundred_game_btn);
        zeroToTen.setBackgroundResource(R.drawable.menu_btn_shape);

        Intent startGame = new Intent(this, MainGame.class);
        startGame.putExtra("maximum", 100);
        startGame.putExtra("minimum", 0);
        startActivity(startGame);
    }

    private void ZeroToThousand(){
        LinearLayout zeroToTen = (LinearLayout)findViewById(R.id.zero_to_thousand_game_btn);
        zeroToTen.setBackgroundResource(R.drawable.menu_btn_shape);

        Intent startGame = new Intent(this, MainGame.class);
        startGame.putExtra("maximum", 1000);
        startGame.putExtra("minimum", 0);
        startActivity(startGame);
    }
}
