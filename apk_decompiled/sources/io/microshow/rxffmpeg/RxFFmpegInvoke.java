package io.microshow.rxffmpeg;

/* JADX INFO: loaded from: classes4.dex */
public class RxFFmpegInvoke {
    private static volatile RxFFmpegInvoke a;

    static {
        System.loadLibrary("rxffmpeg-core");
        System.loadLibrary("rxffmpeg-invoke");
    }

    private RxFFmpegInvoke() {
    }

    public static RxFFmpegInvoke a() {
        if (a == null) {
            synchronized (RxFFmpegInvoke.class) {
                try {
                    if (a == null) {
                        a = new RxFFmpegInvoke();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public native void setDebug(boolean z);
}
