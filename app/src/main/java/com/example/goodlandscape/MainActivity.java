package com.example.goodlandscape;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> QUESTIONS = new ArrayList<String>(Arrays.asList(
            "Seahorses have stomachs for the absorption of nutrients from food",
            "The letter H is between letters G and J on a keyboard",
            "Camels have three sets of eyelashes",
            "If you add the two numbers on the opposite sides of dice together, the answer is always 7",
            "Scallops don't have good vision",
            "The moon is just 50 percent of the mass of Earth",
            "Nearly three percent of the ice in Antarctic glaciers is penguin urine",
            "A snail can sleep for three months",
            "Your nose and sinuses produce almost one liter of mucus a day",
            "Tasting is never determined by what you’re smelling"
            ));

    private ArrayList<Boolean> ANSWERS = new ArrayList<Boolean>(Arrays.asList(
            false,
            true,
            true,
            true,
            false,
            false,
            true,
            false,
            true,
            false
    ));

    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button next = (Button) findViewById(R.id.Next);
        Button previous = (Button) findViewById(R.id.Previous);
        Button fals = (Button) findViewById(R.id.False);
        Button tru = (Button) findViewById(R.id.True);
        TextView text = (TextView) findViewById(R.id.Question);
        text.setText(QUESTIONS.get(index));
        TextView answer = (TextView) findViewById(R.id.Answer);
        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                index++;
                if(index == 10){
                    index = 0;
                }
                text.setText(QUESTIONS.get(index));
            }
        });
        previous.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                index--;
                if(index == -1){
                    index = 9;
                }
                text.setText(QUESTIONS.get(index));
            }
        });
        fals.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(ANSWERS.get(index).booleanValue() == false){
                    answer.setText("Correct!");
                }else{
                    answer.setText("Incorrect");
                }
                index++;
                if(index == 10){
                    index = 0;
                }
                Handler handler=new Handler();
                Runnable r=new Runnable() {
                    public void run() {
                        text.setText(QUESTIONS.get(index));
                        answer.setText(null);
                    }
                };
                handler.postDelayed(r, 2000);
            }
        });
        tru.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(ANSWERS.get(index).booleanValue() == true){
                    answer.setText("Correct!");
                }else{
                    answer.setText("Incorrect");
                }
                index++;
                if(index == 10){
                    index = 0;
                }
                Handler handler=new Handler();
                Runnable r=new Runnable() {
                    public void run() {
                        text.setText(QUESTIONS.get(index));
                        answer.setText(null);
                    }
                };
                handler.postDelayed(r, 2000);
            }
        });
    }
}