package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.d;

/* JADX INFO: loaded from: classes4.dex */
public final class FastServiceLoaderKt {
    private static final boolean ANDROID_DETECTED = false;

    static {
        Object objM69constructorimpl;
        try {
            Result.a aVar = Result.Companion;
            objM69constructorimpl = Result.m69constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            objM69constructorimpl = Result.m69constructorimpl(d.a(th));
        }
        Result.m76isSuccessimpl(objM69constructorimpl);
    }

    public static final boolean getANDROID_DETECTED() {
        return true;
    }
}
