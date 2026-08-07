package com.blankj.utilcode.util;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
final class p implements Application.ActivityLifecycleCallbacks {
    static final p g = new p();
    private static final Activity h = new Activity();
    private final LinkedList a = new LinkedList();
    private final List b = new CopyOnWriteArrayList();
    private final Map c = new ConcurrentHashMap();
    private int d = 0;
    private int e = 0;
    private boolean f = false;

    class a implements Runnable {
        final /* synthetic */ Activity a;
        final /* synthetic */ o.a b;

        a(Activity activity, o.a aVar) {
            this.a = activity;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.e(this.a, this.b);
        }
    }

    class b implements Runnable {
        final /* synthetic */ Activity a;
        final /* synthetic */ o.a b;

        b(Activity activity, o.a aVar) {
            this.a = activity;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.v(this.a, this.b);
        }
    }

    class c implements Runnable {
        final /* synthetic */ Activity a;
        final /* synthetic */ Object b;

        c(Activity activity, Object obj) {
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

    p() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Activity activity, o.a aVar) {
        List copyOnWriteArrayList = (List) this.c.get(activity);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.c.put(activity, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(aVar)) {
            return;
        }
        copyOnWriteArrayList.add(aVar);
    }

    private void g(Activity activity, Lifecycle.Event event) {
        h(activity, event, (List) this.c.get(activity));
        h(activity, event, (List) this.c.get(h));
    }

    private void h(Activity activity, Lifecycle.Event event, List list) {
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            o.a aVar = (o.a) it.next();
            aVar.g(activity, event);
            if (event.equals(Lifecycle.Event.ON_CREATE)) {
                aVar.a(activity);
            } else if (event.equals(Lifecycle.Event.ON_START)) {
                aVar.e(activity);
            } else if (event.equals(Lifecycle.Event.ON_RESUME)) {
                aVar.d(activity);
            } else if (event.equals(Lifecycle.Event.ON_PAUSE)) {
                aVar.c(activity);
            } else if (event.equals(Lifecycle.Event.ON_STOP)) {
                aVar.f(activity);
            } else if (event.equals(Lifecycle.Event.ON_DESTROY)) {
                aVar.b(activity);
            }
        }
        if (event.equals(Lifecycle.Event.ON_DESTROY)) {
            this.c.remove(activity);
        }
    }

    private List i() {
        LinkedList linkedList = new LinkedList();
        Activity activity = null;
        try {
            Object objK = k();
            if (objK == null) {
                return linkedList;
            }
            Field declaredField = objK.getClass().getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objK);
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

    private Object k() {
        Object objL = l();
        return objL != null ? objL : m();
    }

    private Object l() {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticField: " + e.getMessage());
            return null;
        }
    }

    private Object m() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", null).invoke(null, null);
        } catch (Exception e) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticMethod: " + e.getMessage());
            return null;
        }
    }

    private void r(Activity activity, boolean z) {
        if (this.b.isEmpty()) {
            return;
        }
        for (o.c cVar : this.b) {
            if (z) {
                cVar.a(activity);
            } else {
                cVar.b(activity);
            }
        }
    }

    private void s(Activity activity, boolean z) {
        try {
            if (z) {
                Window window = activity.getWindow();
                window.getDecorView().setTag(-123, Integer.valueOf(window.getAttributes().softInputMode));
                window.setSoftInputMode(3);
            } else {
                Object tag = activity.getWindow().getDecorView().getTag(-123);
                if (!(tag instanceof Integer)) {
                } else {
                    q.O(new c(activity, tag), 100L);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(Activity activity, o.a aVar) {
        List list = (List) this.c.get(activity);
        if (list == null || list.isEmpty()) {
            return;
        }
        list.remove(aVar);
    }

    private static void w() {
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

    private void x(Activity activity) {
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

    void c(Activity activity, o.a aVar) {
        if (activity == null || aVar == null) {
            return;
        }
        q.N(new a(activity, aVar));
    }

    void d(o.a aVar) {
        c(h, aVar);
    }

    void f(o.c cVar) {
        this.b.add(cVar);
    }

    List j() {
        if (!this.a.isEmpty()) {
            return new LinkedList(this.a);
        }
        this.a.addAll(i());
        return new LinkedList(this.a);
    }

    Application n() {
        Object objInvoke;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objK = k();
            if (objK == null || (objInvoke = cls.getMethod("getApplication", null).invoke(objK, null)) == null) {
                return null;
            }
            return (Application) objInvoke;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    Activity o() {
        for (Activity activity : j()) {
            if (q.A(activity)) {
                return activity;
            }
        }
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.a.size() == 0) {
            r(activity, true);
        }
        i.a(activity);
        w();
        x(activity);
        g(activity, Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        this.a.remove(activity);
        q.g(activity);
        g(activity, Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        g(activity, Lifecycle.Event.ON_PAUSE);
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
        x(activity);
        if (this.f) {
            this.f = false;
            r(activity, true);
        }
        s(activity, false);
        g(activity, Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (!this.f) {
            x(activity);
        }
        int i = this.e;
        if (i < 0) {
            this.e = i + 1;
        } else {
            this.d++;
        }
        g(activity, Lifecycle.Event.ON_START);
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
                r(activity, false);
            }
        }
        s(activity, true);
        g(activity, Lifecycle.Event.ON_STOP);
    }

    void p(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    boolean q() {
        return !this.f;
    }

    void t(Activity activity, o.a aVar) {
        if (activity == null || aVar == null) {
            return;
        }
        q.N(new b(activity, aVar));
    }

    void u(o.a aVar) {
        t(h, aVar);
    }

    void y(Application application) {
        this.a.clear();
        application.unregisterActivityLifecycleCallbacks(this);
    }
}
