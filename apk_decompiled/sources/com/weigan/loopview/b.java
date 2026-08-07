package com.weigan.loopview;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes3.dex */
final class b extends GestureDetector.SimpleOnGestureListener {
    final LoopView a;

    b(LoopView loopView) {
        this.a = loopView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.a.h(f2);
        return true;
    }
}
