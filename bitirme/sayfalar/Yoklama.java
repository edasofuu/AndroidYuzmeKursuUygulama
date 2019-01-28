package com.android.bitirme.sayfalar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import com.android.bitirme.VeriTabani;
import com.android.bitirme.adapter.YoklamaListAdapter;
import com.example.samet.anasayfa.R;
import es.dmoral.toasty.Toasty;

import java.util.ArrayList;
import java.util.HashMap;

public class Yoklama extends AppCompatActivity {

    private static String secilenSeans = "";
    private ListView yoklamaListesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoklama);

        seansSecilmeIslemi();

        yoklamaListesi = findViewById(R.id.yoklamalarListesi);
        Button seansSecButton = this.findViewById(R.id.seansSecButton);
        seansSecButton.setOnClickListener(v -> {
            listeyiDoldur();
        });

    }

    private void seansSecilmeIslemi() {
        Spinner seanslar = this.findViewById(R.id.seanslar);

        // Seanslar listesini gösterebilmek için adapter tanımlıyoruz.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.seanlar_listesi, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        seanslar.setAdapter(adapter);

        // her seans secilme isleminden sonra secilenSeans degerini güncelliyoruz
        seanslar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                secilenSeans = (String) parent.getItemAtPosition(position);
                Toasty.info(getApplicationContext(), secilenSeans + " Seansı Seçildi", Toast.LENGTH_LONG).show();
                listeyiDoldur();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //secilen seansa göre yoklama listesi
        if (!secilenSeans.isEmpty()) {
            listeyiDoldur();
        }

    }

    public void listeyiDoldur() {
        VeriTabani db = new VeriTabani(Yoklama.this);
        ArrayList<HashMap<String, String>> kullaniciBilgileri = db.seansKullanicilariniGetir(secilenSeans);

        int size = kullaniciBilgileri.size();
        ///yoklamada kimse yoksa uyari ver
        if (size == 0) {
            Toasty.info(getApplicationContext(), "Yoklama Listesinde Kimse Yok", Toast.LENGTH_SHORT).show();
        }
        //gelen liste boyutuna gore dizileri olustur
        String[] adSoyad = new String[size];
        String[] kullaniciTCNo = new String[size];
        String[] kullaniciID = new String[size];

        //kullanıcılar veritabanından alınıyor.
        for (int j = 0; j < kullaniciBilgileri.size(); j++) {
            //adi soyadi
            adSoyad[j] = kullaniciBilgileri.get(size - j - 1).get("AD_SOYAD");
            //tckn
            kullaniciTCNo[j] = kullaniciBilgileri.get(size - j - 1).get("TC");
            //kullanici id
            kullaniciID[j] = kullaniciBilgileri.get(size - j - 1).get("ID");
        }

        YoklamaListAdapter yoklamaListAdapter = new YoklamaListAdapter(Yoklama.this, adSoyad, kullaniciTCNo);
        yoklamaListesi.setAdapter(yoklamaListAdapter);
    }
}
