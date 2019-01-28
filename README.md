# AndroidY-zmeKursuUygulama
Araştırma Problemleri 
 Projenin Layoutları

   Bir Android projesine başlamadan önce XML’in ne olduğu ile ilgili bilgi edinmek önemlidir. Bu sebeple XML’den temelce bahsedilecek bu bölümde bir XML dosyası nasıl oluşturulur ve ne işe yarar gibi konulara değinilecek.
  XML 'i kısaca tanımlamak gerekirse: XML, bir belgenin yapısını ve görünümünü tanımlamak için kullanılan, platform bağımsız bir işaretleme dilidir. Ayrıca veri taşımak için kullanılan uluslararası standarttır. 
  Bu Android uygulamasını yaparken XML sayfaları tasarlamak için kullanıldı. Projenin anasayfası ile başlayıp karşılaşılabilecek her ekran için bir tasarım, xml dosyası, bulunacaktır.  
   Android Studio’da sıfırdan bir proje açtığımızda bize ilk başlayacağımız ekranı seçmemizi söyler. 
  				  Şekil 2.1: Activity Seçme Ekranı
Şekil 2.2 : XML Dosyası İsimlendirme


   Next ile ulaşılan sayfada dikkat edilecek olursa Layout kısmında yer alan isim bizim XML dosyamızın ismi olacaktır. 

  Bundan sonra kaydedilen bütün XML dosyaları projenin altında bulunan layouts dosyasında yer alacak. Bizim halihazırdaki projemiz için xml dosyaları şu şekildedir:


	      Şekil 2.3 : Yüzme Kursu Uygulaması XML dosyaları

   3. ANASAYFA

   Oluşturulan projeye başlangıç olarak eklenecek Activity’yi oluşturma bir önceki bölümde gösterilmişti. Şimdi ise var olan projeye başka sayfalar eklemek istendiğinde ne yapılması gerektiğine bakalım.


		 	Şekil 3.1 : Var olan projeye yeni Activity ekleme

   Ekranın sağ köşesinde bulunan sekmede projenin katmanları görülüyor. Java klasörü altından projeminin main dosyasına sağ tıklanıldığında  açılan listeden “New” seçeneğini seçerek; gerektiğinde yeni java classı gerektiğinde Activity ve daha birçok sayfa eklenebiliyor . Burada tasarlanmak üzere boş bir Activity sayfası seçildi. Gerekli komponentler seçilerek aktif bir şekilde tasarım yapıldı. Bu tasarımlar yapılırken XML dosyalarında gerekli kod da kendiliğinden oluştu. Gerektiği takdirde kodlama ile tasarım da yapılabilir fakat bu yöntem pek tercih edilmez. Tasarımda ufak oynamalar yapılacağı zaman kodda değişiklik yapılabilir. Örneğin elle tutturulması zor oranları kodda yazarak tam olarak istenen boyuta ulaşılabilir. 
 
   			         Şekil 3.2: Anasayfa Ekran Tasarımı

  Tasarımda kullanılan komponentler, textview, tablerow ve buttonlardır. 
TableRow’lar ile düzenli bir görünüm sağlandı. İki adet TableRow kullanıldı ve bunların her birine 3’er tane Button eklendi. Arka plan rengi kurumsal renk olan sarı yapılarak tasarıma renk katıldı. Hangi sayfada olduğumuzu belirten “Anasayfa” yazısı ise TextView kullanılarak sayfaya eklendi. Buttonların tasarımları ayrı bir programda yapıldı ve background olarak butonlara eklendi. Bu butonların üzerilerine tıklanarak ilgili sayfalara geçiş sağlanıyor. 
 Şekil 3.2’de görülen ekranı oluşturabilmek için yazılan XML kodu ise aşağıda verildiği gibidir. 
 
<TextView
   android:id="@+id/textView8"
   android:layout_width="272dp"
   android:layout_height="76dp"
   android:layout_centerHorizontal="true"
   android:layout_marginStart="4dp"
   android:layout_marginLeft="4dp"
   android:layout_marginTop="95dp"
   android:layout_marginEnd="8dp"
   android:layout_marginRight="8dp"
   android:layout_marginBottom="8dp"
   android:text="ANASAYFA"
   android:textColor="@android:color/background_dark"
   android:textSize="50sp" />


                                          Tablo 3.1.  : TextView kodu örneği 

      
