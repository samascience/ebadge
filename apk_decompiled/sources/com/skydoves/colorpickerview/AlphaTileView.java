package com.skydoves.colorpickerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import defpackage.n5;

/* JADX INFO: loaded from: classes.dex */
public class AlphaTileView extends View {
    private Paint a;
    private Bitmap b;
    private final n5.a c;

    public AlphaTileView(Context context) {
        super(context);
        this.c = new n5.a();
        b();
    }

    private void a(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.AlphaTileView);
        try {
            int i = R$styleable.AlphaTileView_tileSize;
            if (typedArrayObtainStyledAttributes.hasValue(i)) {
                n5.a aVar = this.c;
                aVar.j(typedArrayObtainStyledAttributes.getInt(i, aVar.g()));
            }
            int i2 = R$styleable.AlphaTileView_tileOddColor;
            if (typedArrayObtainStyledAttributes.hasValue(i2)) {
                n5.a aVar2 = this.c;
                aVar2.i(typedArrayObtainStyledAttributes.getInt(i2, aVar2.f()));
            }
            int i3 = R$styleable.AlphaTileView_tileEvenColor;
            if (typedArrayObtainStyledAttributes.hasValue(i3)) {
                n5.a aVar3 = this.c;
                aVar3.h(typedArrayObtainStyledAttributes.getInt(i3, aVar3.e()));
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void b() {
        this.a = new Paint(1);
        setBackgroundColor(-1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.b, 0.0f, 0.0f, (Paint) null);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.a);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        n5 n5VarD = this.c.d();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.b = bitmapCreateBitmap;
        if (bitmapCreateBitmap == null || bitmapCreateBitmap.isRecycled()) {
            return;
        }
        Canvas canvas = new Canvas(this.b);
        n5VarD.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        n5VarD.draw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        setPaintColor(i);
    }

    public void setPaintColor(int i) {
        this.a.setColor(i);
        invalidate();
    }

    public AlphaTileView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new n5.a();
        b();
        a(attributeSet);
    }

    public AlphaTileView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new n5.a();
        b();
        a(attributeSet);
    }
}
