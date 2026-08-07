package kotlinx.coroutines.internal;

import defpackage.ar0;
import defpackage.c81;
import defpackage.d63;
import defpackage.p31;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Result;
import kotlin.d;
import kotlinx.coroutines.CopyableThrowable;

/* JADX INFO: loaded from: classes4.dex */
public final class ExceptionsConstructorKt {
    private static final CtorCache ctorCache;
    private static final int throwableFields = fieldsCountOrDefault(Throwable.class, -1);

    static {
        CtorCache ctorCache2;
        try {
            ctorCache2 = FastServiceLoaderKt.getANDROID_DETECTED() ? WeakMapCtorCache.INSTANCE : ClassValueCtorCache.INSTANCE;
        } catch (Throwable unused) {
            ctorCache2 = WeakMapCtorCache.INSTANCE;
        }
        ctorCache = ctorCache2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E extends Throwable> ar0 createConstructor(Class<E> cls) {
        Object next;
        ar0 ar0Var;
        Pair pairA;
        ExceptionsConstructorKt$createConstructor$nullResult$1 exceptionsConstructorKt$createConstructor$nullResult$1 = new ar0() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$nullResult$1
            @Override // defpackage.ar0
            public final Void invoke(Throwable th) {
                return null;
            }
        };
        if (throwableFields != fieldsCountOrDefault(cls, 0)) {
            return exceptionsConstructorKt$createConstructor$nullResult$1;
        }
        Constructor<?>[] constructors = cls.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.length);
        int length = constructors.length;
        int i = 0;
        while (true) {
            next = null;
            if (i >= length) {
                break;
            }
            final Constructor<?> constructor = constructors[i];
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            int length2 = parameterTypes.length;
            if (length2 == 0) {
                pairA = d63.a(safeCtor(new ar0() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // defpackage.ar0
                    public final Throwable invoke(Throwable th) throws IllegalAccessException, InstantiationException, InvocationTargetException {
                        Object objNewInstance = constructor.newInstance(null);
                        p31.d(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
                        Throwable th2 = (Throwable) objNewInstance;
                        th2.initCause(th);
                        return th2;
                    }
                }), 0);
            } else if (length2 == 1) {
                Class<?> cls2 = parameterTypes[0];
                if (p31.a(cls2, String.class)) {
                    pairA = d63.a(safeCtor(new ar0() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // defpackage.ar0
                        public final Throwable invoke(Throwable th) throws IllegalAccessException, InstantiationException, InvocationTargetException {
                            Object objNewInstance = constructor.newInstance(th.getMessage());
                            p31.d(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
                            Throwable th2 = (Throwable) objNewInstance;
                            th2.initCause(th);
                            return th2;
                        }
                    }), 2);
                } else {
                    pairA = p31.a(cls2, Throwable.class) ? d63.a(safeCtor(new ar0() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // defpackage.ar0
                        public final Throwable invoke(Throwable th) throws IllegalAccessException, InstantiationException, InvocationTargetException {
                            Object objNewInstance = constructor.newInstance(th);
                            p31.d(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
                            return (Throwable) objNewInstance;
                        }
                    }), 1) : d63.a(null, -1);
                }
            } else if (length2 != 2) {
                pairA = d63.a(null, -1);
            } else {
                pairA = (p31.a(parameterTypes[0], String.class) && p31.a(parameterTypes[1], Throwable.class)) ? d63.a(safeCtor(new ar0() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // defpackage.ar0
                    public final Throwable invoke(Throwable th) throws IllegalAccessException, InstantiationException, InvocationTargetException {
                        Object objNewInstance = constructor.newInstance(th.getMessage(), th);
                        p31.d(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
                        return (Throwable) objNewInstance;
                    }
                }), 3) : d63.a(null, -1);
            }
            arrayList.add(pairA);
            i++;
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int iIntValue = ((Number) ((Pair) next).getSecond()).intValue();
                do {
                    Object next2 = it.next();
                    int iIntValue2 = ((Number) ((Pair) next2).getSecond()).intValue();
                    if (iIntValue < iIntValue2) {
                        next = next2;
                        iIntValue = iIntValue2;
                    }
                } while (it.hasNext());
            }
        }
        Pair pair = (Pair) next;
        return (pair == null || (ar0Var = (ar0) pair.getFirst()) == null) ? exceptionsConstructorKt$createConstructor$nullResult$1 : ar0Var;
    }

    private static final int fieldsCount(Class<?> cls, int i) {
        do {
            int i2 = 0;
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i;
    }

    static /* synthetic */ int fieldsCount$default(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return fieldsCount(cls, i);
    }

    private static final int fieldsCountOrDefault(Class<?> cls, int i) {
        Object objM69constructorimpl;
        c81.c(cls);
        try {
            Result.a aVar = Result.Companion;
            objM69constructorimpl = Result.m69constructorimpl(Integer.valueOf(fieldsCount$default(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            objM69constructorimpl = Result.m69constructorimpl(d.a(th));
        }
        Integer numValueOf = Integer.valueOf(i);
        if (Result.m75isFailureimpl(objM69constructorimpl)) {
            objM69constructorimpl = numValueOf;
        }
        return ((Number) objM69constructorimpl).intValue();
    }

    private static final ar0 safeCtor(final ar0 ar0Var) {
        return new ar0() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt.safeCtor.1
            {
                super(1);
            }

            @Override // defpackage.ar0
            public final Throwable invoke(Throwable th) {
                Object objM69constructorimpl;
                ar0 ar0Var2 = ar0Var;
                try {
                    Result.a aVar = Result.Companion;
                    Throwable th2 = (Throwable) ar0Var2.invoke(th);
                    if (!p31.a(th.getMessage(), th2.getMessage()) && !p31.a(th2.getMessage(), th.toString())) {
                        th2 = null;
                    }
                    objM69constructorimpl = Result.m69constructorimpl(th2);
                } catch (Throwable th3) {
                    Result.a aVar2 = Result.Companion;
                    objM69constructorimpl = Result.m69constructorimpl(d.a(th3));
                }
                return (Throwable) (Result.m75isFailureimpl(objM69constructorimpl) ? null : objM69constructorimpl);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E extends Throwable> E tryCopyException(E e) {
        Object objM69constructorimpl;
        if (!(e instanceof CopyableThrowable)) {
            return (E) ctorCache.get(e.getClass()).invoke(e);
        }
        try {
            Result.a aVar = Result.Companion;
            objM69constructorimpl = Result.m69constructorimpl(((CopyableThrowable) e).createCopy());
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            objM69constructorimpl = Result.m69constructorimpl(d.a(th));
        }
        if (Result.m75isFailureimpl(objM69constructorimpl)) {
            objM69constructorimpl = null;
        }
        return (E) objM69constructorimpl;
    }
}
