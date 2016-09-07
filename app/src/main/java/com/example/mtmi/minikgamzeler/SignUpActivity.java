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

    private EditText email, password, passwordcontrol, ad, soyad, Tc, telefon;
    private Button signup, signinbutton, resetpasswordbutton;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();
        resetpasswordbutton = (Button) findViewById(R.id.btn_reset_password);
        signinbutton = (Button) findViewById(R.id.sign_in_button);
        email = (EditText) findViewById(R.id.email_signup);
        password = (EditText) findViewById(R.id.password_signup);
        signup = (Button) findViewById(R.id.signup2);
        passwordcontrol = (EditText) findViewById(R.id.password_control);
        ad = (EditText) findViewById(R.id.Ad);
        soyad = (EditText) findViewById(R.id.soy_ad);
        Tc = (EditText) findViewById(R.id.Tc);
        telefon = (EditText) findViewById(R.id.telefon);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailInput = email.getText().toString();
                String passInput = password.getText().toString();
                String passcontInput = passwordcontrol.getText().toString();
                String TcInput = Tc.getText().toString();
                String adInput = ad.getText().toString();
                String soyadınput = soyad.getText().toString();
                String telefoninput = telefon.getText().toString();

                if (TextUtils.isEmpty(adInput)) {
                    Toast.makeText(getApplicationContext(), "Lütfen Adınızı giriniz!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(soyadınput)) {
                    Toast.makeText(getApplicationContext(), "Lütfen Soyadınızı giriniz!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(TcInput)) {
                    Toast.makeText(getApplicationContext(), "Lütfen T.C. nonuzu giriniz!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (Tc.length() < 11) {
                    Toast.makeText(getApplicationContext(), "Lütfen 11 haneli T.C. nonuzu giriniz!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(telefoninput)) {
                    Toast.makeText(getApplicationContext(), "Lütfen Telefon numaranızı başında 0 olmadan giriniz!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(emailInput)) {
                    Toast.makeText(getApplicationContext(), "Lütfen Email Adresi giriniz!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(passInput)) {
                    Toast.makeText(getApplicationContext(), "Lütfen Şifre giriniz!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (passInput.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Şifre çok kısa, Minimum 6 karakter!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!passInput.equals(passcontInput)) {
                    Toast.makeText(getApplicationContext(), "Şifreler uyuşmuyor!", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.createUserWithEmailAndPassword(emailInput, passInput).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
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

        signinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });

        resetpasswordbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, ResetPasswordActivity.class));
            }

        });

    }
}
