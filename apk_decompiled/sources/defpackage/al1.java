package defpackage;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public abstract class al1 {
    public static boolean a(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
