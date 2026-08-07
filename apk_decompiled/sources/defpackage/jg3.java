package defpackage;

import android.content.Context;
import android.media.SoundPool;
import com.luck.picture.lib.R$raw;

/* JADX INFO: loaded from: classes3.dex */
public class jg3 {
    private static jg3 c;
    private SoundPool a;
    private int b;

    public static jg3 a() {
        if (c == null) {
            synchronized (jg3.class) {
                try {
                    if (c == null) {
                        c = new jg3();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    private void c(Context context) {
        if (this.a == null) {
            SoundPool soundPool = new SoundPool(1, 3, 0);
            this.a = soundPool;
            this.b = soundPool.load(context.getApplicationContext(), R$raw.picture_music, 1);
        }
    }

    public void b(Context context) {
        c(context);
    }

    public void d() {
        SoundPool soundPool = this.a;
        if (soundPool != null) {
            soundPool.play(this.b, 0.1f, 0.5f, 0, 1, 1.0f);
        }
    }

    public void e() {
        try {
            SoundPool soundPool = this.a;
            if (soundPool != null) {
                soundPool.release();
                this.a = null;
            }
            c = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
