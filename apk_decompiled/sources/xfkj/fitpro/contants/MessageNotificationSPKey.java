package xfkj.fitpro.contants;

import defpackage.vh0;
import kotlin.enums.a;

/* JADX INFO: loaded from: classes4.dex */
public enum MessageNotificationSPKey {
    OTHER_MESSAGE_NOTIFICATION("OtherMessageState");

    private static final /* synthetic */ vh0 $ENTRIES = a.a(values());
    private final String spKey;

    MessageNotificationSPKey(String str) {
        this.spKey = str;
    }

    public static vh0 getEntries() {
        return $ENTRIES;
    }

    public final String getSpKey() {
        return this.spKey;
    }
}
