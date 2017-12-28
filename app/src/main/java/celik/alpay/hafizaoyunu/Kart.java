package celik.alpay.hafizaoyunu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;

public class Kart extends Button{
    boolean acikMi = false;
    boolean cevrilebilir = true;
    int arkaPlanID;
    int onPlanID;
    Drawable arka;
    Drawable on;
    public Kart(Context context, int id) {
        super(context);
        setId(id);
        arkaPlanID = R.drawable.arkaplan;

        if(id%8 == 1)
            onPlanID = R.drawable.c1;
        if(id%8 == 2)
            onPlanID = R.drawable.c2;
        if(id%8 == 3)
            onPlanID = R.drawable.c3;
        if(id%8 == 4)
            onPlanID = R.drawable.c4;
        if(id%8 == 5)
            onPlanID = R.drawable.c5;
        if(id%8 == 6)
            onPlanID = R.drawable.c6;
        if(id%8 == 7)
            onPlanID = R.drawable.c7;
        if(id%8 == 0)
            onPlanID = R.drawable.c8;

        arka = AppCompatDrawableManager.get().getDrawable(context,arkaPlanID);
        on = AppCompatDrawableManager.get().getDrawable(context, onPlanID);
        setBackground(arka);
    }
    public void cevir(){
        if(cevrilebilir) {
            if (!acikMi) { // arkası cevriliyse
                setBackground(on);
                acikMi = true;
            } else {
                setBackground(arka);
                acikMi = false;
            }
        }
    }
}
