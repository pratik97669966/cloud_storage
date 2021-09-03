package com.mobigic.cloud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class SignUp extends AppCompatActivity {
    TextInputLayout regname, regusername, regemail, regphone, regpassword;
    Button regBtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    RadioGroup radioGroup;
    RadioButton selectedGender;
    DatePicker datePicker;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //hooks for username

        regphone = (TextInputLayout) findViewById(R.id.signup_phone_number);
        scrollView = findViewById(R.id.scrollView);
        //hooks for date and gender


    }



    public void nextbutton(View view) {
        String phoneno = regphone.getEditText().getText().toString();
        String phoneNo = "+" + "91" + phoneno;

        Toast.makeText(this, "Form succes", Toast.LENGTH_SHORT).show();
        //send data to next activity
        Intent intent = new Intent(getApplicationContext(), VerifyOtp2.class);
        intent.putExtra("phoneno", phoneNo);
        startActivity(intent);
        finish();

    }

    }
