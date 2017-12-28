package celik.alpay.hafizaoyunu;

import android.content.Intent;
import android.os.Handler;
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
        final String s = i.getStringExtra("mesaj");
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(s);
        GridLayout gl = (GridLayout) findViewById(R.id.kartlar);
        Kart kartlar[] = new Kart[16];
        for (int j = 1; j<=16; j++) {
            kartlar[j-1] = new Kart(this, j);
            kartlar[j-1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   final Kart k = (Kart) v;
                   k.cevir();
                   if(sonKart>0){
                       final Kart k2 = (Kart) findViewById(sonKart);
                       if((k2.onPlanID == k.onPlanID) && (k2.getId() != k.getId())){ //Eşleştiler
                            k2.cevrilebilir = false;
                            k.cevrilebilir = false;
                            skor++;
                            TextView tvS = (TextView) findViewById(R.id.tvSkor);
                            tvS.setText("Skorunuz: "+skor);
                            if(skor == 8){// Oyun bitti.
                                Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                                i.putExtra("puan",hata);
                                i.putExtra("isim",s);
                                startActivity(i);
                            }
                       }
                       else{ // Eşleşmediler 2 kartı geri çevir.
                           Handler h = new Handler();
                           h.postDelayed(new Runnable() {
                               @Override
                               public void run() {
                                   k.cevir();
                                   k2.cevir();
                               }
                           },500);
                           hata++;
                           TextView tvH = (TextView) findViewById(R.id.tvHata);
                           tvH.setText("Hata Sayısı: "+hata);
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
