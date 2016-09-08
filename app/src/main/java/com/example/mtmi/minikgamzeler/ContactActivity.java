package com.example.mtmi.minikgamzeler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class ContactActivity extends AppCompatActivity {

    EditText ad_soyad,iletişimemail,konu,mesajınız;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_activity);

        ad_soyad = (EditText) findViewById(R.id.Ad_Soyad);
        iletişimemail= (EditText) findViewById(R.id.iletisim_email);
        konu= (EditText) findViewById(R.id.konu);
        mesajınız= (EditText) findViewById(R.id.Mesajınız);








    }
}
