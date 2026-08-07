package com.tenmeter.smlibrary.banner.transformer;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BasePageTransformer implements ViewPager2.k {
    public static final float DEFAULT_CENTER = 0.5f;

    @Override // androidx.viewpager2.widget.ViewPager2.k
    public abstract /* synthetic */ void transformPage(View view, float f);
}
