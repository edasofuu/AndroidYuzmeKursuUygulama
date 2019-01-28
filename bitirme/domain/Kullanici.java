package com.android.bitirme.domain;

public class Kullanici {
    private String adSoyad;
    private String dogumTarihi;
    private String TC;
    private String cepTelefonu;
    private String evTelefonu;
    private String evAdresi;
    private String isAdresi;
    private String anneMeslek;
    private String babaMeslek;
    private String okul;
    private String sinif;
    private String kanGrubu;
    private String cinsiyeti;
    private String fotograf;
    private String seans;
//    private String YUZME_BILGISI;
//    private String ANTRENOR_ID;
//    private String GECIRDIGI_AMELIYATLAR;
//    private String SAGLIK_SORUNLARI;
//    private String KULLANDIGI_ILACLAR;
//    private String BOY;
//    private String KILO;
//    private String IKI_KOL_BOYU;
//    private String BACAK_UZUNLUGU;
//    private String OMUZ_GENISLIGI;
//    private String LISANS_NO;
//    private String KATILDIGI_YARISLAR;


    public Kullanici() {
    }

    public Kullanici(String adSoyad, String dogumTarihi, String TC, String cepTelefonu, String evTelefonu, String evAdresi, String isAdresi,
                     String anneMeslek, String babaMeslek, String okul, String sinif, String kanGrubu, String cinsiyeti, String fotograf,String seans) {
        this.adSoyad = adSoyad;
        this.dogumTarihi = dogumTarihi;
        this.TC = TC;
        this.cepTelefonu = cepTelefonu;
        this.evTelefonu = evTelefonu;
        this.evAdresi = evAdresi;
        this.isAdresi = isAdresi;
        this.anneMeslek = anneMeslek;
        this.babaMeslek = babaMeslek;
        this.okul = okul;
        this.sinif = sinif;
        this.kanGrubu = kanGrubu;
        this.cinsiyeti = cinsiyeti;
        this.fotograf = fotograf;
        this.seans = seans;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getTC() {
        return TC;
    }

    public void setTC(String TC) {
        this.TC = TC;
    }

    public String getCepTelefonu() {
        return cepTelefonu;
    }

    public void setCepTelefonu(String cepTelefonu) {
        this.cepTelefonu = cepTelefonu;
    }

    public String getEvTelefonu() {
        return evTelefonu;
    }

    public void setEvTelefonu(String evTelefonu) {
        this.evTelefonu = evTelefonu;
    }

    public String getEvAdresi() {
        return evAdresi;
    }

    public void setEvAdresi(String evAdresi) {
        this.evAdresi = evAdresi;
    }

    public String getIsAdresi() {
        return isAdresi;
    }

    public void setIsAdresi(String isAdresi) {
        this.isAdresi = isAdresi;
    }

    public String getAnneMeslek() {
        return anneMeslek;
    }

    public void setAnneMeslek(String anneMeslek) {
        this.anneMeslek = anneMeslek;
    }

    public String getBabaMeslek() {
        return babaMeslek;
    }

    public void setBabaMeslek(String babaMeslek) {
        this.babaMeslek = babaMeslek;
    }

    public String getOkul() {
        return okul;
    }

    public void setOkul(String okul) {
        this.okul = okul;
    }

    public String getSinif() {
        return sinif;
    }

    public void setSinif(String sinif) {
        this.sinif = sinif;
    }

    public String getKanGrubu() {
        return kanGrubu;
    }

    public void setKanGrubu(String kanGrubu) {
        this.kanGrubu = kanGrubu;
    }

    public String getCinsiyeti() {
        return cinsiyeti;
    }

    public void setCinsiyeti(String cinsiyeti) {
        this.cinsiyeti = cinsiyeti;
    }

    public String getFotograf() {
        return fotograf;
    }

    public void setFotograf(String fotograf) {
        this.fotograf = fotograf;
    }

    public String getSeans() {
        return seans;
    }

    public void setSeans(String seans) {
        this.seans = seans;
    }
}
