package defpackage;

import android.util.Log;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    private static final String a = "g";

    public static String a(String str, String str2) {
        byte[] bArrB = b(e(str), str2);
        if (bArrB == null || bArrB.length == 0) {
            return null;
        }
        return d(bArrB);
    }

    public static byte[] b(byte[] bArr, String str) {
        try {
            if (str == null) {
                Log.e(a, "decrypt: Key is empty null");
                return null;
            }
            if (str.length() != 32) {
                Log.e(a, "decrypt: Key length is not 16 bits");
                return null;
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(e(str), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(2, secretKeySpec);
            try {
                return cipher.doFinal(bArr);
            } catch (Exception e) {
                Log.e(a, "decrypt: " + e);
                return null;
            }
        } catch (InvalidKeyException e2) {
            e = e2;
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            e.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e4) {
            e = e4;
            e.printStackTrace();
            return null;
        }
    }

    public static String c(String str, String str2) {
        try {
            if (str2.length() != 32) {
                return null;
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(e(str2), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(1, secretKeySpec);
            return d(cipher.doFinal(e(str)));
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String d(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static byte[] e(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) * 16) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
        }
        return bArr;
    }
}
