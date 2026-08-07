package com.tenmeter.smlibrary.banner.indicator;

import android.view.View;
import com.tenmeter.smlibrary.banner.config.IndicatorConfig;
import com.tenmeter.smlibrary.banner.listener.OnPageChangeListener;

/* JADX INFO: loaded from: classes3.dex */
public interface Indicator extends OnPageChangeListener {
    IndicatorConfig getIndicatorConfig();

    View getIndicatorView();

    void onPageChanged(int i, int i2);
}
