package defpackage;

import android.window.BackEvent;

/* JADX INFO: loaded from: classes.dex */
public final class u7 {
    public static final u7 a = new u7();

    private u7() {
    }

    public final BackEvent a(float f, float f2, float f3, int i) {
        return new BackEvent(f, f2, f3, i);
    }

    public final float b(BackEvent backEvent) {
        p31.f(backEvent, "backEvent");
        return backEvent.getProgress();
    }

    public final int c(BackEvent backEvent) {
        p31.f(backEvent, "backEvent");
        return backEvent.getSwipeEdge();
    }

    public final float d(BackEvent backEvent) {
        p31.f(backEvent, "backEvent");
        return backEvent.getTouchX();
    }

    public final float e(BackEvent backEvent) {
        p31.f(backEvent, "backEvent");
        return backEvent.getTouchY();
    }
}
