import java.util.ArrayList;
import java.util.List;

class Banka {
    private List<Kullanici> kullaniciListesi;

    public Banka() {
        kullaniciListesi = new ArrayList<>();
    }

    public void kullaniciEkle(Kullanici kullanici) {
        kullaniciListesi.add(kullanici);
    }

    public Kullanici kullaniciBul(String tcKimlikNo) {
        for (Kullanici kullanici : kullaniciListesi) {
            if (kullanici.getTcKimlikNo().equals(tcKimlikNo)) {
                return kullanici;
            }
        }
        return null; // Kullanıcı bulunamadı
    }
}