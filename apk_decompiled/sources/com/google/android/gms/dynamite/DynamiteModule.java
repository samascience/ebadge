package com.google.android.gms.dynamite;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import defpackage.st1;
import defpackage.tu3;
import java.lang.reflect.Field;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public abstract class DynamiteModule {
    private static final ThreadLocal g = new ThreadLocal();
    private static final ThreadLocal h = new com.google.android.gms.dynamite.a();
    private static final a.InterfaceC0082a i = new b();
    public static final a a = new c();
    public static final a b = new d();
    public static final a c = new e();
    public static final a d = new f();
    public static final a e = new g();
    public static final a f = new h();
    public static final a j = new i();

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {

        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, tu3 tu3Var) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, tu3 tu3Var) {
            super(str, th);
        }
    }

    public interface a {

        /* JADX INFO: renamed from: com.google.android.gms.dynamite.DynamiteModule$a$a, reason: collision with other inner class name */
        public interface InterfaceC0082a {
        }
    }

    public static int a(Context context, String str) {
        try {
            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (st1.a(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e2) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e2.getMessage())));
            return 0;
        }
    }
}
