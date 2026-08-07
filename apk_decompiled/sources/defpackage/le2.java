package defpackage;

import com.google.gson.ReflectionAccessFilter$FilterResult;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class le2 {

    private static abstract class b {
        public static final b a;

        class a extends b {
            final /* synthetic */ Method b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Method method) {
                super();
                this.b = method;
            }

            @Override // le2.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                try {
                    return ((Boolean) this.b.invoke(accessibleObject, obj)).booleanValue();
                } catch (Exception e) {
                    throw new RuntimeException("Failed invoking canAccess", e);
                }
            }
        }

        /* JADX INFO: renamed from: le2$b$b, reason: collision with other inner class name */
        class C0139b extends b {
            C0139b() {
                super();
            }

            @Override // le2.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                return true;
            }
        }

        static {
            b aVar;
            if (o41.d()) {
                try {
                    aVar = new a(AccessibleObject.class.getDeclaredMethod("canAccess", Object.class));
                } catch (NoSuchMethodException unused) {
                    aVar = null;
                }
            } else {
                aVar = null;
            }
            if (aVar == null) {
                aVar = new C0139b();
            }
            a = aVar;
        }

        private b() {
        }

        public abstract boolean a(AccessibleObject accessibleObject, Object obj);
    }

    public static boolean a(AccessibleObject accessibleObject, Object obj) {
        return b.a.a(accessibleObject, obj);
    }

    public static ReflectionAccessFilter$FilterResult b(List list, Class cls) {
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return ReflectionAccessFilter$FilterResult.ALLOW;
        }
        e43.a(it.next());
        throw null;
    }
}
