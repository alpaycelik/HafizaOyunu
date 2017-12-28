package celik.alpay.hafizaoyunu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;

public class Kart extends Button{
    boolean acikMi = false;
    int resimID;
    int arkaPlanID;
    public Kart(Context context) {
        super(context);
        arkaPlanID = R.drawable.arkaplan;
        Drawable d = AppCompatDrawableManager.get().getDrawable(context,arkaPlanID);
        setBackground(d);
    }
}
