package defpackage;

import java.lang.ref.WeakReference;
import java.util.TimerTask;
import xfkj.fitpro.ui.activities.device.electronicBadgeDevice.VideoCutActivity;

/* JADX INFO: loaded from: classes4.dex */
public class j33 extends TimerTask {
    private WeakReference a;

    public j33(VideoCutActivity videoCutActivity) {
        this.a = new WeakReference(videoCutActivity);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        WeakReference weakReference = this.a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        ((VideoCutActivity) this.a.get()).D0();
    }
}
