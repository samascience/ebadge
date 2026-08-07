package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import defpackage.q30;
import defpackage.yz1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class PermissionUtils {
    private static PermissionUtils i;
    private static b j;
    private static b k;
    private String[] a;
    private c b;
    private b c;
    private Set d;
    private List e;
    private List f;
    private List g;
    private List h;

    static final class PermissionActivityImpl extends UtilsTransActivity.TransActivityDelegate {
        private static PermissionActivityImpl INSTANCE = new PermissionActivityImpl();
        private static final String TYPE = "TYPE";
        private static final int TYPE_DRAW_OVERLAYS = 3;
        private static final int TYPE_RUNTIME = 1;
        private static final int TYPE_WRITE_SETTINGS = 2;
        private static int currentRequestCode = -1;

        class a implements o.b {
            final /* synthetic */ int a;

            a(int i) {
                this.a = i;
            }

            @Override // com.blankj.utilcode.util.o.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Intent intent) {
                intent.putExtra(PermissionActivityImpl.TYPE, this.a);
            }
        }

        class b implements Runnable {
            final /* synthetic */ UtilsTransActivity a;

            b(UtilsTransActivity utilsTransActivity) {
                this.a = utilsTransActivity;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.requestPermissions((String[]) PermissionUtils.i.e.toArray(new String[0]), 1);
            }
        }

        PermissionActivityImpl() {
        }

        private void checkRequestCallback(int i) {
            if (i == 2) {
                if (PermissionUtils.j == null) {
                    return;
                }
                if (PermissionUtils.v()) {
                    PermissionUtils.j.onGranted();
                } else {
                    PermissionUtils.j.onDenied();
                }
                b unused = PermissionUtils.j = null;
                return;
            }
            if (i != 3 || PermissionUtils.k == null) {
                return;
            }
            if (PermissionUtils.u()) {
                PermissionUtils.k.onGranted();
            } else {
                PermissionUtils.k.onDenied();
            }
            b unused2 = PermissionUtils.k = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void requestPermissions(UtilsTransActivity utilsTransActivity) {
            if (PermissionUtils.i.B(utilsTransActivity, new b(utilsTransActivity))) {
                return;
            }
            utilsTransActivity.requestPermissions((String[]) PermissionUtils.i.e.toArray(new String[0]), 1);
        }

        public static void start(int i) {
            UtilsTransActivity.H(new a(i), INSTANCE);
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public boolean dispatchTouchEvent(UtilsTransActivity utilsTransActivity, MotionEvent motionEvent) {
            utilsTransActivity.finish();
            return true;
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onActivityResult(UtilsTransActivity utilsTransActivity, int i, int i2, Intent intent) {
            utilsTransActivity.finish();
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onCreated(UtilsTransActivity utilsTransActivity, Bundle bundle) {
            utilsTransActivity.getWindow().addFlags(262160);
            int intExtra = utilsTransActivity.getIntent().getIntExtra(TYPE, -1);
            if (intExtra != 1) {
                if (intExtra == 2) {
                    currentRequestCode = 2;
                    PermissionUtils.E(utilsTransActivity, 2);
                    return;
                } else if (intExtra == 3) {
                    currentRequestCode = 3;
                    PermissionUtils.C(utilsTransActivity, 3);
                    return;
                } else {
                    utilsTransActivity.finish();
                    Log.e("PermissionUtils", "type is wrong.");
                    return;
                }
            }
            if (PermissionUtils.i == null) {
                Log.e("PermissionUtils", "sInstance is null.");
                utilsTransActivity.finish();
                return;
            }
            if (PermissionUtils.i.e == null) {
                Log.e("PermissionUtils", "mPermissionsRequest is null.");
                utilsTransActivity.finish();
            } else if (PermissionUtils.i.e.size() <= 0) {
                Log.e("PermissionUtils", "mPermissionsRequest's size is no more than 0.");
                utilsTransActivity.finish();
            } else {
                PermissionUtils.i(PermissionUtils.i);
                PermissionUtils.j(PermissionUtils.i);
                requestPermissions(utilsTransActivity);
            }
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onDestroy(UtilsTransActivity utilsTransActivity) {
            int i = currentRequestCode;
            if (i != -1) {
                checkRequestCallback(i);
                currentRequestCode = -1;
            }
            super.onDestroy(utilsTransActivity);
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onRequestPermissionsResult(UtilsTransActivity utilsTransActivity, int i, String[] strArr, int[] iArr) {
            utilsTransActivity.finish();
            if (PermissionUtils.i == null || PermissionUtils.i.e == null) {
                return;
            }
            PermissionUtils.i.x(utilsTransActivity);
        }
    }

    public interface a {
    }

    public interface b {
        void onDenied();

        void onGranted();
    }

    public interface c {
        void a(boolean z, List list, List list2, List list3);
    }

    public interface d {
    }

    private PermissionUtils(String... strArr) {
        this.a = strArr;
        i = this;
    }

    private void A() {
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(this.g.isEmpty(), this.f, this.h, this.g);
            this.b = null;
        }
        if (this.c != null) {
            if (this.g.isEmpty()) {
                this.c.onGranted();
            } else {
                this.c.onDenied();
            }
            this.c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B(UtilsTransActivity utilsTransActivity, Runnable runnable) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void C(Activity activity, int i2) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + o.a().getPackageName()));
        if (q.E(intent)) {
            activity.startActivityForResult(intent, i2);
        } else {
            w();
        }
    }

    private void D() {
        PermissionActivityImpl.start(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void E(Activity activity, int i2) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + o.a().getPackageName()));
        if (q.E(intent)) {
            activity.startActivityForResult(intent, i2);
        } else {
            w();
        }
    }

    static /* synthetic */ d i(PermissionUtils permissionUtils) {
        permissionUtils.getClass();
        return null;
    }

    static /* synthetic */ a j(PermissionUtils permissionUtils) {
        permissionUtils.getClass();
        return null;
    }

    public static List o() {
        return p(o.a().getPackageName());
    }

    public static List p(String str) {
        try {
            String[] strArr = o.a().getPackageManager().getPackageInfo(str, 4096).requestedPermissions;
            return strArr == null ? Collections.emptyList() : Arrays.asList(strArr);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private void q(Activity activity) {
        for (String str : this.e) {
            if (s(str)) {
                this.f.add(str);
            } else {
                this.g.add(str);
                if (!activity.shouldShowRequestPermissionRationale(str)) {
                    this.h.add(str);
                }
            }
        }
    }

    private static Pair r(String... strArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List listO = o();
        for (String str : strArr) {
            boolean z = false;
            for (String str2 : yz1.a(str)) {
                if (listO.contains(str2)) {
                    arrayList.add(str2);
                    z = true;
                }
            }
            if (!z) {
                arrayList2.add(str);
                Log.e("PermissionUtils", "U should add the permission of " + str + " in manifest.");
            }
        }
        return Pair.create(arrayList, arrayList2);
    }

    private static boolean s(String str) {
        return q30.a(o.a(), str) == 0;
    }

    public static boolean t(String... strArr) {
        Pair pairR = r(strArr);
        if (!((List) pairR.second).isEmpty()) {
            return false;
        }
        Iterator it = ((List) pairR.first).iterator();
        while (it.hasNext()) {
            if (!s((String) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean u() {
        return Settings.canDrawOverlays(o.a());
    }

    public static boolean v() {
        return Settings.System.canWrite(o.a());
    }

    public static void w() {
        Intent intentQ = q.q(o.a().getPackageName(), true);
        if (q.E(intentQ)) {
            o.a().startActivity(intentQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Activity activity) {
        q(activity);
        A();
    }

    public static PermissionUtils y(String... strArr) {
        return new PermissionUtils(strArr);
    }

    public PermissionUtils m(b bVar) {
        this.c = bVar;
        return this;
    }

    public PermissionUtils n(c cVar) {
        this.b = cVar;
        return this;
    }

    public void z() {
        String[] strArr = this.a;
        if (strArr == null || strArr.length <= 0) {
            Log.w("PermissionUtils", "No permissions to request.");
            return;
        }
        this.d = new LinkedHashSet();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        Pair pairR = r(this.a);
        this.d.addAll((Collection) pairR.first);
        this.g.addAll((Collection) pairR.second);
        for (String str : this.d) {
            if (s(str)) {
                this.f.add(str);
            } else {
                this.e.add(str);
            }
        }
        if (this.e.isEmpty()) {
            A();
        } else {
            D();
        }
    }
}
