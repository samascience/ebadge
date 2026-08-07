package defpackage;

import android.os.IBinder;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class rt1 extends py0.a {
    private final Object c;

    private rt1(Object obj) {
        this.c = obj;
    }

    public static Object c(py0 py0Var) {
        if (py0Var instanceof rt1) {
            return ((rt1) py0Var).c;
        }
        IBinder iBinderAsBinder = py0Var.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
        a52.g(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return field.get(iBinderAsBinder);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
        } catch (NullPointerException e2) {
            throw new IllegalArgumentException("Binder object is null.", e2);
        }
    }

    public static py0 d(Object obj) {
        return new rt1(obj);
    }
}
