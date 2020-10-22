package com.example.sampleproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;


public class Registration extends AppCompatActivity {
    private static final String tag = "Registration";
    EditText username, phoneno, emailid, password,confirmpassword;
    Button save;
    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initview();
        awasomevalidation();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate()) {
                    if (password.getText().toString().matches( confirmpassword.getText().toString())) {
                       // startActivity(new Intent(Registration.this, MainActivity.class));
                    }
                    else {
                         Toast.makeText(getApplicationContext(), "Please Check Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void initview(){
        username = findViewById(R.id.edit_text_newusername);
        phoneno = findViewById(R.id.edit_text_mobileNo);
        emailid = findViewById(R.id.edit_text_emailid);
        password = findViewById(R.id.edit_text_password);
        confirmpassword = findViewById(R.id.edit_text_confirmpassword);
        save = findViewById(R.id.btn_save);
    }

    private void awasomevalidation() {
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(username,"^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$","Please Enter");
        awesomeValidation.addValidation(phoneno, Patterns.PHONE, "Please Check");
        awesomeValidation.addValidation(emailid, Patterns.EMAIL_ADDRESS,"Please Check");
        String regexPassword = ".{3,}";
        awesomeValidation.addValidation(password, regexPassword, "Please Enter");
        awesomeValidation.addValidation(confirmpassword, regexPassword, "Password not match");
    }

}