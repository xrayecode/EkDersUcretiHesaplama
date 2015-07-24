package xrayecode.ekdersucretihesaplama;

/**
 * Created by akkaraman on 20.7.2015.
 */
public class UcretHesapla {
    private double alan1,alan2,alan3,alan4,alan5,alan6;
    private double toplam,vergi,damga,ssk,net,agi;
    private int primGunu;
    private static final double maasKatsayi =0.083084;
    private static final double damgaOran =0.759/100;
    private static final double sskOran =14;
    private static final double sskEmekliOran =7.5;
    private static final double asgariUcret =1201.50;

    public UcretHesapla(FormBean fb) {

        if (fb.getSec_islemturuint()==1)
            agiTahakkuk(fb);
        else {
            switch (fb.getSec_unvanint()) {
                case 1:
                case 2:
                case 3:
                case 4: {
                    getIlkDortUnvanHesap(fb);
                    break;
                }
                case 5: {
                    getKadroluOgretmenHesap(fb);
                    break;
                }
                case 6: {
                    getSozlesmeliOgretmenHesap(fb);
                    break;
                }
                case 7: {
                    getUcretliOgretmenHesap(fb);
                    break;
                }


            }
            toplamTahakkuk(fb);
        }
    }

    private void getIlkDortUnvanHesap(FormBean fb){
        int puan=0;
        if (fb.getSec_unvanint()==1) puan=300; // Prof
        if (fb.getSec_unvanint()==2) puan=250; // Doç
        if (fb.getSec_unvanint()==3) puan=200; // Yar. Doç
        if (fb.getSec_unvanint()==4) puan=160; // Okutman Öğretim Görevlisi

        alan1 = yuvarla((fb.getEd1()  * maasKatsayi *  puan),2);
        alan2 = yuvarla(( fb.getEd2() * maasKatsayi * (puan*1.6)),2);    // % 60 daha fazlası
        alan3 = yuvarla((fb.getEd3()  * maasKatsayi *((puan*2)*1.6)),2); // % 60 daha fazlası  // 2 katının % 60 daha fazlası

        alan4=0;
        alan5=0;
        alan6=0;
    }
    private void getKadroluOgretmenHesap(FormBean fb){
        double gunduzpuan=140;
        double gecepuan=150;
        double fgunduzpuan=140;
        double fgecepuan=150;
        double tgunduzpuan=140*2;
        double tgecepuan=150*2;
        if (fb.getSec_egitimturuint()==1) {//Özel Öğretim
            gunduzpuan *= 1.25;
            gecepuan *= 1.25;
            fgunduzpuan *= 1.25;
            fgecepuan *= 1.25;
            tgunduzpuan *= 1.25;
            tgecepuan *= 1.25;
        }
        if (fb.getSec_sonogrenimint()==1) { //Y. Lisans
            fgunduzpuan *= 1.05;
            fgecepuan *= 1.05;
        }
        if (fb.getSec_sonogrenimint()==2) { //Doktora
            fgunduzpuan *= 1.15;
            fgecepuan *= 1.15;
        }
        if (fb.getSec_sonogrenimint()==0) { //Lisans
            alan1 = ((fb.getEd1() * maasKatsayi * gunduzpuan));
            alan2 = (fb.getEd2() * maasKatsayi * gecepuan);
            alan3 = (fb.getEd3() * maasKatsayi * gunduzpuan * 2);
            alan4 = (fb.getEd4() * maasKatsayi * gecepuan * 2);
        } else { //Y.Lisans and Doktora
            alan1 = (fb.getEd1() * maasKatsayi * fgunduzpuan);
            alan2 = (fb.getEd2() * maasKatsayi * fgecepuan);
            alan3 = (fb.getEd3() * maasKatsayi * gunduzpuan);
            alan4 = (fb.getEd4() * maasKatsayi * gecepuan);
            alan5 = (fb.getEd5() * maasKatsayi * tgunduzpuan);
            alan6 = (fb.getEd6() * maasKatsayi * tgecepuan);
        }
    }

