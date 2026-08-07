package com.legend.mywatch.sdk.mywatchsdklib.android.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import defpackage.q30;
import defpackage.zz1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class PermissionUtils {
    private static PermissionUtils h;
    private static b i;
    private static b j;
    static final String[] k = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    private String[] a;
    private b b;
    private Set c;
    private List d;
    private List e;
    private List f;
    private List g;

    static final class PermissionActivityImpl extends UtilsTransActivity.TransActivityDelegate {
        private static PermissionActivityImpl INSTANCE = new PermissionActivityImpl();
        private static final String TYPE = "TYPE";
        private static final int TYPE_DRAW_OVERLAYS = 3;
        private static final int TYPE_RUNTIME = 1;
        private static final int TYPE_WRITE_SETTINGS = 2;
        private static int currentRequestCode = -1;

        class a implements i.a {
            final /* synthetic */ int a;

            a(int i) {
                this.a = i;
            }

            @Override // com.legend.mywatch.sdk.mywatchsdklib.android.utils.i.a
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
                this.a.requestPermissions((String[]) PermissionUtils.h.d.toArray(new String[0]), 1);
            }
        }

        PermissionActivityImpl() {
        }

        private void checkRequestCallback(int i) {
            if (i == 2) {
                if (PermissionUtils.i == null) {
                    return;
                }
                if (PermissionUtils.x()) {
                    PermissionUtils.i.onGranted();
                } else {
                    PermissionUtils.i.onDenied();
                }
                PermissionUtils.i = null;
                return;
            }
            if (i != 3 || PermissionUtils.j == null) {
                return;
            }
            if (PermissionUtils.w()) {
                PermissionUtils.j.onGranted();
            } else {
                PermissionUtils.j.onDenied();
            }
            PermissionUtils.j = null;
        }

        private void requestPermissions(UtilsTransActivity utilsTransActivity) {
            if (PermissionUtils.h.D(utilsTransActivity, new b(utilsTransActivity))) {
                return;
            }
            utilsTransActivity.requestPermissions((String[]) PermissionUtils.h.d.toArray(new String[0]), 1);
        }

        public static void start(int i) {
            UtilsTransActivity.H(new a(i), INSTANCE);
        }

        @Override // com.legend.mywatch.sdk.mywatchsdklib.android.utils.UtilsTransActivity.TransActivityDelegate
        public boolean dispatchTouchEvent(UtilsTransActivity utilsTransActivity, MotionEvent motionEvent) {
            utilsTransActivity.finish();
            return true;
        }

        @Override // com.legend.mywatch.sdk.mywatchsdklib.android.utils.UtilsTransActivity.TransActivityDelegate
        public void onActivityResult(UtilsTransActivity utilsTransActivity, int i, int i2, Intent intent) {
            utilsTransActivity.finish();
        }

        @Override // com.legend.mywatch.sdk.mywatchsdklib.android.utils.UtilsTransActivity.TransActivityDelegate
        public void onCreated(UtilsTransActivity utilsTransActivity, Bundle bundle) {
            utilsTransActivity.getWindow().addFlags(262160);
            int intExtra = utilsTransActivity.getIntent().getIntExtra(TYPE, -1);
            if (intExtra != 1) {
                if (intExtra == 2) {
                    currentRequestCode = 2;
                    PermissionUtils.G(utilsTransActivity, 2);
                    return;
                } else if (intExtra == 3) {
                    currentRequestCode = 3;
                    PermissionUtils.E(utilsTransActivity, 3);
                    return;
                } else {
                    utilsTransActivity.finish();
                    Log.e("PermissionUtils", "type is wrong.");
                    return;
                }
            }
            if (PermissionUtils.h == null) {
                Log.e("PermissionUtils", "sInstance is null.");
                utilsTransActivity.finish();
                return;
            }
            if (PermissionUtils.h.d == null) {
                Log.e("PermissionUtils", "mPermissionsRequest is null.");
                utilsTransActivity.finish();
            } else if (PermissionUtils.h.d.size() <= 0) {
                Log.e("PermissionUtils", "mPermissionsRequest's size is no more than 0.");
                utilsTransActivity.finish();
            } else {
                PermissionUtils.c(PermissionUtils.h);
                PermissionUtils.a(PermissionUtils.h);
                requestPermissions(utilsTransActivity);
            }
        }

        @Override // com.legend.mywatch.sdk.mywatchsdklib.android.utils.UtilsTransActivity.TransActivityDelegate
        public void onDestroy(UtilsTransActivity utilsTransActivity) {
            int i = currentRequestCode;
            if (i != -1) {
                checkRequestCallback(i);
                currentRequestCode = -1;
            }
            super.onDestroy(utilsTransActivity);
        }

        @Override // com.legend.mywatch.sdk.mywatchsdklib.android.utils.UtilsTransActivity.TransActivityDelegate
        public void onRequestPermissionsResult(UtilsTransActivity utilsTransActivity, int i, String[] strArr, int[] iArr) {
            utilsTransActivity.finish();
            if (PermissionUtils.h == null || PermissionUtils.h.d == null) {
                return;
            }
            PermissionUtils.h.z(utilsTransActivity);
        }
    }

    public interface a {
    }

    public interface b {
        void onDenied();

        void onGranted();
    }

    public interface c {
    }

    private PermissionUtils(String... strArr) {
        this.a = strArr;
        h = this;
    }

    public static PermissionUtils A(String... strArr) {
        return new PermissionUtils(strArr);
    }

    private void C() {
        if (this.b != null) {
            if (this.f.isEmpty()) {
                this.b.onGranted();
            } else {
                this.b.onDenied();
            }
            this.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D(UtilsTransActivity utilsTransActivity, Runnable runnable) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void E(Activity activity, int i2) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + i.a().getPackageName()));
        if (k.o(intent)) {
            activity.startActivityForResult(intent, i2);
        } else {
            y();
        }
    }

    private void F() {
        PermissionActivityImpl.start(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(Activity activity, int i2) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + i.a().getPackageName()));
        if (k.o(intent)) {
            activity.startActivityForResult(intent, i2);
        } else {
            y();
        }
    }

    static /* bridge */ /* synthetic */ a a(PermissionUtils permissionUtils) {
        permissionUtils.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ c c(PermissionUtils permissionUtils) {
        permissionUtils.getClass();
        return null;
    }

    public static List n() {
        return o(i.a().getPackageName());
    }

    public static List o(String str) {
        try {
            String[] strArr = i.a().getPackageManager().getPackageInfo(str, 4096).requestedPermissions;
            return strArr == null ? Collections.emptyList() : Arrays.asList(strArr);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private void p(Activity activity) {
        for (String str : this.d) {
            if (u(str)) {
                this.e.add(str);
            } else {
                this.f.add(str);
                if (!activity.shouldShowRequestPermissionRationale(str)) {
                    this.g.add(str);
                }
            }
        }
    }

    private static Pair q(String... strArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List listN = n();
        for (String str : strArr) {
            boolean z = false;
            for (String str2 : zz1.a(str)) {
                if (listN.contains(str2)) {
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

    public static boolean r() {
        return !t() || s("android.permission.BLUETOOTH_CONNECT");
    }

    public static boolean s(String str) {
        return u(str);
    }

    public static boolean t() {
        return Build.VERSION.SDK_INT >= 31;
    }

    private static boolean u(String str) {
        return q30.a(i.a(), str) == 0;
    }

    public static boolean v(String... strArr) {
        Pair pairQ = q(strArr);
        if (!((List) pairQ.second).isEmpty()) {
            return false;
        }
        Iterator it = ((List) pairQ.first).iterator();
        while (it.hasNext()) {
            if (!u((String) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean w() {
        return Settings.canDrawOverlays(i.a());
    }

    public static boolean x() {
        return Settings.System.canWrite(i.a());
    }

    public static void y() {
        Intent intentG = k.g(i.a().getPackageName(), true);
        if (k.o(intentG)) {
            i.a().startActivity(intentG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Activity activity) {
        p(activity);
        C();
    }

    public void B() {
        String[] strArr = this.a;
        if (strArr == null || strArr.length <= 0) {
            Log.w("PermissionUtils", "No permissions to request.");
            return;
        }
        this.c = new LinkedHashSet();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        Pair pairQ = q(this.a);
        this.c.addAll((Collection) pairQ.first);
        this.f.addAll((Collection) pairQ.second);
        for (String str : this.c) {
            if (u(str)) {
                this.e.add(str);
            } else {
                this.d.add(str);
            }
        }
        if (this.d.isEmpty()) {
            C();
        } else {
            F();
        }
    }

    public PermissionUtils m(b bVar) {
        this.b = bVar;
        return this;
    }
}
