# Java Programlama Notları

## Veri Tipleri

- **İlkel (Primitive) Veri Tipleri**:

  - `byte`: 8-bit (-128 to 127)
  - `short`: 16-bit (-32,768 to 32,767)
  - `int`: 32-bit (-2^31 to 2^31-1)
  - `long`: 64-bit (-2^63 to 2^63-1)
  - `float`: 32-bit ondalıklı sayı
  - `double`: 64-bit ondalıklı sayı
  - `char`: 16-bit Unicode karakter
  - `boolean`: true/false

- **Referans Veri Tipleri**:
  - `String`, `Array`, `Class`, `Interface`, vb.

## Operatörler

- **Aritmetik**: `+`, `-`, `*`, `/`, `%`
- **Atama**: `=`, `+=`, `-=`, `*=`, `/=`
- **Karşılaştırma**: `==`, `!=`, `>`, `<`, `>=`, `<=`
- **Mantıksal**: `&&`, `||`, `!`
- **Bit**: `&`, `|`, `^`, `~`, `<<`, `>>`, `>>>`
- **Tekli**: `++`, `--`
- **Koşul**: `? :`

## Döngüler

- **for döngüsü**: Belirli sayıda tekrar için kullanılır.

  ```java
  for (int i = 0; i < 5; i++) {
      // Kod bloğu
  }
  ```

- **while döngüsü**: Koşul sağlandığı sürece çalışır.

  ```java
  while (koşul) {
      // Kod bloğu
  }
  ```

- **do-while döngüsü**: En az bir kez çalışır, sonra koşul sağlandığı sürece devam eder.

  ```java
  do {
      // Kod bloğu
  } while (koşul);
  ```

- **for-each döngüsü**: Koleksiyonları gezmek için kullanılır.
  ```java
  for (Tip eleman : koleksiyon) {
      // Kod bloğu
  }
  ```

## Metodlar ve Method Overloading

Metodlar, belirli bir görevi yerine getiren kod bloklarıdır. Program modülerliğini ve kod tekrarını azaltmayı sağlarlar.

### Metod Tanımlama

```java
erişim_belirleyici dönüş_tipi metod_adı(parametre_listesi) {
    // Metod gövdesi
    return değer; // dönüş_tipi void değilse
}
```

### Metod Örnekleri

```java
// Dönüş değeri olan metod
public int topla(int a, int b) {
    return a + b;
}

// Dönüş değeri olmayan metod
public void selamVer(String isim) {
    System.out.println("Merhaba " + isim);
}
```

### Method Overloading (Metot Aşırı Yükleme)

Method overloading, aynı isimli ancak farklı parametre listelerine sahip metodlar oluşturabilme özelliğidir.

```java
public class HesapMakinesi {
    // İki tamsayının toplamı
    public int topla(int a, int b) {
        return a + b;
    }

    // Üç tamsayının toplamı
    public int topla(int a, int b, int c) {
        return a + b + c;
    }

    // İki ondalıklı sayının toplamı
    public double topla(double a, double b) {
        return a + b;
    }

    // String birleştirme
    public String topla(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        HesapMakinesi hesap = new HesapMakinesi();

        System.out.println(hesap.topla(5, 3));           // 8
        System.out.println(hesap.topla(5, 3, 2));        // 10
        System.out.println(hesap.topla(5.5, 3.2));       // 8.7
        System.out.println(hesap.topla("Java ", "Programlama")); // "Java Programlama"
    }
}
```

Method overloading'de önemli noktalar:

- Aynı isimli metodlar farklı sayıda parametreye sahip olabilir.
- Aynı sayıda parametreye sahip olsalar bile, parametre tipleri farklı olabilir.
- Dönüş tipi method overloading için yeterli değildir, parametre listesi farklı olmalıdır.

## Nesne Yönelimli Programlama (OOP)

Nesne Yönelimli Programlama, gerçek dünyadaki nesneleri yazılımda modelleyen bir programlama paradigmasıdır.

### OOP'nin Temel İlkeleri

#### 1. Kapsülleme (Encapsulation)

Veri ve metotları bir arada tutarak dış erişimi kontrol etme prensibidir.

```java
public class Ogrenci {
    // private değişkenler
    private String ad;
    private String soyad;
    private int no;

    // Yapıcı metod (Constructor)
    public Ogrenci(String ad, String soyad, int no) {
        this.ad = ad;
        this.soyad = soyad;
        this.no = no;
    }

    // Getter metodları
    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public int getNo() {
        return no;
    }

    // Setter metodları
    public void setAd(String ad) {
        this.ad = ad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public void setNo(int no) {
        if (no > 0) {
            this.no = no;
        }
    }

    // Metod
    public String tamAd() {
        return ad + " " + soyad;
    }
}
```

