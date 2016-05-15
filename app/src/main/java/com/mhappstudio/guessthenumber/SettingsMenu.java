package com.mhappstudio.guessthenumber;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SettingsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_menu);

        findViewById(R.id.clear_highscore).setOnClickListener(ClearHighScore);

        findViewById(R.id.clear_highscore).setOnTouchListener(clearDown);
    }

    View.OnClickListener ClearHighScore = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            clearHighScoreClick();
        }
    };

    View.OnTouchListener clearDown = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            LinearLayout clearBtn = (LinearLayout)findViewById(R.id.clear_highscore);
            clearBtn.setBackgroundResource(R.drawable.menu_btn_shape_pressed);
            return false;
        }
    };

    private void clearHighScoreClick(){
        SharedPreferences highScorePref = getSharedPreferences("HighScore", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = highScorePref.edit();

        editor.remove("10").commit();
        editor.remove("100").commit();
        editor.remove("1000").commit();

        Toast.makeText(getApplicationContext(), "High Score Cleared", Toast.LENGTH_SHORT).show();

        LinearLayout clearBtn = (LinearLayout)findViewById(R.id.clear_highscore);
        clearBtn.setBackgroundResource(R.drawable.menu_btn_shape);
    }

}
