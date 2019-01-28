
package com.android.bitirme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.bitirme.domain.Kullanici;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VeriTabani extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "havuz_database";

    public VeriTabani(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    private static final String ad_soyad = "AD_SOYAD";
    private final String dogum_tarihi = "DOGUM_TARIHI";
    private final String tc = "TC";
    private final String cep_telefonu = "CEP_TELEFONU";
    private final String ev_telefonu = "EV_TELEFONU";
    private final String ev_adres = "EV_ADRES";
    private final String is_adresi = "İS_ADRESİ";
    private final String anne_meslek = "ANNE_MESLEK";
    private final String baba_meslek = "BABA_MESLEK";
    private final String okulu = "OKULU";
    private final String sinifi = "SINIFI";
    private final String kan_grubu = "KAN_GRUBU";
    private final String cinsiyet = "CİNSİYETİ";
    private final String resim = "RESIM";
    private final String seans = "SEANS";

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_KULLANICI_TABLE = "CREATE TABLE IF NOT EXISTS KULLANICILAR (" +
                "ID      INTEGER PRIMARY KEY AUTOINCREMENT,  " + ad_soyad + "  TEXT,  " + dogum_tarihi + "   TEXT,  " + tc + " TEXT, " + cep_telefonu + "  TEXT," +
                ev_telefonu + "     TEXT," + ev_adres + "     TEXT," + is_adresi + "     TEXT,"
                + anne_meslek + "     TEXT," + baba_meslek + "     TEXT, " + okulu + "     TEXT," + sinifi + "     TEXT," +
                kan_grubu + "     TEXT," + cinsiyet + "     TEXT, " + resim + "     TEXT," + seans + " TEXT)";

        db.execSQL(CREATE_KULLANICI_TABLE);

        String CREATE_AIDAT_TABLE = "CREATE TABLE IF NOT EXISTS AIDATLAR  (" + "" +
                "  ID      INTEGER PRIMARY KEY AUTOINCREMENT," +
                "KULLANICI_ID     INTEGER, MIKTAR     TEXT,TARIH     TEXT)";
        db.execSQL(CREATE_AIDAT_TABLE);

        String CREATE_ANTRENOR_TABLE = "CREATE TABLE IF NOT EXISTS ANTRENORLER (  ID INTEGER PRIMARY KEY AUTOINCREMENT,AD_SOYAD TEXT,FOTOGRAF  TEXT )";
        db.execSQL(CREATE_ANTRENOR_TABLE);

        String CREATE_YOKLAMA_TABLE = "CREATE TABLE  IF NOT EXISTS YOKLAMA  (" +
                "ID      INTEGER PRIMARY KEY AUTOINCREMENT," +
                " KULLANICI_ID     INTEGER,       TARIH     TEXT)";

        db.execSQL(CREATE_YOKLAMA_TABLE);

    }


    public void kullaniciKaydet(Kullanici kullanici) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("AD_SOYAD", kullanici.getAdSoyad());
        values.put("DOGUM_TARIHI", kullanici.getDogumTarihi());
        values.put("TC", kullanici.getTC());
        values.put("CEP_TELEFONU", kullanici.getCepTelefonu());
        values.put("EV_TELEFONU", kullanici.getEvTelefonu());
        values.put("EV_ADRES", kullanici.getEvAdresi());
        values.put("İS_ADRESİ", kullanici.getIsAdresi());
        values.put("ANNE_MESLEK", kullanici.getAnneMeslek());
        values.put("BABA_MESLEK", kullanici.getBabaMeslek());
        values.put("OKULU", kullanici.getOkul());
        values.put("SINIFI", kullanici.getSinif());
        values.put("KAN_GRUBU", kullanici.getKanGrubu());
        values.put("CİNSİYETİ", kullanici.getCinsiyeti());
        values.put("RESIM", kullanici.getFotograf());
        values.put("SEANS", kullanici.getSeans());

        db.insert("KULLANICILAR", null, values);
        db.close();

    }

    public List<Kullanici> tumKullanicilariGetir() {

        List<Kullanici> kullanicilar = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        String[] sutunlar = {ad_soyad, dogum_tarihi, tc, cep_telefonu, ev_telefonu, ev_adres, is_adresi, anne_meslek, baba_meslek, okulu, sinifi, kan_grubu, cinsiyet, resim, seans};

        Cursor cursor = db.query("KULLANICILAR", sutunlar, null, null, null, null, null);

        while (cursor.moveToNext()) {
            kullaniciyiListeyeEkle(kullanicilar, cursor);
        }
        return kullanicilar;
    }

    public ArrayList<HashMap<String, String>> tumKullanicilariFormatliSekildeGetir() {

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM KULLANICILAR";
        return selectQuery(db, selectQuery);
    }

    public ArrayList<HashMap<String, String>> kullaniciBilgisiniGetir(int id) {

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM KULLANICILAR" + " WHERE ID = " + id;
        return selectQuery(db, selectQuery);
    }

    private ArrayList<HashMap<String, String>> selectQuery(SQLiteDatabase db, String selectQuery) {
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<HashMap<String, String>> infoList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<>();
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    map.put(cursor.getColumnName(i), cursor.getString(i));
                }

                infoList.add(map);
            } while (cursor.moveToNext());
        }
        db.close();
        return infoList;
    }

    private void kullaniciyiListeyeEkle(List<Kullanici> kullanicilar, Cursor cursor) {
        Kullanici kullanici = new Kullanici(cursor.getString(0), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),
                cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10),
                cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14));

        kullanicilar.add(kullanici);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public ArrayList<HashMap<String, String>> seansKullanicilariniGetir(String secilenSeans) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM KULLANICILAR" + " WHERE SEANS = '" + secilenSeans + "'";
        return selectQuery(db, selectQuery);
    }
}
