package defpackage;

import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ei0 {
    public static void a(Object obj) {
        EventBus.getDefault().register(obj);
    }

    public static void b(Object obj) {
        EventBus.getDefault().unregister(obj);
    }
}
