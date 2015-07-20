package xrayecode.ekdersucretihesaplama;

/**
 * Created by akkaraman on 20.7.2015.
 */
public class UcretHesapla {
    private double alan1,alan2,alan3,alan4,alan5,alan6;
    private double toplam,vergi  ,net  ,damga;
    private static final double maasKatsayi =0.083084;

    public UcretHesapla(FormBean fb) {
        if (fb.getSec_unvanint()==1 || fb.getSec_unvanint()==2  || fb.getSec_unvanint()==3 || fb.getSec_unvanint()==4 ){
            getIlkDortUnvanHesap(fb);
        }
        toplamtahakkuk();
    }

    private void getIlkDortUnvanHesap(FormBean fb){
        int puan=0;
        if (fb.getSec_unvanint()==1) puan=300;
        if (fb.getSec_unvanint()==2) puan=250;
        if (fb.getSec_unvanint()==3) puan=200;
        if (fb.getSec_unvanint()==4) puan=160;

        if (fb.getEd1()>0){
            alan1 =  Math.round ((fb.getEd1() * maasKatsayi * puan)*100.0)/100.0;
        }
        if (fb.getEd2()>0){
            alan2 = Math.round (( fb.getEd2() * maasKatsayi * (puan*1.6))*100.0)/100.0; // % 60 daha fazlası
        }
        if (fb.getEd3()>0){
            alan3 =  Math.round ((fb.getEd3() * maasKatsayi * ((puan*2)*1.6))*100.0)/100.0; // % 60 daha fazlası  // 2 katının % 60 daha fazlası
        }

        //Math.round((99999)*100.0)/100.0;
        alan4=0;
        alan5=0;
        alan6=0;
    }

    private void toplamtahakkuk(){
        this.toplam = alan1+alan2+alan3+alan4+alan5+alan6;
        this.vergi  = Math.round((toplam * 15/100)*100.0)/100.0;
        this.damga  = Math.round((toplam * 0.729/100)*100.0)/100.0;
        this.net    = Math.round((toplam - (vergi+damga))*100.0)/100.0;
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
