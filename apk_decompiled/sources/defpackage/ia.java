package defpackage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.BeanProperty;

/* JADX INFO: loaded from: classes.dex */
public class ia extends a73 {
    public ia(n63 n63Var, BeanProperty beanProperty) {
        super(n63Var, beanProperty);
    }

    @Override // defpackage.z63
    public JsonTypeInfo.As c() {
        return JsonTypeInfo.As.WRAPPER_ARRAY;
    }

    @Override // defpackage.z63
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public ia a(BeanProperty beanProperty) {
        return this.b == beanProperty ? this : new ia(this.a, beanProperty);
    }
}