    private void getSozlesmeliOgretmenHesap(FormBean fb){
        double gunduzpuan=140;
        double gecepuan=150;
        if (fb.getSec_egitimturuint()==1) {//Özel Öğretim
            gunduzpuan *= 1.25;
            gecepuan *= 1.25;
        }
        alan1 = ((fb.getEd1() * maasKatsayi * gunduzpuan));
        alan2 = (fb.getEd2() * maasKatsayi * gecepuan);
        alan3 = 0; alan4 = 0; alan5 = 0; alan6 = 0;
    }

    private void getUcretliOgretmenHesap(FormBean fb){
        double gunduzpuan=140;
        double gecepuan=150;
        alan1 = ((fb.getEd1() * maasKatsayi * gunduzpuan));
        alan2 = (fb.getEd2() * maasKatsayi * gecepuan);
        primGunu= (int) Math.ceil((fb.getEd1() + fb.getEd2()) / 7.5);
        alan3 = 0; alan4 = 0; alan5 = 0; alan6 = 0;
    }

    private void toplamTahakkuk(FormBean fb){
        this.ssk=0;
        this.agi=0;
        this.toplam = yuvarla(alan1+alan2+alan3+alan4+alan5+alan6,2);
        if (fb.getSec_unvanint()==6) // sözleşmeliden ssk kesilir.
            this.ssk=yuvarla(this.toplam*sskOran/100,2);
        if (fb.getSec_unvanint()==7){ //Ücretli Öğretmenden ssk kesilir
            if(fb.getSec_statuint()==1)
                this.ssk=yuvarla(this.toplam*sskEmekliOran/100,2);
            else
                this.ssk=yuvarla(this.toplam*sskOran/100,2);
            this.agi    = AgiHesap(fb.getSec_medeniint(), this.vergi);
        }
        this.vergi = yuvarla(((toplam-ssk) * voran(fb.getSec_vergidilimiint())/100),2);
        this.damga  = yuvarla(toplam * damgaOran,2);
        this.net    = yuvarla(this.toplam+this.agi - (vergi+damga+ssk),2);
    }

    private void agiTahakkuk(FormBean fb){
        this.ssk=0;
        this.agi=0;
        this.net=0;
        this.net    = AgiHesap(fb.getSec_medeniint(), 9999999.99);
    }

    public int voran(int v){
        switch(v){
            case 0: return 15;
            case 1: return 20;
            case 2: return 27;
            case 3: return 35;
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

    public double AgiHesap(int sec,double vh){
        double agi= yuvarla((AgiOran(sec)*asgariUcret)*0.15,2);
        if (agi>vh) return vh;
        return agi;
    }

    public double AgiOran(int sec){
        switch (sec){
            case 0 :return 0.5;//	Bekar
            case 1 :return 0.5;//	Evli eşi çalışan
            case 2 :return 0.575;//	Evli eşi çalışan 1 çocuk
            case 3 :return 0.65;//	Evli eşi çalışan 2 çocuk
            case 4 :return 0.75;//	Evli eşi çalışan 3 çocuk
            case 5 :return 0.8;//	Evli eşi çalışan 4 çocuk
            case 6 :return 0.85;//	Evli eşi çalışan 5 ve üzeri çocuk
            case 7 :return 0.6;//	Evli eşi çalışmayan
            case 8 :return 0.675;//	Evli eşi çalışmayan 1 çocuk
            case 9 :return 0.75;//	Evli eşi çalışmayan 2 çocuk
            case 10:return 0.85;//	Evli eşi çalışmayan 3 ve üzeri çocuk
        }
        return 0.5;
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

    public double getSsk() {
        return ssk;
    }

    public void setSsk(double ssk) {
        this.ssk = ssk;
    }

    public int getPrimGunu() {
        return primGunu;
    }

    public void setPrimGunu(int primGunu) {
        this.primGunu = primGunu;
    }

    public double getAgi() {
        return agi;
    }

    public void setAgi(double agi) {
        this.agi = agi;
    }
}
