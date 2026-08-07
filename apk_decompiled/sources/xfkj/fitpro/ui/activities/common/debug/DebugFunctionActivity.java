package xfkj.fitpro.ui.activities.common.debug;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.View;
import com.blankj.utilcode.util.ToastUtils;
import com.legend.smartwatch.app.base.acitivity.BaseActivity;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.dn0;
import defpackage.h3;
import defpackage.lv2;
import defpackage.ng;
import defpackage.p31;
import defpackage.t9;
import defpackage.y70;
import defpackage.y93;
import defpackage.zi2;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.collections.b0;
import kotlin.collections.j;
import kotlin.text.i;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import xfkj.fitpro.manager.WatchThemeTransferManager;
import xfkj.fitpro.ui.activities.common.debug.DebugFunctionActivity;

/* JADX INFO: loaded from: classes4.dex */
public final class DebugFunctionActivity extends BaseActivity<h3> {
    public static final a p = new a(null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Set f395q = b0.f("jpg", "jpeg", "png", "gif", "bmp", "webp");
    private boolean k;
    private boolean l;
    private final Handler m;
    private Runnable n;
    private y93 o;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements WatchThemeTransferManager.c {
        final /* synthetic */ File b;

        b(File file) {
            this.b = file;
        }

        @Override // xfkj.fitpro.manager.WatchThemeTransferManager.c
        public void a(String str) {
            p31.f(str, "errorMessage");
            DebugFunctionActivity.this.l = false;
            DebugFunctionActivity.a0(DebugFunctionActivity.this).F.setEnabled(true);
            y93 y93Var = DebugFunctionActivity.this.o;
            if (y93Var == null) {
                p31.t("uploadProgressUi");
                y93Var = null;
            }
            y93Var.h(str);
            DebugFunctionActivity.this.o0("推送失败: " + str, true);
            ToastUtils.v("推送失败: " + str, new Object[0]);
            Log.e(DebugFunctionActivity.this.K(), "图片推送失败: " + str);
        }

        @Override // xfkj.fitpro.manager.WatchThemeTransferManager.c
        public void b() {
            DebugFunctionActivity.this.l = false;
            DebugFunctionActivity.a0(DebugFunctionActivity.this).F.setEnabled(true);
            y93 y93Var = DebugFunctionActivity.this.o;
            if (y93Var == null) {
                p31.t("uploadProgressUi");
                y93Var = null;
            }
            y93Var.i();
            DebugFunctionActivity.this.o0("推送成功\n文件: " + this.b.getName() + "\n路径: " + this.b.getAbsolutePath(), false);
            ToastUtils.v("图片推送成功", new Object[0]);
            Log.d(DebugFunctionActivity.this.K(), "图片推送成功: " + this.b.getAbsolutePath());
        }

        @Override // xfkj.fitpro.manager.WatchThemeTransferManager.c
        public void c() {
            y93 y93Var = DebugFunctionActivity.this.o;
            if (y93Var == null) {
                p31.t("uploadProgressUi");
                y93Var = null;
            }
            String string = DebugFunctionActivity.this.getString(R.string.preparing_for_upload);
            p31.e(string, "getString(...)");
            y93Var.g(string, 0);
        }

        @Override // xfkj.fitpro.manager.WatchThemeTransferManager.c
        public void d(int i) {
            y93 y93Var = DebugFunctionActivity.this.o;
            if (y93Var == null) {
                p31.t("uploadProgressUi");
                y93Var = null;
            }
            y93Var.j(i, DebugFunctionActivity.this.getString(R.string.upload_progress, Integer.valueOf(i)));
        }
    }

    public DebugFunctionActivity() {
        super(R.layout.activity_debug_function);
        this.m = new Handler(Looper.getMainLooper());
    }

    public static final /* synthetic */ h3 a0(DebugFunctionActivity debugFunctionActivity) {
        return (h3) debugFunctionActivity.I();
    }

    private final File f0() {
        File[] fileArrListFiles;
        File file = new File("/storage/emulated/0/Android/data/com.legend.superband.watch/files/testPicture");
        Object next = null;
        if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : fileArrListFiles) {
            if (file2.isFile()) {
                p31.c(file2);
                if (l0(file2)) {
                    arrayList.add(file2);
                }
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long jLastModified = ((File) next).lastModified();
                do {
                    Object next2 = it.next();
                    long jLastModified2 = ((File) next2).lastModified();
                    if (jLastModified < jLastModified2) {
                        next = next2;
                        jLastModified = jLastModified2;
                    }
                } while (it.hasNext());
            }
        }
        return (File) next;
    }

