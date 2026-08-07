package defpackage;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public abstract class gb1 {
    private static void a(Activity activity, boolean z, boolean z2) {
        if (z && z2) {
            activity.getWindow().getDecorView().setSystemUiVisibility(256);
            return;
        }
        if (!z && !z2) {
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
        } else {
            if (z || !z2) {
                return;
            }
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
        }
    }

    private static void b(Activity activity, boolean z, boolean z2, boolean z3, boolean z4) {
        try {
            if (z3) {
                Window window = activity.getWindow();
                if (z && z2) {
                    if (z4) {
                        window.getDecorView().setSystemUiVisibility(8448);
                    } else {
                        window.getDecorView().setSystemUiVisibility(256);
                    }
                } else if (z || z2) {
                    if (z || !z2) {
                        return;
                    }
                    if (z4) {
                        window.getDecorView().setSystemUiVisibility(9472);
                    } else {
                        window.getDecorView().setSystemUiVisibility(1280);
                    }
                } else if (z4) {
                    window.getDecorView().setSystemUiVisibility(9472);
                } else {
                    window.getDecorView().setSystemUiVisibility(1280);
                }
            } else {
                View decorView = activity.getWindow().getDecorView();
                if (z4) {
                    decorView.setSystemUiVisibility(8192);
                } else {
                    decorView.setSystemUiVisibility(0);
                }
            }
        } catch (Exception unused) {
        }
    }

    private static boolean c(Activity activity, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        if (activity == null) {
            return false;
        }
        a(activity, z, z2);
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt(null);
            int i2 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z4 ? i | i2 : (~i) & i2);
            activity.getWindow().setAttributes(attributes);
            try {
                if (ai2.a() >= 7) {
                    b(activity, z, z2, z3, z4);
                }
                return true;
            } catch (Exception unused) {
                z5 = true;
                b(activity, z, z2, z3, z4);
                return z5;
            }
        } catch (Exception unused2) {
        }
    }

    public static void d(Activity activity, boolean z, boolean z2, boolean z3, boolean z4) {
        int iB = ai2.b();
        if (iB == 1) {
            if (ai2.c() >= 7) {
                b(activity, z, z2, z3, z4);
                return;
            } else {
                e(activity, z, z2, z3, z4);
                return;
            }
        }
        if (iB == 2) {
            c(activity, z, z2, z3, z4);
        } else {
            if (iB != 3) {
                return;
            }
            b(activity, z, z2, z3, z4);
        }
    }

    private static boolean e(Activity activity, boolean z, boolean z2, boolean z3, boolean z4) {
        a(activity, z, z2);
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class cls3 = Integer.TYPE;
            cls.getMethod("setExtraFlags", cls3, cls3).invoke(activity.getWindow(), Integer.valueOf(z4 ? i : 0), Integer.valueOf(i));
            return true;
        } catch (Exception unused) {
            b(activity, z, z2, z3, z4);
            return false;
        }
    }
}
