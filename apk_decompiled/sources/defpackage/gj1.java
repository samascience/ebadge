package defpackage;

import android.os.Handler;
import android.os.Message;
import com.contrarywind.view.WheelView;

/* JADX INFO: loaded from: classes.dex */
public final class gj1 extends Handler {
    private final WheelView a;

    public gj1(WheelView wheelView) {
        this.a = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1000) {
            this.a.invalidate();
        } else if (i == 2000) {
            this.a.r(WheelView.ACTION.FLING);
        } else {
            if (i != 3000) {
                return;
            }
            this.a.m();
        }
    }
}