<Button
   android:id="@+id/yeniUyeButon"
   style="@style/Widget.AppCompat.Button.Borderless.Colored"
   android:layout_width="400dp"
   android:layout_height="match_parent"
   android:background="@drawable/yeniuye"
   android:ellipsize="none"
   android:textColor="@android:color/background_dark"
   android:textSize="30sp" />


   	          Tablo 3.2. : Button Kodu Örneği

  Örnekteki button tasarımının kodunda dikkat edilmesi gereken, daha önce de belirtildiği gibi, yapılan tasarımın butona background olarak eklenmesi. @drawable kullanarak istenilen herhangi bir resim butonun üzerine eklenebilir. Aynı şekilde imageview kullanırken de drawable’dan yararlanılır. Drawable’ın kullanılacağı resmi görmesi için resmin dosya yolunun ayarlanması gerekiyor. Projenin klasöründe C:...PROJE-KLASÖRÜ...\app\src\main\res\drawable klasörüne erişerek bu klasörün içine kullanmak istenilen resimler atılmalıdır. Projede kullanılacak tüm resimler bu klasörün içinde bulunacaktır ve gerektiğinde isimleriyle birlikte drawable ile çağırılacaklardır. 
 	

<TableRow
   android:id="@+id/tableRow5"
   android:layout_width="match_parent"
   android:layout_height="200dp"
   android:layout_above="@+id/bottomLayout"
   android:layout_marginStart="8dp"
   android:layout_marginLeft="8dp"
   android:layout_marginTop="8dp"
   android:layout_marginEnd="8dp"
   android:layout_marginRight="8dp"
   android:layout_marginBottom="12dp"
   android:background="@color/colorPrimary">
  			Tablo 3.3.  : TableRow Kullanımı Kodu 
                   
				

 

  TableRow xml kodu da diğerleriyle benzer. Her birinde boyut, id, konum gibi bilgilendirmeler yapılıyor. TableRow’un kurumun rengi olan sarı olmasını istediğimiz için bu sarıyı seçildi koda da son satırdaki hali ile yansıdı. Seçme işlemini yaparken TableRow özelliklerinden backgrounda tıklanarak renk seçimi yapıldı.


			        Şekil 3.3. : Background Color Seçimi 

Anasayfanın XML kodlarını inceledik. Tasarım yapıldıktan sonra ekranda ne tür işlemler olacağının ayarlanacağı java classına geçelim.

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


     Tablo 3.4.  : Anasayfadaki Butonları Tıklandığında Yapacakları Davranışı Tanımlayan Kod

   Anasayfa isimli java classında tek bir işlem yapılıyor. Butonlara tıklandığında ilgili sayfaya geçiliyor. StartActivity metodu ile butona tıklandığında açılacak Activity belirtiliyor.


   4.YENİ ÜYE

   Anasayfada oluşturulmuş olan yeni üye butonuna basıldığında kullanıcı yeni üye sayfasına yönlendirilmektedir. 

		   Şekil 4.1. : Anasayfadan Yeni Üye Sayfasına Yönlendirilme

  Java klasörü altında proje için oluşturulan sayfalar klasörüne sağ tıklanıp açılan listeden “New” seçeneği seçilerek YeniUye adında yeni bir Activity sınıfı eklenmiştir.
YeniUye sayfası da diğer sayfalar gibi AppCompatActivity sınıfından extends edilmiştir. Bu sayede AppCompatActivity sınıfının onCreate() gibi istenilen metotlarını override edip bu sınıfta da kullanımına yer verilmiştir.

@Override
	protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeniuye);

    	defineItems();
    	fotografCekmeYadaSecme();
    	seansSecilmeIslemi();
    	kaydetButonu();    
	}
        Tablo 4.1.  : onCreate() metodunun override edilip kodlanması	

  YeniUye activity sayfası ilk çalıştığında onCreate metodu devreye girer. Bu mettotta setContentView metodu çalıştırılarak activity_yeniuye  layout dosyasından ekran tasarımı yüklenir. Bunun yanı sıra ilk oluştuğunda tanımlanması gereken başka aksiyonlarda olduğundan onların da çağrımını onCreate metodu içinde gerçekleştirilmiştir. (defineItems(), fotografCekmeYadaSecme(), seansSecilmeIslemi(), kaydetButonu())


		     Şekil 4.2. : Fotoğraf Çekme İşleminin Gerçekleştirilmesi

  fotografCekmeYadaSecme() metodunda fotoğraf çekilme tercihinde bulunulmuşsa önce kamera açmak için izin isteyip sonrasında kameradan fotoğraf çekme ve görüntüleme işlemi gerçekleştiriliyor. Eğer galeriden resim seçme tercihinde bulunulmuş ise galeriden resim seçme ve görüntüleme işlemi gerçekleştiriliyor.






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
Tablo 4.2. : Fotoğraf Çekme /Seçme İşleminin Kodu


Şekil 4.3. : Üyenin Başarılı Bir Şekilde Sisteme Kaydedilmesi

