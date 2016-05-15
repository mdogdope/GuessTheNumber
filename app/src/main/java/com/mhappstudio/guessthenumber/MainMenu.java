package com.mhappstudio.guessthenumber;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainMenu extends AppCompatActivity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        LinearLayout QuickPlayBtn = (LinearLayout)findViewById(R.id.quick_play_btn);
        assert QuickPlayBtn != null;
        QuickPlayBtn.setOnClickListener(QuickPlayClick);

        LinearLayout CustomGameBtn = (LinearLayout)findViewById(R.id.custom_game_btn);
        assert CustomGameBtn != null;
        CustomGameBtn.setOnClickListener(CustomGameClick);

        LinearLayout SettingsBtn = (LinearLayout)findViewById(R.id.settings_btn);
        assert SettingsBtn != null;
        SettingsBtn.setOnClickListener(SettingsClick);

        ImageView HighScoreBtn = (ImageView)findViewById(R.id.high_score_btn);
        assert HighScoreBtn != null;
        HighScoreBtn.setOnClickListener(HighScoreClick);

        findViewById(R.id.quick_play_btn).setOnTouchListener(QuickPlayTouch);
        findViewById(R.id.custom_game_btn).setOnTouchListener(CustomGameTouch);
        findViewById(R.id.settings_btn).setOnTouchListener(SettingsTouch);
    }

    View.OnClickListener QuickPlayClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            QuickPlayMethod();
        }
    };

    View.OnClickListener CustomGameClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CustomGameMethod();
        }
    };

    View.OnClickListener SettingsClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SettingsMethod();
        }
    };

    View.OnClickListener HighScoreClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            HighScoreMethod();
        }
    };

    View.OnTouchListener QuickPlayTouch = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            LinearLayout quickPlay = (LinearLayout)findViewById(R.id.quick_play_btn);
            quickPlay.setBackgroundResource(R.drawable.menu_btn_shape_pressed);
            return false;
        }
    };

    View.OnTouchListener CustomGameTouch = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            LinearLayout quickPlay = (LinearLayout)findViewById(R.id.custom_game_btn);
            quickPlay.setBackgroundResource(R.drawable.menu_btn_shape_pressed);
            return false;
        }
    };

    View.OnTouchListener SettingsTouch = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            LinearLayout quickPlay = (LinearLayout)findViewById(R.id.settings_btn);
            quickPlay.setBackgroundResource(R.drawable.menu_btn_shape_pressed);
            return false;
        }
    };

    private void QuickPlayMethod(){
        LinearLayout quickPlay = (LinearLayout)findViewById(R.id.quick_play_btn);
        quickPlay.setBackgroundResource(R.drawable.menu_btn_shape);

        Intent start = new Intent(this, QuickPlayMenu.class);
        startActivity(start);
    }

    private void CustomGameMethod(){
        LinearLayout quickPlay = (LinearLayout)findViewById(R.id.custom_game_btn);
        quickPlay.setBackgroundResource(R.drawable.menu_btn_shape);

        Intent start = new Intent(this, CustomGameMenu.class);
        startActivity(start);
    }

    private void SettingsMethod(){
        LinearLayout quickPlay = (LinearLayout)findViewById(R.id.settings_btn);
        quickPlay.setBackgroundResource(R.drawable.menu_btn_shape);

        Intent start = new Intent(this, SettingsMenu.class);
        startActivity(start);
    }

    private void HighScoreMethod(){
        Intent start = new Intent(this, HighScoreMenu.class);
        startActivity(start);
    }

    @Override
    public void onClick(View v) {

    }
}
