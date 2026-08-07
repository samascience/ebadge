package kotlin.io.encoding;

import defpackage.vh0;
import kotlin.enums.a;

/* JADX INFO: loaded from: classes4.dex */
public enum Base64$PaddingOption {
    PRESENT,
    ABSENT,
    PRESENT_OPTIONAL,
    ABSENT_OPTIONAL;

    private static final /* synthetic */ vh0 $ENTRIES = a.a(values());

    public static vh0 getEntries() {
        return $ENTRIES;
    }
}