private void kaydetButonu() {
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
        	Kullanici kullanici = new Kullanici(adSoyad, dogumTarihi, tc, cepTel, evTel,
        	        evAdres, isAdres, anneMeslek, babaMeslek, okul, sinif, kanGrubu, cinsiyet, imageUrl, secilenSeans);
          Tablo 4.3.  : Kullanıcı nesnesinin oluşturulması

 
// Girilen TC ile daha onca kayıt olmus birisi var mı diye bakılıyor
        	boolean tcZatenKayitliMi = kullanicilar.stream().anyMatch(user -> user.getTC().equals(tc));
// Fotoğraf seçildi mi diye bakılıyor. ( Null mu diye bakıyoruz ) 
-- Seçim yapılmadıysa null oluyor
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
		Tablo 4.5.  : Tüm Şartlar Sağlanmışsa Kullanıcının Veritabanına Kaydedilmesi

  seansSecilmeIslemi() metodunda her seans seçilme işleminden sonra seçilen seans değerinin güncelleme işlemini gerçekleştirilmektedir.


Şekil 4.4. : Seans Seçimi






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


Tablo 4.6. : Seans Seçilme İşlemi Kodu

  defineItems() metodunda ekrandaki tüm itemlera kod içerisinden erişebilmek için idleri ile tanımlama işlemi, seanslar listesinin gösterilmesi için ise adapter tanımlama işlemi gerçekleştirilmiştir.

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
Tablo 4.7. : defineItems() metodunun kodlanması


 		         Şekil 4.5.. :  Fotoğrafın Başarılı/Başarısız Eklenme Durumu

 onActivityResult() metodu override edilip kullanılmıştır. Çünkü bir Activity’yi çalıştırma işlemi her zaman tek taraflı olmak zorunda değildir. Başlatıldıktan sonra ondan sonuç döndürülmesi istenilen durumlar olabilmektedir. Projede de bu durum kamera uygulamasını başlatıp kullanıcının çektiği fotoğrafı sonuç bilgisinin olarak alınmasının istenildiği bir durum oldu. Bu nedenle Activity’nin bir sonuç döndürecek şekilde tasarlanmasına yönelik çalışmalar gerçekleştirildi. Activity bunu yaptığında sonucu bir Intent nesnesi şeklinde döndürür. Bu nedenle sonuç almak için başlatıldığında beklenilen sonucun alındığından emin olmak için açık Intent kullanılmıştır. Bu metod kısaca fotoğrafın başarıyla eklenme ya da fotoğrafın çekilirken hata oluştu bilgisinin sonucunu return etmektedir.

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
Tabo 4.8. :  onActivityResult() metodunun kodlanması

 onRequestPermissionsResult() FragmentActivity.java sınıfından override edilip kullanılan bir metottur. Tehlikeli olarak tanımlanan türden izinler için AndroidManifest.xml’e tanımlamak artık yeterli olmamaktadır.
  Uygulama çalışırken izin gereken bir iş yapmak istendiğinde kullanıcıya sorup, her defasında izin almak gerekebilir. Projede de bu örnek cihaz hafızasından okuma erişimi için verilebilir. Kullanıcının izin verip vermediğinin anlanacağı bir callback yani geri bildirim metodu tasarlanmıştır.

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
Tablo 4.9. :  onRequestPermissionaResult() metodunun kodlanması

 Ayrıca projenin bitirme klasörü altında model klasörü bulunmaktadır. Bu klasörde YeniUye.java sınıfı kodlanırken ihtiyaç duyulan ImagePicker.java ve ImageUtils.java isminde internetten alınan iki tane yardımcı sınıflar bulunmaktadır. ImagePicker.java yardımcı sınıfına fotoğraf çekmek için bir kamera ve galeriden resim seçicisinin başlatılması için ihtiyaç duyulmuştur. ImageUtils.java yardımcı sınıfı ise görüntü yükleme ve bitmap ölçeklendirme ile ilgili kısımlar için ihtiyaç duyulmuştur.

5.ÜYE LİSTESİ


  Şekil 5.1. . : Üye Listesi Ekranı

  Üye listesi ekranı sisteme kaydedilen her bir kullanıcının listelenmesi görevini görür. Listelenen her bir kişinin üzerine tıklandığında ise ilgili kişinin üye bilgilerinin yer aldığı sayfa açılır. Bu işlemlerin kod üzerinde nasıl yapıldığını inceleyelim. 
  İşlemler kişilerin ID numarası üzerinden yapılacaktır. Sayfanın çalışma mantığını kısaca anlamak istersek; görüntülenmek istenen kişinin üzerine tıklandığında, tıklanan satırın position adını verdiğimiz değeri belirleniyor. Position basitçe anlatmak gerekirse kişinin listedeki yeri, sırası demektir. Bu positiondaki kişinin ID bilgisine ulaşılıyor, sonrasında ise bu ID bilgisi ÜyeBilgileri isimli sayfaya yönlendiriliyor. Üye bilgilerinin olduğu kişi kartını açma işlemleri ise üye bilgileri classında yapılıyor. Buradaki işlemler bir sonraki bölümde aktarılacaktır. 
 Kişilerin isimleri ekranda Android’in ListView isimli komponenti ile sağlanıyor. 

private ListView kullaniciListesi;
private String[] kullaniciID;
                     Tablo 5.1. : Kullanılacak Verilerin Private Olarak tanımlanması

kullaniciListesi.setOnItemClickListener((parent, view, position, id) -> {
   Intent uyeBilgileriSayfasi = new Intent(UyeListesi.this, UyeBilgileri.class);

   // ID bilgisini diğer sayfaya yollayan kısım

   uyeBilgileriSayfasi.putExtra("kullaniciID", kullaniciID[position]);

   // Üye bilgileri sayfasını açan kısım 

   startActivity(uyeBilgileriSayfasi);  
});
		   Tablo 5.2. : Kullanıcı ID’sine Göre Kişi Kartını Açan Kod Kısmı

 Peki bu işlemleri yapabilmek için gerekli olan kişi listesini veritabanından nasıl getirildi? Veritabanını ve kullanıcıBilgileriListesi isimli diziyi tanımladıktan sonra, HashMap kullanarak veritabanındaki değerler okunuyor.

VeriTabani db = new VeriTabani(UyeListesi.this);

ArrayList<HashMap<String, String>> kullaniciBilgieriListesi = db.tumKullanicilariFormatliSekildeGetir();
int boyut = kullaniciBilgieriListesi.size();

String[] adSoyad = new String[boyut];
String[] kullaniciTC = new String[boyut];
kullaniciID = new String[boyut];


		      Tablo 5.3.  : Veritabanındaki Kullanıcıların Tümünü Alma İşlemi

Kullanıcıları alındıktan sonra ise bu kullanıcıların gerekli bilgilerini tanımlanıp oluşturulan KullanıcıBilgileriListesi isimli diziye atanıyor. 

for (int j = 0; j < kullaniciBilgieriListesi.size(); j++) {
   adSoyad[j] = kullaniciBilgieriListesi.get(boyut - j - 1).get("AD_SOYAD");
   kullaniciTC[j] = kullaniciBilgieriListesi.get(boyut - j - 1).get("TC");
   kullaniciID[j] = kullaniciBilgieriListesi.get(boyut - j - 1).get("ID");
}
  Tablo 5.4. : AdSoyad, TC ve ID Bilgilerinin Diziye Atanması

 Arka planda yapılması gereken işlemler yapıldıktan sonra kullanıcının göreceği ekranın detaylandırılması Adapter kullanılarak yapılıyor. Bu adapter yardımı ile ListView’da kişilerin hangi bilgilerinin görüneceği, nasıl görüneceği gibi detaylar tasarlanabiliyor. 

KullaniciListesiAdapter kullaniciListesiAdapter = new KullaniciListesiAdapter(UyeListesi.this, adSoyad, kullaniciTC);

kullaniciListesi.setAdapter(kullaniciListesiAdapter);


  		Tablo 5.6. : Üyeler Listesinde Görünecek Bilgilerin (Ad Soyad TC) Belirlenmesi

Kullanıcı Listesi Adapter

   Adapterlar istenilen komponentleri özelleştirmek için kullanılan yapılardır. Yüzme Kursu Projesi örneğinde üye bilgilerini listelerken onların TC ve Ad Soyad bilgilerini görüntülenmesi istendiği için ListView’a buna uygun bir şekil verildi. Position bilgisine göre ilgili kişiye ulaşım için yol sağlandı. 

public View getView(final int position, View convertView, ViewGroup parent) {

   // Declare Variables
   TextView nameFull, pID;
   inflater = (LayoutInflater) context
           .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


   View itemView = inflater.inflate(R.layout.list_item, parent, false);
   nameFull = (TextView) itemView.findViewById(R.id.nameSurname);
   pID = (TextView) itemView.findViewById(R.id.pidNo);


   nameFull.setText(nameSurname[position]);
   pID.setText(pidNo[position]);


   return itemView;
}
		                 Tablo 5.7. : Üye Listesi Adapter Kodu 


6.ÜYE BİLGİLERİ

                                     Şekil 6.1. : Üye Bilgileri Görüntüleme Sayfası

  Üye bilgileri sayfasına, üye listesi sayfasından herhangi bir üye tıklandığında açılmaktadır. 
Sayfanın tasarımında diğer sayfalarda oldugu gibi xml kullanıldı.
Sayfada bulunan başlıca görüntü komponenetleri şunlardır:
Fotoğrafı gösterebilmek için ImageView
Her bir satırda bilgileri gösterebilmek için ListView


<ImageView android:layout_width="250dp"
          android:layout_height="250dp"
          android:id="@+id/personelImage"
          android:layout_centerHorizontal="true"
/>


<ListView android:layout_width="fill_parent"
         android:layout_height="fill_parent"
         android:id="@+id/uyeBilgiListesi"
         android:layout_margin="16dp"
         android:layout_below="@+id/personelImage"
         android:background="#ffffff"
/>


                                     Tablo 6.1. : Uye Bilgileri Sayfası XML Tasarımı


  Kullanıcının fotoğraf hariç diğer tüm bilgilerini satır satır gösterebilmek için bir ListView bulunmakta. Veritabanından alınan bilgileri satır satır ListView ile gösterilebilir.
  Üye listesi sayfasından , listeden tıklanın kullanıcının ID bilgisi parametre olarak üye bilgileri sayfasına gelmektedir.Bu ID ile kullanıcının bilgileri veritabanında sorgulanmakta ve ilgili kişinin bilgileri üye bilgileri sayfasında fotoğrafta dahil olmak üzere görüntülenebilmektedir[6].

// veritabanından sorgu yapabilmek için veritabanı nesnesi olusturuyoruz
VeriTabani db = new VeriTabani(UyeBilgileri.this);

// seçilen kullanıcının ID'si ile veritabanından kullanıcının bilgilerini getiriyoruz
ArrayList<HashMap<String, String>> kullaniciBilgileri = db.kullaniciBilgisiniGetir(kullaniciID);


   Tablo 6.2.  : Kullanıcı Bilgilerini Veritabanından Getiren Kod Parçacığı

 Uye listesi sayfasından parametre geçilen Kullanıcının ID’si ile veritabanından bilgileri getirerek kullanıcı bilgileri listesinde tutulmaktadır. 
Kullanıcı listesinin içindeki HasMap’te tutulan bilgiler Key-Value şeklinde tutulmaktadır bundan dolayıdır ki kullanıcının hangi bilgisine erişmek istiyorsak HasMap’teki o key ile o bilgiye erişip kullanılabilir.

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


 	 Tablo 6.3.   : Veritabanından Gelen Bilgileri HashMap’e Ekleyen Fonksiyon Çağrıları


      Key-Value seklinde verilere erişip  bu bilgileri üye bilgiler sayfasında satır satır olarak gösterebilmek için yeni bir HashMap olusturarak yine Key-Value seklinde tutmak için bilgiyiSatirListesineEkle fonksiyonuna parametre olarak yolluyoruz ve fonksiyonda satırda göstermek için HashMap’e eklemiş oluyoruz..
  Diğer bilgilerden farklı olarak fotoğrafı satırda değilde sayfanın en ustunde gosterdiğimiz için fotoğrafın bilgisini  HashMap’e eklemeyip direkt olarak göstermek için  text olarak kaydedilen bilgilerden farklı olarak üyenin fotoğrafının telefondaki yerinini bilgisini URI sekline cevirerek formatlıyoruz. 
   Fotoğrafı telefonun hafızasından yüklemek/getirmek için Android için açık kaynak olarak hazırlanmış olan Picasso kütüphanesini kullandık. Formatladığımız fotoğrafın lokasyon bilgisini Picasso kütüphanesinin fonksiyonuna veriyoruz  o da bizim için XML tasarımımızdaki ImageView’imiz olan fotografUri komponentine fotoğrafımızı yüklüyor ve fotoğraf bu şekilde telefonun hafızasından yüklenerek ekranda gösterilmiş oluyor.

Uri fotografUri = Uri.parse(kullaniciBilgileri.get(0).get("RESIM"));

// Picasso kutuphanesi ile fotografın url'inden  kullanıcını fotografını yüklüyoruz
Picasso.with(UyeBilgileri.this).load(fotografUri).into(kullaniciFotograf);



                      Tablo 6.4. :  Fotoğrafın URL’ini Formatlayan Ve Ekranda Gösterilmesi Kod Parçacığı
  
   Android ile bir listenin satırlarının ekranda nasıl görüneceğini ve o bilgilerin satırlara nasıl dönüşeceğini , nasıl davranacaklarını ayarlabilmek için LisView’e bir adapter vermemiz gerekiyor bunu için  bir ListAdapter  ile tasarlayarak kullanıcının bilgilerini doldurarak  hazırlamış olduğumuz HashMap’i bu adaptere veriyoruz ve bilgilerimiz ekran ayarlanılan sekilde gözüküyor[7].
  
  Adapterin her bir satır için nasıl davranacığını belirlemek için bir satırı temsil eden bir tasarım yapmamız gerekiyor aksi halde adapter nasıl davranacağını bilemez. Dolayısıyla ListView’de verileri ekranda   nasıl göstereceğini bilemez.


                              Şekil 6.2. : Her bir Satırı Temsil Eden Tasarım

  Bunun için  her bir satırı temsil edecek şekilde Şekil 15’te de görüldüğü üzere basitçe iki tane TextView kullanarak ile bir tasarım yapıldı . Bu tasarımı artık Adapterimize set ettiğimizde adapter kendisine verilen her bir bilgiyi listenin içerisine hangi formatta koyacağını ve her bir bilgiyi ekranda hangi formatta göstereceğini bilmiş oldu.
  Her bir satırının tasarımın içinde Şekil 16’da da görüldüğü üzere sadece iki tane TextView bulunmaktadır.

<RelativeLayout android:layout_width="match_parent"
               android:id="@+id/h1"
               android:layout_height="wrap_content">
   <TextView android:layout_width="wrap_content"
             android:layout_height="wrap_content"
             android:textSize="20dp"
             android:textColor="#333"
             android:text="Ad-Soyad"
             android:textStyle="bold"
             android:layout_margin="16dp"
             android:id="@+id/header"
   />
   <TextView android:layout_width="wrap_content"
             android:layout_height="wrap_content"
             android:textSize="25dp"
             android:textColor="#333"
             android:text="Sevgi Alkan"
             android:layout_below="@+id/header"
             android:layout_marginLeft="16dp"
             android:id="@+id/info"
   />
</RelativeLayout>
             	Tablo 6.5. : Her bir Satırı Temsil Eden Tasarım Kodu

  Adapterimize her bir satır için nasıl davranacağını söylemiş olduk . Bundan sonra adaptere ekranda gösterilecek bilgilerimizi vermemiz gerekiyor.Verilen bilgileri belirlediğimiz formatta ekranda gösterecektir.

// her bir bilgi için bir satir listesi yapıp Map'e eklemiş olduk.
// Bu  tüm bilgileri içeren listeyi görünmesi için adapter'a veriyoruz ve adapterimizi listemize setliyoruz
com.android.bitirme.adapter.kullaniciBilgiListesiAdapter kullaniciBilgiListesiAdapter = new kullaniciBilgiListesiAdapter(UyeBilgileri.this, satirListesi);
kullaniciBilgiListesi.setAdapter(kullaniciBilgiListesiAdapter);



                    Tablo 6.6. : Adaptere Satır Tasarımın Set Edilmesi, Adapterin Listeye Set Edilmesi

  Adapterimizi oluşturduk ve her bir satır için nasıl  davranacağını da belirledik . Hazırlamış oldugumuz adapterimizi üye bilgileri sayfasındaki listemizin adapterine vermemiz gerekiyor bu şekilde ekran açıldıgında ListView  kendisine verilmiş olan Adapter’i  çağıracak ve adapterde kendisine daha önce verilmiş olan satır formatında bilgileri formatlayacaktır. Bu işlemler Şekil 17 deki kod parçacığı ile gerçekleşmektedir.

7. VERİ TABANI

 Android ile ilgili merak edilen konulardan birisi de veritabanı kullanımıdır.Günümüzde popüler olan veritabanları Microsoft SQL Server, MySQL, Oracle vb. dir. Ancak Android’den bunlara doğal yöntemler ile erişmek mümkün değildir, çünkü gerekli kütüphaneler bulunmamaktadır. Bu veritabanları büyüklükleri sebebiyle Android cihazına kurulamazlar. Bu veritabanlarına ancak bir web servis aracılığıyla erişilebilir.
   Android’te lokal veritabanı olarak sadece SQLite isimli dosya tipi veritabanı yönetim sistemi kullanılabilir. SQLite açık kaynak kodlu bu sebeple birçok platformda kullanılabilir. Hem SQL komutlarını çalıştırabilmesi hem de mobil cihazlar gibi düşük kapasiteli ortamlarda kolayca çalışabilmesi SQLite’ı Android ve iOS platformlarında ilk seçenek haline getirmiştir. SQLite, diğer sunucu tipi veritabanları ile karşılaştırıldığında basit kalmaktadır.
  SQLite ilişkisel ve işlemsel güçlü bir veritabanıdır.Android’in rehber, ajanda gibi kendi uygulamalarında da bu veritabanı kullanılır.




  Bu veritabanının;
View ve trigger desteği vardır.
Şu anda stored procedure desteği yoktur.
Geçici tablolar oluşturulabilir.
Desteklenen türler (integer, null, blob, text ve real) olup dinamik tür belirlemeyi destekler.
Diğer veri tabanlarına göre desteklediği veri türü sınırlıdır. (Boolean, Datetime, Money, XML gibi türleri desteklemez.) [1]

  SQLite, Android içinde gelen bir veritabanı kütüphanesidir. Kullanmak için herhangi bir kurulum yapmanıza gerek yoktur. Gerekli metotları oluşturduktan sonra, veritabanı cihaza otomatik olarak kurulacaktır..[2]
 VeriTabani sınıfında sqlite veri tabanı kullanılarak oluşturulduğu yüzme kursu uygulamasında yer alan kişilerin ad-soyad,dogum tarih,tc,anne ve babasının telefon numarası,ev adresi ,anne ve babasının iş adresi, mesleği, cinsiyet,kan grubu,seans bilgileri kullanici sınıfından alınmaktadır.
  VeriTabani sınıfı SQLiteOpenHelper sınıfından extends edildi. SQLiteOpenHelper, veritabanı erişimi için yazılacak olan sınıf için taban sınıf olarak kullanılır. Soyut bir sınıftır. Tabloların oluşturulması ya da şematik değişiklikler bu sınıflar ile gerçekleştirilir. Extends ettikten sonra VeriTabani sınıfı hata verip, onCreate() ve onUpgrade() metotlarını override edilmesini isteyecek. Override işleminden sonra en son sınıfın constructor’ ını oluşturulur. VeriTabani sınıfının içine DATABASE_NAME ve DATABASE_VERSION‘u tanımladıktan sonra onCreate() metodunu oluşturabiliriz bu metot içerisinde uygulama ilk defa yüklendiğinde çalışıp, veritabanını oluşturacak kodları içeriyor. Veri  tabanının ismini  havuz_database olarak belirlendi.

public class VeriTabani extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
 private static final String DATABASE_NAME =          "havuz_database";

    public VeriTabani(Context context) {
       super(context, DATABASE_NAME, null, DATABASE_VERSION);
   }
Tablo 7.1: VeriTabanımızı extends ettiğimiz sınıf onCreate() Metodu

  onCreate() metodunun içinde database oluşturulur. Bu methodu biz çağırmıyoruz. Database’de obje oluşturduğumuzda otomatik çağırılıyor. (SQLiteDatabase db)




public void onCreate(SQLiteDatabase db) {

   String CREATE_KULLANICI_TABLE = "CREATE TABLE IF NOT EXISTS KULLANICILAR (" +
           "ID      INTEGER PRIMARY KEY AUTOINCREMENT,  " + ad_soyad + "  TEXT,  "
           + dogum_tarihi + "   TEXT,  " + tc + " TEXT, " + cep_telefonu + "  TEXT," +
           ev_telefonu + "     TEXT," + ev_adres + "     TEXT," + is_adresi + "     TEXT,"
           + anne_meslek + "     TEXT," + baba_meslek + "     TEXT, " + okulu + "     TEXT,"
           + sinifi + "     TEXT," + kan_grubu + "     TEXT," + cinsiyet + "     TEXT, "
           + resim + "     TEXT," + seans + " TEXT)";

   db.execSQL(CREATE_KULLANICI_TABLE);
Tablo 7.2: onCreate() metodu

 onCreate() metodun çalışma anında veritabanının içine tablolar oluşturuldu ve değerler belirlendi.
  kullaniciKaydet() metodu ise adı üstünde database’e veri eklemek için  kullanıldı. VeriTabani sınıfında yazılabilir bağlantı açıldı. ContentValues sınıfından bir nesne oluşturuldu. ContentValues değerleri tutmamızı sağlıyor. Kullanıcımızın ad_soyad,dogum_tarihi, tc, cep-ev telefonu, ev-iş adres bilgisi,anne-baba meslek, kan grubu, cinsiyet ,okul, resim ve seans bilgilerini teker teker alınır. Sonrasında tablomuza eklememizi yapıyoruz. Ve veritabanı kapatılır.

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
                                          Tablo 7.3: kullaniciKaydet() Metodu


  Daha sonrasında Kullanıcı türünde bir liste oluşturuldu. SQLiteDatabase sınıfında yazılabilir bağlantı açıldı. Sutunlar oluşturuldu. query fonksiyonu ile aldığımız parametreler yoluyla komutu kendi içerisinde yapılandırıldı. while’ın  içerisi ise verileri sırasıyla listelenmesini sağlıyor.

public List<Kullanici> tumKullanicilariGetir() {

   List<Kullanici> kullanicilar = new ArrayList<>();
   SQLiteDatabase db = this.getWritableDatabase();

   String[] sutunlar = {ad_soyad, dogum_tarihi, tc,
           cep_telefonu, ev_telefonu, ev_adres, is_adresi,
           anne_meslek, baba_meslek, okulu, sinifi,
           kan_grubu, cinsiyet, resim, seans};

   Cursor cursor = db.query("KULLANICILAR", sutunlar,
           null, null, null,
           null, null);

   while (cursor.moveToNext()) {
       kullaniciyiListeyeEkle(kullanicilar, cursor);
   }
   return kullanicilar;
}
    Tablo 7.4:  List Kullanımı

  Java'da sıkça kullanılan bir diğer veri saklama yöntemlerinden diğeri de Map interface sınıfı kullanımıdır. Bu sınıflar verileri anahtar - değer mantığına göre saklamaktadır. Bir obje Map içerisine eklenirken bu objeyi işaret eden bir anahtar kullanmaktadır. Obje çekilmek istediğinde bu anahtar değeri sorgulanır ve obje hızlı bir şekilde diğer objeler arasından getirilir. HashMap bir çift boyutlu arraydir.[3]

public ArrayList<HashMap<String, String>> tumKullanicilariFormatliSekildeGetir() {

   SQLiteDatabase db = this.getReadableDatabase();
   String selectQuery = "SELECT * FROM KULLANICILAR";
   return selectQuery(db, selectQuery);
}
           Tablo 7.5: HashMap Kullanımı




  Bu ArrayList metodunda ise tablodaki tüm değerler alınır. ArrayList adı üstünde Array’ lerin listelendiği bir dizi. Burada hashmap’ler listelenir. Her bir satırı key ve value ile hashmap'a atıyoruz. Her bir satır bir tane hashmap array’ı demek. Olusturduğumuz tüm hashmapleri ArrayList’e atıp geri dönüyoruz.

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
   Tablo 7.6:Array’lerin Listelendiği Dizi

  kullaniciyiListeyeEkle() metodunda kullanıcıların bilgileri teker teker listeye eklenir.

private void kullaniciyiListeyeEkle(List<Kullanici> kullanicilar, Cursor cursor) {
   Kullanici kullanici = new Kullanici(cursor.getString(0),
           cursor.getString(1), cursor.getString(2),
           cursor.getString(3), cursor.getString(4),
           cursor.getString(5), cursor.getString(6),
           cursor.getString(7), cursor.getString(8),
           cursor.getString(9), cursor.getString(10),
           cursor.getString(11), cursor.getString(12),
           cursor.getString(13), cursor.getString(14));

   kullanicilar.add(kullanici);
}
     Tablo 7.7: kullaniciyiListeyeEkle() Metodu






  onUpgrade() Metodu ise onCreate() metodu çağrılarak oluşturulan veritabanı tablosunda onUpgrade() metodu  ile güncelleme yapıldı.

public ArrayList<HashMap<String, String>> seansKullanicilariniGetir(String secilenSeans) {
   SQLiteDatabase db = this.getReadableDatabase();
   String selectQuery = "SELECT * FROM KULLANICILAR" + " WHERE SEANS = '" + secilenSeans + "'";
   return selectQuery(db, selectQuery);
}
                                      Tablo 7.8: seansKullanicilariniGetir() 

   Ve son olarak seans bilgilerinin Hashmap olarak saklandığı kullanıcıya ait bilgiler anahtar - değer ikilileri halinde saklanmıştır. Daha sonra kullanıcıya ait bir bilgiye ulaşmak istediğimizde ilgili anahtarı girilmesi yeterli olacaktır[2].


8. KARŞILAŞILAN ZORLUKLAR ve ÇÖZÜM YOLLARI

   Proje adımları hayata geçirilirken çeşitli zorluklar ve hatalarla karşılaşılmıştır. Bunlar;

Kullanıcıdan Fotoğraf ve Depolama İzninin Alınması
Yeni üye ekleme sayfasında üye fotoğrafının eklenebilmesi için "fotoğraf çek"   ve "galeriden seç" gibi iki farklı seçenek bulunmaktadır. Bu seçeneklerden herhangi biri seçilerek fotoğrafın uygulamaya aktarılması, telefonun hafızasına kaydedilmesi ve kayıt ekranında gösterilmesi aşamalarının gerçekleştirilmesi gerekmektedir. Bu işlemler için kullanıcıdan fotoğraf ve depolama izninin alınması kısmında ilk zorlukla karşılaşılmıştır. Bu zorluğu aşmak ve kurguyu daha iyi yönetebilmek adına "ImagePicker" adında yardımcı bir sınıf oluşturulmuş,  buna bağlı olarak gerekli kodlama işlemleri gerçekleştirilmiştir.

Cihaz Hafızasındaki Fotoğrafın Ekranda Gösterilmesi
Karşılaşılan bir diğer zorlukta cihazın hafızasına kayıtlı olan fotoğrafın ekranda gösterilmesi oldu. Bu zorluk ise open source olarak geliştirilen Picasso isimli kütüphanenin kullanılması ile giderilmiştir[8].





Cihaz Hafızasından Okuma Erişimi
Gerekli araştırmalar sonucunda tehlikeli olarak tanımlanan türden izinler için AndroidManifest.xml’e tanımlamanın artık yeterli olmadığı öğrenilmiştir. Uygulama çalışırken izin gereken bir iş yapılmak istendiğinde kullanıcıya sorulması, her defasında izin alınması gerekebilmektedir. Bu zorluğa da projedeki cihaz hafızasından okuma erişimi sırasında rastlanmıştır. Çözümü ise kullanıcının izin verip vermediğinin anlanacağı bir callback yani geri bildirim metodu tasarımı ile sonuca ulaştırılmıştır.  
