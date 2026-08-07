package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineHeightSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ReplacementSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.text.style.UpdateAppearance;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.tencent.connect.common.Constants;
import defpackage.q30;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class SpanUtils {
    private static final String a0 = System.getProperty("line.separator");
    private Typeface A;
    private Layout.Alignment B;
    private int C;
    private ClickableSpan D;
    private String E;
    private float F;
    private BlurMaskFilter.Blur G;
    private Shader H;
    private float I;
    private float J;
    private float K;
    private int L;
    private Object[] M;
    private Bitmap N;
    private Drawable O;
    private Uri P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private SerializableSpannableStringBuilder U;
    private boolean V;
    private int W;
    private final int X;
    private final int Y;
    private final int Z;
    private TextView a;
    private CharSequence b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f220q;
    private float r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private String z;

    @SuppressLint({"ParcelCreator"})
    static class CustomTypefaceSpan extends TypefaceSpan {
        private final Typeface a;

        /* synthetic */ CustomTypefaceSpan(Typeface typeface, a aVar) {
            this(typeface);
        }

        private void a(Paint paint, Typeface typeface) {
            Typeface typeface2 = paint.getTypeface();
            int style = (typeface2 == null ? 0 : typeface2.getStyle()) & (~typeface.getStyle());
            if ((style & 1) != 0) {
                paint.setFakeBoldText(true);
            }
            if ((style & 2) != 0) {
                paint.setTextSkewX(-0.25f);
            }
            paint.getShader();
            paint.setTypeface(typeface);
        }

        @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            a(textPaint, this.a);
        }

        @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
        public void updateMeasureState(TextPaint textPaint) {
            a(textPaint, this.a);
        }

        private CustomTypefaceSpan(Typeface typeface) {
            super(Constants.STR_EMPTY);
            this.a = typeface;
        }
    }

    private static class SerializableSpannableStringBuilder extends SpannableStringBuilder implements Serializable {
        private static final long serialVersionUID = 4909567650765875771L;

        private SerializableSpannableStringBuilder() {
        }

        /* synthetic */ SerializableSpannableStringBuilder(a aVar) {
            this();
        }
    }

    class a extends ClickableSpan {
        final /* synthetic */ int a;
        final /* synthetic */ boolean b;
        final /* synthetic */ View.OnClickListener c;

        a(int i, boolean z, View.OnClickListener onClickListener) {
            this.a = i;
            this.b = z;
            this.c = onClickListener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.c;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.a);
            textPaint.setUnderlineText(this.b);
        }
    }

    static class b implements LeadingMarginSpan {
        private final int a;
        private final int b;
        private final int c;
        private Path d;

        /* synthetic */ b(int i, int i2, int i3, a aVar) {
            this(i, i2, i3);
        }

        @Override // android.text.style.LeadingMarginSpan
        public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
            if (((Spanned) charSequence).getSpanStart(this) == i6) {
                Paint.Style style = paint.getStyle();
                int color = paint.getColor();
                paint.setColor(this.a);
                paint.setStyle(Paint.Style.FILL);
                if (canvas.isHardwareAccelerated()) {
                    if (this.d == null) {
                        Path path = new Path();
                        this.d = path;
                        path.addCircle(0.0f, 0.0f, this.b, Path.Direction.CW);
                    }
                    canvas.save();
                    canvas.translate(i + (i2 * this.b), (i3 + i5) / 2.0f);
                    canvas.drawPath(this.d, paint);
                    canvas.restore();
                } else {
                    int i8 = this.b;
                    canvas.drawCircle(i + (i2 * i8), (i3 + i5) / 2.0f, i8, paint);
                }
                paint.setColor(color);
                paint.setStyle(style);
            }
        }

        @Override // android.text.style.LeadingMarginSpan
        public int getLeadingMargin(boolean z) {
            return (this.b * 2) + this.c;
        }

        private b(int i, int i2, int i3) {
            this.d = null;
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    static abstract class c extends ReplacementSpan {
        final int a;
        private WeakReference b;

        /* synthetic */ c(int i, a aVar) {
            this(i);
        }

        private Drawable a() {
            WeakReference weakReference = this.b;
            Drawable drawable = weakReference != null ? (Drawable) weakReference.get() : null;
            if (drawable != null) {
                return drawable;
            }
            Drawable drawableB = b();
            this.b = new WeakReference(drawableB);
            return drawableB;
        }

        public abstract Drawable b();

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            int iHeight;
            float fHeight;
            Drawable drawableA = a();
            Rect bounds = drawableA.getBounds();
            canvas.save();
            if (bounds.height() < i5 - i3) {
                int i6 = this.a;
                if (i6 == 3) {
                    fHeight = i3;
                } else {
                    if (i6 == 2) {
                        iHeight = ((i5 + i3) - bounds.height()) / 2;
                    } else if (i6 == 1) {
                        fHeight = i4 - bounds.height();
                    } else {
                        iHeight = i5 - bounds.height();
                    }
                    fHeight = iHeight;
                }
                canvas.translate(f, fHeight);
            } else {
                canvas.translate(f, i3);
            }
            drawableA.draw(canvas);
            canvas.restore();
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            int i3;
            Rect bounds = a().getBounds();
            if (fontMetricsInt != null && (i3 = fontMetricsInt.bottom - fontMetricsInt.top) < bounds.height()) {
                int i4 = this.a;
                if (i4 == 3) {
                    fontMetricsInt.top = fontMetricsInt.top;
                    fontMetricsInt.bottom = bounds.height() + fontMetricsInt.top;
                } else if (i4 == 2) {
                    int i5 = i3 / 4;
                    fontMetricsInt.top = ((-bounds.height()) / 2) - i5;
                    fontMetricsInt.bottom = (bounds.height() / 2) - i5;
                } else {
                    int i6 = -bounds.height();
                    int i7 = fontMetricsInt.bottom;
                    fontMetricsInt.top = i6 + i7;
                    fontMetricsInt.bottom = i7;
                }
                fontMetricsInt.ascent = fontMetricsInt.top;
                fontMetricsInt.descent = fontMetricsInt.bottom;
            }
            return bounds.right;
        }

        private c(int i) {
            this.a = i;
        }
    }

    static class d extends c {
        private Drawable c;
        private Uri d;
        private int e;

        /* synthetic */ d(int i, int i2, a aVar) {
            this(i, i2);
        }

        @Override // com.blankj.utilcode.util.SpanUtils.c
        public Drawable b() {
            Drawable drawableE;
            Drawable drawable = this.c;
            if (drawable != null) {
                return drawable;
            }
            BitmapDrawable bitmapDrawable = null;
            if (this.d != null) {
                try {
                    InputStream inputStreamOpenInputStream = o.a().getContentResolver().openInputStream(this.d);
                    BitmapDrawable bitmapDrawable2 = new BitmapDrawable(o.a().getResources(), BitmapFactory.decodeStream(inputStreamOpenInputStream));
                    try {
                        bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), bitmapDrawable2.getIntrinsicHeight());
                        if (inputStreamOpenInputStream != null) {
                            inputStreamOpenInputStream.close();
                        }
                        return bitmapDrawable2;
                    } catch (Exception e) {
                        e = e;
                        bitmapDrawable = bitmapDrawable2;
                        Log.e("sms", "Failed to loaded content " + this.d, e);
                        return bitmapDrawable;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } else {
                try {
                    drawableE = q30.e(o.a(), this.e);
                    try {
                        drawableE.setBounds(0, 0, drawableE.getIntrinsicWidth(), drawableE.getIntrinsicHeight());
                        return drawableE;
                    } catch (Exception unused) {
                        Log.e("sms", "Unable to find resource: " + this.e);
                        return drawableE;
                    }
                } catch (Exception unused2) {
                    drawableE = null;
                }
            }
        }

        /* synthetic */ d(Bitmap bitmap, int i, a aVar) {
            this(bitmap, i);
        }

        /* synthetic */ d(Drawable drawable, int i, a aVar) {
            this(drawable, i);
        }

        /* synthetic */ d(Uri uri, int i, a aVar) {
            this(uri, i);
        }

        private d(Bitmap bitmap, int i) {
            super(i, null);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(o.a().getResources(), bitmap);
            this.c = bitmapDrawable;
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), this.c.getIntrinsicHeight());
        }

        private d(Drawable drawable, int i) {
            super(i, null);
            this.c = drawable;
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.c.getIntrinsicHeight());
        }

        private d(Uri uri, int i) {
            super(i, null);
            this.d = uri;
        }

        private d(int i, int i2) {
            super(i2, null);
            this.e = i;
        }
    }

    static class e implements LineHeightSpan {
        static Paint.FontMetricsInt c;
        private final int a;
        final int b;

        e(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
            Paint.FontMetricsInt fontMetricsInt2 = c;
            if (fontMetricsInt2 == null) {
                Paint.FontMetricsInt fontMetricsInt3 = new Paint.FontMetricsInt();
                c = fontMetricsInt3;
                fontMetricsInt3.top = fontMetricsInt.top;
                fontMetricsInt3.ascent = fontMetricsInt.ascent;
                fontMetricsInt3.descent = fontMetricsInt.descent;
                fontMetricsInt3.bottom = fontMetricsInt.bottom;
                fontMetricsInt3.leading = fontMetricsInt.leading;
            } else {
                fontMetricsInt.top = fontMetricsInt2.top;
                fontMetricsInt.ascent = fontMetricsInt2.ascent;
                fontMetricsInt.descent = fontMetricsInt2.descent;
                fontMetricsInt.bottom = fontMetricsInt2.bottom;
                fontMetricsInt.leading = fontMetricsInt2.leading;
            }
            int i5 = this.a;
            int i6 = fontMetricsInt.descent;
            int i7 = fontMetricsInt.ascent;
            int i8 = i5 - (((i4 + i6) - i7) - i3);
            if (i8 > 0) {
                int i9 = this.b;
                if (i9 == 3) {
                    fontMetricsInt.descent = i6 + i8;
                } else if (i9 == 2) {
                    int i10 = i8 / 2;
                    fontMetricsInt.descent = i6 + i10;
                    fontMetricsInt.ascent = i7 - i10;
                } else {
                    fontMetricsInt.ascent = i7 - i8;
                }
            }
            int i11 = fontMetricsInt.bottom;
            int i12 = fontMetricsInt.top;
            int i13 = i5 - (((i4 + i11) - i12) - i3);
            if (i13 > 0) {
                int i14 = this.b;
                if (i14 == 3) {
                    fontMetricsInt.bottom = i11 + i13;
                } else if (i14 == 2) {
                    int i15 = i13 / 2;
                    fontMetricsInt.bottom = i11 + i15;
                    fontMetricsInt.top = i12 - i15;
                } else {
                    fontMetricsInt.top = i12 - i13;
                }
            }
            if (i2 == ((Spanned) charSequence).getSpanEnd(this)) {
                c = null;
            }
        }
    }

    static class f implements LeadingMarginSpan {
        private final int a;
        private final int b;
        private final int c;

        /* synthetic */ f(int i, int i2, int i3, a aVar) {
            this(i, i2, i3);
        }

        @Override // android.text.style.LeadingMarginSpan
        public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
            Paint.Style style = paint.getStyle();
            int color = paint.getColor();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.a);
            canvas.drawRect(i, i3, i + (this.b * i2), i5, paint);
            paint.setStyle(style);
            paint.setColor(color);
        }

        @Override // android.text.style.LeadingMarginSpan
        public int getLeadingMargin(boolean z) {
            return this.b + this.c;
        }

        private f(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    static class g extends CharacterStyle implements UpdateAppearance {
        private Shader a;

        /* synthetic */ g(Shader shader, a aVar) {
            this(shader);
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setShader(this.a);
        }

        private g(Shader shader) {
            this.a = shader;
        }
    }

    static class h extends CharacterStyle implements UpdateAppearance {
        private float a;
        private float b;
        private float c;
        private int d;

        /* synthetic */ h(float f, float f2, float f3, int i, a aVar) {
            this(f, f2, f3, i);
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setShadowLayer(this.a, this.b, this.c, this.d);
        }

        private h(float f, float f2, float f3, int i) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = i;
        }
    }

    static class i extends ReplacementSpan {
        private final int a;
        private final Paint b;

        /* synthetic */ i(int i, int i2, a aVar) {
            this(i, i2);
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            canvas.drawRect(f, i3, f + this.a, i5, this.b);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            return this.a;
        }

        private i(int i, int i2) {
            Paint paint = new Paint();
            this.b = paint;
            this.a = i;
            paint.setColor(i2);
            paint.setStyle(Paint.Style.FILL);
        }
    }

    static class j extends ReplacementSpan {
        final int a;

        j(int i) {
            this.a = i;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            CharSequence charSequenceSubSequence = charSequence.subSequence(i, i2);
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.drawText(charSequenceSubSequence.toString(), f, i4 - (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - ((i5 + i3) / 2)), paint);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            return (int) paint.measureText(charSequence.subSequence(i, i2).toString());
        }
    }

    private SpanUtils(TextView textView) {
        this();
        this.a = textView;
    }

    private void d(int i2) {
        e();
        this.W = i2;
    }

    private void e() {
        if (this.V) {
            return;
        }
        int i2 = this.W;
        if (i2 == 0) {
            m();
        } else if (i2 == 1) {
            n();
        } else if (i2 == 2) {
            o();
        }
        i();
    }

    private void i() {
        this.c = 33;
        this.d = -16777217;
        this.e = -16777217;
        this.f = -1;
        this.h = -16777217;
        this.k = -1;
        this.m = -16777217;
        this.p = -1;
        this.f220q = -1.0f;
        this.r = -1.0f;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = -1;
        this.D = null;
        this.E = null;
        this.F = -1.0f;
        this.H = null;
        this.I = -1.0f;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = -1;
        this.S = -1;
    }

    private void l() {
        TextView textView = this.a;
        if (textView == null || textView.getMovementMethod() != null) {
            return;
        }
        this.a.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void m() {
        if (this.b.length() == 0) {
            return;
        }
        int length = this.U.length();
        if (length == 0 && this.f != -1) {
            this.U.append((CharSequence) Character.toString((char) 2)).append((CharSequence) "\n").setSpan(new AbsoluteSizeSpan(0), 0, 2, 33);
            length = 2;
        }
        this.U.append(this.b);
        int length2 = this.U.length();
        if (this.C != -1) {
            this.U.setSpan(new j(this.C), length, length2, this.c);
        }
        if (this.d != -16777217) {
            this.U.setSpan(new ForegroundColorSpan(this.d), length, length2, this.c);
        }
        if (this.e != -16777217) {
            this.U.setSpan(new BackgroundColorSpan(this.e), length, length2, this.c);
        }
        if (this.k != -1) {
            this.U.setSpan(new LeadingMarginSpan.Standard(this.k, this.l), length, length2, this.c);
        }
        int i2 = this.h;
        a aVar = null;
        if (i2 != -16777217) {
            this.U.setSpan(new f(i2, this.i, this.j, aVar), length, length2, this.c);
        }
        int i3 = this.m;
        if (i3 != -16777217) {
            this.U.setSpan(new b(i3, this.n, this.o, aVar), length, length2, this.c);
        }
        if (this.p != -1) {
            this.U.setSpan(new AbsoluteSizeSpan(this.p, false), length, length2, this.c);
        }
        if (this.f220q != -1.0f) {
            this.U.setSpan(new RelativeSizeSpan(this.f220q), length, length2, this.c);
        }
        if (this.r != -1.0f) {
            this.U.setSpan(new ScaleXSpan(this.r), length, length2, this.c);
        }
        int i4 = this.f;
        if (i4 != -1) {
            this.U.setSpan(new e(i4, this.g), length, length2, this.c);
        }
        if (this.s) {
            this.U.setSpan(new StrikethroughSpan(), length, length2, this.c);
        }
        if (this.t) {
            this.U.setSpan(new UnderlineSpan(), length, length2, this.c);
        }
        if (this.u) {
            this.U.setSpan(new SuperscriptSpan(), length, length2, this.c);
        }
        if (this.v) {
            this.U.setSpan(new SubscriptSpan(), length, length2, this.c);
        }
        if (this.w) {
            this.U.setSpan(new StyleSpan(1), length, length2, this.c);
        }
        if (this.x) {
            this.U.setSpan(new StyleSpan(2), length, length2, this.c);
        }
        if (this.y) {
            this.U.setSpan(new StyleSpan(3), length, length2, this.c);
        }
        if (this.z != null) {
            this.U.setSpan(new TypefaceSpan(this.z), length, length2, this.c);
        }
        if (this.A != null) {
            this.U.setSpan(new CustomTypefaceSpan(this.A, aVar), length, length2, this.c);
        }
        if (this.B != null) {
            this.U.setSpan(new AlignmentSpan.Standard(this.B), length, length2, this.c);
        }
        ClickableSpan clickableSpan = this.D;
        if (clickableSpan != null) {
            this.U.setSpan(clickableSpan, length, length2, this.c);
        }
        if (this.E != null) {
            this.U.setSpan(new URLSpan(this.E), length, length2, this.c);
        }
        if (this.F != -1.0f) {
            this.U.setSpan(new MaskFilterSpan(new BlurMaskFilter(this.F, this.G)), length, length2, this.c);
        }
        if (this.H != null) {
            this.U.setSpan(new g(this.H, aVar), length, length2, this.c);
        }
        if (this.I != -1.0f) {
            this.U.setSpan(new h(this.I, this.J, this.K, this.L, null), length, length2, this.c);
        }
        Object[] objArr = this.M;
        if (objArr != null) {
            for (Object obj : objArr) {
                this.U.setSpan(obj, length, length2, this.c);
            }
        }
    }

    private void n() {
        int length = this.U.length();
        this.b = "<img>";
        m();
        int length2 = this.U.length();
        a aVar = null;
        if (this.N != null) {
            this.U.setSpan(new d(this.N, this.R, aVar), length, length2, this.c);
            return;
        }
        if (this.O != null) {
            this.U.setSpan(new d(this.O, this.R, aVar), length, length2, this.c);
        } else if (this.P != null) {
            this.U.setSpan(new d(this.P, this.R, aVar), length, length2, this.c);
        } else if (this.Q != -1) {
            this.U.setSpan(new d(this.Q, this.R, aVar), length, length2, this.c);
        }
    }

    private void o() {
        int length = this.U.length();
        this.b = "< >";
        m();
        this.U.setSpan(new i(this.S, this.T, null), length, this.U.length(), this.c);
    }

    public static SpanUtils p(TextView textView) {
        return new SpanUtils(textView);
    }

    public SpanUtils a(CharSequence charSequence) {
        d(0);
        this.b = charSequence;
        return this;
    }

    public SpanUtils b(int i2) {
        return c(i2, 0);
    }

    public SpanUtils c(int i2, int i3) {
        d(2);
        this.S = i2;
        this.T = i3;
        return this;
    }

    public SpannableStringBuilder f() {
        e();
        TextView textView = this.a;
        if (textView != null) {
            textView.setText(this.U);
        }
        this.V = true;
        return this.U;
    }

    public SpanUtils g() {
        this.w = true;
        return this;
    }

    public SpanUtils h(int i2, boolean z, View.OnClickListener onClickListener) {
        l();
        this.D = new a(i2, z, onClickListener);
        return this;
    }

    public SpanUtils j(int i2) {
        return k(i2, false);
    }

    public SpanUtils k(int i2, boolean z) {
        if (z) {
            this.p = (int) ((i2 * Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
        } else {
            this.p = i2;
        }
        return this;
    }

    public SpanUtils() {
        this.X = 0;
        this.Y = 1;
        this.Z = 2;
        this.U = new SerializableSpannableStringBuilder(null);
        this.b = Constants.STR_EMPTY;
        this.W = -1;
        i();
    }
}
