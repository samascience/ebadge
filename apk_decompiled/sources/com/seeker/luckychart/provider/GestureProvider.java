package com.seeker.luckychart.provider;

import com.seeker.luckychart.strategy.doubletab.DoubleTap;
import com.seeker.luckychart.strategy.press.LongPress;
import com.seeker.luckychart.strategy.scale.Scaler;
import com.seeker.luckychart.strategy.scroll.Scroller;

/* JADX INFO: loaded from: classes.dex */
public interface GestureProvider {
    DoubleTap getDoubleTab();

    LongPress getLongpresser();

    Scaler getScaler();

    Scroller getScrollImpl();
}
