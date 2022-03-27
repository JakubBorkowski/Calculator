package com.example.calculator;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView screen, prev;
    private float num1, num2 = 0;
    private char sign = 0;
    private boolean repeat = false; //If true then the "equal" button will repeat the last operation.

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        num1 = savedInstanceState.getFloat("num1");
        num2 = savedInstanceState.getFloat("num2");
        sign = savedInstanceState.getChar("sign");
        screen.setText(savedInstanceState.getString("screen"));
        prev.setText(savedInstanceState.getString("prev"));
        repeat = savedInstanceState.getBoolean("repeat");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putFloat("num1", num1);
        outState.putFloat("num2", num2);
        outState.putChar("sign", sign);
        outState.putString("screen", screen.getText().toString());
        outState.putString("prev", prev.getText().toString());
        outState.putBoolean("repeat", repeat);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        screen = findViewById(R.id.textView);
        prev = findViewById(R.id.textView2);

        final Button button1b = findViewById(R.id.button1);
        button1b.setOnClickListener(v -> writeOnScreen(button1b));

        final Button button2b = findViewById(R.id.button2);
        button2b.setOnClickListener(v -> writeOnScreen(button2b));

        final Button button3b = findViewById(R.id.button3);
        button3b.setOnClickListener(v -> writeOnScreen(button3b));

        final Button button4b = findViewById(R.id.button4);
        button4b.setOnClickListener(v -> writeOnScreen(button4b));

        final Button button5b = findViewById(R.id.button5);
        button5b.setOnClickListener(v -> writeOnScreen(button5b));

        final Button button6b = findViewById(R.id.button6);
        button6b.setOnClickListener(v -> writeOnScreen(button6b));

        final Button button7b = findViewById(R.id.button7);
        button7b.setOnClickListener(v -> writeOnScreen(button7b));

        final Button button8b = findViewById(R.id.button8);
        button8b.setOnClickListener(v -> writeOnScreen(button8b));

        final Button button9b = findViewById(R.id.button9);
        button9b.setOnClickListener(v -> writeOnScreen(button9b));

        final Button button0b = findViewById(R.id.button0);
        button0b.setOnClickListener(v -> writeOnScreen(button0b));

        final Button button00b = findViewById(R.id.button00);
        button00b.setOnClickListener(v -> {
            String screenStr = screen.getText().toString();
            if(repeat){
                clearMemory();
            }
            if(screenStr.contains("-0") && !screenStr.contains(".") || screenStr.equals("-")){
                screen.setText("-0");
            }//I - Infinity, N - NaN
            else if (repeat || screenStr.equals("0") || screenStr.equals("") ||
                    screenStr.contains("I") || screenStr.contains("N")){
                screen.setText("0");
            }
            else
                screen.setText(screenStr + "00");
        });

        final Button buttonC = findViewById(R.id.buttonc);
        buttonC.setOnClickListener(v -> {
            String screenStr = screen.getText().toString();
            if  (!screenStr.isEmpty()&&!screenStr.equals("0")){
                if(repeat){
                    clearMemory();
                }//I - Infinity, N - NaN
                if (screenStr.contains("I") || screenStr.contains("N") || screenStr.contains("E") ||
                        screenStr.equals("-") || screenStr.substring(0, screenStr.length()-1).equals("") )
                    screen.setText("0");
                else
                    screen.setText(screenStr.substring(0, screenStr.length()-1));
            }
        });

        final Button buttonAC = findViewById(R.id.buttonac);
        buttonAC.setOnClickListener(v -> {
            screen.setText("0");
            clearMemory();
        });

        final Button buttonPlusMinus = findViewById(R.id.buttonplmin);
        buttonPlusMinus.setOnClickListener(v -> {
            String screenStr = screen.getText().toString();
            if(!screenStr.isEmpty()){
                if(repeat){
                    clearMemory();
                }
                if(screenStr.substring(0, 1).contains("-"))
                    screen.setText(screenStr.substring(1));//Delete minus sign
                else if(!screenStr.contains("N"))
                    screen.setText("-" + screenStr);
            }
        });

        final Button buttonPlus = findViewById(R.id.buttonplus);
        buttonPlus.setOnClickListener(v -> setSign('+'));

        final Button buttonMin = findViewById(R.id.buttonmin);
        buttonMin.setOnClickListener(v -> setSign('-'));

        final Button buttonMul = findViewById(R.id.buttonmul);
        buttonMul.setOnClickListener(v -> setSign('*'));

        final Button buttonDiv = findViewById(R.id.buttondiv);
        buttonDiv.setOnClickListener(v -> setSign('/'));

        final Button buttonPow = findViewById(R.id.buttonpow);
        buttonPow.setOnClickListener(v -> setSign('^'));

        final Button buttonSqrt = findViewById(R.id.buttonsqrt);
        buttonSqrt.setOnClickListener(v -> {
            String screenStr = screen.getText().toString();
            if  (!screenStr.isEmpty() && !screenStr.equals("-")){
                num1 = Float.parseFloat(screenStr);
                prev.setText("Sqrt(" + formatNumber(num1) + ")=");
                num1 = (float) Math.sqrt(num1);
                sign = 0;
                screen.setText(formatNumber(num1));
            }
        });

        final Button buttonDot = findViewById(R.id.buttondot);
        buttonDot.setOnClickListener(v -> {
            String screenStr = screen.getText().toString();
            if(repeat){
                clearMemory();
            }
            if(screenStr.isEmpty()){
                screen.setText("0.");
            }
            else if(screenStr.equals("-")){
                screen.setText("-0.");
            }
            else if(!screenStr.contains(".") && !screenStr.contains("I") && !screenStr.contains("N")){
                screen.setText(screenStr + ".");
            }
        });

        final Button buttonEqual = findViewById(R.id.buttonequal);
        buttonEqual.setOnClickListener(v -> {
            String screenStr = screen.getText().toString();
            if  (screenStr.isEmpty() || sign == 0)
                screen.setText(screenStr);
            else {
                if (!repeat)
                    num2 = Float.parseFloat(screenStr);
                float res = 0;
                switch(sign){
                    case '+':
                        res = num1 + num2;
                        prev.setText(formatNumber(num1) + "+" + formatNumber(num2) + "=");
                        break;
                    case '-':
                        res = num1 - num2;
                        prev.setText(formatNumber(num1) + "-" + formatNumber(num2) + "=");
                        break;
                    case '*':
                        res = num1 * num2;
                        prev.setText(formatNumber(num1) + "*" + formatNumber(num2) + "=");
                        break;
                    case '/':
                        if (num2 == 0) {//Protection against dividing by zero
                            res = 0;
                        }
                        else {
                            res = num1 / num2;
                            prev.setText(formatNumber(num1) + "/" + formatNumber(num2) + "=");
                        }
                        break;
                    case '^':
                        res = (float) Math.pow(num1, num2);
                        prev.setText(formatNumber(num1) + "^" + formatNumber(num2) + "=");
                        break;
                }
                num1 = res;
                screen.setText(formatNumber(res));
                if(sign != '/' && num2 != 0){
                    repeat = true;
                }
            }
        });
    }

    private String formatNumber(float num){
        String str = "";
        if(String.valueOf(num).endsWith(".0")){
            str = String.valueOf(num).substring(0, String.valueOf(num).length()-2);
        }
        else{
            str = String.valueOf(num);
        }
        return(str);
    }

    @SuppressLint("SetTextI18n")
    private void setSign(char signToSet){
        String ScreenStr = screen.getText().toString();
        if  (!ScreenStr.isEmpty() && !ScreenStr.equals("-")){
            num1 = Float.parseFloat(ScreenStr);
            sign = signToSet;
            repeat = false;
            screen.setText("");
            prev.setText(formatNumber(num1) + sign);
        }
    }

    private void clearMemory(){
        num1 = 0;
        num2 = 0;
        sign = 0;
        repeat = false;
        prev.setText("");
    }

    @SuppressLint("SetTextI18n")
    private void writeOnScreen(Button button){
        String buttonStr = button.getText().toString();
        String screenStr = screen.getText().toString();
        if(repeat){
            clearMemory();
        }
        if(screenStr.contains("-0") && !screenStr.contains(".")){
            screen.setText("-" + buttonStr);
        }//I - Infinity, N - NaN
        else if (repeat || screenStr.equals("0") || screenStr.contains("I") || screenStr.contains("N"))
            screen.setText(buttonStr);
        else
            screen.setText(screenStr + buttonStr);
    }

}