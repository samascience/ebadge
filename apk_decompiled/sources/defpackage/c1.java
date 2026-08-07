package defpackage;

/* JADX INFO: loaded from: classes.dex */
abstract class c1 {
    static final byte[] a = new byte[128];

    static {
        char c = 0;
        while (true) {
            byte[] bArr = a;
            if (c >= bArr.length) {
                break;
            }
            bArr[c] = -1;
            c = (char) (c + 1);
        }
        for (char c2 = '0'; c2 <= '9'; c2 = (char) (c2 + 1)) {
            a[c2] = (byte) (c2 - '0');
        }
        for (char c3 = 'A'; c3 <= 'F'; c3 = (char) (c3 + 1)) {
            a[c3] = (byte) (c3 - '7');
        }
        for (char c4 = 'a'; c4 <= 'f'; c4 = (char) (c4 + 1)) {
            a[c4] = (byte) (c4 - 'W');
        }
        for (char c5 = '.'; c5 <= '.'; c5 = (char) (c5 + 1)) {
            a[c5] = -4;
        }
    }

    c1() {
    }
}