    private final String g0(long j) {
        if (j >= 1073741824) {
            lv2 lv2Var = lv2.a;
            String str = String.format("%.2f GB", Arrays.copyOf(new Object[]{Double.valueOf(j / 1.073741824E9d)}, 1));
            p31.e(str, "format(...)");
            return str;
        }
        if (j >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            lv2 lv2Var2 = lv2.a;
            String str2 = String.format("%.2f MB", Arrays.copyOf(new Object[]{Double.valueOf(j / 1048576.0d)}, 1));
            p31.e(str2, "format(...)");
            return str2;
        }
        if (j >= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            lv2 lv2Var3 = lv2.a;
            String str3 = String.format("%.2f KB", Arrays.copyOf(new Object[]{Double.valueOf(j / 1024.0d)}, 1));
            p31.e(str3, "format(...)");
            return str3;
        }
        return j + " B";
    }

    private final void h0() {
        if (!zi2.i()) {
            ToastUtils.v("设备未连接，请先连接设备", new Object[0]);
            p0("错误: 设备未连接", true);
            return;
        }
        try {
            byte[] bArrJ = zi2.j();
            if (bArrJ != null && bArrJ.length != 0) {
                zi2.e().K(bArrJ, "获取表盘剩余空间");
                this.k = true;
                p0("正在获取表盘剩余空间...", false);
                ((h3) I()).z.setEnabled(false);
                Runnable runnable = new Runnable() { // from class: g70
                    @Override // java.lang.Runnable
                    public final void run() {
                        DebugFunctionActivity.i0(this.a);
                    }
                };
                this.n = runnable;
                Handler handler = this.m;
                p31.c(runnable);
                handler.postDelayed(runnable, 5000L);
                Log.d(K(), "已发送获取表盘剩余空间命令");
                return;
            }
            ToastUtils.v("获取命令失败", new Object[0]);
            p0("错误: 获取命令失败", true);
        } catch (Exception e) {
            Log.e(K(), "获取表盘剩余空间失败: " + e.getMessage(), e);
            ToastUtils.v("获取失败: " + e.getMessage(), new Object[0]);
            p0("错误: " + e.getMessage(), true);
            this.k = false;
            ((h3) I()).z.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(DebugFunctionActivity debugFunctionActivity) {
        if (debugFunctionActivity.k) {
            debugFunctionActivity.k = false;
            debugFunctionActivity.p0("错误: 获取超时，请重试", true);
            ((h3) debugFunctionActivity.I()).z.setEnabled(true);
            ToastUtils.v("获取超时", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(DebugFunctionActivity debugFunctionActivity, View view) {
        debugFunctionActivity.h0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(DebugFunctionActivity debugFunctionActivity, View view) {
        debugFunctionActivity.m0();
    }

    private final boolean l0(File file) {
        String lowerCase = dn0.b(file).toLowerCase(Locale.ROOT);
        p31.e(lowerCase, "toLowerCase(...)");
        return f395q.contains(lowerCase);
    }

    private final void m0() {
        if (this.l) {
            return;
        }
        if (!zi2.i()) {
            ToastUtils.v("设备未连接，请先连接设备", new Object[0]);
            o0("错误: 设备未连接", true);
            return;
        }
        File fileF0 = f0();
        if (fileF0 == null) {
            ToastUtils.v("未找到可推送的图片", new Object[0]);
            o0("错误: 未找到图片\n搜索目录:\n/storage/emulated/0/Android/data/com.legend.superband.watch/files/testPicture", true);
            return;
        }
        this.l = true;
        ((h3) I()).F.setEnabled(false);
        o0("正在推送: " + fileF0.getName() + "\n路径: " + fileF0.getAbsolutePath(), false);
        WatchThemeTransferManager watchThemeTransferManagerA = WatchThemeTransferManager.g.a();
        String absolutePath = fileF0.getAbsolutePath();
        p31.e(absolutePath, "getAbsolutePath(...)");
        watchThemeTransferManagerA.V(this, absolutePath, new b(fileF0));
    }

    private final Long n0(ng ngVar) {
        try {
            Class<?> cls = ngVar.getClass();
            List<String> listM = j.m("remainSpace", "remain", "space", "freeSpace", "dialRemainSpace", "watchRemainSpace", "remainingSpace", "value", "data", "size", "free");
            Iterator it = listM.iterator();
            while (it.hasNext()) {
                try {
                    Field declaredField = cls.getDeclaredField((String) it.next());
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(ngVar);
                    if (obj instanceof Long) {
                        return (Long) obj;
                    }
                    if (obj instanceof Integer) {
                        return Long.valueOf(((Number) obj).intValue());
                    }
                    if (obj instanceof Short) {
                        return Long.valueOf(((Number) obj).shortValue());
                    }
                    if (obj instanceof Byte) {
                        return Long.valueOf(((Number) obj).byteValue());
                    }
                    if (obj instanceof Number) {
                        return Long.valueOf(((Number) obj).longValue());
                    }
                } catch (NoSuchFieldException unused) {
                }
            }
            for (String string : listM) {
                try {
                    if (string.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        char cCharAt = string.charAt(0);
                        sb.append((Object) (Character.isLowerCase(cCharAt) ? kotlin.text.a.e(cCharAt) : String.valueOf(cCharAt)));
                        String strSubstring = string.substring(1);
                        p31.e(strSubstring, "substring(...)");
                        sb.append(strSubstring);
                        string = sb.toString();
                    }
                    Object objInvoke = cls.getMethod("get" + string, null).invoke(ngVar, null);
                    if (objInvoke instanceof Long) {
                        return (Long) objInvoke;
                    }
                    if (objInvoke instanceof Integer) {
                        return Long.valueOf(((Number) objInvoke).intValue());
                    }
                    if (objInvoke instanceof Short) {
                        return Long.valueOf(((Number) objInvoke).shortValue());
                    }
                    if (objInvoke instanceof Byte) {
                        return Long.valueOf(((Number) objInvoke).byteValue());
                    }
                    if (objInvoke instanceof Number) {
                        return Long.valueOf(((Number) objInvoke).longValue());
                    }
                } catch (Exception unused2) {
                }
            }
            String simpleName = cls.getSimpleName();
            p31.e(simpleName, "getSimpleName(...)");
            String lowerCase = simpleName.toLowerCase(Locale.ROOT);
            p31.e(lowerCase, "toLowerCase(...)");
            if (i.M(lowerCase, "remain", false, 2, null) || i.M(lowerCase, "space", false, 2, null) || i.M(lowerCase, "dial", false, 2, null) || i.M(lowerCase, "watch", false, 2, null)) {
                Iterator itA = t9.a(cls.getDeclaredFields());
                while (itA.hasNext()) {
                    Field field = (Field) itA.next();
                    try {
                        field.setAccessible(true);
                        Object obj2 = field.get(ngVar);
                        if (obj2 instanceof Long) {
                            if (((Number) obj2).longValue() > 0 && ((Number) obj2).longValue() < 9007199254740991L) {
                                return (Long) obj2;
                            }
                        } else if ((obj2 instanceof Integer) && ((Number) obj2).intValue() > 0) {
                            return Long.valueOf(((Number) obj2).intValue());
                        }
                    } catch (Exception unused3) {
                    }
                }
            }
        } catch (Exception e) {
            Log.e(K(), "解析剩余空间失败: " + e.getMessage(), e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(String str, boolean z) {
        if (Q()) {
            ((h3) I()).G.setText(str);
            if (z) {
                ((h3) I()).G.setTextColor(getColor(R.color.red));
            } else {
                ((h3) I()).G.setTextColor(getColor(R.color.black));
            }
        }
    }

    private final void p0(String str, boolean z) {
        if (Q()) {
            ((h3) I()).H.setText(str);
            if (z) {
                ((h3) I()).H.setTextColor(getColor(R.color.red));
            } else {
                ((h3) I()).H.setTextColor(getColor(R.color.black));
            }
        }
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initData(Bundle bundle) {
        this.o = new y93(this);
        p0("等待获取...", false);
        o0("等待推送...", false);
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initListener() {
        ((h3) I()).z.setOnClickListener(new View.OnClickListener() { // from class: e70
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DebugFunctionActivity.j0(this.a, view);
            }
        });
        ((h3) I()).F.setOnClickListener(new View.OnClickListener() { // from class: f70
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DebugFunctionActivity.k0(this.a, view);
            }
        });
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Runnable runnable = this.n;
        if (runnable != null) {
            this.m.removeCallbacks(runnable);
        }
        y93 y93Var = this.o;
        if (y93Var == null) {
            p31.t("uploadProgressUi");
            y93Var = null;
        }
        y93Var.d();
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onDialRemainSpaceEvent(ng ngVar) {
        if (ngVar == null || !this.k) {
            return;
        }
        Log.d(K(), "收到事件: " + ngVar.getClass().getSimpleName());
        Long lN0 = n0(ngVar);
        if (lN0 != null) {
            Runnable runnable = this.n;
            if (runnable != null) {
                this.m.removeCallbacks(runnable);
            }
            this.k = false;
            ((h3) I()).z.setEnabled(true);
            String strG0 = g0(lN0.longValue());
            p0("剩余表盘空间: " + strG0, false);
            ToastUtils.v("获取成功: " + strG0, new Object[0]);
            Log.d(K(), "表盘剩余空间: " + strG0);
        }
    }
}
