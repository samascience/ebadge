package xfkj.fitpro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.SpanUtils;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class VerticalTextView extends AppCompatTextView {
    private String h;
    private String i;
    private float j;
    private float k;
    private int l;
    private int m;
    private int n;

    public VerticalTextView(Context context) {
        super(context);
        this.n = 17;
    }

    private void q(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.VerticalFontTextView);
        this.h = typedArrayObtainStyledAttributes.getString(4);
        this.i = typedArrayObtainStyledAttributes.getString(0);
        this.j = typedArrayObtainStyledAttributes.getDimension(6, 14.0f);
        this.k = typedArrayObtainStyledAttributes.getDimension(2, 14.0f);
        this.l = typedArrayObtainStyledAttributes.getColor(5, -16777216);
        this.m = typedArrayObtainStyledAttributes.getColor(1, -16777216);
        this.n = typedArrayObtainStyledAttributes.getInt(3, 17);
        r();
    }

    private void r() {
        SpanUtils spanUtilsP = SpanUtils.p(this);
        spanUtilsP.a(this.h).j((int) this.j).h(this.l, false, null);
        spanUtilsP.a("\n");
        spanUtilsP.a(this.i).j((int) this.k).h(this.m, false, null);
        spanUtilsP.f();
        setGravity(this.n);
    }

    public void setBottomFontColor(int i) {
        this.m = i;
        r();
    }

    public void setBottomFontSize(float f) {
        this.k = f;
        r();
    }

    public void setBottomFontText(String str) {
        this.i = str;
        r();
    }

    public void setTopFontColor(int i) {
        this.l = i;
        r();
    }

    public void setTopFontSize(float f) {
        this.j = f;
        r();
    }

    public void setTopFontText(String str) {
        this.h = str;
        r();
    }

    public VerticalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = 17;
        q(context, attributeSet);
    }

    public VerticalTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = 17;
        q(context, attributeSet);
    }
}
