package com.estechvmg.intents;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SentActivity extends AppCompatActivity {
    public TextView welcome,counter;
    public Button reset,sum;
    public LinearLayout lay;
    private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sent);
        Bundle b=getIntent().getExtras();
        String name=b.getString("NAME");
        welcome=findViewById(R.id.welcome);
        welcome.setText("Welcome " + name);
        sum=findViewById(R.id.addToCount);
        reset=findViewById(R.id.reset);
        lay=findViewById(R.id.lay);
        counter=findViewById(R.id.counter);
        updateCounter();
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                updateCounter();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=0;
                updateCounter();
            }
        });
    }
    private void updateCounter() {
        counter.setText(String.valueOf(count));
        if (count<=10){
            lay.setBackgroundColor(Color.GREEN);
        }else if(count <= 50){
            lay.setBackgroundColor(Color.YELLOW);
        }else{
            lay.setBackgroundColor(Color.RED);
        }
    }
}
