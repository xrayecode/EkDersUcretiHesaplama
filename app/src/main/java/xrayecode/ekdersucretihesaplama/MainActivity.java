package xrayecode.ekdersucretihesaplama;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends Activity {
    Button btn;
    LinearLayout l1;
    Spinner unvanspn,egitimturuspn,sonogrenimspn,vergidilimispn,statuspn,medenispn,islemturuspn;
    int sec_unvanint,sec_egitimturuint,sec_sonogrenimint,sec_vergidilimiint,sec_medeniint,sec_statuint,sec_islemturuint;
    String sec_unvantxt,sec_egitimturutxt,sec_sonogrenimtxt,sec_vergidilimitxt,sec_medenitxt,sec_statutxt,sec_islemturutxt;
    ArrayAdapter<CharSequence> unvan_adapter,egitimturu_adapter,sonogrenim_adapter,vergidilimi_adapter,statu_adapter,medeni_adapter,islemturu_adapter;
    LinearLayout layout_main,layout_unvan,layout_egitimturu,layout_mezuniyet,layout_vergidilimi,layout_medeni,layout_statu,layout_islemturu,layout_1,layout_2,layout_3,layout_4,layout_5,layout_6;
    TextView label_1,label_2,label_3,label_4,label_5,label_6;
    EditText edit_1, edit_2,edit_3,edit_4,edit_5,edit_6;
    UcretHesapla uh;
    FormBean fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setItem();
        getSpinner();


        btn=(Button) findViewById(R.id.btn_hesapla);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hesapla();
                showSonucDialog();
            }
        });
    }

    private void Hesapla(){
        fb = new FormBean();
        fb.setEd1(Integer.parseInt(nvl(edit_1.getText().toString(),"0")));
        fb.setEd2(Integer.parseInt(nvl(edit_2.getText().toString(),"0")));
        fb.setEd3(Integer.parseInt(nvl(edit_3.getText().toString(), "0")));
        fb.setEd4(Integer.parseInt(nvl(edit_4.getText().toString(), "0")));
        fb.setEd5(Integer.parseInt(nvl(edit_5.getText().toString(), "0")));
        fb.setEd6(Integer.parseInt(nvl(edit_6.getText().toString(), "0")));
        fb.setSec_unvanint(this.sec_unvanint);
        fb.setSec_egitimturuint(this.sec_egitimturuint);
        fb.setSec_sonogrenimint(this.sec_sonogrenimint);
        fb.setSec_vergidilimiint(this.sec_vergidilimiint);
        fb.setSec_statuint(this.sec_statuint);
        fb.setSec_medeniint(this.sec_medeniint);
        fb.setSec_islemturuint(this.sec_islemturuint);


        uh = new UcretHesapla(fb);
    }

    private String nvl(String str,String val){
        if(str != null && !str.isEmpty()) { return str;  }
        return val;

    }


    private void showSonucDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog_layout, null, false);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(view);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        TextView txtTitle = (TextView) dialog.findViewById(R.id.txt_dialog_title);
        txtTitle.setText("Sonuç");

        TextView txtMessage = (TextView) dialog.findViewById(R.id.txt_dialog_message);
        txtMessage.setText("Toplam:" + uh.getToplam() + "\nVergi:" + uh.getVergi() + "\nDamga:" + uh.getDamga() + "\nNet:" + uh.getNet());
        /*
        Button btnOpenBrowser = (Button) dialog.findViewById(R.id.btn_open_browser);
        btnOpenBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Open the browser
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.android-ios-tutorials.com"));
                startActivity(browserIntent);
                // Dismiss the dialog
                dialog.dismiss();
            }
        });
        */
        Button btnCancel = (Button) dialog.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        // Display the dialog
        dialog.show();

    }
    private void setItem() {
        layout_main       = (LinearLayout) findViewById(R.id.layout_main);
        layout_egitimturu = (LinearLayout) findViewById(R.id.layout_egitimturu);
        layout_mezuniyet  = (LinearLayout) findViewById(R.id.layout_mezuniyet);
        layout_vergidilimi= (LinearLayout) findViewById(R.id.layout_vergidilimi);
        layout_medeni     = (LinearLayout) findViewById(R.id.layout_medeni);
        layout_statu      = (LinearLayout) findViewById(R.id.layout_statu);
        layout_islemturu  = (LinearLayout) findViewById(R.id.layout_islemturu);
        layout_unvan      = (LinearLayout) findViewById(R.id.layout_unvan);
        layout_1          = (LinearLayout) findViewById(R.id.layout_1);
        layout_2          = (LinearLayout) findViewById(R.id.layout_2);
        layout_3          = (LinearLayout) findViewById(R.id.layout_3);
        layout_4          = (LinearLayout) findViewById(R.id.layout_4);
        layout_5          = (LinearLayout) findViewById(R.id.layout_5);
        layout_6          = (LinearLayout) findViewById(R.id.layout_6);
        label_1           = (TextView) findViewById(R.id.label_1);
        label_2           = (TextView) findViewById(R.id.label_2);
        label_3           = (TextView) findViewById(R.id.label_3);
        label_4           = (TextView) findViewById(R.id.label_4);
        label_5           = (TextView) findViewById(R.id.label_5);
        label_6           = (TextView) findViewById(R.id.label_6);
        edit_1            = (EditText) findViewById(R.id.edit_1);
        edit_2            = (EditText) findViewById(R.id.edit_2);
        edit_3            = (EditText) findViewById(R.id.edit_3);
        edit_4            = (EditText) findViewById(R.id.edit_4);
        edit_5            = (EditText) findViewById(R.id.edit_5);
        edit_6            = (EditText) findViewById(R.id.edit_6);

    }


    private void getSpinner() {

        //Ãœnvan Bilgisi Al
        unvanspn= (Spinner) findViewById(R.id.unvanspn);
        unvan_adapter= ArrayAdapter.createFromResource(this, R.array.unvan_arr, android.R.layout.simple_spinner_item);
        unvan_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unvanspn.setAdapter(unvan_adapter);
        unvanspn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sec_unvantxt=(String) parent.getItemAtPosition(position);
                sec_unvanint=position;
                setVisibilityChange();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //EÄŸitim TÃ¼rÃ¼ Bilgisini Al
        egitimturuspn= (Spinner) findViewById(R.id.egitimturuspn);
        egitimturu_adapter= ArrayAdapter.createFromResource(this, R.array.egitimturu_arr, android.R.layout.simple_spinner_item);
        egitimturu_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        egitimturuspn.setAdapter(egitimturu_adapter);
        egitimturuspn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sec_egitimturutxt= (String) parent.getItemAtPosition(position);
                sec_egitimturuint=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Son Ã–ÄŸrenim Bilgisini Al
        sonogrenimspn= (Spinner) findViewById(R.id.sonogrenimspn);
        sonogrenim_adapter= ArrayAdapter.createFromResource(this, R.array.mezuniyet_arr, android.R.layout.simple_spinner_item);
        sonogrenim_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sonogrenimspn.setAdapter(sonogrenim_adapter);
        sonogrenimspn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sec_sonogrenimtxt= (String) parent.getItemAtPosition(position);
                sec_sonogrenimint=position;
                setVisibilityChange();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Vergi Dilimi Al
        vergidilimispn= (Spinner) findViewById(R.id.vergidilimispn);
        vergidilimi_adapter= ArrayAdapter.createFromResource(this, R.array.vergidilimi_arr, android.R.layout.simple_spinner_item);
        vergidilimi_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vergidilimispn.setAdapter(vergidilimi_adapter);
        vergidilimispn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sec_vergidilimitxt= (String) parent.getItemAtPosition(position);
                sec_vergidilimiint=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Statü Seçimi
        statuspn= (Spinner) findViewById(R.id.statuspn);
        statu_adapter= ArrayAdapter.createFromResource(this, R.array.statu_arr, android.R.layout.simple_spinner_item);
        statu_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statuspn.setAdapter(statu_adapter);
        statuspn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sec_statutxt= (String) parent.getItemAtPosition(position);
                sec_statuint = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Medeni Seçimi
        medenispn= (Spinner) findViewById(R.id.medenispn);
        medeni_adapter= ArrayAdapter.createFromResource(this, R.array.medeni_arr, android.R.layout.simple_spinner_item);
        medeni_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        medenispn.setAdapter(medeni_adapter);
        medenispn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sec_medenitxt= (String) parent.getItemAtPosition(position);
                sec_medeniint = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //İşlem Türü Seçimi
        islemturuspn= (Spinner) findViewById(R.id.islemturuspn);
        islemturu_adapter= ArrayAdapter.createFromResource(this, R.array.islemturu_arr, android.R.layout.simple_spinner_item);
        islemturu_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        islemturuspn.setAdapter(islemturu_adapter);
        islemturuspn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sec_islemturutxt= (String) parent.getItemAtPosition(position);
                sec_islemturuint = position;
                setVisibilityChange();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }

    private void setVisibilityChange() {
        layout_unvan.setVisibility(View.VISIBLE);
        layout_egitimturu.setVisibility(View.VISIBLE);
        layout_mezuniyet.setVisibility(View.VISIBLE);
        layout_vergidilimi.setVisibility(View.VISIBLE);
        layout_medeni.setVisibility(View.VISIBLE);
        layout_statu.setVisibility(View.VISIBLE);
        layout_1.setVisibility(View.VISIBLE);
        layout_2.setVisibility(View.VISIBLE);
        layout_3.setVisibility(View.VISIBLE);
        layout_4.setVisibility(View.VISIBLE);
        layout_5.setVisibility(View.VISIBLE);
        layout_6.setVisibility(View.VISIBLE);
        edit_1.setText("");edit_2.setText("");
        edit_3.setText("");edit_4.setText("");
        edit_5.setText("");edit_6.setText("");
        if(sec_unvanint==0 && sec_islemturuint==0){
            layout_1.setVisibility(View.GONE);
            layout_2.setVisibility(View.GONE);
            layout_3.setVisibility(View.GONE);
            layout_4.setVisibility(View.GONE);
            layout_5.setVisibility(View.GONE);
            layout_6.setVisibility(View.GONE);
            layout_egitimturu.setVisibility(View.GONE);
            layout_mezuniyet.setVisibility(View.GONE);
            layout_vergidilimi.setVisibility(View.GONE);
            layout_medeni.setVisibility(View.GONE);
            layout_statu.setVisibility(View.GONE);
        }
        if ((sec_unvanint==1 || sec_unvanint==2 ||sec_unvanint==3  ||sec_unvanint==4)  && sec_islemturuint==0 ){//profesÃƒÂ¶r,//doÃƒÂ§ent,//yar. doÃƒÂ§ent
            layout_egitimturu.setVisibility(View.GONE);
            layout_mezuniyet.setVisibility(View.GONE);
            layout_medeni.setVisibility(View.GONE);
            layout_statu.setVisibility(View.GONE);
            layout_4.setVisibility(View.GONE);
            layout_5.setVisibility(View.GONE);
            layout_6.setVisibility(View.GONE);
            label_1.setText(R.string.gunduz_normal_ogretim);
            label_2.setText(R.string.gece_normal_ogretim);
            label_3.setText(R.string.gece_ikinci_ogretim);
        }

        if (sec_unvanint==5  && sec_islemturuint==0){
            layout_medeni.setVisibility(View.GONE);
            layout_statu.setVisibility(View.GONE);
            if(sec_sonogrenimint==0) {
                layout_5.setVisibility(View.GONE);
                layout_6.setVisibility(View.GONE);
                label_1.setText(R.string.gunduz_normal_ogretim);
                label_2.setText(R.string.gece_normal_ogretim);
                label_3.setText(R.string.gunduz_takviye_kursu);
                label_4.setText(R.string.gece_takviye_kursu);
            }else {
                label_1.setText(R.string.gunduz_fiilen_girilen);
                label_2.setText(R.string.gece_fiilen_girilen);
                label_3.setText(R.string.gunduz_normal_ogretim);
                label_4.setText(R.string.gece_normal_ogretim);
                label_5.setText(R.string.gunduz_takviye_kursu);
                label_6.setText(R.string.gece_takviye_kursu);
            }
        }
        if (sec_unvanint==6 && sec_islemturuint==0){
            layout_mezuniyet.setVisibility(View.GONE);
            layout_medeni.setVisibility(View.GONE);
            layout_statu.setVisibility(View.GONE);
            layout_3.setVisibility(View.GONE);
            layout_4.setVisibility(View.GONE);
            layout_5.setVisibility(View.GONE);
            layout_6.setVisibility(View.GONE);
            label_1.setText(R.string.gunduz_normal_ogretim);
            label_2.setText(R.string.gece_normal_ogretim);
        }
        if (sec_unvanint==7 && sec_islemturuint==0){
            layout_mezuniyet.setVisibility(View.GONE);
            layout_egitimturu.setVisibility(View.GONE);
            layout_3.setVisibility(View.GONE);
            layout_4.setVisibility(View.GONE);
            layout_5.setVisibility(View.GONE);
            layout_6.setVisibility(View.GONE);
            label_1.setText(R.string.gunduz_normal_ogretim);
            label_2.setText(R.string.gece_normal_ogretim);
        }
        if (sec_islemturuint==1){
            layout_unvan.setVisibility(View.GONE);
            layout_egitimturu.setVisibility(View.GONE);
            layout_mezuniyet.setVisibility(View.GONE);
            layout_vergidilimi.setVisibility(View.GONE);
            layout_statu.setVisibility(View.GONE);
            layout_1.setVisibility(View.GONE);
            layout_2.setVisibility(View.GONE);
            layout_3.setVisibility(View.GONE);
            layout_4.setVisibility(View.GONE);
            layout_5.setVisibility(View.GONE);
            layout_6.setVisibility(View.GONE);
        }

        layout_main.invalidate();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
