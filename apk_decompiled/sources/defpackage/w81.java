package defpackage;

import com.tencent.connect.common.Constants;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public interface w81 {
    public static final Charset a = Charset.forName(Constants.ENC_UTF_8);

    boolean equals(Object obj);

    int hashCode();

    void updateDiskCacheKey(MessageDigest messageDigest);
}
