package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import defpackage.jf2;
import defpackage.na3;
import defpackage.u9;
import defpackage.va1;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h implements Handler.Callback {
    private static final b j = new a();
    private volatile com.bumptech.glide.f a;
    private final Handler d;
    private final b e;
    private final g i;
    final Map b = new HashMap();
    final Map c = new HashMap();
    private final u9 f = new u9();
    private final u9 g = new u9();
    private final Bundle h = new Bundle();

    class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.manager.h.b
        public com.bumptech.glide.f a(com.bumptech.glide.a aVar, va1 va1Var, jf2 jf2Var, Context context) {
            return new com.bumptech.glide.f(aVar, va1Var, jf2Var, context);
        }
    }

    public interface b {
        com.bumptech.glide.f a(com.bumptech.glide.a aVar, va1 va1Var, jf2 jf2Var, Context context);
    }

    public h(b bVar, com.bumptech.glide.d dVar) {
        this.e = bVar == null ? j : bVar;
        this.d = new Handler(Looper.getMainLooper(), this);
        this.i = b(dVar);
    }

    private static void a(Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    private static g b(com.bumptech.glide.d dVar) {
        if (com.bumptech.glide.load.resource.bitmap.b.h && com.bumptech.glide.load.resource.bitmap.b.g) {
            return dVar.a(com.bumptech.glide.b.d.class) ? new e() : new f();
        }
        return new c();
    }

    private static Activity c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private com.bumptech.glide.f d(Context context, FragmentManager fragmentManager, Fragment fragment, boolean z) {
        RequestManagerFragment requestManagerFragmentJ = j(fragmentManager, fragment);
        com.bumptech.glide.f fVarE = requestManagerFragmentJ.e();
        if (fVarE == null) {
            fVarE = this.e.a(com.bumptech.glide.a.c(context), requestManagerFragmentJ.c(), requestManagerFragmentJ.f(), context);
            if (z) {
                fVarE.onStart();
            }
            requestManagerFragmentJ.k(fVarE);
        }
        return fVarE;
    }

    private com.bumptech.glide.f h(Context context) {
        if (this.a == null) {
            synchronized (this) {
                try {
                    if (this.a == null) {
                        this.a = this.e.a(com.bumptech.glide.a.c(context.getApplicationContext()), new com.bumptech.glide.manager.b(), new d(), context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.a;
    }

    private RequestManagerFragment j(FragmentManager fragmentManager, Fragment fragment) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (requestManagerFragment != null) {
            return requestManagerFragment;
        }
        RequestManagerFragment requestManagerFragment2 = (RequestManagerFragment) this.b.get(fragmentManager);
        if (requestManagerFragment2 != null) {
            return requestManagerFragment2;
        }
        RequestManagerFragment requestManagerFragment3 = new RequestManagerFragment();
        requestManagerFragment3.j(fragment);
        this.b.put(fragmentManager, requestManagerFragment3);
        fragmentManager.beginTransaction().add(requestManagerFragment3, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.d.obtainMessage(1, fragmentManager).sendToTarget();
        return requestManagerFragment3;
    }

    private SupportRequestManagerFragment l(androidx.fragment.app.FragmentManager fragmentManager, androidx.fragment.app.Fragment fragment) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.j0("com.bumptech.glide.manager");
        if (supportRequestManagerFragment != null) {
            return supportRequestManagerFragment;
        }
        SupportRequestManagerFragment supportRequestManagerFragment2 = (SupportRequestManagerFragment) this.c.get(fragmentManager);
        if (supportRequestManagerFragment2 != null) {
            return supportRequestManagerFragment2;
        }
        SupportRequestManagerFragment supportRequestManagerFragment3 = new SupportRequestManagerFragment();
        supportRequestManagerFragment3.F(fragment);
        this.c.put(fragmentManager, supportRequestManagerFragment3);
        fragmentManager.p().d(supportRequestManagerFragment3, "com.bumptech.glide.manager").i();
        this.d.obtainMessage(2, fragmentManager).sendToTarget();
        return supportRequestManagerFragment3;
    }

    private static boolean m(Context context) {
        Activity activityC = c(context);
        return activityC == null || !activityC.isFinishing();
    }

    private com.bumptech.glide.f n(Context context, androidx.fragment.app.FragmentManager fragmentManager, androidx.fragment.app.Fragment fragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragmentL = l(fragmentManager, fragment);
        com.bumptech.glide.f fVarZ = supportRequestManagerFragmentL.z();
        if (fVarZ == null) {
            fVarZ = this.e.a(com.bumptech.glide.a.c(context), supportRequestManagerFragmentL.x(), supportRequestManagerFragmentL.A(), context);
            if (z) {
                fVarZ.onStart();
            }
            supportRequestManagerFragmentL.G(fVarZ);
        }
        return fVarZ;
    }

    public com.bumptech.glide.f e(Activity activity) {
        if (na3.p()) {
            return f(activity.getApplicationContext());
        }
        if (activity instanceof FragmentActivity) {
            return g((FragmentActivity) activity);
        }
        a(activity);
        this.i.a(activity);
        return d(activity, activity.getFragmentManager(), null, m(activity));
    }

    public com.bumptech.glide.f f(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (na3.q() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return g((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return e((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return f(contextWrapper.getBaseContext());
                }
            }
        }
        return h(context);
    }

    public com.bumptech.glide.f g(FragmentActivity fragmentActivity) {
        if (na3.p()) {
            return f(fragmentActivity.getApplicationContext());
        }
        a(fragmentActivity);
        this.i.a(fragmentActivity);
        return n(fragmentActivity, fragmentActivity.getSupportFragmentManager(), null, m(fragmentActivity));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Object objRemove;
        Object obj2;
        Object obj3;
        int i = message.what;
        boolean z = true;
        if (i != 1) {
            if (i != 2) {
                obj3 = null;
                z = false;
                obj2 = null;
            } else {
                obj = (androidx.fragment.app.FragmentManager) message.obj;
                objRemove = this.c.remove(obj);
            }
            if (z && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
            }
            return z;
        }
        obj = (FragmentManager) message.obj;
        objRemove = this.b.remove(obj);
        Object obj4 = objRemove;
        obj2 = obj;
        obj3 = obj4;
        if (z) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z;
    }

    RequestManagerFragment i(Activity activity) {
        return j(activity.getFragmentManager(), null);
    }

    SupportRequestManagerFragment k(androidx.fragment.app.FragmentManager fragmentManager) {
        return l(fragmentManager, null);
    }
}
