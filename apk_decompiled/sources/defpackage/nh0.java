package defpackage;

import java.util.Arrays;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes.dex */
public abstract class nh0 {

    public static abstract class b {
        private String a;
        private String b;
        private SecretKey c;
        private byte[] d;

        public String toString() {
            return "EncryptionConfig.EncryptionConfigBuilder(publicKeyId=" + this.a + ", base64PublicKey=" + this.b + ", AESEncryptKey=" + this.c + ", iv$value=" + Arrays.toString(this.d) + ")";
        }
    }

    private static final class c extends b {
        private c() {
        }
    }

    public static b a() {
        return new c();
    }

    public abstract SecretKey b();

    public abstract String c();

    public abstract byte[] d();

    public abstract String e();
}
