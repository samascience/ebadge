package xfkj.fitpro.utils.qrcode.zxing;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 xfkj.fitpro.utils.qrcode.zxing.ErrorCorrectionLevel, still in use, count: 1, list:
  (r0v0 xfkj.fitpro.utils.qrcode.zxing.ErrorCorrectionLevel) from 0x002e: FILLED_NEW_ARRAY 
  (r1v1 xfkj.fitpro.utils.qrcode.zxing.ErrorCorrectionLevel)
  (r0v0 xfkj.fitpro.utils.qrcode.zxing.ErrorCorrectionLevel)
  (r3v2 xfkj.fitpro.utils.qrcode.zxing.ErrorCorrectionLevel)
  (r2v1 xfkj.fitpro.utils.qrcode.zxing.ErrorCorrectionLevel)
 A[WRAPPED] elemType: xfkj.fitpro.utils.qrcode.zxing.ErrorCorrectionLevel
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes4.dex */
public final class ErrorCorrectionLevel {
    L(1),
    M(0),
    Q(3),
    H(2);

    private static final ErrorCorrectionLevel[] FOR_BITS;
    private final int bits;

    static {
        FOR_BITS = new ErrorCorrectionLevel[]{errorCorrectionLevel, new ErrorCorrectionLevel(1), errorCorrectionLevel, new ErrorCorrectionLevel(3)};
    }

    private ErrorCorrectionLevel(int i) {
        super(str, i);
        this.bits = i;
    }

    public static ErrorCorrectionLevel forBits(int i) {
        if (i >= 0) {
            ErrorCorrectionLevel[] errorCorrectionLevelArr = FOR_BITS;
            if (i < errorCorrectionLevelArr.length) {
                return errorCorrectionLevelArr[i];
            }
        }
        throw new IllegalArgumentException();
    }

    public static ErrorCorrectionLevel valueOf(String str) {
        return (ErrorCorrectionLevel) Enum.valueOf(ErrorCorrectionLevel.class, str);
    }

    public static ErrorCorrectionLevel[] values() {
        return (ErrorCorrectionLevel[]) $VALUES.clone();
    }

    public int getBits() {
        return this.bits;
    }
}