#### 2. Kalıtım (Inheritance)

Bir sınıfın başka bir sınıfın özelliklerini ve davranışlarını devralmasıdır.

```java
// Üst sınıf (Ebeveyn sınıf)
public class Hayvan {
    protected String tür;
    protected int yaş;

    public Hayvan(String tür, int yaş) {
        this.tür = tür;
        this.yaş = yaş;
    }

    public void sesCikar() {
        System.out.println("Hayvan ses çıkarıyor");
    }
}

// Alt sınıf (Çocuk sınıf)
public class Kedi extends Hayvan {
    private String cins;

    public Kedi(String cins, int yaş) {
        super("Kedi", yaş); // Üst sınıfın yapıcı metodunu çağırır
        this.cins = cins;
    }

    // Metod override
    @Override
    public void sesCikar() {
        System.out.println("Miyav!");
    }

    public void patiGöster() {
        System.out.println("Pati gösteriyor");
    }
}

// Kullanım
public class HayvanTest {
    public static void main(String[] args) {
        Kedi kedi = new Kedi("Tekir", 3);
        kedi.sesCikar(); // "Miyav!" yazdırır
        kedi.patiGöster(); // "Pati gösteriyor" yazdırır
    }
}
```

#### 3. Çok Biçimlilik (Polymorphism)

Aynı arayüze sahip farklı nesnelerin farklı davranışlar sergileyebilmesidir.

```java
public class Sekil {
    public double alanHesapla() {
        return 0.0;
    }
}

public class Daire extends Sekil {
    private double yaricap;

    public Daire(double yaricap) {
        this.yaricap = yaricap;
    }

    @Override
    public double alanHesapla() {
        return Math.PI * yaricap * yaricap;
    }
}

public class Dikdortgen extends Sekil {
    private double genislik;
    private double yukseklik;

    public Dikdortgen(double genislik, double yukseklik) {
        this.genislik = genislik;
        this.yukseklik = yukseklik;
    }

    @Override
    public double alanHesapla() {
        return genislik * yukseklik;
    }
}

// Kullanım
public class SekilTest {
    public static void main(String[] args) {
        Sekil[] sekiller = new Sekil[2];
        sekiller[0] = new Daire(5.0);
        sekiller[1] = new Dikdortgen(4.0, 6.0);

        for (Sekil sekil : sekiller) {
            System.out.println("Alan: " + sekil.alanHesapla());
        }
    }
}
```

#### 4. Soyutlama (Abstraction)

Karmaşıklığı azaltmak için gereksiz detayları gizleme prensibidir.

```java
// Banka hesabı soyutlama örneği
public class BankaHesabi {
    private double bakiye;
    private String hesapNo;

    public BankaHesabi(String hesapNo, double baslangicBakiye) {
        this.hesapNo = hesapNo;
        this.bakiye = baslangicBakiye;
    }

    public void paraCek(double miktar) {
        if (miktar <= bakiye) {
            bakiye -= miktar;
            System.out.println(miktar + " TL çekildi. Yeni bakiye: " + bakiye + " TL");
        } else {
            System.out.println("Yetersiz bakiye!");
        }
    }

    public void paraYatir(double miktar) {
        bakiye += miktar;
        System.out.println(miktar + " TL yatırıldı. Yeni bakiye: " + bakiye + " TL");
    }

    public double getBakiye() {
        return bakiye;
    }

    public String getHesapNo() {
        return hesapNo;
    }
}
```

## Interface ve Abstract Class

### Interface (Arayüz)

Interface, sınıfların uygulayabileceği bir kontrat gibidir. Sadece metod imzalarını belirtir, implementasyon içermez.

```java
public interface OdemeYontemi {
    void odemeYap(double miktar);
    boolean odemeOnay();
    String odemeDetayi();
}

// Interface implementasyonu
public class KrediKarti implements OdemeYontemi {
    private String kartNo;
    private String sonKullanmaTarihi;

    public KrediKarti(String kartNo, String sonKullanmaTarihi) {
        this.kartNo = kartNo;
        this.sonKullanmaTarihi = sonKullanmaTarihi;
    }

    @Override
    public void odemeYap(double miktar) {
        System.out.println(miktar + " TL kredi kartı ile ödendi");
    }

    @Override
    public boolean odemeOnay() {
        // Kredi kartı onay işlemleri
        return true;
    }

    @Override
    public String odemeDetayi() {
        return "Kredi Kartı: " + maskeleKartNo(kartNo);
    }

    private String maskeleKartNo(String kartNo) {
        return "****-****-****-" + kartNo.substring(kartNo.length() - 4);
    }
}

// Başka bir implementasyon
public class BankaHavalesi implements OdemeYontemi {
    private String ibanNo;

    public BankaHavalesi(String ibanNo) {
        this.ibanNo = ibanNo;
    }

    @Override
    public void odemeYap(double miktar) {
        System.out.println(miktar + " TL banka havalesi ile ödendi");
    }

    @Override
    public boolean odemeOnay() {
        // Havale onay işlemleri
        return true;
    }

    @Override
    public String odemeDetayi() {
        return "Banka Havalesi: " + ibanNo;
    }
}
```

