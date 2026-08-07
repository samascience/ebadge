package xfkj.fitpro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.SpanUtils;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class BigSmallTextView extends AppCompatTextView {
    private String h;
    private String i;
    private float j;
    private float k;
    private int l;
    private int m;
    private float n;

    public BigSmallTextView(Context context) {
        super(context);
    }

    private void q() {
        SpanUtils spanUtilsP = SpanUtils.p(this);
        spanUtilsP.a(this.h).j((int) this.j).g().h(this.l, false, null);
        spanUtilsP.b((int) this.n);
        spanUtilsP.a(this.i).j((int) this.k).h(this.m, false, null);
        spanUtilsP.f();
    }

    private void r(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BigSmallTextView);
        this.h = typedArrayObtainStyledAttributes.getString(2);
        this.i = typedArrayObtainStyledAttributes.getString(5);
        this.j = typedArrayObtainStyledAttributes.getDimension(1, 24.0f);
        this.k = typedArrayObtainStyledAttributes.getDimension(4, 12.0f);
        this.l = typedArrayObtainStyledAttributes.getColor(0, -16777216);
        this.m = typedArrayObtainStyledAttributes.getColor(3, -16777216);
        this.n = typedArrayObtainStyledAttributes.getDimension(6, 5.0f);
        q();
    }

    public String getBigFontText() {
        return this.h;
    }

    public String getSmallFontText() {
        return this.i;
    }

    @Override // android.view.View
    public boolean isFocused() {
        return true;
    }

    public void setBigFontText(String str) {
        this.h = str;
        q();
    }

    public void setSmallFontText(String str) {
        this.i = str;
        q();
    }

    public BigSmallTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        r(context, attributeSet);
    }

    public BigSmallTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        r(context, attributeSet);
    }
}
