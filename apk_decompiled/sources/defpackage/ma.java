package defpackage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.BeanProperty;

/* JADX INFO: loaded from: classes.dex */
public class ma extends ia {
    protected final String c;

    public ma(n63 n63Var, BeanProperty beanProperty, String str) {
        super(n63Var, beanProperty);
        this.c = str;
    }

    @Override // defpackage.a73, defpackage.z63
    public String b() {
        return this.c;
    }

    @Override // defpackage.ia, defpackage.z63
    public JsonTypeInfo.As c() {
        return JsonTypeInfo.As.PROPERTY;
    }

    @Override // defpackage.ia
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public ma a(BeanProperty beanProperty) {
        return this.b == beanProperty ? this : new ma(this.a, beanProperty, this.c);
    }
}