Interface'in Özellikleri:

- Java 8'den önce sadece soyut metod imzaları içerebilirdi
- Java 8 ile birlikte default ve static metodları da içerebilir
- Java 9 ile birlikte private metodları da içerebilir
- Tüm alanlar varsayılan olarak public, static ve final'dır
- Bir sınıf birden fazla interface'i implement edebilir

### Abstract Class (Soyut Sınıf)

Abstract class, hem soyut (implementasyonsuz) hem de somut (implementasyonlu) metodlar içerebilen, doğrudan örneği oluşturulamayan bir sınıftır.

```java
public abstract class Calisan {
    private String ad;
    private String soyad;
    private String tcNo;

    public Calisan(String ad, String soyad, String tcNo) {
        this.ad = ad;
        this.soyad = soyad;
        this.tcNo = tcNo;
    }

    // Somut (concrete) metod
    public String tamAd() {
        return ad + " " + soyad;
    }

    // Soyut (abstract) metod - Alt sınıflar implement etmek zorunda
    public abstract double maasHesapla();

    // Getters
    public String getAd() { return ad; }
    public String getSoyad() { return soyad; }
    public String getTcNo() { return tcNo; }
}

// Abstract sınıfın alt sınıfı
public class TamZamanliCalisan extends Calisan {
    private double aylikMaas;

    public TamZamanliCalisan(String ad, String soyad, String tcNo, double aylikMaas) {
        super(ad, soyad, tcNo);
        this.aylikMaas = aylikMaas;
    }

    @Override
    public double maasHesapla() {
        return aylikMaas;
    }
}

// Başka bir alt sınıf
public class YarimZamanliCalisan extends Calisan {
    private double saatlikUcret;
    private int calismaHafta;
    private int haftadaCalismaSaati;

    public YarimZamanliCalisan(String ad, String soyad, String tcNo,
                               double saatlikUcret, int calismaHafta,
                               int haftadaCalismaSaati) {
        super(ad, soyad, tcNo);
        this.saatlikUcret = saatlikUcret;
        this.calismaHafta = calismaHafta;
        this.haftadaCalismaSaati = haftadaCalismaSaati;
    }

    @Override
    public double maasHesapla() {
        return saatlikUcret * haftadaCalismaSaati * calismaHafta;
    }
}
```

Abstract Class'ın Özellikleri:

- Hem soyut (abstract) hem de somut (concrete) metodlar içerebilir
- Doğrudan örneği oluşturulamaz (new ile instantiate edilemez)
- Alt sınıflar soyut metodları implement etmek zorundadır
- Yapıcı metodlar (constructors) içerebilir
- Farklı erişim belirleyicilere (access modifiers) sahip üyeler içerebilir
- Bir sınıf sadece bir abstract class'ı extend edebilir

### Interface vs Abstract Class Karşılaştırması

| Özellik               | Interface                                                                    | Abstract Class                                                            |
| --------------------- | ---------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| Metodlar              | Java 8 öncesi tüm metodlar abstract. Java 8+ ile default ve static metodlar. | Abstract ve concrete metodlar içerebilir.                                 |
| Alanlar               | Tüm alanlar public, static ve final olmak zorunda.                           | Farklı erişim belirleyicilere sahip alanlar içerebilir.                   |
| Erişim Belirleyiciler | Tüm üyeler varsayılan olarak public.                                         | public, protected, default, private erişim belirleyiciler kullanılabilir. |
| Çoklu Miras           | Bir sınıf birden fazla interface'i implement edebilir.                       | Bir sınıf sadece bir abstract class'ı extend edebilir.                    |
| Yapıcı Metod          | Yapıcı metod içeremez.                                                       | Yapıcı metod içerebilir.                                                  |
| Amaç                  | "Ne yapabilir?" sorusunu cevaplar.                                           | "Ne olduğunu?" sorusunu cevaplar.                                         |

```

```
