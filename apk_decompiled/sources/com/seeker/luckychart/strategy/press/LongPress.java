package com.seeker.luckychart.strategy.press;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public interface LongPress {
    void finish(MotionEvent motionEvent);

    void longPressed(MotionEvent motionEvent);
}
