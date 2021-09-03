package com.mobigic.cloud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashBoard extends AppCompatActivity {
    TextView textusername;
    TextInputEditText etRegPhone;
    String phone,phone1;
    TextInputLayout regphone ;
    Button verify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        textusername=findViewById(R.id.textuser);
        etRegPhone = findViewById(R.id.etRegPhone);
        verify=findViewById(R.id.btn_verify);
        regphone = (TextInputLayout) findViewById(R.id.signup_phone_number);
        String phoneno = regphone.getEditText().getText().toString();
        phone1="+" + "91" + phoneno;



        verify.setOnClickListener(view ->{
            Intent intent = new Intent(getApplicationContext(), DashBoard.class);
            intent.putExtra("phoneno",phone1);
            startActivity(new Intent(DashBoard.this, VerifyOtp2.class));
            finish();
        });
}



}