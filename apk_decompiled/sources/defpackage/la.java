package defpackage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.BeanProperty;

/* JADX INFO: loaded from: classes.dex */
public class la extends a73 {
    protected final String c;

    public la(n63 n63Var, BeanProperty beanProperty, String str) {
        super(n63Var, beanProperty);
        this.c = str;
    }

    @Override // defpackage.a73, defpackage.z63
    public String b() {
        return this.c;
    }

    @Override // defpackage.z63
    public JsonTypeInfo.As c() {
        return JsonTypeInfo.As.EXTERNAL_PROPERTY;
    }

    @Override // defpackage.z63
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public la a(BeanProperty beanProperty) {
        return this.b == beanProperty ? this : new la(this.a, beanProperty, this.c);
    }
}
