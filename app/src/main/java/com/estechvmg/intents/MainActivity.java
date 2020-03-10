package com.estechvmg.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public CheckBox check;
    public Button send;
    public EditText firstName,lastName,age,optional;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send=findViewById(R.id.sendButton);
        check=findViewById(R.id.checkBox);
        firstName=findViewById(R.id.firstName);
        lastName=findViewById(R.id.lastName);
        age=findViewById(R.id.age);
        optional=findViewById(R.id.optional);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check.isChecked()){
                    optional.setVisibility(View.VISIBLE);
                }else{
                    optional.setVisibility(View.GONE);
                }
            }
        });;
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmpty(firstName)|isEmpty(lastName)|isEmpty(age)|(check.isChecked() && isEmpty(optional))){
                    makeToast("Please fill all the fields");
                }else if(Integer.parseInt(getTextInString(age))<18){
                    makeToast("You must be 18+ to register");
                }else{
                    Intent intent = new Intent(MainActivity.this, SentActivity.class);
                    intent.putExtra("NAME",getTextInString(firstName) + " " + getTextInString(lastName));
                    startActivity(intent);
                }
            }
        });
    }
    public void makeToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    public static String getTextInString(EditText e){
        return e.getText().toString();
    }
    private boolean isEmpty(EditText e){
        return getTextInString(e).isEmpty();
    }
}
