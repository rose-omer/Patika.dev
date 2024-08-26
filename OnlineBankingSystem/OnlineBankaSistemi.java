public class OnlineBankaSistemi {
    public static void main(String[] args) {
        // Banka oluştur
        Banka banka = new Banka();

        // Kullanıcıları oluştur
        Kullanici kullanici1 = new Kullanici("12345678901", "sifre1");
        Kullanici kullanici2 = new Kullanici("23456789012", "sifre2");

        // Kullanıcıları bankaya ekle
        banka.kullaniciEkle(kullanici1);
        banka.kullaniciEkle(kullanici2);

        // Kullanıcı girişi yap
        String girilenTcKimlikNo = "12345678901";
        String girilenSifre = "sifre1";
        Kullanici girisYapanKullanici = banka.kullaniciBul(girilenTcKimlikNo);

        if (girisYapanKullanici != null && girisYapanKullanici.sifreDogruMu(girilenSifre)) {
            System.out.println("Giriş başarılı!");
            // İşlem yapılacak
        } else {
            System.out.println("Giriş başarısız! Kullanıcı adı veya şifre yanlış.");
        }
    }
}