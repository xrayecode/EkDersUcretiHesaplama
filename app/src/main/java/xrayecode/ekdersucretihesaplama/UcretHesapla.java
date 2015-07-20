package xrayecode.ekdersucretihesaplama;

/**
 * Created by akkaraman on 20.7.2015.
 */
public class UcretHesapla {
    private double alan1,alan2,alan3,alan4,alan5,alan6;
    private double toplam,vergi,damga,net ;
    private static final double maasKatsayi =0.083084;
    private static final double damgaOran =0.729/100;

    public UcretHesapla(FormBean fb) {
        if (fb.getSec_unvanint()==1 || fb.getSec_unvanint()==2  || fb.getSec_unvanint()==3 || fb.getSec_unvanint()==4 ){
            getIlkDortUnvanHesap(fb);
        }
        toplamTahakkuk(fb);
    }

    private void getIlkDortUnvanHesap(FormBean fb){
        int puan=0;
        if (fb.getSec_unvanint()==1) puan=300;
        if (fb.getSec_unvanint()==2) puan=250;
        if (fb.getSec_unvanint()==3) puan=200;
        if (fb.getSec_unvanint()==4) puan=160;

        if (fb.getEd1()>0){
            alan1 =  yuvarla((fb.getEd1() * maasKatsayi * puan),2);
        }
        if (fb.getEd2()>0){
            alan2 = yuvarla(( fb.getEd2() * maasKatsayi * (puan*1.6)),2); // % 60 daha fazlası
        }
        if (fb.getEd3()>0){
            alan3 =  yuvarla((fb.getEd3() * maasKatsayi * ((puan*2)*1.6)),2); // % 60 daha fazlası  // 2 katının % 60 daha fazlası
        }
        alan4=0;
        alan5=0;
        alan6=0;
    }

    private void toplamTahakkuk(FormBean fb){
        this.toplam = alan1+alan2+alan3+alan4+alan5+alan6;
        this.vergi  = yuvarla((toplam * voran(fb.getSec_vergidilimiint())/100),2);
        this.damga  = yuvarla(toplam * damgaOran,2);
        this.net    = yuvarla(toplam - (vergi+damga),2);
    }

    public int voran(int v){
        switch(v){
            case 1: return 15;
            case 2: return 20;
            case 3: return 27;
            case 4: return 35;
        }
        return 0;
    }

    public double yuvarla(double sayi,int hane){
        double pin=100.0;
        switch (hane){
            case 1: pin=10.0; break;
            case 2: pin=100.0; break;
            case 3: pin=1000.0; break;
            case 4: pin=10000.0; break;
            case 5: pin=100000.0; break;
            case 6: pin=1000000.0; break;
            default:pin=100.0; break;
        }
        return Math.round(sayi*pin)/pin;
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
}
