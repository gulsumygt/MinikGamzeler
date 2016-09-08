package com.example.mtmi.minikgamzeler.dataClasses;

/**
 * Created by büşra erçelik on 08.09.2016.
 */
public class Person {

    String ad, soyad, tc, telefon, şifre, email;

    public Person(String ad, String tc, String telefon, String şifre, String email, String soyad) {
        this.ad = ad;
        this.tc = tc;
        this.telefon = telefon;
        this.şifre = şifre;
        this.email = email;
        this.soyad = soyad;
    }
}
