package xfkj.fitpro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class AutoLinkStyleTextView extends AppCompatTextView {
    private static int k = 1;
    private static int l = Color.parseColor("#f23218");
    private String h;
    private boolean i;
    private int j;

    class a extends ClickableSpan {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AutoLinkStyleTextView.r(AutoLinkStyleTextView.this);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(AutoLinkStyleTextView.l);
            textPaint.setUnderlineText(AutoLinkStyleTextView.this.i);
        }
    }

    private class b extends ImageSpan {
        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            Drawable drawable = getDrawable();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i6 = ((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2);
            canvas.save();
            canvas.translate(f, i6);
            drawable.draw(canvas);
            canvas.restore();
        }

        private b(Context context, int i) {
            super(context, i);
        }
    }

    public interface c {
    }

    public AutoLinkStyleTextView(Context context) {
        this(context, null);
    }

    static /* bridge */ /* synthetic */ c r(AutoLinkStyleTextView autoLinkStyleTextView) {
        autoLinkStyleTextView.getClass();
        return null;
    }

    private void t() {
        if (TextUtils.isEmpty(this.h) || !this.h.contains(",")) {
            return;
        }
        String[] strArrSplit = this.h.split(",");
        SpannableString spannableString = new SpannableString(getText().toString().trim());
        for (int i = 0; i < strArrSplit.length; i++) {
            spannableString.setSpan(new a(i), getText().toString().trim().indexOf(strArrSplit[i]), getText().toString().trim().indexOf(strArrSplit[i]) + strArrSplit[i].length(), 33);
        }
        setText(spannableString);
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void u(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AutoLinkStyleTextView, i, 0);
        k = typedArrayObtainStyledAttributes.getInt(4, 1);
        this.h = typedArrayObtainStyledAttributes.getString(3);
        l = typedArrayObtainStyledAttributes.getColor(0, l);
        this.i = typedArrayObtainStyledAttributes.getBoolean(1, this.i);
        this.j = typedArrayObtainStyledAttributes.getResourceId(2, 0);
        t();
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setOnClickCallBack(c cVar) {
    }

    public void setStartImageText(CharSequence charSequence) {
        if (k != 0 || TextUtils.isEmpty(charSequence) || this.j == 0) {
            return;
        }
        SpannableString spannableString = new SpannableString("   " + ((Object) charSequence));
        spannableString.setSpan(new b(getContext(), this.j), 0, 1, 33);
        setText(spannableString);
    }

    public AutoLinkStyleTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoLinkStyleTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = null;
        this.i = true;
        u(context, attributeSet, i);
    }
}
