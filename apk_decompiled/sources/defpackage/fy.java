package defpackage;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes3.dex */
public abstract class fy {
    public static String a(int i) {
        if (i == 0) {
            return "LH728-Audio";
        }
        if (i != 1) {
            return i != 2 ? Constants.STR_EMPTY : "LH722-Audio";
        }
        return "WellAudio";
    }
}
