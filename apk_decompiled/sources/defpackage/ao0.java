package defpackage;

import android.util.JsonReader;

/* JADX INFO: loaded from: classes.dex */
public class ao0 implements eb3 {
    public static final ao0 a = new ao0();

    private ao0() {
    }

    @Override // defpackage.eb3
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Float a(JsonReader jsonReader, float f) {
        return Float.valueOf(s71.g(jsonReader) * f);
    }
}
