package com.example.mtmi.minikgamzeler;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText email,password;
    private Button signup;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth=FirebaseAuth.getInstance();

        email= (EditText) findViewById(R.id.email_signup);
        password= (EditText) findViewById(R.id.password_signup);
        signup= (Button) findViewById(R.id.signup2);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailInput=email.getText().toString();
                String passInput=password.getText().toString();
                if (TextUtils.isEmpty(emailInput)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(passInput)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.createUserWithEmailAndPassword(emailInput,passInput).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                            finish();
                        }
                    }
                });
            }
        });


    }
}
