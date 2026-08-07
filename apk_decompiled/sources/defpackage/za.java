package defpackage;

import android.util.Log;
import com.arthenica.ffmpegkit.FFmpegKitConfig;

/* JADX INFO: loaded from: classes.dex */
public class za implements Runnable {
    private final yj0 a;
    private final zj0 b;

    public za(yj0 yj0Var) {
        this.a = yj0Var;
        this.b = yj0Var.x();
    }

    @Override // java.lang.Runnable
    public void run() {
        FFmpegKitConfig.f(this.a);
        zj0 zj0Var = this.b;
        if (zj0Var != null) {
            try {
                zj0Var.a(this.a);
            } catch (Exception e) {
                Log.e("ffmpeg-kit", String.format("Exception thrown inside session complete callback.%s", mi0.a(e)));
            }
        }
        zj0 zj0VarH = FFmpegKitConfig.h();
        if (zj0VarH != null) {
            try {
                zj0VarH.a(this.a);
            } catch (Exception e2) {
                Log.e("ffmpeg-kit", String.format("Exception thrown inside global complete callback.%s", mi0.a(e2)));
            }
        }
    }
}
