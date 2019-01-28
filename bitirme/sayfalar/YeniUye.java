package com.android.bitirme.sayfalar;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import com.android.bitirme.VeriTabani;
import com.android.bitirme.domain.Kullanici;
import com.android.bitirme.model.ImagePicker;
import com.example.samet.anasayfa.R;
import es.dmoral.toasty.Toasty;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

public class YeniUye extends AppCompatActivity {

    private EditText adSoyadEditText, dogumTarihiEditText, tcNumberEditText, evTelEditText,
            cepTelEditText, evAdresiEditText, isAdresiEditText, anneMeslekEditText,
            babaMeslekEditText, okulEditText, sinifEditText, kanGrubuEditText, cinsiyetEditText;
    private Button kaydetButton;
    private Spinner seanslar;
    private static final String CACHED_IMG_KEY = "img_key";
    private static String imageUrl = null;
    private static final int SECOND_PIC_REQ = 1313;
    private static String secilenSeans = "";

    private ImageView imagePreview;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeniuye);

        defineItems();
        fotografCekmeYadaSecme();
        seansSecilmeIslemi();
        kaydetButonu();
    }

    private void fotografCekmeYadaSecme() {
        ImageButton fotografCekButonu = findViewById(R.id.takePicture);
        ImagePicker.setMinQuality(250, 250);
        imagePreview = findViewById(R.id.imagePreview);
        fotografCekButonu.setOnClickListener(v -> {

            //once kamera acmak için izin istiyoruz...
            ActivityCompat.requestPermissions(YeniUye.this,
                    new String[]{Manifest.permission.CAMERA},
                    1);

            ImagePicker.pickImage(YeniUye.this, "Bir Fotoğraf Seçin", SECOND_PIC_REQ, false);
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void kaydetButonu() {
        // Kaydet butonuna tıklanınca olacak işlemler..
        kaydetButton.setOnClickListener(v -> {

            String adSoyad = adSoyadEditText.getText().toString();
            String dogumTarihi = dogumTarihiEditText.getText().toString();
            String tc = tcNumberEditText.getText().toString();
            String evTel = cepTelEditText.getText().toString();
            String cepTel = evTelEditText.getText().toString();
            String evAdres = evAdresiEditText.getText().toString();
            String isAdres = isAdresiEditText.getText().toString();
            String anneMeslek = anneMeslekEditText.getText().toString();
            String babaMeslek = babaMeslekEditText.getText().toString();
            String okul = okulEditText.getText().toString();
            String sinif = sinifEditText.getText().toString();
            String kanGrubu = kanGrubuEditText.getText().toString();
            String cinsiyet = cinsiyetEditText.getText().toString();


            // Girilen bilgiler ile bir kullanici nesnesi olusturuluyor.
            Kullanici kullanici = new Kullanici(adSoyad, dogumTarihi, tc, cepTel, evTel,
                    evAdres, isAdres, anneMeslek, babaMeslek, okul, sinif, kanGrubu, cinsiyet, imageUrl, secilenSeans);

            VeriTabani veriTabani = new VeriTabani(YeniUye.this);

            // veritabanından tum kullanıcılar getiriliyor
            List<Kullanici> kullanicilar = veriTabani.tumKullanicilariGetir();


            // Girilen TC ile daha onca kayıt olmus birisi var mı diye bakılıyor
            boolean tcZatenKayitliMi = kullanicilar.stream().anyMatch(user -> user.getTC().equals(tc));

            // Fotoğraf secildi mi diye bakılıyor. ( Null mı diye bakıyoruz ) -- Secim yapılmadıysa null oluyor cünkü
            boolean fotografSecildiMi = Objects.isNull(imageUrl);


            // TC zaten kayıtlı veya Fotograf secilmediyse Uyarı gosterip kaydetmiyoruz.
            if (tcZatenKayitliMi) {
                Toasty.error(this, " Bu TC ile bir kullanici zaten var!", Toast.LENGTH_LONG).show();
            } else if (fotografSecildiMi) {
                Toasty.error(this, " FOTOĞRAF SEÇİLMEDİ !", Toast.LENGTH_LONG).show();

            } else {

                // Tüm sartlar saglandıysa kullanıcıyı veritabanına kaydediyoruz.
                veriTabani.kullaniciKaydet(kullanici);
                Toasty.success(this, adSoyad + " isimli kullanici kaydedildi!", Toast.LENGTH_LONG, true).show();
            }

        });
    }

    private void seansSecilmeIslemi() {

        // her seans secilme isleminden sonra secilenSeans degerini güncelliyoruz
        seanslar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                secilenSeans = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    // Ekrandaki tüm itemleri kod içerisinden erişelebilmek için idleri ile tanimliyoruz
    private void defineItems() {
        kaydetButton = this.findViewById(R.id.kaydetButton);
        adSoyadEditText = this.findViewById(R.id.adSoyadEditText);
        dogumTarihiEditText = this.findViewById(R.id.dogumTarihiEditText);
        tcNumberEditText = this.findViewById(R.id.tcNumberEditText);
        evTelEditText = this.findViewById(R.id.evTelEditText);
        cepTelEditText = this.findViewById(R.id.cepTelEditText);
        evAdresiEditText = this.findViewById(R.id.evAdresEditText);
        isAdresiEditText = this.findViewById(R.id.isAdresEditText);
        anneMeslekEditText = this.findViewById(R.id.anneMeslekEditText);
        babaMeslekEditText = this.findViewById(R.id.babaMeslekEditText);
        okulEditText = this.findViewById(R.id.okulEditText);
        sinifEditText = this.findViewById(R.id.sınıfEditText);
        kanGrubuEditText = this.findViewById(R.id.kanGrubuEditText);
        cinsiyetEditText = this.findViewById(R.id.cinsiyetEditText);
        seanslar = this.findViewById(R.id.seanslar);


        // Seanslar listesini gösterebilmek için adapter tanımlıyoruz.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.seanlar_listesi, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        seanslar.setAdapter(adapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case SECOND_PIC_REQ:
                String imagePathFromResult = ImagePicker.getImagePathFromResult(YeniUye.this,
                        requestCode, resultCode, data);
                if (imagePathFromResult != null) {
                    String path = "file:///" + imagePathFromResult;
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(YeniUye.this);
                    prefs.edit().putString(CACHED_IMG_KEY, imagePathFromResult).apply();
                    imageUrl = path;
                    //  Picasso.with(YeniUye.this).load(path).into(imagePreview);
                    imagePreview.setImageBitmap(null);
                    imagePreview.setImageURI(Uri.parse(path));
                }
        }
        InputStream is = ImagePicker.getInputStreamFromResult(YeniUye.this, requestCode, resultCode, data);
        if (is != null) {
            Toasty.success(getApplicationContext(), "Fotoğraf başarıyla eklendi").show();
            try {
                is.close();
            } catch (IOException ex) {
                // ignore
            }
        } else {
            Toasty.error(getApplicationContext(), "Fotoğraf eklenirken hata oluştu!").show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    Toasty.warning(YeniUye.this, "Cihazın hafızasından okuma erişimi engelledi", Toast.LENGTH_SHORT).show();
                }
                return;
            }


        }
    }
}
