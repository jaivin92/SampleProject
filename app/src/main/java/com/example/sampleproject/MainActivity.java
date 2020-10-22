package com.example.sampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String tag = "MainAcivity";
    EditText username, userpassword;
    Button submit;
    TextView forgotpassword, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.edit_text_username);
        userpassword = findViewById(R.id.edit_text_userPassword);
        submit = findViewById(R.id.btn_login);
        forgotpassword = findViewById(R.id.text_view_forgotpassword);
        signup = findViewById(R.id.text_view_newuser);

    }

    public void Sinup(View view) {
        Log.d(tag,"sucess login");
    startActivity(new Intent(MainActivity.this, Registration.class));
    }
}