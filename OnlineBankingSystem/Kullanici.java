class Kullanici {
    private String tcKimlikNo;
    private String sifre;

    public Kullanici(String tcKimlikNo, String sifre) {
        this.tcKimlikNo = tcKimlikNo;
        this.sifre = sifre;
    }

    public String getTcKimlikNo() {
        return tcKimlikNo;
    }

    public boolean sifreDogruMu(String girilenSifre) {
        return this.sifre.equals(girilenSifre);
    }
}