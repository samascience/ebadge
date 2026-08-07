package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public abstract class pa1 {
    public static String a(int i) {
        switch (i) {
            case 258:
                return "INVALID STATE";
            case 259:
                return "NOT SUPPORTED";
            case 260:
                return "DATA SIZE EXCEEDS LIMIT";
            case 261:
                return "INVALID CRC ERROR";
            case 262:
                return "OPERATION FAILED";
            default:
                return "UNKNOWN (" + i + ")";
        }
    }
}
