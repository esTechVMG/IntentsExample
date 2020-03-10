package com.estechvmg.intents;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SentActivity extends AppCompatActivity {
    public TextView welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sent);
        Bundle b=getIntent().getExtras();
        String name=b.getString("NAME");
        welcome=findViewById(R.id.welcome);
        welcome.setText("Welcome " + name);

    }
}
