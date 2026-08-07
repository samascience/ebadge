package defpackage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.BeanProperty;

/* JADX INFO: loaded from: classes.dex */
public class na extends a73 {
    public na(n63 n63Var, BeanProperty beanProperty) {
        super(n63Var, beanProperty);
    }

    @Override // defpackage.z63
    public JsonTypeInfo.As c() {
        return JsonTypeInfo.As.WRAPPER_OBJECT;
    }

    @Override // defpackage.z63
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public na a(BeanProperty beanProperty) {
        return this.b == beanProperty ? this : new na(this.a, beanProperty);
    }
}
