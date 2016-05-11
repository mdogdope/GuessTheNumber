package com.mhappstudio.guessthenumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class CustomGameMenu extends AppCompatActivity {

    boolean text1check = false, text2check = false;

    int selectedBox = 0;
    String inputFieldView1 = "";
    String inputFieldView2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_game_menu);

        findViewById(R.id.minimum_edit_text).setOnClickListener(minimumText);
        findViewById(R.id.maximum_edit_text).setOnClickListener(maximumText);
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

    //Text view selection==============[[
    View.OnClickListener minimumText = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            minimumTextSelect();
        }
    };

    View.OnClickListener maximumText = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            maximumTextSelect();
        }
    };

    private void minimumTextSelect(){
        TextView textViewNew = (TextView)findViewById(R.id.minimum_edit_text);
        TextView textViewOld = (TextView)findViewById(R.id.maximum_edit_text);

        textViewNew.setBackgroundResource(R.drawable.text_field_style_pressed);
        textViewOld.setBackgroundResource(R.drawable.text_field_style);

        selectedBox = 1;
    }

    private void maximumTextSelect(){
        TextView textViewNew = (TextView)findViewById(R.id.maximum_edit_text);
        TextView textViewOld = (TextView)findViewById(R.id.minimum_edit_text);

        textViewNew.setBackgroundResource(R.drawable.text_field_style_pressed);
        textViewOld.setBackgroundResource(R.drawable.text_field_style);

        selectedBox = 2;
    }
    //Text view selection==============]]

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

    //Keypad function========[[

    private void keypad(int num){
        String strNum = String.valueOf(num);
        switch (selectedBox){
            case 0:
                Toast.makeText(getApplicationContext(), "Select an input field", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                TextView text1 = (TextView)findViewById(R.id.minimum_edit_text);
                inputFieldView1 = inputFieldView1 + strNum;
                text1.setText(inputFieldView1);

                text1check = true;
                 break;
            case 2:
                TextView text2 = (TextView)findViewById(R.id.maximum_edit_text);
                inputFieldView2 = inputFieldView2 + strNum;
                text2.setText(inputFieldView2);

                text2check = true;
                break;
        }
    }

    private void clearText(){
        switch (selectedBox){
            case 0:
                Toast.makeText(getApplicationContext(), "Select an input field", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                TextView text1 = (TextView)findViewById(R.id.minimum_edit_text);
                text1.setText("");
                inputFieldView1 = "";

                text1check = false;
                break;
            case 2:
                TextView text2 = (TextView)findViewById(R.id.maximum_edit_text);
                text2.setText("");
                inputFieldView2 = "";

                text2check = false;
                break;
        }
    }

    private void enter(){


        if(text1check && text2check){
            int min = Integer.parseInt(inputFieldView1);
            int max = Integer.parseInt(inputFieldView2);

            Intent startGame = new Intent(this, MainGame.class);
            startGame.putExtra("maximum", max);
            startGame.putExtra("minimum", min);
            startActivity(startGame);
        }
    }
    //Keypad function========]]
}
