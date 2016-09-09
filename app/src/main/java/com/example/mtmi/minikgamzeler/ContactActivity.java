package com.example.mtmi.minikgamzeler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {

    EditText ad_soyad,iletişimemail,konu,mesajınız;
    Button  gönder;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_activity);

        ad_soyad = (EditText) findViewById(R.id.Ad_Soyad);
        iletişimemail= (EditText) findViewById(R.id.iletisim_email);
        konu= (EditText) findViewById(R.id.konu);
        mesajınız= (EditText) findViewById(R.id.Mesajınız);
        gönder= (Button) findViewById(R.id.Gönder);


        gönder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar = (ProgressBar) findViewById(R.id.progressBar);
                String adsoyadinput = ad_soyad.getText().toString();
                String iletişimemailinput = iletişimemail.getText().toString();
                String konuinput = konu.getText().toString();
                String mesajınızinput = mesajınız.getText().toString();
                showOrder(adsoyadinput, iletişimemailinput, konuinput, mesajınızinput);

                if (TextUtils.isEmpty(adsoyadinput)) {
                    Toast.makeText(getApplicationContext(), "Lütfen Adınız ve SoyAdınızı giriniz!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(iletişimemailinput)) {
                    Toast.makeText(getApplicationContext(), "Lütfen Email adresinizi giriniz!", Toast.LENGTH_SHORT).show();
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

                private void showOrder (String adsoyadinput, String iletişimemailinput, String konuinput,String mesajınızinput) {
                    String result = adsoyadinput + iletişimemailinput + konuinput + mesajınızinput ;

                    //Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

                    String emailAddress = "harun140591@hotmail.com";

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
                    intent.putExtra(Intent.EXTRA_TEXT, result);

                }
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
