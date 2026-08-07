package defpackage;

import android.os.Build;

/* JADX INFO: loaded from: classes4.dex */
final class pz2 implements uc2.b {
    pz2() {
    }

    @Override // uc2.b
    public String a(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    @Override // uc2.b
    public String b(String str) {
        return str.substring(3, str.length() - 3);
    }

    @Override // uc2.b
    public String[] c() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            return strArr;
        }
        String str = Build.CPU_ABI2;
        return !g23.a(str) ? new String[]{Build.CPU_ABI, str} : new String[]{Build.CPU_ABI};
    }

    @Override // uc2.b
    public void d(String str) {
        System.load(str);
    }

    @Override // uc2.b
    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }
}
