package defpackage;

import android.app.Application;
import androidx.lifecycle.l;
import androidx.lifecycle.o;
import com.tencent.open.SocialOperation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.d;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class ak2 {
    private static final List a = j.m(Application.class, l.class);
    private static final List b = j.e(l.class);

    public static final Constructor c(Class cls, List list) {
        p31.f(cls, "modelClass");
        p31.f(list, SocialOperation.GAME_SIGNATURE);
        Constructor<?>[] constructors = cls.getConstructors();
        p31.e(constructors, "modelClass.constructors");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            p31.e(parameterTypes, "constructor.parameterTypes");
            List listD = d.D(parameterTypes);
            if (p31.a(list, listD)) {
                p31.d(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            }
            if (list.size() == listD.size() && listD.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final o d(Class cls, Constructor constructor, Object... objArr) {
        p31.f(cls, "modelClass");
        p31.f(constructor, "constructor");
        p31.f(objArr, "params");
        try {
            return (o) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to access " + cls, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e3.getCause());
        }
    }
}
