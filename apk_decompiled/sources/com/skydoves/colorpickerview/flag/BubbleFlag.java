package com.skydoves.colorpickerview.flag;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.appcompat.widget.AppCompatImageView;
import com.skydoves.colorpickerview.R$id;
import com.skydoves.colorpickerview.R$layout;
import defpackage.d11;
import defpackage.gz;

/* JADX INFO: loaded from: classes.dex */
public class BubbleFlag extends FlagView {
    private AppCompatImageView c;

    public BubbleFlag(Context context) {
        super(context, R$layout.flag_bubble);
        this.c = (AppCompatImageView) findViewById(R$id.bubble);
    }

    @Override // com.skydoves.colorpickerview.flag.FlagView
    public void d(gz gzVar) {
        d11.c(this.c, ColorStateList.valueOf(gzVar.a()));
    }
}
