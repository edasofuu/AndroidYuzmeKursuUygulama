package com.android.bitirme.sayfalar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import com.example.samet.anasayfa.R;

public class Anasayfa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);

        Button uyeListesiButton = findViewById(R.id.uyeListesiButon);

        // uye listesi butonuna tıklayınca uye listesi sayfası aciliyor
        uyeListesiButton.setOnClickListener(v -> {
            startActivity(new Intent(Anasayfa.this, UyeListesi.class));
        });

        Button yeniUyeButton = findViewById(R.id.yeniUyeButon);
        // yeni uye butonuna tıklayınca yeni uye sayfası aciliyor
        yeniUyeButton.setOnClickListener(v -> {
            startActivity(new Intent(Anasayfa.this, YeniUye.class));
        });

        Button yoklamaButton = findViewById(R.id.yoklamaButton);
        // yoklama sayfası acılıyor
        yoklamaButton.setOnClickListener(v -> {
            startActivity(new Intent(Anasayfa.this, Yoklama.class));
        });
    }
}
