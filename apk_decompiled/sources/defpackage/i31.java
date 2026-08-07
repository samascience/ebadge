package defpackage;

import android.util.JsonReader;

/* JADX INFO: loaded from: classes.dex */
public class i31 implements eb3 {
    public static final i31 a = new i31();

    private i31() {
    }

    @Override // defpackage.eb3
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(JsonReader jsonReader, float f) {
        return Integer.valueOf(Math.round(s71.g(jsonReader) * f));
    }
}
