package com.example.calculator;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView screen, prev;
    private float num1, num2 = 0;
    private char sign = 0;
    private boolean equal = false; //If true then the "equal" button will repeat the last operation.


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        num1 = savedInstanceState.getFloat("num1");
        num2 = savedInstanceState.getFloat("num2");
        sign = savedInstanceState.getChar("sign");
        screen.setText(savedInstanceState.getString("screen"));
        prev.setText(savedInstanceState.getString("prev"));
        equal = savedInstanceState.getBoolean("equal");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putFloat("num1", num1);
        outState.putFloat("num2", num2);
        outState.putChar("sign", sign);
        outState.putString("screen", screen.getText().toString());
        outState.putString("prev", prev.getText().toString());
        outState.putBoolean("equal", equal);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);



        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout3);
        int height = linearLayout.getHeight();



        screen = (TextView)findViewById(R.id.textView);
        prev = (TextView)findViewById(R.id.textView2);

        final Button button1b = (Button) findViewById(R.id.button1);
        button1b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(equal){
                    num1 = 0;
                    num2 = 0;
                    sign = 0;
                    equal = false;
                    prev.setText("");
                }
                if(screen.getText().toString().contains("-0") && !screen.getText().toString().contains(".")){
                    screen.setText("-1");
                }//I - Infinity, N - NaN
                else if (equal || screen.getText().toString().equals("0") || (screen.getText().toString()).contains("I") || (screen.getText().toString()).contains("N"))
                    screen.setText("1");
                else
                    screen.setText((screen.getText().toString()) + "1");
            }
        });

        final Button button2b = (Button) findViewById(R.id.button2);
        button2b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(equal){
                    num1 = 0;
                    num2 = 0;
                    sign = 0;
                    equal = false;
                    prev.setText("");
                }
                if(screen.getText().toString().contains("-0") && !screen.getText().toString().contains(".")){
                    screen.setText("-2");
                }//I - Infinity, N - NaN
                else if (equal || screen.getText().toString().equals("0") || (screen.getText().toString()).contains("I") || (screen.getText().toString()).contains("N"))
                    screen.setText("2");
                else
                    screen.setText((screen.getText().toString()) + "2");
            }
        });

        final Button button3b = (Button) findViewById(R.id.button3);
        button3b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(equal){
                    num1 = 0;
                    num2 = 0;
                    sign = 0;
                    equal = false;
                    prev.setText("");
                }
                if(screen.getText().toString().contains("-0") && !screen.getText().toString().contains(".")){
                    screen.setText("-3");
                }//I - Infinity, N - NaN
                else if (equal || screen.getText().toString().equals("0") || (screen.getText().toString()).contains("I") || (screen.getText().toString()).contains("N"))
                    screen.setText(button3b.getText().toString());
                else
                    screen.setText((screen.getText().toString()) + "3");
            }
        });

        final Button button4b = (Button) findViewById(R.id.button4);
        button4b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(equal){
                    num1 = 0;
                    num2 = 0;
                    sign = 0;
                    equal = false;
                    prev.setText("");
                }//I - Infinity, N - NaN
                if(screen.getText().toString().contains("-0") && !screen.getText().toString().contains(".")){
                    screen.setText("-4");
                }//I - Infinity, N - NaN
                else if (equal || screen.getText().toString().equals("0") || (screen.getText().toString()).contains("I") || (screen.getText().toString()).contains("N"))
                    screen.setText(button4b.getText().toString());
                else
                    screen.setText((screen.getText().toString()) + "4");
            }
        });

        final Button button5b = (Button) findViewById(R.id.button5);
        button5b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(equal){
                    num1 = 0;
                    num2 = 0;
                    sign = 0;
                    equal = false;
                    prev.setText("");
                }
                if(screen.getText().toString().contains("-0") && !screen.getText().toString().contains(".")){
                    screen.setText("-5");
                }//I - Infinity, N - NaN
                else if (equal || screen.getText().toString().equals("0") || (screen.getText().toString()).contains("I") || (screen.getText().toString()).contains("N"))
                    screen.setText("5");
                else
                    screen.setText((screen.getText().toString()) + "5");
            }
        });

        final Button button6b = (Button) findViewById(R.id.button6);
        button6b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(equal){
                    num1 = 0;
                    num2 = 0;
                    sign = 0;
                    equal = false;
                    prev.setText("");
                }
                if(screen.getText().toString().contains("-0") && !screen.getText().toString().contains(".")){
                    screen.setText("-6");
                }//I - Infinity, N - NaN
                else if (equal || screen.getText().toString().equals("0") || (screen.getText().toString()).contains("I") || (screen.getText().toString()).contains("N"))
                    screen.setText("6");
                else
                    screen.setText((screen.getText().toString()) + "6");;
            }
        });

        final Button button7b = (Button) findViewById(R.id.button7);
        button7b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(equal){
                    num1 = 0;
                    num2 = 0;
                    sign = 0;
                    equal = false;
                    prev.setText("");
                }
                if(screen.getText().toString().contains("-0") && !screen.getText().toString().contains(".")){
                    screen.setText("-7");
                }//I - Infinity, N - NaN
                else if (equal || screen.getText().toString().equals("0") || (screen.getText().toString()).contains("I") || (screen.getText().toString()).contains("N"))
                    screen.setText("7");
                else
                    screen.setText((screen.getText().toString()) + "7");
            }
        });

        final Button button8b = (Button) findViewById(R.id.button8);
        button8b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(equal){
                    num1 = 0;
                    num2 = 0;
                    sign = 0;
                    equal = false;
                    prev.setText("");
                }
                if(screen.getText().toString().contains("-0") && !screen.getText().toString().contains(".")){
                    screen.setText("-8");
                }//I - Infinity, N - NaN
                else if (equal || screen.getText().toString().equals("0") || (screen.getText().toString()).contains("I") || (screen.getText().toString()).contains("N"))
                    screen.setText("8");
                else
                    screen.setText((screen.getText().toString()) + "8");
            }
        });

        final Button button9b = (Button) findViewById(R.id.button9);
        button9b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(equal){
                    num1 = 0;
                    num2 = 0;
                    sign = 0;
                    equal = false;
                    prev.setText("");
                }
                if(screen.getText().toString().contains("-0") && !screen.getText().toString().contains(".")){
                    screen.setText("-9");
                }//I - Infinity, N - NaN
                else if (equal || screen.getText().toString().equals("0") || (screen.getText().toString()).contains("I") || (screen.getText().toString()).contains("N"))
                    screen.setText("9");
                else
                    screen.setText((screen.getText().toString()) + "9");
            }
        });

        final Button button0b = (Button) findViewById(R.id.button0);
        button0b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(equal){
                    num1 = 0;
                    num2 = 0;
                    sign = 0;
                    equal = false;
                    prev.setText("");
                }
                if(screen.getText().toString().contains("-0") && !screen.getText().toString().contains(".")){
                    screen.setText("-0");
                }//I - Infinity, N - NaN
                else if (equal || screen.getText().toString().equals("0") || (screen.getText().toString()).contains("I") || (screen.getText().toString()).contains("N")){
                    screen.setText("0");
                }
                else
                    screen.setText((screen.getText().toString()) + "0");
            }
        });

        final Button button00b = (Button) findViewById(R.id.button00);
        button00b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(equal){
                    num1 = 0;
                    num2 = 0;
                    sign = 0;
                    equal = false;
                    prev.setText("");
                }
                if(screen.getText().toString().contains("-0") && !screen.getText().toString().contains(".") || screen.getText().toString().equals("-")){
                    screen.setText("-0");
                }//I - Infinity, N - NaN
                else if (equal || screen.getText().toString().equals("0") || screen.getText().toString().equals("") || (screen.getText().toString()).contains("I") || (screen.getText().toString()).contains("N")){
                    screen.setText("0");
                }
                else
                    screen.setText((screen.getText().toString()) + "00");
            }
        });

        final Button buttonc = (Button) findViewById(R.id.buttonc);
        buttonc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String current = screen.getText().toString();
                if  (!current.isEmpty()&&!current.equals("0")){
                    if(equal){
                        num1 = 0;
                        num2 = 0;
                        sign = 0;
                        equal = false;
                        prev.setText("");
                    }//I - Infinity, N - NaN
                    if (current.contains("I") || current.contains("N") || current.contains("E") || current.equals("-"))
                        screen.setText("0");
                    else
                        screen.setText(current.substring(0, current.length()-1));
                }
            }
        });

        final Button buttonac = (Button) findViewById(R.id.buttonac);
        buttonac.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                screen.setText("0");
                prev.setText("");
                num1 = 0;
                num2 = 0;
                sign = 0;
                equal = false;
            }
        });

        final Button buttonplmin = (Button) findViewById(R.id.buttonplmin);
        buttonplmin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String current = screen.getText().toString();
                if  (!current.isEmpty()){
                    if(equal){
                        num1 = 0;
                        num2 = 0;
                        sign = 0;
                        equal = false;
                        prev.setText("");
                    }
                    if (current.substring(0, 1).contains("-"))
                        screen.setText(current.substring(1, current.length()));
                    else
                        screen.setText("-" + current);
                }
            }
        });

        final Button buttonplus = (Button) findViewById(R.id.buttonplus);
        buttonplus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String current = screen.getText().toString();
                if  (!current.isEmpty() && !current.equals("-")){
                    num1 = Float.parseFloat(current);
                    sign = '+';
                    equal = false;
                    screen.setText("");
                    prev.setText(String.valueOf(num1) + "+");
                }
            }
        });

        final Button buttonmin = (Button) findViewById(R.id.buttonmin);
        buttonmin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String current = screen.getText().toString();
                if  (!current.isEmpty() && !current.equals("-")){
                    num1 = Float.parseFloat(current);
                    sign = '-';
                    equal = false;
                    screen.setText("");
                    prev.setText(String.valueOf(num1) + "-");
                }
            }
        });

        final Button buttonmul = (Button) findViewById(R.id.buttonmul);
        buttonmul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String current = screen.getText().toString();
                if  (!current.isEmpty() && !current.equals("-")){
                    num1 = Float.parseFloat(current);
                    sign = '*';
                    equal = false;
                    screen.setText("");
                    prev.setText(String.valueOf(num1) + "*");
                }
            }
        });

        final Button buttondiv = (Button) findViewById(R.id.buttondiv);
        buttondiv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String current = screen.getText().toString();
                if  (!current.isEmpty() && !current.equals("-")){
                    num1 = Float.parseFloat(current);
                    sign = '/';
                    equal = false;
                    screen.setText("");
                    prev.setText(String.valueOf(num1) + "/");
                }
            }
        });

        final Button buttonsqrt = (Button) findViewById(R.id.buttonsqrt);
        buttonsqrt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String current = screen.getText().toString();
                if  (!current.isEmpty() && !current.equals("-")){
                    num1 = Float.parseFloat(current);
                    prev.setText("Sqrt(" + String.valueOf(num1) + ")=");
                    num1 = (float) Math.sqrt(num1);
                    sign = 0;
                    screen.setText(String.valueOf(num1));
                }
            }
        });

        final Button buttonpow = (Button) findViewById(R.id.buttonpow);
        buttonpow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String current = screen.getText().toString();
                if  (!current.isEmpty() && !current.equals("-")) {
                    num1 = Float.parseFloat(current);
                    sign = '^';
                    equal = false;
                    screen.setText("");
                    prev.setText(String.valueOf(num1) + "^");
                }
            }
        });

        final Button buttondot = (Button) findViewById(R.id.buttondot);
        buttondot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String current = screen.getText().toString();
                if(equal){
                    num1 = 0;
                    num2 = 0;
                    sign = 0;
                    prev.setText("");
                }
                if(current.isEmpty()){
                    screen.setText("0.");
                }
                else if(current.equals("-")){
                    screen.setText("-0.");
                }
                else if(!current.contains(".") && !current.contains("I") && !current.contains("N")){
                    screen.setText(current + ".");
                }
            }
        });

        final Button buttonequal = (Button) findViewById(R.id.buttonequal);
        buttonequal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String current = screen.getText().toString();
                if  (current.isEmpty() || sign == 0)
                    screen.setText(current);
                else {
                    if (!equal)
                        num2 = Float.parseFloat(current);
                    float res = 0;
                    switch(sign){
                        case '+':
                            res = num1 + num2;
                            prev.setText(String.valueOf(num1) + "+" + String.valueOf(num2) + "=");
                            break;
                        case '-':
                            res = num1 - num2;
                            prev.setText(String.valueOf(num1) + "-" + String.valueOf(num2) + "=");
                            break;
                        case '*':
                            res = num1 * num2;
                            prev.setText(String.valueOf(num1) + "*" + String.valueOf(num2) + "=");
                            break;
                        case '/':
                            if (num2 == 0) {
                                res = 0;
                            }
                            else {
                                res = num1 / num2;
                                prev.setText(String.valueOf(num1) + "/" + String.valueOf(num2) + "=");
                            }
                            break;
                        case '^':
                            res = (float) Math.pow(num1, num2);
                            prev.setText(String.valueOf(num1) + "^" + String.valueOf(num2) + "=");
                            break;
                    }
                    num1 = res;
                    screen.setText(String.valueOf(res));
                    equal = true;
                }
            }
        });
    }
}