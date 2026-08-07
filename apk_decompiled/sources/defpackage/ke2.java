package defpackage;

import com.tencent.connect.common.Constants;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference2;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference2;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ke2 {
    private static final me2 a;
    private static final h81[] b;

    static {
        me2 me2Var = null;
        try {
            me2Var = (me2) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (me2Var == null) {
            me2Var = new me2();
        }
        a = me2Var;
        b = new h81[0];
    }

    public static j81 a(FunctionReference functionReference) {
        return a.a(functionReference);
    }

    public static h81 b(Class cls) {
        return a.b(cls);
    }

    public static i81 c(Class cls) {
        return a.c(cls, Constants.STR_EMPTY);
    }

    public static n81 d(MutablePropertyReference0 mutablePropertyReference0) {
        return a.d(mutablePropertyReference0);
    }

    public static o81 e(MutablePropertyReference1 mutablePropertyReference1) {
        return a.e(mutablePropertyReference1);
    }

    public static p81 f(MutablePropertyReference2 mutablePropertyReference2) {
        return a.f(mutablePropertyReference2);
    }

    public static r81 g(PropertyReference0 propertyReference0) {
        return a.g(propertyReference0);
    }

    public static s81 h(PropertyReference1 propertyReference1) {
        return a.h(propertyReference1);
    }

    public static t81 i(PropertyReference2 propertyReference2) {
        return a.i(propertyReference2);
    }

    public static String j(yr0 yr0Var) {
        return a.j(yr0Var);
    }

    public static String k(Lambda lambda) {
        return a.k(lambda);
    }
}
