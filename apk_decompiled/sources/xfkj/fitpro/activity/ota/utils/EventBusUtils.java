package xfkj.fitpro.activity.ota.utils;

import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes4.dex */
public class EventBusUtils {
    public static void post(Object obj) {
        EventBus.getDefault().post(obj);
    }

    public static void register(Object obj) {
        EventBus.getDefault().register(obj);
    }

    public static void unregister(Object obj) {
        EventBus.getDefault().unregister(obj);
    }
}
