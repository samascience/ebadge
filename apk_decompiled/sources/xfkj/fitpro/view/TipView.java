package xfkj.fitpro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.d;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class TipView extends LinearLayout {
    private Context a;
    private int b;
    private int c;
    private String d;
    private int e;
    private TextView f;
    private int g;
    private Handler h;
    boolean i;

    public TipView(Context context) {
        this(context, null);
    }

    private void a() {
        setGravity(17);
        setBackgroundColor(this.b);
        TextView textView = new TextView(this.a);
        this.f = textView;
        textView.setGravity(17);
        this.f.getPaint().setTextSize(this.e);
        this.f.setTextColor(this.c);
        this.f.setText(this.d);
        addView(this.f);
    }

    public TipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = 2000;
        this.h = new Handler();
        this.i = false;
        this.a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TipView);
        this.b = typedArrayObtainStyledAttributes.getColor(0, Color.parseColor("#ffffff"));
        this.c = typedArrayObtainStyledAttributes.getColor(2, Color.parseColor("#666666"));
        this.d = typedArrayObtainStyledAttributes.getString(1);
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, d.g(12.0f));
        typedArrayObtainStyledAttributes.recycle();
        a();
    }
}
