package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

/* JADX INFO: loaded from: classes4.dex */
public final class AiAccessNative {
    public static final AiAccessNative a = new AiAccessNative();

    static {
        System.loadLibrary("bmp-lib");
    }

    private AiAccessNative() {
    }

    public static final native String decryptToRawPlaintextNative(String str, String str2);
}
