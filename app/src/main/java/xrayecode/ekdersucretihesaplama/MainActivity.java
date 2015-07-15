package xrayecode.ekdersucretihesaplama;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    Button btn;
    LinearLayout l1;
    Spinner unvanspn,egitimturuspn,sonogrenimspn,vergidilimispn;
    int sec_unvanint,sec_egitimturuint,sec_sonogrenimint,sec_vergidilimiint;
    String sec_unvantxt,sec_egitimturutxt,sec_sonogrenimtxt,sec_vergidilimitxt;
    ArrayAdapter<CharSequence> unvan_adapter,egitimturu_adapter,sonogrenim_adapter,vergidilimi_adapter;
    LinearLayout layout_main,layout_egitimturu,layout_mezuniyet,layout_vergidilimi,layout_1,layout_2,layout_3,layout_4,layout_5,layout_6;
    TextView label_1,label_2,label_3,label_4,label_5,label_6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setLayout();
        getSpinner();

    }

    private void setLayout() {
        layout_main       = (LinearLayout) findViewById(R.id.layout_main);
        layout_egitimturu = (LinearLayout) findViewById(R.id.layout_egitimturu);
        layout_mezuniyet  = (LinearLayout) findViewById(R.id.layout_mezuniyet);
        layout_vergidilimi= (LinearLayout) findViewById(R.id.layout_vergidilimi);
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
    }

    private void getSpinner() {

        //Ünvan Bilgisi Al
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

        //Eğitim Türü Bilgisini Al Bilgisi Al
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

        //Son Öğrenim Bilgisini Al
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
    }

    private void setVisibilityChange() {
        layout_egitimturu.setVisibility(View.VISIBLE);
        layout_mezuniyet.setVisibility(View.VISIBLE);
        layout_vergidilimi.setVisibility(View.VISIBLE);
        layout_1.setVisibility(View.VISIBLE);
        layout_2.setVisibility(View.VISIBLE);
        layout_3.setVisibility(View.VISIBLE);
        layout_4.setVisibility(View.VISIBLE);
        layout_5.setVisibility(View.VISIBLE);
        layout_6.setVisibility(View.VISIBLE);

        if (sec_unvanint==1 || sec_unvanint==2 ||sec_unvanint==3  ||sec_unvanint==4 ){//profesör,//doçent,//yar. doçent
            layout_egitimturu.setVisibility(View.GONE);
            layout_mezuniyet.setVisibility(View.GONE);
            layout_4.setVisibility(View.GONE);
            layout_5.setVisibility(View.GONE);
            layout_6.setVisibility(View.GONE);
            label_1.setText(R.string.gunduz_normal_ogretim);
            label_2.setText(R.string.gece_normal_ogretim);
            label_3.setText(R.string.gece_ikinci_ogretim);
        }

        if (sec_unvanint==5){
            if(sec_sonogrenimint==0) {
                layout_5.setVisibility(View.GONE);
                layout_6.setVisibility(View.GONE);
                label_1.setText(R.string.gunduz_normal_ogretim);
                label_2.setText(R.string.gece_normal_ogretim);
                label_3.setText(R.string.gunduz_takviye_kursu);
                label_4.setText(R.string.gece_takviye_kursu);
            }
        }
        if (sec_unvanint==6){
            layout_mezuniyet.setVisibility(View.GONE);
            layout_3.setVisibility(View.GONE);
            layout_4.setVisibility(View.GONE);
            layout_5.setVisibility(View.GONE);
            layout_6.setVisibility(View.GONE);
            label_1.setText(R.string.gunduz_normal_ogretim);
            label_2.setText(R.string.gece_normal_ogretim);
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
