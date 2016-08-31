package com.example.mtmi.minikgamzeler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button signIn, signUp;

    SessionManagement session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new SessionManagement(getApplicationContext());

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        signIn = (Button) findViewById(R.id.signin);
        signUp = (Button) findViewById(R.id.signup);

        signIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Log.v("button: ", "button clicked");

                String emailInput = email.getText().toString();
                final String passInput = password.getText().toString();

                if (TextUtils.isEmpty(emailInput)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(passInput)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (passInput.length() < 5) {
                    Toast.makeText(getApplicationContext(), "şifre 5 karakten az olamaz", Toast.LENGTH_SHORT).show();
                    return;
                }

//                if (emailInput != "admin" && passInput != "admin") {
//                    Toast.makeText(getApplicationContext(), "yanlış mail ya da şifre girdiniz", Toast.LENGTH_SHORT).show();
//                    return;
//                }


                session.createLoginSession("Android Hive","test@gmail.com");

                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();}

        });

    }
}
