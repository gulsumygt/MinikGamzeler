package com.example.mtmi.minikgamzeler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {

    EditText ad_soyad, konu, mesajınız;
    Button gönder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_activity);

        ad_soyad = (EditText) findViewById(R.id.Ad_Soyad);
        konu = (EditText) findViewById(R.id.konu);
        mesajınız = (EditText) findViewById(R.id.Mesajınız);
        gönder = (Button) findViewById(R.id.Gönder);


        gönder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String adsoyadinput = ad_soyad.getText().toString();
                String konuinput = konu.getText().toString();
                String mesajınızinput = mesajınız.getText().toString();


                if (TextUtils.isEmpty(adsoyadinput)) {
                    Toast.makeText(getApplicationContext(), "Lütfen Adınız ve SoyAdınızı giriniz!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(konuinput)) {
                    Toast.makeText(getApplicationContext(), "Lütfen Konu giriniz!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(mesajınızinput)) {
                    Toast.makeText(getApplicationContext(), "Lütfen Mesajınızı giriniz!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String result = mesajınızinput + "\n" + "\n" + "\n" + adsoyadinput;
                Intent email = new Intent(Intent.ACTION_SEND);

                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"harun140591@hotmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, konuinput);
                email.putExtra(Intent.EXTRA_TEXT, result);


                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));


            }


        });
    }


}
