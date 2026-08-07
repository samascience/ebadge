package defpackage;

import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference2;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference2;

/* JADX INFO: loaded from: classes4.dex */
public class me2 {
    public j81 a(FunctionReference functionReference) {
        return functionReference;
    }

    public h81 b(Class cls) {
        return new xx(cls);
    }

    public i81 c(Class cls, String str) {
        return new uy1(cls, str);
    }

    public n81 d(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public o81 e(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public p81 f(MutablePropertyReference2 mutablePropertyReference2) {
        return mutablePropertyReference2;
    }

    public r81 g(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public s81 h(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public t81 i(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }

    public String j(yr0 yr0Var) {
        String string = yr0Var.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public String k(Lambda lambda) {
        return j(lambda);
    }
}
