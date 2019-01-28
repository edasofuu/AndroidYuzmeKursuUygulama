package com.android.bitirme.sayfalar;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import com.android.bitirme.VeriTabani;
import com.android.bitirme.adapter.kullaniciBilgiListesiAdapter;
import com.example.samet.anasayfa.R;
import com.squareup.picasso.Picasso;
import es.dmoral.toasty.Toasty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UyeBilgileri extends AppCompatActivity {

    private List<Map<String, String>> satirListesi = new ArrayList<>();
    private ListView kullaniciBilgiListesi;
    private int kullaniciID = 0;
    private ImageView kullaniciFotograf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // uye listesi sayfasından tıklanına kişinin ID'sini aliyoruz.
            kullaniciID = Integer.parseInt(extras.getString("kullaniciID"));
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye_bilgileri);

        kullaniciBilgiListesi = findViewById(R.id.uyeBilgiListesi);
        kullaniciFotograf = findViewById(R.id.personelImage);

    }

    @Override
    protected void onResume() {
        super.onResume();


        // veritabanından sorgu yapabilmek için veritabanı nesnesi olusturuyoruz
        VeriTabani db = new VeriTabani(UyeBilgileri.this);

        // seçilen kullanıcının ID'si ile veritabanından kullanıcının bilgilerini getiriyoruz
        ArrayList<HashMap<String, String>> kullaniciBilgileri = db.kullaniciBilgisiniGetir(kullaniciID);

        if (kullaniciBilgileri.size() > 0) {

            bilgiyiSatirListesineEkle("Ad-Soyad", kullaniciBilgileri.get(0).get("AD_SOYAD"));
            bilgiyiSatirListesineEkle("T.C Numarası", kullaniciBilgileri.get(0).get("TC"));
            bilgiyiSatirListesineEkle("Doğum Tarihi", kullaniciBilgileri.get(0).get("DOGUM_TARIHI"));
            bilgiyiSatirListesineEkle("Telefon Numarasi", kullaniciBilgileri.get(0).get("CEP_TELEFONU"));
            bilgiyiSatirListesineEkle("Ev Telefon Numarasi", kullaniciBilgileri.get(0).get("EV_TELEFONU"));
            bilgiyiSatirListesineEkle("Ev Adresi", kullaniciBilgileri.get(0).get("EV_ADRES"));
            bilgiyiSatirListesineEkle("İş Adresi", kullaniciBilgileri.get(0).get("İS_ADRESİ"));
            bilgiyiSatirListesineEkle("Anne Meslek", kullaniciBilgileri.get(0).get("ANNE_MESLEK"));
            bilgiyiSatirListesineEkle("Baba Meslek", kullaniciBilgileri.get(0).get("BABA_MESLEK"));
            bilgiyiSatirListesineEkle("Okulu", kullaniciBilgileri.get(0).get("OKULU"));
            bilgiyiSatirListesineEkle("Sınıfı", kullaniciBilgileri.get(0).get("SINIFI"));
            bilgiyiSatirListesineEkle("Kan Grubu", kullaniciBilgileri.get(0).get("KAN_GRUBU"));
            bilgiyiSatirListesineEkle("Cinsiyeti", kullaniciBilgileri.get(0).get("CİNSİYETİ"));
            bilgiyiSatirListesineEkle("Seans", kullaniciBilgileri.get(0).get("SEANS"));

            Uri fotografUri = Uri.parse(kullaniciBilgileri.get(0).get("RESIM"));

            // Picasso kutuphanesi ile fotografın url'inden  kullanıcını fotografını yüklüyoruz
            Picasso.with(UyeBilgileri.this).load(fotografUri).into(kullaniciFotograf);

            // her bir bilgi için bir satir listesi yapıp Map'e eklemiş olduk .
            // Bu  tüm bilgileri içeren listeyi görünmesi için adapter'a veriyoruz ve adapterimizi listemize setliyoruz
            com.android.bitirme.adapter.kullaniciBilgiListesiAdapter kullaniciBilgiListesiAdapter = new kullaniciBilgiListesiAdapter(UyeBilgileri.this, satirListesi);
            kullaniciBilgiListesi.setAdapter(kullaniciBilgiListesiAdapter);

        } else {
            Toasty.error(getApplicationContext(), "Üzgünüm :( bir hata oluştu.").show();
        }

    }


    // kullanici bilgilerini göstermek için her satır için bir Map Oluşturuyoruz ve bu Map'i listeye ekliyoruz
    public void bilgiyiSatirListesineEkle(String header, String info) {

        Map<String, String> bilgiSatiri = new HashMap<>();
        bilgiSatiri.put(header, info);
        satirListesi.add(bilgiSatiri);
    }
}
