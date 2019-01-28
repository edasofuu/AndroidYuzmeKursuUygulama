package com.android.bitirme.sayfalar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import com.android.bitirme.VeriTabani;
import com.android.bitirme.adapter.KullaniciListesiAdapter;
import com.example.samet.anasayfa.R;

import java.util.ArrayList;
import java.util.HashMap;

public class UyeListesi extends AppCompatActivity {
    private ListView kullaniciListesi;
    private String[] kullaniciID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye_listesi);

        kullaniciListesi = findViewById(R.id.uyeListesi);


        // Kullanici listesinden herhangi bir satıra tıklanıldıgın bu fonksiyon calısıyor
        // Bu fonksiyona tıklanılan satırın  "position" bilgisi geliyor
        // Gelen pozsiyon bilgisi üzerinden hangi kullanıcının tıklandıgını bulup
        // tıklanılan kullanıcının ID'sini diğer sayfaya yolluyoruz
        // Yolladıgımız ID bilgisi ile de diğer sayfada tıklanılan kullanıcının bilgilerini alıp gösteriyoruz.
        kullaniciListesi.setOnItemClickListener((parent, view, position, id) -> {
            Intent uyeBilgileriSayfasi = new Intent(UyeListesi.this, UyeBilgileri.class);

            // ID bilgisini diğer sayfaya yolla
            uyeBilgileriSayfasi.putExtra("kullaniciID", kullaniciID[position]);

            // uye bilgileri sayfasını aç
            startActivity(uyeBilgileriSayfasi);
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        VeriTabani db = new VeriTabani(UyeListesi.this);

        // Veritabanından tüm kullanıcıları alıyoruz
        ArrayList<HashMap<String, String>> kullaniciBilgieriListesi = db.tumKullanicilariFormatliSekildeGetir();
        int boyut = kullaniciBilgieriListesi.size();

        String[] adSoyad = new String[boyut];
        String[] kullaniciTC = new String[boyut];
        kullaniciID = new String[boyut];


        // Her bir kullanıcıyı listeye koyuyoruz
        for (int j = 0; j < kullaniciBilgieriListesi.size(); j++) {
            adSoyad[j] = kullaniciBilgieriListesi.get(boyut - j - 1).get("AD_SOYAD");
            kullaniciTC[j] = kullaniciBilgieriListesi.get(boyut - j - 1).get("TC");
            kullaniciID[j] = kullaniciBilgieriListesi.get(boyut - j - 1).get("ID");
        }

        // kullanci listesi için adapter tanımlıyoruz  ve göstermek istediğimiz bilgileri veriyoruz.
        KullaniciListesiAdapter kullaniciListesiAdapter = new KullaniciListesiAdapter(UyeListesi.this, adSoyad, kullaniciTC);

        // olusturdugumuz adapteri setliyoruz.
        kullaniciListesi.setAdapter(kullaniciListesiAdapter);

    }
}
