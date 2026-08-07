package xfkj.fitpro.ui.activities.debug.model;

import android.R;
import defpackage.vh0;
import kotlin.enums.a;

/* JADX INFO: loaded from: classes4.dex */
public enum LogType {
    SEND("发送", R.color.holo_blue_light),
    RECEIVE("接收", R.color.holo_green_light),
    ERROR("错误", R.color.holo_red_light),
    INFO("信息", R.color.holo_orange_light),
    DEBUG("调试", R.color.darker_gray);

    private static final /* synthetic */ vh0 $ENTRIES = a.a(values());
    private final int colorRes;
    private final String displayName;

    LogType(String str, int i) {
        this.displayName = str;
        this.colorRes = i;
    }

    public static vh0 getEntries() {
        return $ENTRIES;
    }

    public final int getColorRes() {
        return this.colorRes;
    }

    public final String getDisplayName() {
        return this.displayName;
    }
}
