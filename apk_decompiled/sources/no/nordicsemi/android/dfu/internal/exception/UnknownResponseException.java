package no.nordicsemi.android.dfu.internal.exception;

import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.tencent.connect.common.Constants;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class UnknownResponseException extends Exception {
    private static final char[] HEX_ARRAY = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final long serialVersionUID = -8716125467309979289L;
    private final int mExpectedOpCode;
    private final int mExpectedReturnCode;
    private final byte[] mResponse;

    public UnknownResponseException(String str, byte[] bArr, int i, int i2) {
        super(str);
        this.mResponse = bArr == null ? new byte[0] : bArr;
        this.mExpectedReturnCode = i;
        this.mExpectedOpCode = i2;
    }

    public static String bytesToHex(byte[] bArr, int i, int i2) {
        if (bArr == null || bArr.length <= i || i2 <= 0) {
            return Constants.STR_EMPTY;
        }
        int iMin = Math.min(i2, bArr.length - i);
        char[] cArr = new char[iMin * 2];
        for (int i3 = 0; i3 < iMin; i3++) {
            byte b = bArr[i + i3];
            int i4 = i3 * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i4] = cArr2[(b & 255) >>> 4];
            cArr[i4 + 1] = cArr2[b & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS];
        }
        return "0x" + new String(cArr);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        Locale locale = Locale.US;
        String message = super.getMessage();
        byte[] bArr = this.mResponse;
        return String.format(locale, "%s (response: %s, expected: 0x%02X%02X..)", message, bytesToHex(bArr, 0, bArr.length), Integer.valueOf(this.mExpectedReturnCode), Integer.valueOf(this.mExpectedOpCode));
    }
}
