package cn.bertsir.zbar.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import defpackage.a02;
import defpackage.q30;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class PermissionUtils {
    private static List h;
    private static PermissionUtils i;
    private static Context j;
    private c a;
    private b b;
    private Set c = new LinkedHashSet();
    private List d;
    private List e;
    private List f;
    private List g;

    public static class PermissionActivity extends Activity {
        public static void a(Context context) {
            Intent intent = new Intent(context, (Class<?>) PermissionActivity.class);
            intent.addFlags(268435456);
            context.startActivity(intent);
        }

        @Override // android.app.Activity, android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            finish();
            return true;
        }

        @Override // android.app.Activity
        protected void onCreate(Bundle bundle) {
            getWindow().addFlags(262160);
            getWindow().setStatusBarColor(0);
            if (PermissionUtils.i == null) {
                super.onCreate(bundle);
                Log.e("PermissionUtils", "request permissions failed");
                finish();
                return;
            }
            PermissionUtils.d(PermissionUtils.i);
            super.onCreate(bundle);
            if (PermissionUtils.i.p(this)) {
                finish();
                return;
            }
            if (PermissionUtils.i.d != null) {
                int size = PermissionUtils.i.d.size();
                if (size <= 0) {
                    finish();
                } else {
                    requestPermissions((String[]) PermissionUtils.i.d.toArray(new String[size]), 1);
                }
            }
        }

        @Override // android.app.Activity
        public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            PermissionUtils.i.m(this);
            finish();
        }
    }

    class a implements c.a {
        a() {
        }

        @Override // cn.bertsir.zbar.utils.PermissionUtils.c.a
        public void a(boolean z) {
            if (z) {
                PermissionUtils.this.s();
            } else {
                PermissionUtils.this.r();
            }
        }
    }

    public interface b {
        void a(List list);

        void b(List list, List list2);
    }

    public interface c {

        public interface a {
            void a(boolean z);
        }

        void a(a aVar);
    }

    public interface d {
    }

    private PermissionUtils(String... strArr) {
        for (String str : strArr) {
            for (String str2 : a02.a(str)) {
                if (h.contains(str2)) {
                    this.c.add(str2);
                }
            }
        }
        i = this;
    }

    static /* synthetic */ d d(PermissionUtils permissionUtils) {
        permissionUtils.getClass();
        return null;
    }

    public static List i() {
        return j(j.getPackageName());
    }

    public static List j(String str) {
        try {
            return Arrays.asList(j.getPackageManager().getPackageInfo(str, 4096).requestedPermissions);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private void k(Activity activity) {
        for (String str : this.d) {
            if (l(str)) {
                this.e.add(str);
            } else {
                this.f.add(str);
                if (!activity.shouldShowRequestPermissionRationale(str)) {
                    this.g.add(str);
                }
            }
        }
    }

    private static boolean l(String str) {
        return q30.a(j, str) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Activity activity) {
        k(activity);
        r();
    }

    public static PermissionUtils n(Context context, String... strArr) {
        j = context;
        h = i();
        return new PermissionUtils(strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p(Activity activity) {
        boolean z = false;
        if (this.a != null) {
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                if (activity.shouldShowRequestPermissionRationale((String) it.next())) {
                    k(activity);
                    this.a.a(new a());
                    z = true;
                    break;
                }
            }
            this.a = null;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.b != null) {
            if (this.d.size() == 0 || this.c.size() == this.e.size()) {
                this.b.a(this.e);
            } else if (!this.f.isEmpty()) {
                this.b.b(this.g, this.f);
            }
            this.b = null;
        }
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.f = new ArrayList();
        this.g = new ArrayList();
        PermissionActivity.a(j);
    }

    public PermissionUtils h(b bVar) {
        this.b = bVar;
        return this;
    }

    public PermissionUtils o(c cVar) {
        this.a = cVar;
        return this;
    }

    public void q() {
        this.e = new ArrayList();
        this.d = new ArrayList();
        for (String str : this.c) {
            if (l(str)) {
                this.e.add(str);
            } else {
                this.d.add(str);
            }
        }
        if (this.d.isEmpty()) {
            r();
        } else {
            s();
        }
    }
}
