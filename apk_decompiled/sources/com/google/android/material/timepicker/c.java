package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes3.dex */
class c implements InputFilter {
    private int a;

    public c(int i) {
        this.a = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i3, i4, charSequence.subSequence(i, i2).toString());
            if (Integer.parseInt(sb.toString()) <= this.a) {
                return null;
            }
            return Constants.STR_EMPTY;
        } catch (NumberFormatException unused) {
            return Constants.STR_EMPTY;
        }
    }
}
