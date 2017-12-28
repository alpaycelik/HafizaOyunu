package celik.alpay.hafizaoyunu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    int sonKart = 0;
    int skor = 0;
    int hata = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        String s = i.getStringExtra("mesaj");
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(s);
        GridLayout gl = (GridLayout) findViewById(R.id.kartlar);
        Kart kartlar[] = new Kart[16];
        for (int j = 1; j<=16; j++) {
            kartlar[j-1] = new Kart(this, j);
            kartlar[j-1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   Kart k = (Kart) v;
                   k.cevir();
                   if(sonKart>0){
                       Kart k2 = (Kart) findViewById(sonKart);
                       if(k2.onPlanID==k.onPlanID && k2.getId() != k.getId()){ //Eşlştiler
                            k2.cevrilebilir = false;
                            k.cevrilebilir = false;
                            skor++;
                            if(skor == 8){
                                // Oyun bitti.
                            }
                       }
                       else{ // Eşleşmediler 2 kartı geri çevir.
                           k.cevir();
                           k2.cevir();
                           hata++;
                           sonKart = 0;
                       }
                   }
                   else{
                       sonKart = k.getId();
                   }
                }
            });
        }
        // Karıştır
        for(int j=0; j<16; j++){
            int rg = (int)(Math.random()*16);
            Kart k = kartlar[rg];
            kartlar[rg] = kartlar[j];
            kartlar[j] = k;
        }
        for (int j=0; j<16; j++) {
            gl.addView(kartlar[j]);
        }
    }
}
