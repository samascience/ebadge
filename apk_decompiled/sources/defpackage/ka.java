package defpackage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.BeanProperty;

/* JADX INFO: loaded from: classes.dex */
public class ka extends ma {
    public ka(n63 n63Var, BeanProperty beanProperty, String str) {
        super(n63Var, beanProperty, str);
    }

    @Override // defpackage.ma, defpackage.ia, defpackage.z63
    public JsonTypeInfo.As c() {
        return JsonTypeInfo.As.EXISTING_PROPERTY;
    }

    @Override // defpackage.ma
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public ka a(BeanProperty beanProperty) {
        return this.b == beanProperty ? this : new ka(this.a, beanProperty, this.c);
    }
}
