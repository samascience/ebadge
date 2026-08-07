package defpackage;

import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes4.dex */
public abstract class di0 {
    public static void a(Object obj) {
        EventBus.getDefault().post(obj);
    }

    public static void b(Object obj) {
        EventBus.getDefault().register(obj);
    }

    public static void c(Object obj) {
        EventBus.getDefault().unregister(obj);
    }
}
