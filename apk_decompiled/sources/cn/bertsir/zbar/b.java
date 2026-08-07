package cn.bertsir.zbar;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import cn.bertsir.zbar.Qr.ScanResult;
import cn.bertsir.zbar.utils.PermissionUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static b c;
    private QrConfig a;
    public c b;

    class a implements PermissionUtils.b {
        final /* synthetic */ Activity a;

        a(Activity activity) {
            this.a = activity;
        }

        @Override // cn.bertsir.zbar.utils.PermissionUtils.b
        public void a(List list) {
            Intent intent = new Intent(this.a, (Class<?>) QRActivity.class);
            intent.putExtra(QrConfig.EXTRA_THIS_CONFIG, b.this.a);
            this.a.startActivity(intent);
        }

        @Override // cn.bertsir.zbar.utils.PermissionUtils.b
        public void b(List list, List list2) {
            Toast.makeText(this.a, "摄像头权限被拒绝！", 0).show();
        }
    }

    /* JADX INFO: renamed from: cn.bertsir.zbar.b$b, reason: collision with other inner class name */
    class C0049b implements PermissionUtils.c {
        C0049b() {
        }

        @Override // cn.bertsir.zbar.utils.PermissionUtils.c
        public void a(PermissionUtils.c.a aVar) {
            aVar.a(true);
        }
    }

    public interface c {
        void a(ScanResult scanResult);
    }

    public static synchronized b b() {
        try {
            if (c == null) {
                c = new b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return c;
    }

    public c c() {
        return this.b;
    }

    public b d(QrConfig qrConfig) {
        this.a = qrConfig;
        return this;
    }

    public void e(Activity activity, c cVar) {
        if (this.a == null) {
            this.a = new QrConfig.a().a();
        }
        PermissionUtils.n(activity, "android.permission-group.CAMERA").o(new C0049b()).h(new a(activity)).q();
        this.b = cVar;
    }
}
