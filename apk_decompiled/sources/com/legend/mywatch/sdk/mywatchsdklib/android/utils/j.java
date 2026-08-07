package com.legend.mywatch.sdk.mywatchsdklib.android.utils;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import defpackage.e43;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
final class j implements Application.ActivityLifecycleCallbacks {
    static final j g = new j();
    private static final Activity h = new Activity();
    private final LinkedList a = new LinkedList();
    private final List b = new CopyOnWriteArrayList();
    private final Map c = new ConcurrentHashMap();
    private int d = 0;
    private int e = 0;
    private boolean f = false;

    class a implements Runnable {
        final /* synthetic */ Activity a;
        final /* synthetic */ Object b;

        a(Activity activity, Object obj) {
            this.a = activity;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Window window = this.a.getWindow();
                if (window != null) {
                    window.setSoftInputMode(((Integer) this.b).intValue());
                }
            } catch (Exception unused) {
            }
        }
    }

    j() {
    }

    private void b(Activity activity, Lifecycle.Event event) {
        c(activity, event, (List) this.c.get(activity));
        c(activity, event, (List) this.c.get(h));
    }

    private void c(Activity activity, Lifecycle.Event event, List list) {
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            throw null;
        }
        if (event.equals(Lifecycle.Event.ON_DESTROY)) {
            this.c.remove(activity);
        }
    }

    private List d() {
        LinkedList linkedList = new LinkedList();
        Activity activity = null;
        try {
            Object objF = f();
            if (objF == null) {
                return linkedList;
            }
            Field declaredField = objF.getClass().getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objF);
            if (!(obj instanceof Map)) {
                return linkedList;
            }
            for (Object obj2 : ((Map) obj).values()) {
                Class<?> cls = obj2.getClass();
                Field declaredField2 = cls.getDeclaredField("activity");
                declaredField2.setAccessible(true);
                Activity activity2 = (Activity) declaredField2.get(obj2);
                if (activity == null) {
                    Field declaredField3 = cls.getDeclaredField("paused");
                    declaredField3.setAccessible(true);
                    if (declaredField3.getBoolean(obj2)) {
                        linkedList.addFirst(activity2);
                    } else {
                        activity = activity2;
                    }
                } else {
                    linkedList.addFirst(activity2);
                }
            }
        } catch (Exception e) {
            Log.e("UtilsActivityLifecycle", "getActivitiesByReflect: " + e.getMessage());
        }
        if (activity != null) {
            linkedList.addFirst(activity);
        }
        return linkedList;
    }

    private Object f() {
        Object objG = g();
        return objG != null ? objG : h();
    }

    private Object g() {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticField: " + e.getMessage());
            return null;
        }
    }

    private Object h() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", null).invoke(null, null);
        } catch (Exception e) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticMethod: " + e.getMessage());
            return null;
        }
    }

    private void m(Activity activity, boolean z) {
        if (this.b.isEmpty()) {
            return;
        }
        for (i.b bVar : this.b) {
            if (z) {
                bVar.a(activity);
            } else {
                bVar.b(activity);
            }
        }
    }

    private void n(Activity activity, boolean z) {
        try {
            if (z) {
                Window window = activity.getWindow();
                window.getDecorView().setTag(-123, Integer.valueOf(window.getAttributes().softInputMode));
                window.setSoftInputMode(3);
            } else {
                Object tag = activity.getWindow().getDecorView().getTag(-123);
                if (!(tag instanceof Integer)) {
                } else {
                    k.t(new a(activity, tag), 100L);
                }
            }
        } catch (Exception unused) {
        }
    }

    private static void o() {
        if (ValueAnimator.areAnimatorsEnabled()) {
            return;
        }
        try {
            Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
            declaredField.setAccessible(true);
            if (((Float) declaredField.get(null)).floatValue() == 0.0f) {
                declaredField.set(null, Float.valueOf(1.0f));
                Log.i("UtilsActivityLifecycle", "setAnimatorsEnabled: Animators are enabled now!");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    private void p(Activity activity) {
        if (!this.a.contains(activity)) {
            this.a.addFirst(activity);
        } else {
            if (((Activity) this.a.getFirst()).equals(activity)) {
                return;
            }
            this.a.remove(activity);
            this.a.addFirst(activity);
        }
    }

    void a(i.b bVar) {
        this.b.add(bVar);
    }

    List e() {
        if (!this.a.isEmpty()) {
            return new LinkedList(this.a);
        }
        this.a.addAll(d());
        return new LinkedList(this.a);
    }

    Application i() {
        Object objInvoke;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objF = f();
            if (objF == null || (objInvoke = cls.getMethod("getApplication", null).invoke(objF, null)) == null) {
                return null;
            }
            return (Application) objInvoke;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    Activity j() {
        for (Activity activity : e()) {
            if (k.l(activity)) {
                return activity;
            }
        }
        return null;
    }

    void k(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    boolean l() {
        return !this.f;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.a.size() == 0) {
            m(activity, true);
        }
        g.a(activity);
        o();
        p(activity);
        b(activity, Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        this.a.remove(activity);
        k.b(activity);
        b(activity, Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        b(activity, Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPrePaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreSaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        p(activity);
        if (this.f) {
            this.f = false;
            m(activity, true);
        }
        n(activity, false);
        b(activity, Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (!this.f) {
            p(activity);
        }
        int i = this.e;
        if (i < 0) {
            this.e = i + 1;
        } else {
            this.d++;
        }
        b(activity, Lifecycle.Event.ON_START);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.e--;
        } else {
            int i = this.d - 1;
            this.d = i;
            if (i <= 0) {
                this.f = true;
                m(activity, false);
            }
        }
        n(activity, true);
        b(activity, Lifecycle.Event.ON_STOP);
    }

    void q(Application application) {
        this.a.clear();
        application.unregisterActivityLifecycleCallbacks(this);
    }
}
