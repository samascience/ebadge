package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.e0;
import com.google.android.material.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public class TabItem extends View {
    public final CharSequence a;
    public final Drawable b;
    public final int c;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e0 e0VarU = e0.u(context, attributeSet, R$styleable.TabItem);
        this.a = e0VarU.p(R$styleable.TabItem_android_text);
        this.b = e0VarU.g(R$styleable.TabItem_android_icon);
        this.c = e0VarU.n(R$styleable.TabItem_android_layout, 0);
        e0VarU.x();
    }
}
