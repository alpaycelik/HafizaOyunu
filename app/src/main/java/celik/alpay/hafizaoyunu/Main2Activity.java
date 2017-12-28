package celik.alpay.hafizaoyunu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

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
