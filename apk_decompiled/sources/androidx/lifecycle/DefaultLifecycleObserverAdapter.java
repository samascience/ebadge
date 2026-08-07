package androidx.lifecycle;

import com.tencent.open.SocialConstants;
import defpackage.d80;
import defpackage.db1;
import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements f {
    private final d80 a;
    private final f b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            a = iArr;
        }
    }

    public DefaultLifecycleObserverAdapter(d80 d80Var, f fVar) {
        p31.f(d80Var, "defaultLifecycleObserver");
        this.a = d80Var;
        this.b = fVar;
    }

    @Override // androidx.lifecycle.f
    public void c(db1 db1Var, Lifecycle.Event event) {
        p31.f(db1Var, SocialConstants.PARAM_SOURCE);
        p31.f(event, "event");
        switch (a.a[event.ordinal()]) {
            case 1:
                this.a.d(db1Var);
                break;
            case 2:
                this.a.onStart(db1Var);
                break;
            case 3:
                this.a.onResume(db1Var);
                break;
            case 4:
                this.a.onPause(db1Var);
                break;
            case 5:
                this.a.onStop(db1Var);
                break;
            case 6:
                this.a.onDestroy(db1Var);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        f fVar = this.b;
        if (fVar != null) {
            fVar.c(db1Var, event);
        }
    }
}
