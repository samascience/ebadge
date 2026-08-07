package defpackage;

import android.util.Base64;
import com.baidu.location.Jni;
import com.tencent.connect.common.Constants;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class mq3 {
    private boolean a;
    private String[] b;

    private static class a {
        private static mq3 a = new mq3();
    }

    private mq3() {
        this.a = false;
        this.b = null;
        try {
            String strH = Jni.h();
            if (strH == null || !strH.contains("|")) {
                return;
            }
            String[] strArrSplit = strH.split("\\|");
            this.b = strArrSplit;
            if (strArrSplit == null || strArrSplit.length != 2) {
                return;
            }
            this.a = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static mq3 b() {
        return a.a;
    }

    public synchronized String a(String str) {
        if (this.a) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(this.b[1].getBytes(Constants.ENC_UTF_8));
                SecretKeySpec secretKeySpec = new SecretKeySpec(this.b[0].getBytes(Constants.ENC_UTF_8), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public synchronized String c(String str) {
        if (!this.a) {
            return null;
        }
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(this.b[1].getBytes(Constants.ENC_UTF_8));
            SecretKeySpec secretKeySpec = new SecretKeySpec(this.b[0].getBytes(Constants.ENC_UTF_8), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(Base64.decode(str, 0)), Constants.ENC_UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean d() {
        return this.a;
    }
}
