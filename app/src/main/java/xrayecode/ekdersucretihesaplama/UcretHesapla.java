package xrayecode.ekdersucretihesaplama;

/**
 * Created by akkaraman on 20.7.2015.
 */
public class UcretHesapla {
    private double alan1,alan2,alan3,alan4,alan5,alan6;
    private int ed1,ed2,ed3,ed4,ed5,ed6;
    private int sec_unvanint,sec_egitimturuint,sec_sonogrenimint,sec_vergidilimiint;
    private double toplam,vergi  ,net  ,damga;
    private static final double maasKatsayi =0.083084;

    public UcretHesapla() {
        if (sec_unvanint==1 || sec_unvanint==2  || sec_unvanint==3 || sec_unvanint==4 ){
            getIlkDortUnvanHesap();
        }
        toplamtahakkuk();
    }

    private void getIlkDortUnvanHesap(){
        int puan=0;
        if (sec_unvanint==1) puan=300;
        if (sec_unvanint==2) puan=250;
        if (sec_unvanint==3) puan=200;
        if (sec_unvanint==4) puan=160;

        if (ed1>0){
            alan1 = ed1 * maasKatsayi * puan;
        }
        if (ed2>0){
            alan2 = ed2 * maasKatsayi * (puan*1.6); // % 60 daha fazlasý
        }
        if (ed3>0){
            alan3 = ed3 * maasKatsayi * ((puan*2)*1.6); // 2 katýnýn % 60 daha fazlasý
        }
        alan4=0;
        alan5=0;
        alan6=0;
    }

    private void toplamtahakkuk(){
        this.toplam = alan1+alan2+alan3+alan4+alan5+alan6;
        this.vergi  = toplam * 15/100;
        this.damga  = toplam * 0.729/100;
        this.net    = toplam - (vergi+damga);
    }


    public double getAlan1() {
        return alan1;
    }

    public void setAlan1(double alan1) {
        this.alan1 = alan1;
    }

    public double getAlan2() {
        return alan2;
    }

    public void setAlan2(double alan2) {
        this.alan2 = alan2;
    }

    public double getAlan3() {
        return alan3;
    }

    public void setAlan3(double alan3) {
        this.alan3 = alan3;
    }

    public double getAlan4() {
        return alan4;
    }

    public void setAlan4(double alan4) {
        this.alan4 = alan4;
    }

    public double getAlan5() {
        return alan5;
    }

    public void setAlan5(double alan5) {
        this.alan5 = alan5;
    }

    public double getAlan6() {
        return alan6;
    }

    public void setAlan6(double alan6) {
        this.alan6 = alan6;
    }

    public int getSec_unvanint() {
        return sec_unvanint;
    }

    public void setSec_unvanint(int sec_unvanint) {
        this.sec_unvanint = sec_unvanint;
    }

    public int getSec_egitimturuint() {
        return sec_egitimturuint;
    }

    public void setSec_egitimturuint(int sec_egitimturuint) {
        this.sec_egitimturuint = sec_egitimturuint;
    }

    public int getSec_sonogrenimint() {
        return sec_sonogrenimint;
    }

    public void setSec_sonogrenimint(int sec_sonogrenimint) {
        this.sec_sonogrenimint = sec_sonogrenimint;
    }

    public int getSec_vergidilimiint() {
        return sec_vergidilimiint;
    }

    public void setSec_vergidilimiint(int sec_vergidilimiint) {
        this.sec_vergidilimiint = sec_vergidilimiint;
    }

    public double getToplam() {
        return toplam;
    }

    public void setToplam(double toplam) {
        this.toplam = toplam;
    }

    public double getVergi() {
        return vergi;
    }

    public void setVergi(double vergi) {
        this.vergi = vergi;
    }

    public double getNet() {
        return net;
    }

    public void setNet(double net) {
        this.net = net;
    }

    public double getDamga() {
        return damga;
    }

    public void setDamga(double damga) {
        this.damga = damga;
    }

    public static double getMaasKatsayi() {
        return maasKatsayi;
    }

    public int getEd1() {
        return ed1;
    }

    public void setEd1(int ed1) {
        this.ed1 = ed1;
    }

    public int getEd2() {
        return ed2;
    }

    public void setEd2(int ed2) {
        this.ed2 = ed2;
    }

    public int getEd3() {
        return ed3;
    }

    public void setEd3(int ed3) {
        this.ed3 = ed3;
    }

    public int getEd4() {
        return ed4;
    }

    public void setEd4(int ed4) {
        this.ed4 = ed4;
    }

    public int getEd5() {
        return ed5;
    }

    public void setEd5(int ed5) {
        this.ed5 = ed5;
    }

    public int getEd6() {
        return ed6;
    }

    public void setEd6(int ed6) {
        this.ed6 = ed6;
    }
}
