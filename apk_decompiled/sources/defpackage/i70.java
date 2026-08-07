package defpackage;

import com.fasterxml.jackson.core.JsonPointer;
import java.lang.reflect.Field;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

/* JADX INFO: loaded from: classes4.dex */
public abstract class i70 {
    private static final void a(int i, int i2) {
        if (i2 <= i) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
    }

    private static final h70 b(BaseContinuationImpl baseContinuationImpl) {
        return (h70) baseContinuationImpl.getClass().getAnnotation(h70.class);
    }

    private static final int c(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(BaseContinuationImpl baseContinuationImpl) {
        String strC;
        p31.f(baseContinuationImpl, "<this>");
        h70 h70VarB = b(baseContinuationImpl);
        if (h70VarB == null) {
            return null;
        }
        a(1, h70VarB.v());
        int iC = c(baseContinuationImpl);
        int i = iC < 0 ? -1 : h70VarB.l()[iC];
        String strB = wk1.a.b(baseContinuationImpl);
        if (strB == null) {
            strC = h70VarB.c();
        } else {
            strC = strB + JsonPointer.SEPARATOR + h70VarB.c();
        }
        return new StackTraceElement(strC, h70VarB.m(), h70VarB.f(), i);
    }
}
