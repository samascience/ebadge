package com.tenmeter.smlibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes3.dex */
public class SmWebView extends WebView {
    public SmWebView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public SmWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SmWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SmWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
