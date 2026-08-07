package defpackage;

import com.alibaba.dashscope.exception.ApiException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: classes.dex */
public abstract class qh0 {
    private static final Integer a = 256;

    public static String a(String str, SecretKey secretKey, byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, secretKey, new GCMParameterSpec(128, bArr));
            return new String(cipher.doFinal(Base64.getDecoder().decode(str)), StandardCharsets.UTF_8);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            throw new ApiException(e);
        }
    }

    public static String b(String str, SecretKey secretKey, byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKey, new GCMParameterSpec(128, bArr));
            return Base64.getEncoder().encodeToString(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)));
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            throw new ApiException(e);
        }
    }

    public static String c(String str, String str2) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(str2))));
            return Base64.getEncoder().encodeToString(cipher.doFinal(str.getBytes()));
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            throw new ApiException(e);
        }
    }

    public static nh0 d(String str) {
        new ph0().b(str);
        new SecureRandom().nextBytes(new byte[12]);
        nh0.a();
        throw null;
    }
}
