package xfkj.fitpro.view;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import defpackage.dd0;
import defpackage.q30;
import defpackage.v8;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class XEditText extends AppCompatEditText {
    private int F;
    private int G;
    private String g;
    private boolean h;
    private int i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private Drawable n;
    private Drawable o;
    private TextWatcher p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f425q;
    private int r;
    private int s;
    private boolean t;
    private int[] u;
    private int[] v;
    private boolean w;
    private boolean x;
    private boolean y;
    private Bitmap z;

    class a implements View.OnFocusChangeListener {
        a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            XEditText.this.t = z;
            XEditText.this.u();
            XEditText.h(XEditText.this);
        }
    }

    private class b implements InputFilter {
        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            while (i < i2) {
                int type = Character.getType(charSequence.charAt(i));
                if (type == 19 || type == 28) {
                    return Constants.STR_EMPTY;
                }
                i++;
            }
            return null;
        }

        private b() {
        }
    }

    private class c implements TextWatcher {
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            XEditText.this.u();
            if (XEditText.this.g.isEmpty()) {
                XEditText.i(XEditText.this);
                return;
            }
            XEditText xEditText = XEditText.this;
            xEditText.removeTextChangedListener(xEditText.p);
            XEditText.this.w(XEditText.this.w ? editable.toString().trim() : editable.toString().replaceAll(XEditText.this.g, Constants.STR_EMPTY).trim(), false);
            XEditText.i(XEditText.this);
            XEditText xEditText2 = XEditText.this;
            xEditText2.addTextChangedListener(xEditText2.p);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            XEditText.this.f425q = charSequence.length();
            XEditText.i(XEditText.this);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            XEditText.this.r = charSequence.length();
            XEditText xEditText = XEditText.this;
            xEditText.s = xEditText.getSelectionStart();
            XEditText.i(XEditText.this);
        }

        private c() {
        }
    }

    public interface d {
    }

    public interface e {
    }

    public XEditText(Context context) {
        this(context, null);
    }

    static /* bridge */ /* synthetic */ d h(XEditText xEditText) {
        xEditText.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ e i(XEditText xEditText) {
        xEditText.getClass();
        return null;
    }

    private void p(boolean z) {
        int inputType = getInputType();
        if (!z) {
            int i = inputType + 1;
            inputType = i == 17 ? inputType + 2 : i;
        }
        boolean z2 = this.j && (inputType == 129 || inputType == 18 || inputType == 145 || inputType == 225);
        this.x = z2;
        if (z2) {
            boolean z3 = inputType == 145;
            this.y = z3;
            if (z3) {
                setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (this.l == -1) {
                this.l = R.drawable.x_et_svg_ic_show_password_24dp;
            }
            if (this.m == -1) {
                this.m = R.drawable.x_et_svg_ic_hide_password_24dp;
            }
            Drawable drawableE = q30.e(getContext(), this.y ? this.l : this.m);
            this.o = drawableE;
            if (this.l == R.drawable.x_et_svg_ic_show_password_24dp || this.m == R.drawable.x_et_svg_ic_hide_password_24dp) {
                dd0.n(drawableE, getCurrentHintTextColor());
            }
            Drawable drawable = this.o;
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.o.getIntrinsicHeight());
            if (this.i == -1) {
                this.i = R.drawable.x_et_svg_ic_clear_24dp;
            }
            if (!this.h) {
                Context context = getContext();
                int i2 = this.i;
                this.z = r(context, i2, i2 == R.drawable.x_et_svg_ic_clear_24dp);
            }
        }
        if (z) {
            return;
        }
        setTextEx(getTextEx());
        u();
    }

    private int q(int i) {
        return (int) TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics());
    }

    private Bitmap r(Context context, int i, boolean z) {
        Drawable drawableB = v8.b(context, i);
        if (drawableB == null) {
            return null;
        }
        if (z) {
            dd0.n(drawableB, getCurrentHintTextColor());
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableB.getIntrinsicWidth(), drawableB.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableB.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableB.draw(canvas);
        return bitmapCreateBitmap;
    }

    private void s(Context context, AttributeSet attributeSet, int i) {
        int inputType;
        boolean z = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.XEditText, i, 0);
        this.g = typedArrayObtainStyledAttributes.getString(5);
        this.h = typedArrayObtainStyledAttributes.getBoolean(1, false);
        this.i = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        this.j = typedArrayObtainStyledAttributes.getBoolean(7, true);
        this.l = typedArrayObtainStyledAttributes.getResourceId(6, -1);
        this.m = typedArrayObtainStyledAttributes.getResourceId(3, -1);
        this.k = typedArrayObtainStyledAttributes.getBoolean(2, false);
        String string = typedArrayObtainStyledAttributes.getString(4);
        typedArrayObtainStyledAttributes.recycle();
        if (this.g == null) {
            this.g = Constants.STR_EMPTY;
        }
        this.w = TextUtils.isEmpty(this.g);
        if (this.g.length() > 0 && ((inputType = getInputType()) == 2 || inputType == 8194 || inputType == 4098)) {
            setInputType(3);
        }
        if (!this.h) {
            if (this.i == -1) {
                this.i = R.drawable.x_et_svg_ic_clear_24dp;
            }
            Drawable drawableB = v8.b(context, this.i);
            this.n = drawableB;
            if (drawableB != null) {
                drawableB.setBounds(0, 0, drawableB.getIntrinsicWidth(), this.n.getIntrinsicHeight());
                if (this.i == R.drawable.x_et_svg_ic_clear_24dp) {
                    dd0.n(this.n, getCurrentHintTextColor());
                }
            }
        }
        p(true);
        if (this.g.isEmpty() || this.x || string == null || string.isEmpty()) {
            return;
        }
        if (string.contains(",")) {
            String[] strArrSplit = string.split(",");
            int length = strArrSplit.length;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    iArr[i2] = Integer.parseInt(strArrSplit[i2]);
                } catch (Exception unused) {
                }
            }
            z = true;
            if (z) {
                v(iArr, this.g);
            }
        } else {
            try {
                v(new int[]{Integer.parseInt(string)}, this.g);
                z = true;
            } catch (Exception unused2) {
            }
        }
        if (z) {
            return;
        }
        Log.e("XEditText", "the Pattern format is incorrect!");
    }

    private boolean t() {
        return getText().toString().trim().length() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (!this.t || (t() && !this.x)) {
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
            if (t() || !this.x) {
                return;
            }
            invalidate();
            return;
        }
        if (this.x) {
            if (this.l == R.drawable.x_et_svg_ic_show_password_24dp || this.m == R.drawable.x_et_svg_ic_hide_password_24dp) {
                dd0.n(this.o, getCurrentHintTextColor());
            }
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.o, getCompoundDrawables()[3]);
            return;
        }
        if (t() || this.h) {
            return;
        }
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.n, getCompoundDrawables()[3]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(CharSequence charSequence, boolean z) {
        int i;
        if (charSequence.length() == 0 || this.v == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            sb.append(charSequence.subSequence(i2, i3));
            int length2 = this.v.length;
            for (int i4 = 0; i4 < length2; i4++) {
                if (i2 == this.v[i4] && i4 < length2 - 1) {
                    sb.insert(sb.length() - 1, this.g);
                    if (this.s == sb.length() - 1 && (i = this.s) > this.v[i4]) {
                        if (this.r > this.f425q) {
                            this.s = i + this.g.length();
                        } else {
                            this.s = i - this.g.length();
                        }
                    }
                }
            }
            i2 = i3;
        }
        String string = sb.toString();
        setText(string);
        if (z) {
            setSelection(string.length());
            return;
        }
        if (this.s > string.length()) {
            this.s = string.length();
        }
        if (this.s < 0) {
            this.s = 0;
        }
        setSelection(this.s);
    }

    public String getTextEx() {
        return this.w ? getText().toString() : getText().toString().replaceAll(this.g, Constants.STR_EMPTY);
    }

    public String getTextTrimmed() {
        return getTextEx().trim();
    }

    @Deprecated
    public String getTrimmedString() {
        return this.w ? getText().toString().trim() : getText().toString().replaceAll(this.g, Constants.STR_EMPTY).trim();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.t || this.z == null || !this.x || t()) {
            return;
        }
        if (this.F * this.G == 0) {
            this.F = (((getMeasuredWidth() - getPaddingRight()) - this.o.getIntrinsicWidth()) - this.z.getWidth()) - q(4);
            this.G = (getMeasuredHeight() - this.z.getHeight()) >> 1;
        }
        canvas.drawBitmap(this.z, this.F, this.G, (Paint) null);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.g = bundle.getString("separator");
        this.u = bundle.getIntArray("pattern");
        this.w = TextUtils.isEmpty(this.g);
        int[] iArr = this.u;
        if (iArr != null) {
            setPattern(iArr);
        }
        super.onRestoreInstanceState(bundle.getParcelable("save_instance"));
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("save_instance", super.onSaveInstanceState());
        bundle.putString("separator", this.g);
        bundle.putIntArray("pattern", this.u);
        return bundle;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        ClipData.Item itemAt;
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        if (clipboardManager != null) {
            if (i == 16908320 || i == 16908321) {
                super.onTextContextMenuItem(i);
                ClipData.Item itemAt2 = clipboardManager.getPrimaryClip().getItemAt(0);
                if (itemAt2 != null && itemAt2.getText() != null) {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText(null, itemAt2.getText().toString().replace(this.g, Constants.STR_EMPTY)));
                    return true;
                }
            } else if (i == 16908322 && (itemAt = clipboardManager.getPrimaryClip().getItemAt(0)) != null && itemAt.getText() != null) {
                setTextEx(getText().toString() + itemAt.getText().toString().replace(this.g, Constants.STR_EMPTY));
                return true;
            }
        }
        return super.onTextContextMenuItem(i);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            performClick();
        }
        boolean z = false;
        if (this.t && this.x && motionEvent.getAction() == 1) {
            int intrinsicWidth = this.o.getIntrinsicWidth();
            int intrinsicHeight = this.o.getIntrinsicHeight();
            int measuredHeight = (getMeasuredHeight() - intrinsicHeight) >> 1;
            int measuredWidth = getMeasuredWidth() - getPaddingRight();
            boolean z2 = motionEvent.getX() <= ((float) measuredWidth) && motionEvent.getX() >= ((float) (measuredWidth - intrinsicWidth));
            boolean z3 = motionEvent.getY() >= ((float) measuredHeight) && motionEvent.getY() <= ((float) (measuredHeight + intrinsicHeight));
            if (z2 && z3) {
                boolean z4 = this.y;
                this.y = !z4;
                if (z4) {
                    setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                setSelection(getSelectionStart(), getSelectionEnd());
                Drawable drawableE = q30.e(getContext(), this.y ? this.l : this.m);
                this.o = drawableE;
                if (this.l == R.drawable.x_et_svg_ic_show_password_24dp || this.m == R.drawable.x_et_svg_ic_hide_password_24dp) {
                    dd0.n(drawableE, getCurrentHintTextColor());
                }
                Drawable drawable = this.o;
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.o.getIntrinsicHeight());
                setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.o, getCompoundDrawables()[3]);
                invalidate();
            }
            if (!this.h) {
                int iQ = measuredWidth - (intrinsicWidth + q(4));
                if (motionEvent.getX() <= iQ && motionEvent.getX() >= iQ - this.z.getWidth() && z3) {
                    setError(null);
                    setText(Constants.STR_EMPTY);
                }
            }
        }
        if (this.t && !this.h && !this.x && motionEvent.getAction() == 1) {
            Rect bounds = this.n.getBounds();
            int iWidth = bounds.width();
            int iHeight = bounds.height();
            int measuredHeight2 = (getMeasuredHeight() - iHeight) >> 1;
            int measuredWidth2 = getMeasuredWidth() - getPaddingRight();
            boolean z5 = motionEvent.getX() <= ((float) measuredWidth2) && motionEvent.getX() >= ((float) (measuredWidth2 - iWidth));
            if (motionEvent.getY() >= measuredHeight2 && motionEvent.getY() <= measuredHeight2 + iHeight) {
                z = true;
            }
            if (z5 && z) {
                setError(null);
                setText(Constants.STR_EMPTY);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void setDisableClear(boolean z) {
        this.h = z;
        invalidate();
    }

    public void setDisableEmoji(boolean z) {
        this.k = z;
        if (z) {
            setFilters(new InputFilter[]{new b()});
        } else {
            setFilters(new InputFilter[0]);
        }
    }

    @Override // android.widget.TextView
    public void setInputType(int i) {
        super.setInputType(i);
        p(false);
    }

    public void setOnXFocusChangeListener(d dVar) {
    }

    public void setOnXTextChangeListener(e eVar) {
    }

    public void setPattern(int[] iArr) {
        this.u = iArr;
        this.v = new int[iArr.length];
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            i += iArr[i2];
            this.v[i2] = i;
        }
        int[] iArr2 = this.v;
        setFilters(new InputFilter[]{new InputFilter.LengthFilter((iArr2[iArr2.length - 1] + iArr.length) - 1)});
    }

    public void setSeparator(String str) {
        this.g = str;
        this.w = TextUtils.isEmpty(str);
        if (this.g.length() > 0) {
            int inputType = getInputType();
            if (inputType == 2 || inputType == 8194 || inputType == 4098) {
                setInputType(3);
            }
        }
    }

    public void setTextEx(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && !this.w) {
            w(charSequence, true);
            return;
        }
        setText(charSequence);
        if (charSequence == null || charSequence.length() <= 0) {
            return;
        }
        setSelection(charSequence.length());
    }

    @Deprecated
    public void setTextToSeparate(CharSequence charSequence) {
        w(charSequence, true);
    }

    public void v(int[] iArr, String str) {
        setSeparator(str);
        setPattern(iArr);
    }

    public XEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.editTextStyle);
    }

    public XEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        s(context, attributeSet, i);
        if (this.k) {
            setFilters(new InputFilter[]{new b()});
        }
        c cVar = new c();
        this.p = cVar;
        addTextChangedListener(cVar);
        setOnFocusChangeListener(new a());
    }
}
