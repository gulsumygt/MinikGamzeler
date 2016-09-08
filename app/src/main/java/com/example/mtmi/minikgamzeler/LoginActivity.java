package com.example.mtmi.minikgamzeler;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button signIn, signUp, resetpassword;
    ProgressBar progressBar;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        setContentView(R.layout.activity_login);


        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        signIn = (Button) findViewById(R.id.signin);
        signUp = (Button) findViewById(R.id.signup);
        resetpassword = (Button) findViewById(R.id.btn_reset_password);

        signIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Log.v("button: ", "button clicked");

                String emailInput = email.getText().toString();
                final String passInput = password.getText().toString();

                if (TextUtils.isEmpty(emailInput)) {
                    Toast.makeText(getApplicationContext(), "Lütfen Email adresi giriniz!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(passInput)) {
                    Toast.makeText(getApplicationContext(), "Lütfen Şifre giriniz!", Toast.LENGTH_SHORT).show();
                    return;
                }


                auth.signInWithEmailAndPassword(emailInput, passInput).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            // there was an error
                            if (password.length() < 6) {
                                Toast.makeText(getApplicationContext(), "şifre 5 karakten az olamaz", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "Giriş başarısız oldu", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            }


        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });

        resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ResetPasswordActivity.class));
            }

        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }

    }
}

