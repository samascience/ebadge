package xfkj.fitpro.view.sleep;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.e43;
import defpackage.fz;
import defpackage.mr2;
import defpackage.nz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.objectweb.asm.Opcodes;
import xfkj.fitpro.R$styleable;
import xfkj.fitpro.view.sleep.SleepView;

/* JADX INFO: loaded from: classes4.dex */
public class SleepView extends View {
    Paint a;
    Paint b;
    Paint c;
    Paint d;
    private List e;

    public SleepView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new ArrayList();
        b(context, attributeSet);
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SleepViewStyle);
        int color = typedArrayObtainStyledAttributes.getColor(0, nz.a(R.color.sleep_default_color));
        int color2 = typedArrayObtainStyledAttributes.getColor(1, Opcodes.V_PREVIEW);
        int color3 = typedArrayObtainStyledAttributes.getColor(2, -256);
        int color4 = typedArrayObtainStyledAttributes.getColor(3, -16777216);
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(color);
        this.a.setStrokeWidth(3.0f);
        this.a.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setColor(color2);
        Paint paint3 = new Paint();
        this.c = paint3;
        paint3.setColor(color3);
        Paint paint4 = new Paint();
        this.d = paint4;
        paint4.setColor(color4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int c(mr2 mr2Var, mr2 mr2Var2) {
        throw null;
    }

    private void d() {
        Collections.sort(this.e, new Comparator() { // from class: or2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                e43.a(obj);
                e43.a(obj2);
                return SleepView.c(null, null);
            }
        });
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), 0.0f, 0.0f, this.a);
        if (fz.c(this.e) <= 0) {
            return;
        }
        d();
        e43.a(this.e.get(0));
        throw null;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setSleepItems(List<mr2> list) {
        this.e = list;
        invalidate();
    }

    public SleepView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new ArrayList();
        b(context, attributeSet);
    }
}
