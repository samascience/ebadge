package defpackage;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.LruCache;
import com.luck.picture.lib.io.BufferedInputStreamWrap;
import java.io.InputStream;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public class w9 {
    private static final w9 d = new w9();
    private final HashSet a = new HashSet();
    private final LruCache b = new LruCache(20);
    private final xe1 c = new xe1(4194304);

    public static w9 c() {
        return d;
    }

    private BufferedInputStreamWrap f(ContentResolver contentResolver, Uri uri) {
        BufferedInputStreamWrap bufferedInputStreamWrap = null;
        try {
            BufferedInputStreamWrap bufferedInputStreamWrap2 = new BufferedInputStreamWrap(contentResolver.openInputStream(uri));
            try {
                int iAvailable = bufferedInputStreamWrap2.available();
                if (iAvailable <= 0) {
                    iAvailable = 5242880;
                }
                bufferedInputStreamWrap2.mark(iAvailable);
                this.b.put(uri.toString(), bufferedInputStreamWrap2);
                this.a.add(uri.toString());
                return bufferedInputStreamWrap2;
            } catch (Exception e) {
                e = e;
                bufferedInputStreamWrap = bufferedInputStreamWrap2;
                e.printStackTrace();
                return bufferedInputStreamWrap;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void a() {
        for (String str : this.a) {
            s12.a((BufferedInputStreamWrap) this.b.get(str));
            this.b.remove(str);
        }
        this.a.clear();
        this.c.a();
    }

    public byte[] b(int i) {
        return (byte[]) this.c.e(i, byte[].class);
    }

    public InputStream d(ContentResolver contentResolver, Uri uri) {
        try {
            BufferedInputStreamWrap bufferedInputStreamWrapF = (BufferedInputStreamWrap) this.b.get(uri.toString());
            if (bufferedInputStreamWrapF != null) {
                bufferedInputStreamWrapF.reset();
            } else {
                bufferedInputStreamWrapF = f(contentResolver, uri);
            }
            return bufferedInputStreamWrapF;
        } catch (Exception unused) {
            return f(contentResolver, uri);
        }
    }

    public void e(byte[] bArr) {
        this.c.n(bArr);
    }
}
