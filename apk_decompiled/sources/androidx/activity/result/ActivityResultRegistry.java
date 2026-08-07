package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.f;
import defpackage.a4;
import defpackage.b4;
import defpackage.db1;
import defpackage.f4;
import defpackage.s3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityResultRegistry {
    private final Map a = new HashMap();
    final Map b = new HashMap();
    private final Map c = new HashMap();
    ArrayList d = new ArrayList();
    final transient Map e = new HashMap();
    final Map f = new HashMap();
    final Bundle g = new Bundle();

    class a extends f4 {
        final /* synthetic */ String a;
        final /* synthetic */ b4 b;

        a(String str, b4 b4Var) {
            this.a = str;
            this.b = b4Var;
        }

        @Override // defpackage.f4
        public void b(Object obj, s3 s3Var) throws Exception {
            Integer num = (Integer) ActivityResultRegistry.this.b.get(this.a);
            if (num != null) {
                ActivityResultRegistry.this.d.add(this.a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.b, obj, s3Var);
                    return;
                } catch (Exception e) {
                    ActivityResultRegistry.this.d.remove(this.a);
                    throw e;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // defpackage.f4
        public void c() {
            ActivityResultRegistry.this.l(this.a);
        }
    }

    class b extends f4 {
        final /* synthetic */ String a;
        final /* synthetic */ b4 b;

        b(String str, b4 b4Var) {
            this.a = str;
            this.b = b4Var;
        }

        @Override // defpackage.f4
        public void b(Object obj, s3 s3Var) throws Exception {
            Integer num = (Integer) ActivityResultRegistry.this.b.get(this.a);
            if (num != null) {
                ActivityResultRegistry.this.d.add(this.a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.b, obj, s3Var);
                    return;
                } catch (Exception e) {
                    ActivityResultRegistry.this.d.remove(this.a);
                    throw e;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // defpackage.f4
        public void c() {
            ActivityResultRegistry.this.l(this.a);
        }
    }

    private static class c {
        final a4 a;
        final b4 b;

        c(a4 a4Var, b4 b4Var) {
            this.a = a4Var;
            this.b = b4Var;
        }
    }

    private static class d {
        final Lifecycle a;
        private final ArrayList b = new ArrayList();

        d(Lifecycle lifecycle) {
            this.a = lifecycle;
        }

        void a(f fVar) {
            this.a.a(fVar);
            this.b.add(fVar);
        }

        void b() {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                this.a.d((f) it.next());
            }
            this.b.clear();
        }
    }

    private void a(int i, String str) {
        this.a.put(Integer.valueOf(i), str);
        this.b.put(str, Integer.valueOf(i));
    }

    private void d(String str, int i, Intent intent, c cVar) {
        if (cVar == null || cVar.a == null || !this.d.contains(str)) {
            this.f.remove(str);
            this.g.putParcelable(str, new ActivityResult(i, intent));
        } else {
            cVar.a.a(cVar.b.c(i, intent));
            this.d.remove(str);
        }
    }

    private int e() {
        int iNextInt = Random.Default.nextInt(2147418112);
        while (true) {
            int i = iNextInt + 65536;
            if (!this.a.containsKey(Integer.valueOf(i))) {
                return i;
            }
            iNextInt = Random.Default.nextInt(2147418112);
        }
    }

    private void k(String str) {
        if (((Integer) this.b.get(str)) != null) {
            return;
        }
        a(e(), str);
    }

    public final boolean b(int i, int i2, Intent intent) {
        String str = (String) this.a.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        d(str, i2, intent, (c) this.e.get(str));
        return true;
    }

    public final boolean c(int i, Object obj) {
        a4 a4Var;
        String str = (String) this.a.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        c cVar = (c) this.e.get(str);
        if (cVar == null || (a4Var = cVar.a) == null) {
            this.g.remove(str);
            this.f.put(str, obj);
            return true;
        }
        if (!this.d.remove(str)) {
            return true;
        }
        a4Var.a(obj);
        return true;
    }

    public abstract void f(int i, b4 b4Var, Object obj, s3 s3Var);

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.d = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.g.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i = 0; i < stringArrayList.size(); i++) {
            String str = stringArrayList.get(i);
            if (this.b.containsKey(str)) {
                Integer num = (Integer) this.b.remove(str);
                if (!this.g.containsKey(str)) {
                    this.a.remove(num);
                }
            }
            a(integerArrayList.get(i).intValue(), stringArrayList.get(i));
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.g.clone());
    }

    public final f4 i(String str, b4 b4Var, a4 a4Var) {
        k(str);
        this.e.put(str, new c(a4Var, b4Var));
        if (this.f.containsKey(str)) {
            Object obj = this.f.get(str);
            this.f.remove(str);
            a4Var.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.g.getParcelable(str);
        if (activityResult != null) {
            this.g.remove(str);
            a4Var.a(b4Var.c(activityResult.b(), activityResult.a()));
        }
        return new b(str, b4Var);
    }

    public final f4 j(final String str, db1 db1Var, final b4 b4Var, final a4 a4Var) {
        Lifecycle lifecycle = db1Var.getLifecycle();
        if (lifecycle.b().isAtLeast(Lifecycle.State.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + db1Var + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
        }
        k(str);
        d dVar = (d) this.c.get(str);
        if (dVar == null) {
            dVar = new d(lifecycle);
        }
        dVar.a(new f() { // from class: androidx.activity.result.ActivityResultRegistry.1
            @Override // androidx.lifecycle.f
            public void c(db1 db1Var2, Lifecycle.Event event) {
                if (!Lifecycle.Event.ON_START.equals(event)) {
                    if (Lifecycle.Event.ON_STOP.equals(event)) {
                        ActivityResultRegistry.this.e.remove(str);
                        return;
                    } else {
                        if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                            ActivityResultRegistry.this.l(str);
                            return;
                        }
                        return;
                    }
                }
                ActivityResultRegistry.this.e.put(str, new c(a4Var, b4Var));
                if (ActivityResultRegistry.this.f.containsKey(str)) {
                    Object obj = ActivityResultRegistry.this.f.get(str);
                    ActivityResultRegistry.this.f.remove(str);
                    a4Var.a(obj);
                }
                ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.g.getParcelable(str);
                if (activityResult != null) {
                    ActivityResultRegistry.this.g.remove(str);
                    a4Var.a(b4Var.c(activityResult.b(), activityResult.a()));
                }
            }
        });
        this.c.put(str, dVar);
        return new a(str, b4Var);
    }

    final void l(String str) {
        Integer num;
        if (!this.d.contains(str) && (num = (Integer) this.b.remove(str)) != null) {
            this.a.remove(num);
        }
        this.e.remove(str);
        if (this.f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f.get(str));
            this.f.remove(str);
        }
        if (this.g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.g.getParcelable(str));
            this.g.remove(str);
        }
        d dVar = (d) this.c.get(str);
        if (dVar != null) {
            dVar.b();
            this.c.remove(str);
        }
    }
}
